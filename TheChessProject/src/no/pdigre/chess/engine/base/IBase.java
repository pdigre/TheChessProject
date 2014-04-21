package no.pdigre.chess.engine.base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Arrays of possible moves for each position of the board sliders have sub
 * arrays - piece - from - to - x - castling
 * 
 * @author pdigre
 * 
 */
public interface IBase extends IConst {

	long[][] M32_WN = new long[64][];
	long[][] M32_BN = new long[64][];
	long[][] M32_WK = new long[64][];
	long[][] M32_BK = new long[64][];
	long[] M64_KNIGHT = new long[64];
	long[] M64_KING = new long[64];
	long[] M64_QUEEN = new long[64];
	long[] M64_ROOK = new long[64];
	long[] M64_BISHOP = new long[64];
	long[] M64_WP = new long[64];
	long[] M64_BP = new long[64];
	long[][][] M32_WB = new long[64][][];
	long[][][] M32_BB = new long[64][][];
	long[][][] M32_WR = new long[64][][];
	long[][][] M32_BR = new long[64][][];
	long[][][] M32_WQ = new long[64][][];
	long[][][] M32_BQ = new long[64][][];
	long CASTLING_WK = BITS.assemble(WK, WK_STARTPOS, WK_STARTPOS + 2, CANCASTLE_BLACK | SPECIAL);
	long CASTLING_WQ = BITS.assemble(WK, WK_STARTPOS, WK_STARTPOS - 2, CANCASTLE_BLACK | SPECIAL);
	long CASTLING_BK = BITS.assemble(BK, BK_STARTPOS, BK_STARTPOS + 2, CANCASTLE_WHITE | SPECIAL);
	long CASTLING_BQ = BITS.assemble(BK, BK_STARTPOS, BK_STARTPOS - 2, CANCASTLE_WHITE | SPECIAL);
	long SIDE_WK = BITS.assemble(WK, WK_STARTPOS, WK_STARTPOS + 1, CANCASTLE_BLACK);
	long SIDE_WQ = BITS.assemble(WK, WK_STARTPOS, WK_STARTPOS - 1, CANCASTLE_BLACK);
	long SIDE_BK = BITS.assemble(BK, BK_STARTPOS, BK_STARTPOS + 1, CANCASTLE_WHITE);
	long SIDE_BQ = BITS.assemble(BK, BK_STARTPOS, BK_STARTPOS - 1, CANCASTLE_WHITE);
	long[][][] M32_WP = new long[64][][];
	long[][][] M32_BP = new long[64][][];
	long[][] M32_WP_CAPTURE = new long[64][];
	long[][] M32_BP_CAPTURE = new long[64][];

	BASE base = new BASE();

	class BASE {
		final public static int LEFT = -1;

		final public static int RIGHT = 1;

		final public static int UP = 8;

		final public static int DOWN = -8;

		static {
			for (int from = 0; from < 64; from++) {
				long[] mw = getKnightMoves(from, WN, CASTLING_STATE | HALFMOVES);
				M32_WN[from] = mw;
				M32_BN[from] = getKnightMoves(from, BN, CASTLING_STATE | HALFMOVES);
				long bfrom = 1L << from;
				for (long bitmap : mw)
					M64_KNIGHT[IConst.BITS.getTo(bitmap)] |= bfrom;
			}
		}

		private static long[] getKnightMoves(int from, int piece, long mask) {
			ArrayList<Long> moves = new ArrayList<Long>();
			add(moves, piece, from, UP + LEFT + LEFT, mask);
			add(moves, piece, from, UP + UP + LEFT, mask);
			add(moves, piece, from, UP + RIGHT + RIGHT, mask);
			add(moves, piece, from, UP + UP + RIGHT, mask);
			add(moves, piece, from, DOWN + LEFT + LEFT, mask);
			add(moves, piece, from, DOWN + DOWN + LEFT, mask);
			add(moves, piece, from, DOWN + RIGHT + RIGHT, mask);
			add(moves, piece, from, DOWN + DOWN + RIGHT, mask);
			return toArraySorted(moves);
		}

		static {
			for (int from = 0; from < 64; from++) {
				M32_WR[from] = getRookMoves(from, WR, CASTLING_STATE | HALFMOVES);
				long[][] mb = getRookMoves(from, BR, CASTLING_STATE | HALFMOVES);
				M32_BR[from] = mb;
				long bfrom = 1L << from;
				for (long[] m2 : mb)
					for (long bitmap : m2)
						M64_ROOK[IConst.BITS.getTo(bitmap)] |= bfrom;
			}
			for (long[] b : M32_WR[0])
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_WHITEQUEEN;
			for (long[] b : M32_WR[7])
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_WHITEKING;
			for (long[] b : M32_BR[56])
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_BLACKQUEEN;
			for (long[] b : M32_BR[63])
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_BLACKKING;
		}

		private static long[][] getRookMoves(int from, int piece, long mask) {
			ArrayList<long[]> slide = new ArrayList<long[]>();
			slide(slide, from, UP, piece, mask);
			slide(slide, from, DOWN, piece, mask);
			slide(slide, from, LEFT, piece, mask);
			slide(slide, from, RIGHT, piece, mask);
			return toArray2(slide);
		}

		static {
			for (int from = 0; from < 64; from++) {
				M32_WB[from] = getBishopMoves(from, WB, CASTLING_STATE | HALFMOVES);
				long[][] mb = getBishopMoves(from, BB, CASTLING_STATE | HALFMOVES);
				M32_BB[from] = mb;
				long bfrom = 1L << from;
				for (long[] m2 : mb)
					for (long bitmap : m2)
						M64_BISHOP[IConst.BITS.getTo(bitmap)] |= bfrom;
			}
		}

		private static long[][] getBishopMoves(int from, int piece, long mask) {
			ArrayList<long[]> slide = new ArrayList<long[]>();
			slide(slide, from, UP + LEFT, piece, mask);
			slide(slide, from, UP + RIGHT, piece, mask);
			slide(slide, from, DOWN + LEFT, piece, mask);
			slide(slide, from, DOWN + RIGHT, piece, mask);
			return toArray2(slide);
		}

		static {
			for (int from = 0; from < 64; from++) {
				M32_WQ[from] = getQueenMoves(from, WQ, CASTLING_STATE | HALFMOVES);
				long[][] mb = getQueenMoves(from, BQ, CASTLING_STATE | HALFMOVES);
				M32_BQ[from] = mb;
				long bfrom = 1L << from;
				for (long[] m2 : mb)
					for (long bitmap : m2)
						M64_QUEEN[IConst.BITS.getTo(bitmap)] |= bfrom;
			}
		}

		private static long[][] getQueenMoves(int from, int piece, long mask) {
			ArrayList<long[]> slide = new ArrayList<long[]>();
			slide(slide, from, UP, piece, mask);
			slide(slide, from, DOWN, piece, mask);
			slide(slide, from, LEFT, piece, mask);
			slide(slide, from, RIGHT, piece, mask);
			slide(slide, from, UP + LEFT, piece, mask);
			slide(slide, from, UP + RIGHT, piece, mask);
			slide(slide, from, DOWN + LEFT, piece, mask);
			slide(slide, from, DOWN + RIGHT, piece, mask);
			return toArray2(slide);
		}

		static {
			for (int from = 0; from < 64; from++) {
				long[] mw = getKingMoves(from, WK, CANCASTLE_BLACK | HALFMOVES);
				M32_WK[from] = mw;
				long[] mb = getKingMoves(from, BK, CANCASTLE_WHITE | HALFMOVES);
				M32_BK[from] = mb;
				long bfrom = 1L << from;
				for (long bitmap : mw)
					M64_KING[IConst.BITS.getTo(bitmap)] |= bfrom;
			}
		}

		private static long[] getKingMoves(int from, int piece, long mask) {
			ArrayList<Long> moves = new ArrayList<Long>();
			add(moves, piece, from, UP, mask);
			add(moves, piece, from, DOWN, mask);
			add(moves, piece, from, LEFT, mask);
			add(moves, piece, from, RIGHT, mask);
			add(moves, piece, from, UP + LEFT, mask);
			add(moves, piece, from, UP + RIGHT, mask);
			add(moves, piece, from, DOWN + LEFT, mask);
			add(moves, piece, from, DOWN + RIGHT, mask);
			return toArraySorted(moves);
		}

		static {
			for (int from = 0; from < 64; from++) {
				M32_WP[from] = getWhitePawnMoves(from);
				M32_BP[from] = getBlackPawnMoves(from);
				long[] mw = getWhitePawnCaptures(from);
				M32_WP_CAPTURE[from] = mw;
				long[] mb = getBlackPawnCaptures(from);
				M32_BP_CAPTURE[from] = mb;
				long bfrom = 1L << from;
				for (long bitmap : mw)
					M64_WP[IConst.BITS.getTo(bitmap)] |= bfrom;
				for (long bitmap : mb)
					M64_BP[IConst.BITS.getTo(bitmap)] |= bfrom;

			}
		}

		private static long[] getWhitePawnCaptures(int from) {
			ArrayList<Long> moves = new ArrayList<Long>();
			int x = from & 7;
			if (x != 0)
				pwcapture(moves, from, from + 7);
			if (x != 7)
				pwcapture(moves, from, from + 9);
			return toArraySorted(moves);
		}

		private static void pwcapture(ArrayList<Long> moves, int from, int to) {
			if (to >= 56 && to < 64) {
				moves.add(BITS.assemblePromote(WP, WQ, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(WP, WR, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(WP, WN, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(WP, WB, from, to, CASTLING_STATE | SPECIAL));
			} else if(to<64){
				moves.add(BITS.assemble(WP, from, to, CASTLING_STATE));
			}
		}

		private static long[] getBlackPawnCaptures(int from) {
			ArrayList<Long> moves = new ArrayList<Long>();
			int x = from & 7;
			if (x != 0)
				pbcapture(moves, from, from - 9);
			if (x != 7)
				pbcapture(moves, from, from - 7);
			return toArraySorted(moves);
		}

		private static void pbcapture(ArrayList<Long> moves, int from, int to) {
			if (to >= 0 && to < 8) {
				moves.add(BITS.assemblePromote(BP, BQ, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(BP, BR, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(BP, BN, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(BP, BB, from, to, CASTLING_STATE | SPECIAL));
			} else if(to>=0){
				moves.add(BITS.assemble(BP, from, to, CASTLING_STATE));
			}
		}

		private static long[][] getWhitePawnMoves(int from) {
			ArrayList<long[]> moves = new ArrayList<long[]>();
			int to = from + 8;
			if (to >= 56 && to < 64) {
				moves.add(new long[] { BITS.assemblePromote(WP, WQ, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(WP, WR, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(WP, WN, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(WP, WB, from, to, CASTLING_STATE | SPECIAL) });
			} else if (from >= 8 && from < 16) {
				moves.add(new long[] { BITS.assemble(WP, from, to, CASTLING_STATE), BITS.assemble(WP, from, to + 8, CASTLING_STATE) });
			} else if (to < 64) {
				moves.add(new long[] { BITS.assemble(WP, from, to, CASTLING_STATE) });
			}
			return toArray2(moves);
		}

		private static long[][] getBlackPawnMoves(int from) {
			ArrayList<long[]> moves = new ArrayList<long[]>();
			int to = from - 8;
			if (to >= 0 && to < 8) {
				moves.add(new long[] { BITS.assemblePromote(BP, BQ, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(BP, BR, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(BP, BN, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(BP, BB, from, to, CASTLING_STATE | SPECIAL) });
			} else if (from >= 48 && from < 56) {
				moves.add(new long[] { BITS.assemble(BP, from, to, CASTLING_STATE), BITS.assemble(BP, from, to - 8, CASTLING_STATE) });
			} else if (to >= 0) {
				moves.add(new long[] { BITS.assemble(BP, from, to, CASTLING_STATE) });
			}
			return toArray2(moves);
		}

		static long[] toArray(ArrayList<Long> moves) {
			long[] ret = new long[moves.size()];
			for (int i = 0; i < moves.size(); i++) {
				ret[i] = moves.get(i);
			}
			return ret;
		}

		static long[] toArraySorted(ArrayList<Long> moves) {
			long[] ret = new long[moves.size()];
			for (int i = 0; i < moves.size(); i++) {
				ret[i] = moves.get(i);
			}
			Arrays.sort(ret);
			return ret;
		}

		static long[] toLongArray(ArrayList<Integer> moves) {
			long[] ret = new long[moves.size()];
			for (int i = 0; i < moves.size(); i++)
				ret[i] = moves.get(i);
			return ret;
		}

		static long[][] toArray2(ArrayList<long[]> moves) {
			long[][] ret = new long[moves.size()][];
			for (int i = 0; i < moves.size(); i++) {
				ret[i] = moves.get(i);
			}
			Arrays.sort(ret,new Comparator<long[]>(){

				@Override
				public int compare(long[] o1, long[] o2) {
					return Long.compare(o1[0], o2[0]);
				}
				
			});
			return ret;
		}

		/**
		 * Calculate is move is within borders return true if can continue like
		 * queen
		 * 
		 * @param moves
		 * @param piece
		 * @param from
		 * @param offset
		 * @param mask
		 * @return
		 */
		static boolean add(ArrayList<Long> moves, int piece, int from, int offset, long mask) {
			int to = from + offset;
			boolean has = inside(to, from);
			if (has)
				moves.add(BITS.assemble(piece, from, to, mask));
			return has;
		}

		static boolean addSlide(ArrayList<Long> moves, int piece, int from, int offset, long mask, int from2) {
			int to = from + offset;
			boolean has = inside(to, from);
			if (has)
				moves.add(BITS.assemble(piece, from2, to, mask));
			return has;
		}

		/**
		 * is it inside the board = legal move
		 * 
		 * @param to
		 * @param from
		 * @return
		 */
		static boolean inside(int to, int from) {
			if (to < 0 || to > 63)
				return false;
			int x1 = to % 8;
			int x2 = from % 8;
			if ((x1 < 3 && x2 > 4) || (x2 < 3 && x1 > 4))
				return false;
			return true;
		}

		/**
		 * Repeated moves like rook and queen
		 * 
		 * @param from
		 * @param offset
		 * @param piece
		 *            TODO
		 * @param mark
		 *            TODO
		 * @param M32_WR
		 * @param board
		 */
		static void slide(ArrayList<long[]> main, int from, int offset, int piece, long mark) {
			ArrayList<Long> moves = new ArrayList<Long>();
			for (int slidefrom = from; addSlide(moves, piece, slidefrom, offset, mark, from); slidefrom += offset)
				;
			long[] mv = toArray(moves);
			if (mv.length > 0)
				main.add(mv);
		}
	}

}

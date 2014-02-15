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

	long[][] M32_WHITE_KNIGHT = new long[64][];
	long[][] M32_BLACK_KNIGHT = new long[64][];
	long[][] M32_WHITE_KING = new long[64][];
	long[][] M32_BLACK_KING = new long[64][];
	long[] M64_KNIGHT = new long[64];
	long[] M64_KING = new long[64];
	long[] M64_QUEEN = new long[64];
	long[] M64_ROOK = new long[64];
	long[] M64_BISHOP = new long[64];
	long[] M64_PAWN_WHITE = new long[64];
	long[] M64_PAWN_BLACK = new long[64];
	long[][][] M32_WHITE_BISHOP = new long[64][][];
	long[][][] M32_BLACK_BISHOP = new long[64][][];
	long[][][] M32_WHITE_ROOK = new long[64][][];
	long[][][] M32_BLACK_ROOK = new long[64][][];
	long[][][] M32_WHITE_QUEEN = new long[64][][];
	long[][][] M32_BLACK_QUEEN = new long[64][][];
	long CASTLING_WHITE_KING = BITS.assemble(WHITE_KING, WHITE_KING_STARTPOS, WHITE_KING_STARTPOS + 2, CANCASTLE_BLACK | SPECIAL);
	long CASTLING_WHITE_QUEEN = BITS.assemble(WHITE_KING, WHITE_KING_STARTPOS, WHITE_KING_STARTPOS - 2, CANCASTLE_BLACK | SPECIAL);
	long CASTLING_BLACK_KING = BITS.assemble(BLACK_KING, BLACK_KING_STARTPOS, BLACK_KING_STARTPOS + 2, CANCASTLE_WHITE | SPECIAL);
	long CASTLING_BLACK_QUEEN = BITS.assemble(BLACK_KING, BLACK_KING_STARTPOS, BLACK_KING_STARTPOS - 2, CANCASTLE_WHITE | SPECIAL);
	long WHITE_KINGSIDE = BITS.assemble(WHITE_KING, WHITE_KING_STARTPOS, WHITE_KING_STARTPOS + 1, CANCASTLE_BLACK);
	long WHITE_QUEENSIDE = BITS.assemble(WHITE_KING, WHITE_KING_STARTPOS, WHITE_KING_STARTPOS - 1, CANCASTLE_BLACK);
	long BLACK_KINGSIDE = BITS.assemble(BLACK_KING, BLACK_KING_STARTPOS, BLACK_KING_STARTPOS + 1, CANCASTLE_WHITE);
	long BLACK_QUEENSIDE = BITS.assemble(BLACK_KING, BLACK_KING_STARTPOS, BLACK_KING_STARTPOS - 1, CANCASTLE_WHITE);
	long[][][] M32_WHITE_PAWN = new long[64][][];
	long[][][] M32_BLACK_PAWN = new long[64][][];
	long[][] M32_WHITE_PAWN_CAPTURE = new long[64][];
	long[][] M32_BLACK_PAWN_CAPTURE = new long[64][];

	BASE base = new BASE();

	class BASE {
		final public static int LEFT = -1;

		final public static int RIGHT = 1;

		final public static int UP = 8;

		final public static int DOWN = -8;

		static {
			for (int from = 0; from < 64; from++) {
				long[] mw = getKnightMoves(from, WHITE_KNIGHT, CASTLING_STATE | HALFMOVES);
				M32_WHITE_KNIGHT[from] = mw;
				M32_BLACK_KNIGHT[from] = getKnightMoves(from, BLACK_KNIGHT, CASTLING_STATE | HALFMOVES);
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
				M32_WHITE_ROOK[from] = getRookMoves(from, WHITE_ROOK, CASTLING_STATE | HALFMOVES);
				long[][] mb = getRookMoves(from, BLACK_ROOK, CASTLING_STATE | HALFMOVES);
				M32_BLACK_ROOK[from] = mb;
				long bfrom = 1L << from;
				for (long[] m2 : mb)
					for (long bitmap : m2)
						M64_ROOK[IConst.BITS.getTo(bitmap)] |= bfrom;
			}
			for (long[] b : M32_WHITE_ROOK[0])
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_WHITEQUEEN;
			for (long[] b : M32_WHITE_ROOK[7])
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_WHITEKING;
			for (long[] b : M32_BLACK_ROOK[56])
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_BLACKQUEEN;
			for (long[] b : M32_BLACK_ROOK[63])
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
				M32_WHITE_BISHOP[from] = getBishopMoves(from, WHITE_BISHOP, CASTLING_STATE | HALFMOVES);
				long[][] mb = getBishopMoves(from, BLACK_BISHOP, CASTLING_STATE | HALFMOVES);
				M32_BLACK_BISHOP[from] = mb;
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
				M32_WHITE_QUEEN[from] = getQueenMoves(from, WHITE_QUEEN, CASTLING_STATE | HALFMOVES);
				long[][] mb = getQueenMoves(from, BLACK_QUEEN, CASTLING_STATE | HALFMOVES);
				M32_BLACK_QUEEN[from] = mb;
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
				long[] mw = getKingMoves(from, WHITE_KING, CANCASTLE_BLACK | HALFMOVES);
				M32_WHITE_KING[from] = mw;
				long[] mb = getKingMoves(from, BLACK_KING, CANCASTLE_WHITE | HALFMOVES);
				M32_BLACK_KING[from] = mb;
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
				M32_WHITE_PAWN[from] = getWhitePawnMoves(from);
				M32_BLACK_PAWN[from] = getBlackPawnMoves(from);
				long[] mw = getWhitePawnCaptures(from);
				M32_WHITE_PAWN_CAPTURE[from] = mw;
				long[] mb = getBlackPawnCaptures(from);
				M32_BLACK_PAWN_CAPTURE[from] = mb;
				long bfrom = 1L << from;
				for (long bitmap : mw)
					M64_PAWN_WHITE[IConst.BITS.getTo(bitmap)] |= bfrom;
				for (long bitmap : mb)
					M64_PAWN_BLACK[IConst.BITS.getTo(bitmap)] |= bfrom;

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
				moves.add(BITS.assemblePromote(WHITE_PAWN, WHITE_QUEEN, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(WHITE_PAWN, WHITE_ROOK, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(WHITE_PAWN, WHITE_KNIGHT, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(WHITE_PAWN, WHITE_BISHOP, from, to, CASTLING_STATE | SPECIAL));
			} else if(to<64){
				moves.add(BITS.assemble(WHITE_PAWN, from, to, CASTLING_STATE));
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
				moves.add(BITS.assemblePromote(BLACK_PAWN, BLACK_QUEEN, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(BLACK_PAWN, BLACK_ROOK, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(BLACK_PAWN, BLACK_KNIGHT, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(BLACK_PAWN, BLACK_BISHOP, from, to, CASTLING_STATE | SPECIAL));
			} else if(to>=0){
				moves.add(BITS.assemble(BLACK_PAWN, from, to, CASTLING_STATE));
			}
		}

		private static long[][] getWhitePawnMoves(int from) {
			ArrayList<long[]> moves = new ArrayList<long[]>();
			int to = from + 8;
			if (to >= 56 && to < 64) {
				moves.add(new long[] { BITS.assemblePromote(WHITE_PAWN, WHITE_QUEEN, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(WHITE_PAWN, WHITE_ROOK, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(WHITE_PAWN, WHITE_KNIGHT, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(WHITE_PAWN, WHITE_BISHOP, from, to, CASTLING_STATE | SPECIAL) });
			} else if (from >= 8 && from < 16) {
				moves.add(new long[] { BITS.assemble(WHITE_PAWN, from, to, CASTLING_STATE), BITS.assemble(WHITE_PAWN, from, to + 8, CASTLING_STATE) });
			} else if (to < 64) {
				moves.add(new long[] { BITS.assemble(WHITE_PAWN, from, to, CASTLING_STATE) });
			}
			return toArray2(moves);
		}

		private static long[][] getBlackPawnMoves(int from) {
			ArrayList<long[]> moves = new ArrayList<long[]>();
			int to = from - 8;
			if (to >= 0 && to < 8) {
				moves.add(new long[] { BITS.assemblePromote(BLACK_PAWN, BLACK_QUEEN, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(BLACK_PAWN, BLACK_ROOK, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(BLACK_PAWN, BLACK_KNIGHT, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(BLACK_PAWN, BLACK_BISHOP, from, to, CASTLING_STATE | SPECIAL) });
			} else if (from >= 48 && from < 56) {
				moves.add(new long[] { BITS.assemble(BLACK_PAWN, from, to, CASTLING_STATE), BITS.assemble(BLACK_PAWN, from, to - 8, CASTLING_STATE) });
			} else if (to >= 0) {
				moves.add(new long[] { BITS.assemble(BLACK_PAWN, from, to, CASTLING_STATE) });
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
		 * @param M32_WHITE_ROOK
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

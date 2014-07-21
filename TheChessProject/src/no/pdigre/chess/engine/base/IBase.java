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

	MOVEMAP[] MM = new MOVEMAP[64];

	BASE base = new BASE();

	class BASE {
		final public static int LEFT = -1;

		final public static int RIGHT = 1;

		final public static int UP = 8;

		final public static int DOWN = -8;

		static {
			for (int from = 0; from < 64; from++) {
				MOVEMAP mm=new MOVEMAP(from);
				MM[from] = mm;
				mm.WN.M = getKnightMoves(from, WN, CASTLING_STATE | HALFMOVES);
				mm.BN.M = getKnightMoves(from, BN, CASTLING_STATE | HALFMOVES);
				mm.WR.M = getRookMoves(from, WR, CASTLING_STATE | HALFMOVES);
				mm.BR.M = getRookMoves(from, BR, CASTLING_STATE | HALFMOVES);
				mm.WB.M = getBishopMoves(from, WB, CASTLING_STATE | HALFMOVES);
				mm.BB.M = getBishopMoves(from, BB, CASTLING_STATE | HALFMOVES);
				mm.WQ.M = getQueenMoves(from, WQ, CASTLING_STATE | HALFMOVES);
				mm.BQ.M = getQueenMoves(from, BQ, CASTLING_STATE | HALFMOVES);
				mm.WP.M = getWhitePawnMoves(from);
				mm.BP.M = getBlackPawnMoves(from);
				mm.WP.C = getWhitePawnCaptures(from);
				mm.BP.C = getBlackPawnCaptures(from);
				mm.WK.M = getKingMoves(from, WK, CANCASTLE_BLACK | HALFMOVES);
				mm.BK.M = getKingMoves(from, BK, CANCASTLE_WHITE | HALFMOVES);

			}
			for (long[] b : MM[0].WR.M)
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_WHITEQUEEN;
			for (long[] b : MM[7].WR.M)
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_WHITEKING;
			for (long[] b : MM[56].BR.M)
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_BLACKQUEEN;
			for (long[] b : MM[63].BR.M)
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_BLACKKING;

			// initialize reverse King in-check
			for (int from = 0; from < 64; from++) {
				MOVEMAP mm = MM[from];
				long bfrom = 1L << from;
				for (long bitmap : mm.WN.M)
					MM[IConst.BITS.getTo(bitmap)].RN |= bfrom;
				for (long[] m2 : mm.WB.M)
					for (long bitmap : m2)
						MM[IConst.BITS.getTo(bitmap)].RB |= bfrom;
				for (long[] m2 : mm.WR.M)
					for (long bitmap : m2)
						MM[IConst.BITS.getTo(bitmap)].RR |= bfrom;
				for (long[] m2 : mm.WQ.M)
					for (long bitmap : m2)
						MM[IConst.BITS.getTo(bitmap)].RQ |= bfrom;
				for (long bitmap : mm.WK.M)
					MM[IConst.BITS.getTo(bitmap)].RK |= bfrom;
				for (long bitmap : mm.WP.C)
					MM[IConst.BITS.getTo(bitmap)].RPW |= bfrom;
				for (long bitmap : mm.BP.C)
					MM[IConst.BITS.getTo(bitmap)].RPB |= bfrom;
			}
		}

		static long[] getKnightMoves(int from, int piece, long mask) {
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

		static long[][] getRookMoves(int from, int piece, long mask) {
			ArrayList<long[]> slide = new ArrayList<long[]>();
			slide(slide, from, UP, piece, mask);
			slide(slide, from, DOWN, piece, mask);
			slide(slide, from, LEFT, piece, mask);
			slide(slide, from, RIGHT, piece, mask);
			return toArray2(slide);
		}

		static long[][] getBishopMoves(int from, int piece, long mask) {
			ArrayList<long[]> slide = new ArrayList<long[]>();
			slide(slide, from, UP + LEFT, piece, mask);
			slide(slide, from, UP + RIGHT, piece, mask);
			slide(slide, from, DOWN + LEFT, piece, mask);
			slide(slide, from, DOWN + RIGHT, piece, mask);
			return toArray2(slide);
		}

		static long[][] getQueenMoves(int from, int piece, long mask) {
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

		static long[] getKingMoves(int from, int piece, long mask) {
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


		static long[] getWhitePawnCaptures(int from) {
			ArrayList<Long> moves = new ArrayList<Long>();
			int x = from & 7;
			if (x != 0)
				pwcapture(moves, from, from + 7);
			if (x != 7)
				pwcapture(moves, from, from + 9);
			return toArraySorted(moves);
		}

		static void pwcapture(ArrayList<Long> moves, int from, int to) {
			if (to >= 56 && to < 64) {
				moves.add(BITS.assemblePromote(WP, WQ, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(WP, WR, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(WP, WN, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(WP, WB, from, to, CASTLING_STATE | SPECIAL));
			} else if(to<64){
				moves.add(BITS.assemble(WP, from, to, CASTLING_STATE));
			}
		}

		static long[] getBlackPawnCaptures(int from) {
			ArrayList<Long> moves = new ArrayList<Long>();
			int x = from & 7;
			if (x != 0)
				pbcapture(moves, from, from - 9);
			if (x != 7)
				pbcapture(moves, from, from - 7);
			return toArraySorted(moves);
		}

		static void pbcapture(ArrayList<Long> moves, int from, int to) {
			if (to >= 0 && to < 8) {
				moves.add(BITS.assemblePromote(BP, BQ, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(BP, BR, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(BP, BN, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(BP, BB, from, to, CASTLING_STATE | SPECIAL));
			} else if(to>=0){
				moves.add(BITS.assemble(BP, from, to, CASTLING_STATE));
			}
		}

		static long[][] getWhitePawnMoves(int from) {
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

		static long[][] getBlackPawnMoves(int from) {
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

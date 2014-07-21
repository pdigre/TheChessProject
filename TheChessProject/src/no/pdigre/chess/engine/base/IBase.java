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

//	MOVEMAP[] MM = new MOVEMAP[64];

	REVERSE[] REV = new REVERSE[64];

	BASE base = new BASE();


	
	class REVERSE {
		// Reverse lookup for in-check
		public long RPW=0L;
		public long RPB=0L;
		public long RN=0L;
		public long RB=0L;
		public long RR=0L;
		public long RQ=0L;
		public long RK=0L;
	}
	
	class BASE {
		final public static int LEFT = -1;

		final public static int RIGHT = 1;

		final public static int UP = 8;

		final public static int DOWN = -8;

		static MPWhite[] WP=new MPWhite[64];
		static MNWhite[] WN=new MNWhite[64];
		static MSliderWhite[] WB=new MSliderWhite[64];
		static MSliderWhite[] WR=new MSliderWhite[64];
		static MSliderWhite[] WQ=new MSliderWhite[64];
		static MKWhite[] WK=new MKWhite[64];
		static MPBlack[] BP=new MPBlack[64];
		static MNBlack[] BN=new MNBlack[64];
		static MSliderBlack[] BB=new MSliderBlack[64];
		static MSliderBlack[] BR=new MSliderBlack[64];
		static MSliderBlack[] BQ=new MSliderBlack[64];
		static MKBlack[] BK=new MKBlack[64];

		static {

			for (int from = 0; from < 64; from++) {
				REV[from] = new REVERSE();
				WN[from] = new MNWhite(from);
                BN[from] = new MNBlack(from);
				WR[from] = new MSliderWhite(from);
				BR[from] = new MSliderBlack(from);
				WB[from] = new MSliderWhite(from);
				BB[from] = new MSliderBlack(from);
				WQ[from] = new MSliderWhite(from);
				BQ[from] = new MSliderBlack(from);
				WP[from] = new MPWhite(from);
				BP[from] = new MPBlack(from);
				WK[from] = from == IConst.WK_STARTPOS ?new MKWhiteStart(from):new MKWhite(from);
				BK[from] = from == IConst.BK_STARTPOS ?new MKBlackStart(from):new MKBlack(from);

				WN[from].M = getKnightMoves(from, IConst.WN, CASTLING_STATE | HALFMOVES);
				BN[from].M = getKnightMoves(from, IConst.BN, CASTLING_STATE | HALFMOVES);
				WR[from].M = getRookMoves(from, IConst.WR, CASTLING_STATE | HALFMOVES);
				BR[from].M = getRookMoves(from, IConst.BR, CASTLING_STATE | HALFMOVES);
				WB[from].M = getBishopMoves(from, IConst.WB, CASTLING_STATE | HALFMOVES);
				BB[from].M = getBishopMoves(from, IConst.BB, CASTLING_STATE | HALFMOVES);
				WQ[from].M = getQueenMoves(from, IConst.WQ, CASTLING_STATE | HALFMOVES);
				BQ[from].M = getQueenMoves(from, IConst.BQ, CASTLING_STATE | HALFMOVES);
				WP[from].M = getWhitePawnMoves(from);
				BP[from].M = getBlackPawnMoves(from);
				WP[from].C = getWhitePawnCaptures(from);
				BP[from].C = getBlackPawnCaptures(from);
				WK[from].M = getKingMoves(from, IConst.WK, CANCASTLE_BLACK | HALFMOVES);
				BK[from].M = getKingMoves(from, IConst.BK, CANCASTLE_WHITE | HALFMOVES);

			}
			for (long[] b : WR[0].M)
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_WHITEQUEEN;
			for (long[] b : WR[7].M)
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_WHITEKING;
			for (long[] b : BR[56].M)
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_BLACKQUEEN;
			for (long[] b : BR[63].M)
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_BLACKKING;

			// initialize reverse King in-check
			for (int from = 0; from < 64; from++) {
				long bfrom = 1L << from;
				for (long bitmap : WN[from].M)
					REV[IConst.BITS.getTo(bitmap)].RN |= bfrom;
				for (long[] m2 : WB[from].M)
					for (long bitmap : m2)
						REV[IConst.BITS.getTo(bitmap)].RB |= bfrom;
				for (long[] m2 : WR[from].M)
					for (long bitmap : m2)
						REV[IConst.BITS.getTo(bitmap)].RR |= bfrom;
				for (long[] m2 : WQ[from].M)
					for (long bitmap : m2)
						REV[IConst.BITS.getTo(bitmap)].RQ |= bfrom;
				for (long bitmap : WK[from].M)
					REV[IConst.BITS.getTo(bitmap)].RK |= bfrom;
				for (long bitmap : WP[from].C)
					REV[IConst.BITS.getTo(bitmap)].RPW |= bfrom;
				for (long bitmap : BP[from].C)
					REV[IConst.BITS.getTo(bitmap)].RPB |= bfrom;
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
				moves.add(BITS.assemblePromote(IConst.WP, IConst.WQ, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(IConst.WP, IConst.WR, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(IConst.WP, IConst.WN, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(IConst.WP, IConst.WB, from, to, CASTLING_STATE | SPECIAL));
			} else if(to<64){
				moves.add(BITS.assemble(IConst.WP, from, to, CASTLING_STATE));
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
				moves.add(BITS.assemblePromote(IConst.BP, IConst.BQ, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(IConst.BP, IConst.BR, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(IConst.BP, IConst.BN, from, to, CASTLING_STATE | SPECIAL));
				moves.add(BITS.assemblePromote(IConst.BP, IConst.BB, from, to, CASTLING_STATE | SPECIAL));
			} else if(to>=0){
				moves.add(BITS.assemble(IConst.BP, from, to, CASTLING_STATE));
			}
		}

		static long[][] getWhitePawnMoves(int from) {
			ArrayList<long[]> moves = new ArrayList<long[]>();
			int to = from + 8;
			if (to >= 56 && to < 64) {
				moves.add(new long[] { BITS.assemblePromote(IConst.WP, IConst.WQ, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(IConst.WP, IConst.WR, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(IConst.WP, IConst.WN, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(IConst.WP, IConst.WB, from, to, CASTLING_STATE | SPECIAL) });
			} else if (from >= 8 && from < 16) {
				moves.add(new long[] { BITS.assemble(IConst.WP, from, to, CASTLING_STATE), BITS.assemble(IConst.WP, from, to + 8, CASTLING_STATE) });
			} else if (to < 64) {
				moves.add(new long[] { BITS.assemble(IConst.WP, from, to, CASTLING_STATE) });
			}
			return toArray2(moves);
		}

		static long[][] getBlackPawnMoves(int from) {
			ArrayList<long[]> moves = new ArrayList<long[]>();
			int to = from - 8;
			if (to >= 0 && to < 8) {
				moves.add(new long[] { BITS.assemblePromote(IConst.BP, IConst.BQ, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(IConst.BP, IConst.BR, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(IConst.BP, IConst.BN, from, to, CASTLING_STATE | SPECIAL),
						BITS.assemblePromote(IConst.BP, IConst.BB, from, to, CASTLING_STATE | SPECIAL) });
			} else if (from >= 48 && from < 56) {
				moves.add(new long[] { BITS.assemble(IConst.BP, from, to, CASTLING_STATE), BITS.assemble(IConst.BP, from, to - 8, CASTLING_STATE) });
			} else if (to >= 0) {
				moves.add(new long[] { BITS.assemble(IConst.BP, from, to, CASTLING_STATE) });
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

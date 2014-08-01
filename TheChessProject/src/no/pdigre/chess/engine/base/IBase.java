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
		static long[] TEMP=new long[8];
		static int itemp=0;
		static MOVEDATA[] DATA=new MOVEDATA[40000];
		static int idata=0;

		static {

			for (int from = 0; from < 64; from++) {
				REV[from] = new REVERSE();
			}
			for (int from = 0; from < 64; from++) {
				WN[from] = new MNWhite(from,getKnightMoves(from, IConst.WN, CASTLING_STATE | HALFMOVES));
                BN[from] = new MNBlack(from,getKnightMoves(from, IConst.BN, CASTLING_STATE | HALFMOVES));
				WR[from] = new MSliderWhite(from,getRookMoves(from, IConst.WR, CASTLING_STATE | HALFMOVES));
				BR[from] = new MSliderBlack(from,getRookMoves(from, IConst.BR, CASTLING_STATE | HALFMOVES));
				WB[from] = new MSliderWhite(from,getBishopMoves(from, IConst.WB, CASTLING_STATE | HALFMOVES));
				BB[from] = new MSliderBlack(from,getBishopMoves(from, IConst.BB, CASTLING_STATE | HALFMOVES));
				WQ[from] = new MSliderWhite(from,getQueenMoves(from, IConst.WQ, CASTLING_STATE | HALFMOVES));
				BQ[from] = new MSliderBlack(from,getQueenMoves(from, IConst.BQ, CASTLING_STATE | HALFMOVES));
				WP[from] = new MPWhite(from);
				BP[from] = new MPBlack(from);
				WK[from] = from == IConst.WK_STARTPOS ?new MKWhiteStart(from):new MKWhite(from);
				BK[from] = from == IConst.BK_STARTPOS ?new MKBlackStart(from):new MKBlack(from);
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
			}
		}

		static long[] getKnightMoves(int from, int piece, long mask) {
			add(piece, from, UP + LEFT + LEFT, mask);
			add(piece, from, UP + UP + LEFT, mask);
			add(piece, from, UP + RIGHT + RIGHT, mask);
			add(piece, from, UP + UP + RIGHT, mask);
			add(piece, from, DOWN + LEFT + LEFT, mask);
			add(piece, from, DOWN + DOWN + LEFT, mask);
			add(piece, from, DOWN + RIGHT + RIGHT, mask);
			add(piece, from, DOWN + DOWN + RIGHT, mask);
			return toArraySorted();
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
			add(piece, from, UP, mask);
			add(piece, from, DOWN, mask);
			add(piece, from, LEFT, mask);
			add(piece, from, RIGHT, mask);
			add(piece, from, UP + LEFT, mask);
			add(piece, from, UP + RIGHT, mask);
			add(piece, from, DOWN + LEFT, mask);
			add(piece, from, DOWN + RIGHT, mask);
			return toArraySorted();
		}


		static long[] getWhitePawnCaptures(int from) {
			int x = from & 7;
			if (x != 0)
				pwcapture(from, from + 7);
			if (x != 7)
				pwcapture(from, from + 9);
			return toArraySorted();
		}

		static void pwcapture(int from, int to) {
			if (to >= 56 && to < 64) {
				add(BITS.assemblePromote(IConst.WP, IConst.WQ, from, to, CASTLING_STATE | SPECIAL));
				add(BITS.assemblePromote(IConst.WP, IConst.WR, from, to, CASTLING_STATE | SPECIAL));
				add(BITS.assemblePromote(IConst.WP, IConst.WN, from, to, CASTLING_STATE | SPECIAL));
				add(BITS.assemblePromote(IConst.WP, IConst.WB, from, to, CASTLING_STATE | SPECIAL));
			} else if(to<64){
				add(BITS.assemble(IConst.WP, from, to, CASTLING_STATE));
			}
		}

		static long[] getBlackPawnCaptures(int from) {
			int x = from & 7;
			if (x != 0)
				pbcapture(from, from - 9);
			if (x != 7)
				pbcapture(from, from - 7);
			return toArraySorted();
		}

		static void pbcapture(int from, int to) {
			if (to >= 0 && to < 8) {
				add(BITS.assemblePromote(IConst.BP, IConst.BQ, from, to, CASTLING_STATE | SPECIAL));
				add(BITS.assemblePromote(IConst.BP, IConst.BR, from, to, CASTLING_STATE | SPECIAL));
				add(BITS.assemblePromote(IConst.BP, IConst.BN, from, to, CASTLING_STATE | SPECIAL));
				add(BITS.assemblePromote(IConst.BP, IConst.BB, from, to, CASTLING_STATE | SPECIAL));
			} else if(to>=0){
				add(BITS.assemble(IConst.BP, from, to, CASTLING_STATE));
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

		static long[] toArray() {
			long[] ret = new long[itemp];
			for (int i = 0; i < itemp; i++) {
				ret[i] = TEMP[i];
			}
			itemp=0;
			return ret;
		}

		static long[] toArraySorted() {
			long[] ret = toArray();
			Arrays.sort(ret);
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
		static boolean add(int piece, int from, int offset, long mask) {
			int to = from + offset;
			boolean has = inside(to, from);
			if (has)
				add(BITS.assemble(piece, from, to, mask));
			return has;
		}

		static boolean addSlide(int piece, int from, int offset, long mask, int from2) {
			int to = from + offset;
			boolean has = inside(to, from);
			if (has)
				add(BITS.assemble(piece, from2, to, mask));
			return has;
		}

		static void add(long bitmap){
//			DATA[idata]=new MOVEDATA(bitmap);
			TEMP[itemp++]=bitmap;
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
			for (int slidefrom = from; addSlide(piece, slidefrom, offset, mark, from); slidefrom += offset)
				;
			long[] mv = toArray();
			if (mv.length > 0)
				main.add(mv);
		}
	}

}

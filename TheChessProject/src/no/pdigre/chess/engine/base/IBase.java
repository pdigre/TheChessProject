package no.pdigre.chess.engine.base;

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
	long[] BETWEEN=new long[4096];
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
		static MBWhite[] WB=new MBWhite[64];
		static MRWhite[] WR=new MRWhite[64];
		static MQWhite[] WQ=new MQWhite[64];
		static MKWhite[] WK=new MKWhite[64];
		static MPBlack[] BP=new MPBlack[64];
		static MNBlack[] BN=new MNBlack[64];
		static MBBlack[] BB=new MBBlack[64];
		static MRBlack[] BR=new MRBlack[64];
		static MQBlack[] BQ=new MQBlack[64];
		static MKBlack[] BK=new MKBlack[64];
		static long[] TEMP=new long[8];
		static int itemp=0;
		static MOVEDATA[] DATA=new MOVEDATA[40000];
		static int idata=0;
		final static int[] DIAGONAL_MOVES = new int[]{UP+LEFT,UP+RIGHT,DOWN+LEFT,DOWN+RIGHT};
		final static int[] LINE_MOVES = new int[]{UP,DOWN,LEFT,RIGHT};
		final static int[] KNIGHT_MOVES = new int[]{UP + LEFT + LEFT,UP + UP + LEFT,UP + RIGHT + RIGHT,UP + UP + RIGHT,
			DOWN + LEFT + LEFT,DOWN + DOWN + LEFT,DOWN + RIGHT + RIGHT,DOWN + DOWN + RIGHT};

		static {
			fillBetween(DIAGONAL_MOVES);
			fillBetween(LINE_MOVES);
			
			for (int from = 0; from < 64; from++){
				REVERSE r = new REVERSE();
				REV[from] = r;
				r.RB=s(from,DIAGONAL_MOVES);
				r.RR=s(from,LINE_MOVES);
				r.RQ=r.RB|r.RR;
				r.RK=m(from,LINE_MOVES)|m(from,DIAGONAL_MOVES);
				r.RN=m(from,KNIGHT_MOVES);
			}
			
			for (int from = 0; from < 64; from++) {
				WN[from] = new MNWhite(from);
                BN[from] = new MNBlack(from);
				WR[from] = from == IConst.WR_KING_STARTPOS || from == WR_QUEEN_STARTPOS?new MRWhiteStart(from):new MRWhite(from);
				BR[from] = from == IConst.BR_KING_STARTPOS || from == BR_QUEEN_STARTPOS?new MRBlackStart(from):new MRBlack(from);
				WB[from] = new MBWhite(from);
				BB[from] = new MBBlack(from);
				WQ[from] = new MQWhite(from);
				BQ[from] = new MQBlack(from);
				WP[from] = new MPWhite(from);
				BP[from] = new MPBlack(from);
				WK[from] = from == IConst.WK_STARTPOS ?new MKWhiteStart(from):new MKWhite(from);
				BK[from] = from == IConst.BK_STARTPOS ?new MKBlackStart(from):new MKBlack(from);
			}
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
		
		static long s(int from,int[] offset) {
			long ret=0L;
			for (int i = 0; i < offset.length; i++) {
				int off=offset[i];
				int to=from+off;
				while(inside(to, to-off)){
					ret |= (1L<<to);
					to+=off;
				}
			}
			return ret;
		}

		static long m(int from,int[] offset) {
			long ret=0L;
			for (int i = 0; i < offset.length; i++) {
				int to=from+offset[i];
				if(inside(to, from))
					ret|= 1L<<to;
			}
			return ret;
		}

		static void fillBetween(int[] offset) {
			for (int j = 0; j < offset.length; j++) {
				int off=offset[j];
				for (int from = 0; from < 64; from++){
					int to=from+off;
					long ray=0L;
					while(inside(to, to-off)){
						int num = from+to*64;
						BETWEEN[num]=ray;
						ray |= (1L<<to);
						to+=off;
					}
				}
			}
		}
	}
}

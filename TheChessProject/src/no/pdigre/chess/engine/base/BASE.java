package no.pdigre.chess.engine.base;

public class BASE implements IConst{
	final public static int LEFT = -1;
	final public static int RIGHT = 1;
	final public static int UP = 8;
	final public static int DOWN = -8;
	final public static REVERSE[] REV;
	static MBP[] BP=new MBP[64];
	static MBB[] BB=new MBB[64];
	static MBR[] BR=new MBR[64];
	static MBQ[] BQ=new MBQ[64];
	static MBK[] BK=new MBK[64];
	static long[] TEMP=new long[8];
	static int itemp=0;
	static MOVEDATA[] DATA=new MOVEDATA[40000];
	static int idata=0;
	final static long[] BETWEEN;
	final static int[] DIAGONAL_MOVES = new int[]{UP+LEFT,UP+RIGHT,DOWN+LEFT,DOWN+RIGHT};
	final static int[] LINE_MOVES = new int[]{UP,DOWN,LEFT,RIGHT};
	final static int[] KNIGHT_MOVES = new int[]{UP + LEFT + LEFT,UP + UP + LEFT,UP + RIGHT + RIGHT,UP + UP + RIGHT,
		DOWN + LEFT + LEFT,DOWN + DOWN + LEFT,DOWN + RIGHT + RIGHT,DOWN + DOWN + RIGHT};

	static {
		REV = new REVERSE[64];
		for (int from = 0; from < 64; from++) {
			long RB = s(from, BASE.DIAGONAL_MOVES);
			long RR = s(from, BASE.LINE_MOVES);
			long RQ = RB | RR;
			long RK = m(from, BASE.LINE_MOVES) | m(from, BASE.DIAGONAL_MOVES);
			long RN = m(from, BASE.KNIGHT_MOVES);
			REV[from] = new REVERSE(RN, RB, RR, RQ,RK);
		}
	}

	static {
		BETWEEN=new long[4096];
		fillBetween(DIAGONAL_MOVES);
		fillBetween(LINE_MOVES);
		
		for (int from = 0; from < 64; from++) {
			BR[from] = from == IConst.BR_KING_STARTPOS || from == BR_QUEEN_STARTPOS?new MBRStart(from):new MBR(from);
			BB[from] = new MBB(from);
			BQ[from] = new MBQ(from);
			BP[from] = new MBP(from);
			BK[from] = from == IConst.BK_STARTPOS ?new MBKStart(from):new MBK(from);
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

	static long m(int from, int[] offset) {
		long ret = 0L;
		for (int i = 0; i < offset.length; i++) {
			int to = from + offset[i];
			if (BASE.inside(to, from))
				ret |= 1L << to;
		}
		return ret;
	}

	static long s(int from, int[] offset) {
		long ret = 0L;
		for (int i = 0; i < offset.length; i++) {
			int off = offset[i];
			int to = from + off;
			while (BASE.inside(to, to - off)) {
				ret |= (1L << to);
				to += off;
			}
		}
		return ret;
	}
}
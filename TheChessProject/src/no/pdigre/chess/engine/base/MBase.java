package no.pdigre.chess.engine.base;



public abstract class MBase implements IConst{
	
	final static int[] WPROMOTES=new int[]{IConst.WN,IConst.WB,IConst.WR,IConst.WQ};
	final static int[] BPROMOTES=new int[]{IConst.BN,IConst.BB,IConst.BR,IConst.BQ};
	final static int[] WCAPTURES=new int[]{IConst.BP,IConst.BN,IConst.BB,IConst.BR,IConst.BQ};
	final static int[] BCAPTURES=new int[]{IConst.WP,IConst.WN,IConst.WB,IConst.WR,IConst.WQ};
	
	final public int from;
	
	public MBase(int from) {
		this.from = from;
	}

	final long purge(long bitmap, int subtract) {
		int score = BITS.score(bitmap) - subtract;
		return (((long) score) << 32) | ((int) bitmap);
	}

	public static MOVEDATA[] castling(MOVEDATA[] m) {
		MOVEDATA[] x=new MOVEDATA[m.length];
		for (int i = 0; i < m.length; i++)
			x[i]=new MOVEDATAX(m[i]);
		return x;
	}

	public static MOVEDATA[] castling(MOVEDATA[] m,long mask) {
		MOVEDATA[] x=new MOVEDATA[m.length];
		for (int i = 0; i < m.length; i++)
			x[i]=new MOVEDATAX(m[i],mask);
		return x;
	}
	public static MOVEDATA[][] castling(MOVEDATA[][] M,long castling) {
		MOVEDATA[][] x=new MOVEDATA[M.length][];
		for (int i = 0; i < M.length; i++)
			x[i]=castling(M[i],castling);
		return x;
	}
	
	public void genLegal(Movegen gen){
		//
	}

	public static <X extends MBase> void genLegal(Movegen gen,long b, X[] arr) {
		int bits = Long.bitCount(b);
		for (int j = 0; j < bits; j++) {
			int from = Long.numberOfTrailingZeros(b);
			b ^= 1L << from;
			arr[from].genLegal(gen);
		}
	}
}

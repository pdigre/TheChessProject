package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;


public abstract class MBase {
	
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

	public MOVEDATA[] castling(MOVEDATA[] m) {
		MOVEDATA[] x=new MOVEDATA[m.length];
		for (int i = 0; i < m.length; i++)
			x[i]=new MOVEDATAX(m[i]);
		return x;
	}

	public MOVEDATA[] castling(MOVEDATA[] m,long mask) {
		MOVEDATA[] x=new MOVEDATA[m.length];
		for (int i = 0; i < m.length; i++)
			x[i]=new MOVEDATAX(m[i],mask);
		return x;
	}
	public MOVEDATA[][] castling(MOVEDATA[][] M,long castling) {
		MOVEDATA[][] x=new MOVEDATA[M.length][];
		for (int i = 0; i < M.length; i++)
			x[i]=castling(M[i],castling);
		return x;
	}
	
	public void genLegal(Movegen gen){
		//
	}

	public void genEvasions(Movegen gen){
		//
	}

	public void genQuiescence(Movegen gen){
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

	public void wmoves(Movegen gen, MOVEDATA[][] moves) {
		for (MOVEDATA[] m : moves){
			long bto = m[5].bto;
			if ((gen.bb_piece & bto) == 0) {
				gen.add(m[5]);
			} else if ((gen.bb_black & bto) != 0) {
				gen.add(m[gen.ctype(bto)]);
			}
		}
		gen.pruneWhite();
	}

	public void wmoves2(Movegen gen, MOVEDATA[][] moves) {
		for (MOVEDATA[] m : moves){
			long bto = m[5].bto;
			if ((gen.bb_piece & bto) == 0) {
				gen.addkw(m[5]);
			} else if ((gen.bb_black & bto) != 0) {
				gen.addkw(m[gen.ctype(bto)]);
			}
		}
	}

	public void bmoves(Movegen gen, MOVEDATA[][] moves) {
		for (MOVEDATA[] m : moves){
			long bto = m[5].bto;
			if ((gen.bb_piece & bto) == 0) {
				gen.add(m[5]);
			} else if ((gen.bb_white & bto) != 0) {
				gen.add(m[gen.ctype(bto)]);
			}
		}
		gen.pruneBlack();
	}

	public void bmoves2(Movegen gen, MOVEDATA[][] moves) {
		for (MOVEDATA[] m : moves){
			long bto = m[5].bto;
			if ((gen.bb_piece & bto) == 0) {
				gen.addkb(m[5]);
			} else if ((gen.bb_white & bto) != 0) {
				gen.addkb(m[gen.ctype(bto)]);
			}
		}
	}

}

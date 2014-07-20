package no.pdigre.chess.engine.base;

public enum EBase {
	WB(IConst.WB, 330),
	WR(IConst.WR, 500),
	WQ(IConst.WQ, 900),
	WP(IConst.WP, 100),
	WN(IConst.WN, 320),
	WK(IConst.WK, 20000),
	BP(IConst.BP, -100),
	BN(IConst.BN, -320),
	BB(IConst.BB, -330),
	BR(IConst.BR, -500),
	BQ(IConst.BQ, -900),
	BK(IConst.BK, -20000);

	final public static EBase[] TYPES = fill();

	public final int key;
	public final int value;
	public final int[] score;
	public final long[] zobrist;

	EBase(int i, int pval) {
		key = i;
		value = pval;
		score = score(i);
		zobrist = longkey(i);
	}

	private long[] longkey(int p) {
		long[] l = new long[64];
		int n = ZobristKey.getKindOfPiece(p) * 64;
		for (int i = 0; i < 64; i++)
			l[i] = ZobristKey.random64[n + i];
		return l;
	}

	private int[] score(int i) {
		return null;
	}

	static EBase[] fill() {
		EBase[] fill = new EBase[16];
		for (EBase b : EBase.values())
			fill[b.key] = b;
		return fill;
	}

}

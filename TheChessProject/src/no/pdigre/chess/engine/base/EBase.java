package no.pdigre.chess.engine.base;

public enum EBase {
	WHITE_BISHOP(IConst.WHITE_BISHOP, 330),
	WHITE_ROOK(IConst.WHITE_ROOK, 500),
	WHITE_QUEEN(IConst.WHITE_QUEEN, 900),
	WHITE_PAWN(IConst.WHITE_PAWN, 100),
	WHITE_KNIGHT(IConst.WHITE_KNIGHT, 320),
	WHITE_KING(IConst.WHITE_KING, 20000),
	BLACK_PAWN(IConst.BLACK_PAWN, -100),
	BLACK_KNIGHT(IConst.BLACK_KNIGHT, -320),
	BLACK_BISHOP(IConst.BLACK_BISHOP, -330),
	BLACK_ROOK(IConst.BLACK_ROOK, -500),
	BLACK_QUEEN(IConst.BLACK_QUEEN, -900),
	BLACK_KING(IConst.BLACK_KING, -20000);

	final public static EBase[] TYPES = fill();

	public final int key;
	public final int value;
	public final Object[] moves;
	public final long[] move64;
	public final int[] score;
	public final long[] zobrist;

	EBase(int i, int pval) {
		key = i;
		moves = moves(i);
		move64 = move64(moves);
		value = pval;
		score = score(i);
		zobrist = longkey(i);
	}

	private int[] shortkey(long[] r642) {
		// TODO Auto-generated method stub
		return null;
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

	static private long[] move64(Object[] moves) {
		return null;
	}

	static private Object[] moves(int i) {
		switch (i) {
		case IConst.BLACK_BISHOP:
			return IBase.M32_BLACK_BISHOP;
		case IConst.BLACK_KING:
			return IBase.M32_BLACK_KING;
		case IConst.BLACK_KNIGHT:
			return IBase.M32_BLACK_KNIGHT;
		case IConst.BLACK_PAWN:
			return IBase.M32_BLACK_PAWN;
		case IConst.BLACK_QUEEN:
			return IBase.M32_BLACK_QUEEN;
		case IConst.BLACK_ROOK:
			return IBase.M32_BLACK_ROOK;
		case IConst.WHITE_BISHOP:
			return IBase.M32_WHITE_BISHOP;
		case IConst.WHITE_KING:
			return IBase.M32_WHITE_KING;
		case IConst.WHITE_KNIGHT:
			return IBase.M32_WHITE_KNIGHT;
		case IConst.WHITE_PAWN:
			return IBase.M32_WHITE_PAWN;
		case IConst.WHITE_QUEEN:
			return IBase.M32_WHITE_QUEEN;
		case IConst.WHITE_ROOK:
			return IBase.M32_WHITE_ROOK;
		}
		return null;
	}

	static EBase[] fill() {
		EBase[] fill = new EBase[16];
		for (EBase b : EBase.values())
			fill[b.key] = b;
		return fill;
	}

}

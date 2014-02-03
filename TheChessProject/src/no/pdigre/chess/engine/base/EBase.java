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
	
	final int key;
	final int value;
	final Object[] moves;
	final long[] move64;
	final int[] score;
	final int[] r32;
	final long[] r64;

	EBase(int i, int pval) {
		key = i;
		moves = moves(this);
		move64 = move64(moves);
		value = pval;
		score = score(this);
		r64 = longkey(i);
		r32 = shortkey(r64);

		switch (i) {
		case IConst.WHITE_KNIGHT:
			break;
		case IConst.BLACK_KNIGHT:
			break;
		case IConst.WHITE_BISHOP:
			break;
		case IConst.BLACK_BISHOP:
			break;
		case IConst.WHITE_QUEEN:
			break;
		case IConst.BLACK_QUEEN:
			break;
		case IConst.WHITE_ROOK:
			break;
		case IConst.BLACK_ROOK:
			break;
		case IConst.WHITE_PAWN:
			break;
		case IConst.BLACK_PAWN:
			break;
		case IConst.WHITE_KING:
			break;
		case IConst.BLACK_KING:
			break;
		default:
			break;
		}
	}

	private int[] shortkey(long[] r642) {
		// TODO Auto-generated method stub
		return null;
	}

	private long[] longkey(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	private int[] score(EBase eBase) {
		// TODO Auto-generated method stub
		return null;
	}

	static private long[] move64(Object[] moves2) {
		// TODO Auto-generated method stub
		return null;
	}

	static private Object[] moves(EBase e) {
		switch (e) {
		case BLACK_BISHOP:
			return IBase.M32_BLACK_BISHOP;
		case BLACK_KING:
			return IBase.M32_BLACK_KING;
		case BLACK_KNIGHT:
			return IBase.M32_BLACK_KNIGHT;
		case BLACK_PAWN:
			return IBase.M32_BLACK_PAWN;
		case BLACK_QUEEN:
			return IBase.M32_BLACK_QUEEN;
		case BLACK_ROOK:
			return IBase.M32_BLACK_ROOK;
		case WHITE_BISHOP:
			return IBase.M32_WHITE_BISHOP;
		case WHITE_KING:
			return IBase.M32_WHITE_KING;
		case WHITE_KNIGHT:
			return IBase.M32_WHITE_KNIGHT;
		case WHITE_PAWN:
			return IBase.M32_WHITE_PAWN;
		case WHITE_QUEEN:
			return IBase.M32_WHITE_QUEEN;
		case WHITE_ROOK:
			return IBase.M32_WHITE_ROOK;
		}
		return null;
	}
}

package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IBase.MOVEDATA;
import no.pdigre.chess.engine.base.IConst.BITS;


public abstract class MBase {
	final public int from;
	public abstract void all(Movegen gen);

	public MBase(int from) {
		this.from = from;
	}

	final boolean slideWhite(Movegen gen,long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if (!((gen.bb_piece & bto) != 0)) {
			add(gen,(bitmap & gen.castling) | gen.halfmoves);
			return true;
		} else if ((gen.bb_black & bto) != 0) {
			int type = type(gen,bto);
			if (type == GMovegen.WR) {
				if (to == GMovegen.BR_KING_STARTPOS)
					bitmap = bitmap & ~GMovegen.CANCASTLE_BLACKKING;
				if (to == GMovegen.BR_QUEEN_STARTPOS)
					bitmap = bitmap & ~GMovegen.CANCASTLE_BLACKQUEEN;
			}
			add(gen,(purge(bitmap, PSQT.pVal(to, type + 8)) & gen.castling) | (type << GMovegen._CAPTURE));
		}
		return false;
	}

	final boolean slideBlack(Movegen gen,long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if (!((gen.bb_piece & bto) != 0)) {
			add(gen,(bitmap & gen.castling) | gen.halfmoves);
			return true;
		} else if ((gen.bb_white & bto) != 0) {
			int type = type(gen,bto);
			if (type == GMovegen.WR) {
				if (to == GMovegen.WR_KING_STARTPOS)
					bitmap = bitmap & ~GMovegen.CANCASTLE_WHITEKING;
				if (to == GMovegen.WR_QUEEN_STARTPOS)
					bitmap = bitmap & ~GMovegen.CANCASTLE_WHITEQUEEN;
			}
			add(gen,(purge(bitmap, PSQT.pVal(to, type)) & gen.castling) | (type << GMovegen._CAPTURE));
		}
		return false;
	}

	final long purge(long bitmap, int subtract) {
		int score = BITS.score(bitmap) - subtract;
		return (((long) score) << 32) | ((int) bitmap);
	}

	final boolean pawnSlide(Movegen gen,long bitmap) {
		if ((gen.bb_piece & BITS.bitsTo(bitmap)) == 0) {
			add(gen,bitmap & gen.castling);
			return true;
		}
		return false;
	}

	final void add(Movegen gen,long bitmap) {
		gen.moves[gen.imoves++] = new MOVEDATA(bitmap);
	}

	final int type(Movegen gen,long bit) {
		return ((gen.bb_bit1 & bit) == 0 ? 0 : 1) | ((gen.bb_bit2 & bit) == 0 ? 0 : 2) | ((gen.bb_bit3 & bit) == 0 ? 0 : 4);
	}
	
	public static <X extends MBase> void genMoves(Movegen gen,long b, X[] arr) {
		int bits = Long.bitCount(b);
		for (int j = 0; j < bits; j++) {
			int from = Long.numberOfTrailingZeros(b);
			b ^= 1L << from;
			arr[from].all(gen);
		}
	}
	
}

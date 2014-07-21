package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;


public abstract class MBase {
	final public int from;
	public abstract void move(GNodegen gen);

	public MBase(int from) {
		this.from = from;
	}

	final boolean slideWhite(GNodegen gen,long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if (!((gen.bb_piece & bto) != 0)) {
			add(gen,(bitmap & gen.castling) | gen.halfmoves);
			return true;
		} else if ((gen.bb_black & bto) != 0) {
			int type = type(gen,bto);
			if (type == GNodegen.WR) {
				if (to == GNodegen.BR_KING_STARTPOS)
					bitmap = bitmap & ~GNodegen.CANCASTLE_BLACKKING;
				if (to == GNodegen.BR_QUEEN_STARTPOS)
					bitmap = bitmap & ~GNodegen.CANCASTLE_BLACKQUEEN;
			}
			add(gen,(purge(bitmap, PSQT.pVal(to, type + 8)) & gen.castling) | (type << GNodegen._CAPTURE));
		}
		return false;
	}

	final boolean slideBlack(GNodegen gen,long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if (!((gen.bb_piece & bto) != 0)) {
			add(gen,(bitmap & gen.castling) | gen.halfmoves);
			return true;
		} else if ((gen.bb_white & bto) != 0) {
			int type = type(gen,bto);
			if (type == GNodegen.WR) {
				if (to == GNodegen.WR_KING_STARTPOS)
					bitmap = bitmap & ~GNodegen.CANCASTLE_WHITEKING;
				if (to == GNodegen.WR_QUEEN_STARTPOS)
					bitmap = bitmap & ~GNodegen.CANCASTLE_WHITEQUEEN;
			}
			add(gen,(purge(bitmap, PSQT.pVal(to, type)) & gen.castling) | (type << GNodegen._CAPTURE));
		}
		return false;
	}

	final long purge(long bitmap, int subtract) {
		int score = BITS.score(bitmap) - subtract;
		return (((long) score) << 32) | ((int) bitmap);
	}

	final boolean pawnSlide(GNodegen gen,long bitmap) {
		if ((gen.bb_piece & BITS.bitsTo(bitmap)) == 0) {
			add(gen,bitmap & gen.castling);
			return true;
		}
		return false;
	}

	final void add(GNodegen gen,long bitmap) {
		gen.moves[gen.imoves++] = bitmap;
	}

	final int type(GNodegen gen,long bit) {
		return ((gen.bb_bit1 & bit) == 0 ? 0 : 1) | ((gen.bb_bit2 & bit) == 0 ? 0 : 2) | ((gen.bb_bit3 & bit) == 0 ? 0 : 4);
	}
	
}

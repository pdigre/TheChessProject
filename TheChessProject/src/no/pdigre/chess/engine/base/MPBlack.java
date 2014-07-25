package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MPBlack  extends MBase{
	public MPBlack(int from) {
		super(from);
		M = IBase.BASE.getBlackPawnMoves(from);
		C = IBase.BASE.getBlackPawnCaptures(from);
	}

	long[][] M;
	long[] C;
	
	@Override
	public void all(GNodegen gen) {
		for (long[] slides : M)
			for (int i = 0; i < slides.length && pawnSlide(gen,slides[i]); i++)
				;
		for (long bitmap : C) {
			int to = BITS.getTo(bitmap);
			if (gen.enpassant == to) {
				add(gen,(purge(bitmap, PSQT.pVal(to + 8, IConst.WP)) & gen.castling) | (IConst.WP << IConst._CAPTURE) | IConst.SPECIAL);
			} else {
				long bto = 1L << to;
				if ((gen.bb_white & bto) != 0) {
					int type = type(gen,bto);
					add(gen,(purge(bitmap, PSQT.pVal(to, type)) & gen.castling) | (type << IConst._CAPTURE));
				}
			}
		}
		gen.pruneBlack();
	}
}

package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MKWhiteStart extends MKWhite {
	final static long CASTLING_WK = BITS.assemble(IConst.WK, IConst.WK_STARTPOS, IConst.WK_STARTPOS + 2, IConst.CANCASTLE_BLACK | IConst.SPECIAL);
	final static long CASTLING_WQ = BITS.assemble(IConst.WK, IConst.WK_STARTPOS, IConst.WK_STARTPOS - 2, IConst.CANCASTLE_BLACK | IConst.SPECIAL);
	final static long SIDE_WK = BITS.assemble(IConst.WK, IConst.WK_STARTPOS, IConst.WK_STARTPOS + 1, IConst.CANCASTLE_BLACK);
	final static long SIDE_WQ = BITS.assemble(IConst.WK, IConst.WK_STARTPOS, IConst.WK_STARTPOS - 1, IConst.CANCASTLE_BLACK);

	public MKWhiteStart(int from) {
		super(from);
	}

	@Override
	public void all(GNodegen gen) {
		for (long bitmap : M)
			slideWhite(gen, bitmap);
		if ((IConst.CWQ & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_WHITEQUEEN) != 0
				&& !gen.pos.isCheckWhite()
				&& !gen.pos.move(SIDE_WQ).isCheckWhite()) {
			add(gen, CASTLING_WQ & gen.castling);
		}
		if ((IConst.CWK & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_WHITEKING) != 0
				&& !gen.pos.isCheckWhite()
				&& !gen.pos.move(SIDE_WK).isCheckWhite()) {
			add(gen, CASTLING_WK & gen.castling);
		}
		gen.pruneWhite();
	}
}

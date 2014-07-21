package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MKBlackStart extends MKBlack {
	final static long CASTLING_BK = BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS + 2, IConst.CANCASTLE_WHITE | IConst.SPECIAL);
	final static long CASTLING_BQ = BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS - 2, IConst.CANCASTLE_WHITE | IConst.SPECIAL);
	final static long SIDE_BK = BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS + 1, IConst.CANCASTLE_WHITE);
	final static long SIDE_BQ = BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS - 1, IConst.CANCASTLE_WHITE);

	public MKBlackStart(int from) {
		super(from);
	}

	@Override
	public void move(GNodegen gen) {
		for (long bitmap : M)
			slideBlack(gen, bitmap);
		if ((IConst.CBQ & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_BLACKQUEEN) != 0
				&& !gen.pos.isCheckBlack()
				&& !gen.pos.move(SIDE_BQ).isCheckBlack()) {
			add(gen, CASTLING_BQ & gen.castling);
		}
		if ((IConst.CBK & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_BLACKKING) != 0
				&& !gen.pos.isCheckBlack()
				&& !gen.pos.move(SIDE_BK).isCheckBlack()) {
			add(gen, CASTLING_BK & gen.castling);
		}
	}
}

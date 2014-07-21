package no.pdigre.chess.engine.base;

public class MKBlackStart extends MKBlack {
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
				&& !gen.pos.move(IBase.SIDE_BQ).isCheckBlack()) {
			add(gen, IBase.CASTLING_BQ & gen.castling);
		}
		if ((IConst.CBK & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_BLACKKING) != 0
				&& !gen.pos.isCheckBlack()
				&& !gen.pos.move(IBase.SIDE_BK).isCheckBlack()) {
			add(gen, IBase.CASTLING_BK & gen.castling);
		}
	}
}

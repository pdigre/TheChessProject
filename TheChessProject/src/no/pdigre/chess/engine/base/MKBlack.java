package no.pdigre.chess.engine.base;

public class MKBlack extends MBase {
	public MKBlack(int from) {
		super(from);
	}

	long[] M;

	@Override
	public void move(GNodegen gen) {
		for (long bitmap : M)
			slideBlack(gen,bitmap);
		if (from == IConst.BK_STARTPOS) {
			if ((IConst.CBQ & gen.bb_piece) == 0 && (gen.castling & IConst.CANCASTLE_BLACKQUEEN) != 0 && !gen.pos.isCheckBlack()
					&& !gen.pos.move(IBase.SIDE_BQ).isCheckBlack()) {
				add(gen,IBase.CASTLING_BQ & gen.castling);
			}
			if ((IConst.CBK & gen.bb_piece) == 0 && (gen.castling & IConst.CANCASTLE_BLACKKING) != 0 && !gen.pos.isCheckBlack() && !gen.pos.move(IBase.SIDE_BK).isCheckBlack()) {
				add(gen,IBase.CASTLING_BK & gen.castling);
			}
		}
	}
}

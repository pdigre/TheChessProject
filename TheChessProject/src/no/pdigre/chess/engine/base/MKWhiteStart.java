package no.pdigre.chess.engine.base;

public class MKWhiteStart extends MKWhite {
	public MKWhiteStart(int from) {
		super(from);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(GNodegen gen) {
		for (long bitmap : M)
			slideWhite(gen, bitmap);
		if ((IConst.CWQ & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_WHITEQUEEN) != 0
				&& !gen.pos.isCheckWhite()
				&& !gen.pos.move(IBase.SIDE_WQ).isCheckWhite()) {
			add(gen, IBase.CASTLING_WQ & gen.castling);
		}
		if ((IConst.CWK & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_WHITEKING) != 0
				&& !gen.pos.isCheckWhite()
				&& !gen.pos.move(IBase.SIDE_WK).isCheckWhite()) {
			add(gen, IBase.CASTLING_WK & gen.castling);
		}
	}
}

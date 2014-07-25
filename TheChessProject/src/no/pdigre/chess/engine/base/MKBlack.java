package no.pdigre.chess.engine.base;

public class MKBlack extends MBase {
	public MKBlack(int from) {
		super(from);
		M=IBase.BASE.getKingMoves(from, IConst.BK, IBase.CANCASTLE_WHITE | IBase.HALFMOVES);
	}

	long[] M;

	@Override
	public void all(GNodegen gen) {
		for (long bitmap : M)
			slideBlack(gen,bitmap);
		gen.pruneBlack();
	}
}

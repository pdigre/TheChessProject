package no.pdigre.chess.engine.base;

public class MKWhite extends MBase {
	public MKWhite(int from) {
		super(from);
		M=IBase.BASE.getKingMoves(from, IConst.WK, IBase.CANCASTLE_BLACK | IBase.HALFMOVES);
	}

	long[] M;

	public void all(Movegen gen) {
		for (long bitmap : M)
			slideWhite(gen, bitmap);
		gen.pruneWhite();
	}
}

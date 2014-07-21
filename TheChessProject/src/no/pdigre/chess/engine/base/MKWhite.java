package no.pdigre.chess.engine.base;

public class MKWhite extends MBase {
	public MKWhite(int from) {
		super(from);
	}

	long[] M;

	@Override
	public void move(GNodegen gen) {
		for (long bitmap : M)
			slideWhite(gen, bitmap);
	}
}

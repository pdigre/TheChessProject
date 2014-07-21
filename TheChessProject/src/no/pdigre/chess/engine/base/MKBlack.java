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
	}
}

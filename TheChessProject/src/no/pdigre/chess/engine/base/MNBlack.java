package no.pdigre.chess.engine.base;

public class MNBlack extends MBase {
	public MNBlack(int from) {
		super(from);
	}

	long M64 = 0L;
	long[] M;

	public void move(GNodegen gen) {
		for (long m : M)
			slideBlack(gen,m);
	}

}

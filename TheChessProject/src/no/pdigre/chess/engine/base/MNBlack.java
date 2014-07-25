package no.pdigre.chess.engine.base;

public class MNBlack extends MBase {
	
	public MNBlack(int from,long[] m) {
		super(from);
		M=m;
	}

	final long[] M;

	public void all(GNodegen gen) {
		for (long m : M)
			slideBlack(gen,m);
		gen.pruneBlack();
	}

}

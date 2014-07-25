package no.pdigre.chess.engine.base;

public class MNWhite extends MBase{
	public MNWhite(int from,long[] m) {
		super(from);
		M=m;
	}

	final long[] M;

	public void all(GNodegen gen){
		for (long m : M)
			slideWhite(gen,m);
		gen.pruneWhite();
	}

}

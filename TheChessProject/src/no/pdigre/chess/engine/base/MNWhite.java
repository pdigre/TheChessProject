package no.pdigre.chess.engine.base;

public class MNWhite extends MBase{
	public MNWhite(int from) {
		super(from);
	}

	long[] M;

	public void move(GNodegen gen){
		for (long m : M)
			slideWhite(gen,m);
	}

}

package no.pdigre.chess.engine.base;

public class MNWhite extends MBase{
	long M64=0L;
	long[] M;

	public void move(GNodegen gen){
		for (long m : M)
			gen.slideWhite(m);
	}

}

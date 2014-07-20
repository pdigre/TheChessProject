package no.pdigre.chess.engine.base;

public class MNBlack extends MBase{
	long M64=0L;
	long[] M;

	public void move(GNodegen gen){
		for (long m : M)
			gen.slideBlack(m);
	}

}

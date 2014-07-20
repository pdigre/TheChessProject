package no.pdigre.chess.engine.base;

public class MN extends MBase{
	long M64=0L;
	long[] MW;
	long[] MB;

	public void moveW(GNodegen gen){
		for (long m : MW)
			gen.slideWhite(m);
	}

	public void moveB(GNodegen gen){
		for (long m : MB)
			gen.slideWhite(m);
	}

}

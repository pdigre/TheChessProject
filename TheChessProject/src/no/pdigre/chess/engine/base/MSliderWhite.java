package no.pdigre.chess.engine.base;


public class MSliderWhite extends MBase{
	public MSliderWhite(int from,long[][] m) {
		super(from);
		M=m;
	}

	final long[][] M;
	
	public void all(GNodegen gen){
		for (long[] slides : M)
			for (int i = 0; i < slides.length && slideWhite(gen,slides[i]); i++)
				;
		gen.pruneWhite();
	}
}

package no.pdigre.chess.engine.base;


public class MSliderBlack extends MBase{
	public MSliderBlack(int from,long[][] m) {
		super(from);
		M=m;
	}

	long[][] M;
	
	public void all(Movegen gen){
		for (long[] slides : M)
			for (int i = 0; i < slides.length && slideBlack(gen,slides[i]); i++)
				;
		gen.pruneBlack();
	}
}

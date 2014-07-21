package no.pdigre.chess.engine.base;


public class MSliderWhite extends MBase{
	public MSliderWhite(int from) {
		super(from);
	}

	long[][] M;
	
	public void move(GNodegen gen){
		for (long[] slides : M)
			for (int i = 0; i < slides.length && slideWhite(gen,slides[i]); i++)
				;
	}
}

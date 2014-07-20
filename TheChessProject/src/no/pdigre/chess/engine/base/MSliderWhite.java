package no.pdigre.chess.engine.base;


public class MSliderWhite extends MBase{
	long M64=0L;
	long[][] M;
	
	public void move(GNodegen gen){
		for (long[] slides : M)
			for (int i = 0; i < slides.length && gen.slideWhite(slides[i]); i++)
				;
	}
}

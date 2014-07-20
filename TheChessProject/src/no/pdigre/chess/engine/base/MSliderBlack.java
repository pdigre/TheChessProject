package no.pdigre.chess.engine.base;


public class MSliderBlack extends MBase{
	long M64=0L;
	long[][] M;
	
	public void move(GNodegen gen){
		for (long[] slides : M)
			for (int i = 0; i < slides.length && gen.slideBlack(slides[i]); i++)
				;
	}
}

package no.pdigre.chess.engine.base;


public class MSlider extends MBase{
	long M64=0L;
	long[][] MW;
	long[][] MB;
	
	public void moveW(GNodegen gen){
		for (long[] slides : MW)
			for (int i = 0; i < slides.length && gen.slideWhite(slides[i]); i++)
				;
	}

	public void moveB(GNodegen gen){
		for (long[] slides : MB)
			for (int i = 0; i < slides.length && gen.slideBlack(slides[i]); i++)
				;
	}
}

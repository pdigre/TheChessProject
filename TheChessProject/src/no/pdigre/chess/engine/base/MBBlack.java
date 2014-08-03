package no.pdigre.chess.engine.base;

import static no.pdigre.chess.engine.base.IBase.BASE.DOWN;
import static no.pdigre.chess.engine.base.IBase.BASE.LEFT;
import static no.pdigre.chess.engine.base.IBase.BASE.RIGHT;
import static no.pdigre.chess.engine.base.IBase.BASE.UP;


public class MBBlack extends MSlider{

	final MOVEDATA[] UL,UR,DL,DR;

	public MBBlack(int from) {
		super(from);
		UL=slide(IConst.BB, UP + LEFT);
		UR=slide(IConst.BB, UP + RIGHT);
		DL=slide(IConst.BB, DOWN + LEFT);
		DR=slide(IConst.BB, DOWN + RIGHT);
	}

	public void genLegal(Movegen gen){
		bslide(gen,UL);
		bslide(gen,UR);
		bslide(gen,DL);
		bslide(gen,DR);
		gen.pruneBlack();
	}
}

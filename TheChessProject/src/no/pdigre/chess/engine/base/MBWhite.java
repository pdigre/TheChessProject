package no.pdigre.chess.engine.base;

import static no.pdigre.chess.engine.base.IBase.BASE.DOWN;
import static no.pdigre.chess.engine.base.IBase.BASE.LEFT;
import static no.pdigre.chess.engine.base.IBase.BASE.RIGHT;
import static no.pdigre.chess.engine.base.IBase.BASE.UP;


public class MBWhite extends MBase{

	final MOVEDATA[] UL,UR,DL,DR;

	public MBWhite(int from) {
		super(from);
		UL=slide(IConst.WB, UP + LEFT);
		UR=slide(IConst.WB, UP + RIGHT);
		DL=slide(IConst.WB, DOWN + LEFT);
		DR=slide(IConst.WB, DOWN + RIGHT);
	}

	public void genLegal(Movegen gen){
		wslide(gen,UL);
		wslide(gen,UR);
		wslide(gen,DL);
		wslide(gen,DR);
		gen.pruneWhite();
	}
	
}

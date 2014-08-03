package no.pdigre.chess.engine.base;

import static no.pdigre.chess.engine.base.IBase.BASE.DOWN;
import static no.pdigre.chess.engine.base.IBase.BASE.LEFT;
import static no.pdigre.chess.engine.base.IBase.BASE.RIGHT;
import static no.pdigre.chess.engine.base.IBase.BASE.UP;


public class MQWhite extends MBase{

	final MOVEDATA[] U,D, L,R,UL,UR,DL,DR;

	public MQWhite(int from) {
		super(from);
		U=slide(IConst.WQ, UP);
		D=slide(IConst.WQ, DOWN);
		L=slide(IConst.WQ, LEFT);
		R=slide(IConst.WQ, RIGHT);
		UL=slide(IConst.WQ, UP + LEFT);
		UR=slide(IConst.WQ, UP + RIGHT);
		DL=slide(IConst.WQ, DOWN + LEFT);
		DR=slide(IConst.WQ, DOWN + RIGHT);
	}

	public void genLegal(Movegen gen){
		wslide(gen,U);
		wslide(gen,D);
		wslide(gen,L);
		wslide(gen,R);
		wslide(gen,UL);
		wslide(gen,UR);
		wslide(gen,DL);
		wslide(gen,DR);
		gen.pruneWhite();
	}
	
}

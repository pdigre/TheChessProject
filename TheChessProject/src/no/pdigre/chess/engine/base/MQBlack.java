package no.pdigre.chess.engine.base;

import static no.pdigre.chess.engine.base.IBase.BASE.DOWN;
import static no.pdigre.chess.engine.base.IBase.BASE.LEFT;
import static no.pdigre.chess.engine.base.IBase.BASE.RIGHT;
import static no.pdigre.chess.engine.base.IBase.BASE.UP;


public class MQBlack extends MBase{

	final MOVEDATA[] U,D, L,R,UL,UR,DL,DR;

	public MQBlack(int from) {
		super(from);
		U=slide(IConst.BQ, UP);
		D=slide(IConst.BQ, DOWN);
		L=slide(IConst.BQ, LEFT);
		R=slide(IConst.BQ, RIGHT);
		UL=slide(IConst.BQ, UP + LEFT);
		UR=slide(IConst.BQ, UP + RIGHT);
		DL=slide(IConst.BQ, DOWN + LEFT);
		DR=slide(IConst.BQ, DOWN + RIGHT);
	}

	public void genLegal(Movegen gen){
		bslide(gen,U);
		bslide(gen,D);
		bslide(gen,L);
		bslide(gen,R);
		bslide(gen,UL);
		bslide(gen,UR);
		bslide(gen,DL);
		bslide(gen,DR);
		gen.pruneBlack();
	}
	
}

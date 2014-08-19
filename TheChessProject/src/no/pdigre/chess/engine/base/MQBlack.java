package no.pdigre.chess.engine.base;

import static no.pdigre.chess.engine.base.IBase.BASE.DOWN;
import static no.pdigre.chess.engine.base.IBase.BASE.LEFT;
import static no.pdigre.chess.engine.base.IBase.BASE.RIGHT;
import static no.pdigre.chess.engine.base.IBase.BASE.UP;


public class MQBlack extends MSlider{

	final MOVEDATA[] U,D, L,R,UL,UR,DL,DR;
	final MOVEDATA[][] DIAG,LINE;

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
		DIAG=new MOVEDATA[][]{UL,UR,DL,DR};
		LINE=new MOVEDATA[][]{U,D, L,R};
	}

	public void genLegal(Movegen gen){
		bslide(gen,LINE);
		bslide(gen,DIAG);
	}
	
}

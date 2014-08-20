package no.pdigre.chess.engine.base;

import static no.pdigre.chess.engine.base.BASE.DOWN;
import static no.pdigre.chess.engine.base.BASE.LEFT;
import static no.pdigre.chess.engine.base.BASE.RIGHT;
import static no.pdigre.chess.engine.base.BASE.UP;


public class MBQ extends MSlider{

	final MOVEDATA[] U,D, L,R,UL,UR,DL,DR;
	final MOVEDATA[][] DIAG,LINE;

	public MBQ(int from) {
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

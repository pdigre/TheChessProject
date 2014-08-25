package no.pdigre.chess.engine.base;

import static no.pdigre.chess.engine.base.BASE.*;


public class MBB extends MSlider{

	final MOVEDATA[] UL,UR,DL,DR;
	final MOVEDATA[][] DIAG;

	final static MBB[] BB;
	static {
		BB=new MBB[64];
		for (int from = 0; from < 64; from++)
			BB[from] = new MBB(from);
	}

	public MBB(int from) {
		super(from);
		UL=slide(IConst.BB, UP + LEFT);
		UR=slide(IConst.BB, UP + RIGHT);
		DL=slide(IConst.BB, DOWN + LEFT);
		DR=slide(IConst.BB, DOWN + RIGHT);
		DIAG=new MOVEDATA[][]{UL,UR,DL,DR};
	}

	public void genLegal(Movegen gen){
		bslide(gen,DIAG);
	}
}
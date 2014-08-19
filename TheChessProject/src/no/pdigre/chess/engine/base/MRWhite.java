package no.pdigre.chess.engine.base;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.IConst.BITS;
import static no.pdigre.chess.engine.base.IBase.BASE.*;


public class MRWhite extends MSlider{

	final MOVEDATA[] U, D, L, R;
	MOVEDATA XQ, XK;
	final MOVEDATA[][] LINE;

	public MRWhite(int from) {
		super(from);
		U=slide(UP);
		D=slide(DOWN);
		L=slide(LEFT);
		R=slide(RIGHT);
		LINE=new MOVEDATA[][]{U,D, L,R};
	}

	private MOVEDATA[] slide(int offset) {
		ArrayList<MOVEDATA> list = new ArrayList<MOVEDATA>();
		int to=from+offset;
		while(inside(to, to-offset)){
			long bitmap = BITS.assemble(IConst.WR, from, to, IConst.CASTLING_STATE | IConst.HALFMOVES);
			if(from==IConst.WR_QUEEN_STARTPOS)
				bitmap^= IConst.CANCASTLE_WHITEQUEEN;
			else if(from==IConst.WR_KING_STARTPOS)
				bitmap^= IConst.CANCASTLE_WHITEKING;
			for (int i = 0; i < 5; i++)
				list.add(MOVEDATA.createxw((purge(bitmap, PSQT.pVal(to, WCAPTURES[i]))) | ((WCAPTURES[i] & 7) << IBase._CAPTURE)));
			list.add(MOVEDATA.create(bitmap));
			to+=offset;
		}
		return list.toArray(new MOVEDATA[list.size()]);
	}

	public void genLegal(Movegen gen){
		wslide(gen,LINE);
	}
	
}

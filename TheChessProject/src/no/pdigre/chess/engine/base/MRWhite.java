package no.pdigre.chess.engine.base;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.IConst.BITS;
import static no.pdigre.chess.engine.base.IBase.BASE.*;


public class MRWhite extends MBase{

	final MOVEDATA[] U, D, L, R;
	MOVEDATA XQ, XK;

	public MRWhite(int from) {
		super(from);
		U=slide(IConst.WR,UP);
		D=slide(IConst.WR,DOWN);
		L=slide(IConst.WR,LEFT);
		R=slide(IConst.WR,RIGHT);
	}

	public void addSlide(int type,ArrayList<MOVEDATA> list, int to) {
		long bitmap = BITS.assemble(IConst.WR, from, to, IConst.CASTLING_STATE | IConst.HALFMOVES);
		if(from==IConst.WR_QUEEN_STARTPOS)
			bitmap^= IConst.CANCASTLE_WHITEQUEEN;
		else if(from==IConst.WR_KING_STARTPOS)
			bitmap^= IConst.CANCASTLE_WHITEKING;
		for (int i = 0; i < 5; i++)
			list.add(MOVEDATA.createxw((purge(bitmap, PSQT.pVal(to, WCAPTURES[i]))) | ((WCAPTURES[i] & 7) << GMovegen._CAPTURE)));
		list.add(MOVEDATA.create(bitmap));
	}

	public void genLegal(Movegen gen){
		wslide(gen,U);
		wslide(gen,D);
		wslide(gen,L);
		wslide(gen,R);
		gen.pruneWhite();
	}
	
}

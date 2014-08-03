package no.pdigre.chess.engine.base;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.IConst.BITS;
import static no.pdigre.chess.engine.base.IBase.BASE.*;


public class MRBlack extends MBase{

	final MOVEDATA[] U;
	final MOVEDATA[] D;
	final MOVEDATA[] L;
	final MOVEDATA[] R;

	public MRBlack(int from) {
		super(from);
		U=slide(UP);
		D=slide(DOWN);
		L=slide(LEFT);
		R=slide(RIGHT);
	}

	private MOVEDATA[] slide(int offset) {
		ArrayList<MOVEDATA> list = new ArrayList<MOVEDATA>();
		int to=from+offset;
		while(inside(to, to-offset)){
			long bitmap = BITS.assemble(IConst.BR, from, to, IConst.CASTLING_STATE | IConst.HALFMOVES);
			if(from==IConst.BR_QUEEN_STARTPOS)
				bitmap^= IConst.CANCASTLE_BLACKQUEEN;
			else if(from==IConst.BR_KING_STARTPOS)
				bitmap^= IConst.CANCASTLE_BLACKKING;
			for (int i = 0; i < 5; i++)
				list.add(MOVEDATA.createxw((purge(bitmap, PSQT.pVal(to, BCAPTURES[i]))) | ((BCAPTURES[i] & 7) << GMovegen._CAPTURE)));
			list.add(MOVEDATA.create(bitmap));
			to+=offset;
		}
		return list.toArray(new MOVEDATA[list.size()]);
	}

	public void genLegal(Movegen gen){
		bslide(gen,U);
		bslide(gen,D);
		bslide(gen,L);
		bslide(gen,R);
		gen.pruneBlack();
	}
	
}

package no.pdigre.chess.engine.base;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.IConst.BITS;
import static no.pdigre.chess.engine.base.IBase.BASE.*;


public class MBBlack extends MBase{

	final MOVEDATA[] UL;
	final MOVEDATA[] UR;
	final MOVEDATA[] DL;
	final MOVEDATA[] DR;

	public MBBlack(int from) {
		super(from);
		UL=slide(UP + LEFT);
		UR=slide(UP + RIGHT);
		DL=slide(DOWN + LEFT);
		DR=slide(DOWN + RIGHT);
	}

	private MOVEDATA[] slide(int offset) {
		ArrayList<MOVEDATA> list = new ArrayList<MOVEDATA>();
		int to=from+offset;
		while(inside(to, to-offset)){
			long bitmap = BITS.assemble(IConst.BB, from, to, IConst.CASTLING_STATE | IConst.HALFMOVES);
			for (int i = 0; i < 5; i++)
				list.add(MOVEDATA.createxw((purge(bitmap, PSQT.pVal(to, BCAPTURES[i]))) | ((BCAPTURES[i] & 7) << GMovegen._CAPTURE)));
			list.add(MOVEDATA.create(bitmap));
			to+=offset;
		}
		return list.toArray(new MOVEDATA[list.size()]);
	}

	public void genLegal(Movegen gen){
		slide(gen,UL);
		slide(gen,UR);
		slide(gen,DL);
		slide(gen,DR);
		gen.pruneBlack();
	}

	private void slide(Movegen gen, MOVEDATA[] m) {
		int i=0;
		long occ=gen.bb_piece;
		while(i<m.length){
			long bto=m[i+5].bto;
			if((occ&bto)!=0){
				if((gen.bb_white&bto)!=0)
					gen.add(m[i+gen.ctype(bto)]);
				break;
			} else {
				gen.add(m[i+5]);
				i+=6;
			}
		}
	}
	
}

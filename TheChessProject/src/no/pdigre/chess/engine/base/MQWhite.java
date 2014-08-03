package no.pdigre.chess.engine.base;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.IConst.BITS;
import static no.pdigre.chess.engine.base.IBase.BASE.*;


public class MQWhite extends MBase{

	final MOVEDATA[] U;
	final MOVEDATA[] D;
	final MOVEDATA[] L;
	final MOVEDATA[] R;
	final MOVEDATA[] UL;
	final MOVEDATA[] UR;
	final MOVEDATA[] DL;
	final MOVEDATA[] DR;

	public MQWhite(int from) {
		super(from);
		U=slide(UP);
		D=slide(DOWN);
		L=slide(LEFT);
		R=slide(RIGHT);
		UL=slide(UP + LEFT);
		UR=slide(UP + RIGHT);
		DL=slide(DOWN + LEFT);
		DR=slide(DOWN + RIGHT);
	}

	private MOVEDATA[] slide(int offset) {
		ArrayList<MOVEDATA> list = new ArrayList<MOVEDATA>();
		int to=from+offset;
		while(inside(to, to-offset)){
			IBase.REV[to].RQ |= (1L<<from);
			long bitmap = BITS.assemble(IConst.WQ, from, to, IConst.CASTLING_STATE | IConst.HALFMOVES);
			for (int i = 0; i < 5; i++)
				list.add(MOVEDATA.createxw((purge(bitmap, PSQT.pVal(to, WCAPTURES[i]))) | ((WCAPTURES[i] & 7) << GMovegen._CAPTURE)));
			list.add(MOVEDATA.create(bitmap));
			to+=offset;
		}
		return list.toArray(new MOVEDATA[list.size()]);
	}

	public void genLegal(Movegen gen){
		slide(gen,U);
		slide(gen,D);
		slide(gen,L);
		slide(gen,R);
		slide(gen,UL);
		slide(gen,UR);
		slide(gen,DL);
		slide(gen,DR);
		gen.pruneWhite();
	}

	private void slide(Movegen gen, MOVEDATA[] m) {
		int i=0;
		long occ=gen.bb_piece;
		while(i<m.length){
			long bto=m[i+5].bto;
			if((occ&bto)!=0){
				if((gen.bb_black&bto)!=0)
					gen.add(m[i+gen.ctype(bto)]);
				break;
			} else {
				gen.add(m[i+5]);
				i+=6;
			}
		}
	}
	
}
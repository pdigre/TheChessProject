package no.pdigre.chess.engine.base;

import static no.pdigre.chess.engine.base.IBase.BASE.inside;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MSlider extends MBase{

	MOVEDATA Q;
	MOVEDATA K;
	
	public MSlider(int from) {
		super(from);
	}
	
	public MOVEDATA[] slide(int type,int offset) {
		ArrayList<MOVEDATA> list = new ArrayList<MOVEDATA>();
		int to=from+offset;
		while(inside(to, to-offset)){
			addSlide(type, list, to);
			to+=offset;
		}
		return list.toArray(new MOVEDATA[list.size()]);
	}

	public void addSlide(int type, ArrayList<MOVEDATA> list, int to) {
		long bitmap = BITS.assemble(type, from, to, IConst.CASTLING_STATE | IConst.HALFMOVES);
		int[] captures=(type&8)>0?BCAPTURES:WCAPTURES;
		for (int i = 0; i < 5; i++)
			list.add(createxw((purge(bitmap, PSQT.pVal(to, captures[i]))) | ((captures[i] & 7) << GMovegen._CAPTURE)));
		list.add(MOVEDATA.create(bitmap));
	}

	public static MOVEDATA createxw(long bitmap){
		int to=BITS.getTo(bitmap);
		MOVEDATA normal = new MOVEDATA(bitmap,1L << to);
		int c=BITS.getCaptured(bitmap);
		if(c==IConst.BR){
			if(to==IConst.BR_KING_STARTPOS)
				return new MOVEDATAX(bitmap & ~IConst.CANCASTLE_BLACKKING,1L << to,normal);
			if(to==IConst.BR_QUEEN_STARTPOS)
				return new MOVEDATAX(bitmap & ~IConst.CANCASTLE_BLACKQUEEN,1L << to,normal);
		}
		return normal;
	}

	public static MOVEDATA createxb(long bitmap){
		int to=BITS.getTo(bitmap);
		MOVEDATA normal = new MOVEDATA(bitmap,1L << to);
		int c=BITS.getCaptured(bitmap);
		if(c==IConst.WR){
			if(to==IConst.WR_KING_STARTPOS)
				return new MOVEDATAX(bitmap & ~IConst.CANCASTLE_WHITEKING,1L << to,normal);
			if(to==IConst.WR_QUEEN_STARTPOS)
				return new MOVEDATAX(bitmap & ~IConst.CANCASTLE_WHITEQUEEN,1L << to,normal);
		}
		return normal;
	}
	
	public void bslide(Movegen gen, MOVEDATA[] m) {
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
	
	public void wslide(Movegen gen, MOVEDATA[] m) {
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

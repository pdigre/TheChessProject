package no.pdigre.chess.engine.base;

import java.util.ArrayList;

import static no.pdigre.chess.engine.base.BASE.*;


public class MWR extends MSlider{

	final static MOVEDATA[] XQU,XQD,XQL,XQR,XKU,XKD,XKL,XKR;
	final MOVEDATA[] U, D, L, R;
	final MOVEDATA[][] LINE;

	final static MWR[] WR;
	static {
		WR=new MWR[64];
		for (int from = 0; from < 64; from++)
			WR[from] = new MWR(from);
		MWR Q=WR[WR_QUEEN_STARTPOS];
		XQU=castling(Q.U);
		XQD=castling(Q.D);
		XQL=castling(Q.L);
		XQR=castling(Q.R);
		MWR K=WR[WR_KING_STARTPOS];
		XKU=castling(K.U);
		XKD=castling(K.D);
		XKL=castling(K.L);
		XKR=castling(K.R);
	}

	public MWR(int from) {
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
				list.add(MOVEDATA.createxw((purge(bitmap, PSQT.pVal(to, WCAPTURES[i]))) | ((WCAPTURES[i] & 7) << _CAPTURE)));
			list.add(MOVEDATA.create(bitmap));
			to+=offset;
		}
		return list.toArray(new MOVEDATA[list.size()]);
	}

	public void genLegal(Movegen gen){
		wslide(gen,LINE);
	}
	
}

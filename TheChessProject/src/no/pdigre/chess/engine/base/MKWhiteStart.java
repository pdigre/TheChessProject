package no.pdigre.chess.engine.base;

import java.util.List;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MKWhiteStart extends MKWhite {
	final MOVEDATA CQ,CK;
	final MOVEDATA[][] X,XQ,XK;

	public MKWhiteStart(int from) {
		super(from);
		X=castling(M,IConst.CANCASTLE_WHITE);
		XQ=castling(M,IConst.CANCASTLE_WHITEQUEEN);
		XK=castling(M,IConst.CANCASTLE_WHITEKING);
		CK=MOVEDATAX.create(BITS.assemble(IConst.WK, IConst.WK_STARTPOS, IConst.WK_STARTPOS + 2, IConst.CANCASTLE_BLACK | IConst.SPECIAL));
		CQ=MOVEDATAX.create(BITS.assemble(IConst.WK, IConst.WK_STARTPOS, IConst.WK_STARTPOS - 2, IConst.CANCASTLE_BLACK | IConst.SPECIAL));
	}
	
	protected void add(int offset, List<MOVEDATA[]> list) {
		int to = from + offset;
		if (IBase.BASE.inside(to, from)){
			MOVEDATA[] m=new MOVEDATA[6];
			list.add(m);
			long bitmap = BITS.assemble(IConst.WK, from, to, IBase.CANCASTLE_BLACK | IBase.HALFMOVES);
			m[5]=MOVEDATAX.create(bitmap & ~IConst.CANCASTLE_WHITE);
			IBase.REV[to].RK |= (1L<<from);
			for (int i = 0; i < 5; i++)
				m[i]=MOVEDATAX.create((purge(bitmap, PSQT.pVal(to, WCAPTURES[i]))) | ((WCAPTURES[i] & 7) << IBase._CAPTURE)); 
		}
	}

	@Override
	public void genLegal(Movegen gen) {
		long castling = gen.castling & IConst.CANCASTLE_WHITE;
		if(castling != 0){
			if ((castling & IConst.CANCASTLE_WHITEQUEEN) != 0
					&& (IConst.CWQ & gen.bb_piece) == 0
					&& !gen.pos.isCheckWhite()
					&& !KingSafe.pos(gen.pos).isSafeWhite(IConst.WK_STARTPOS - 1)) {
				gen.add(CQ);
			}
			if ((castling & IConst.CANCASTLE_WHITEKING) != 0
					&& (IConst.CWK & gen.bb_piece) == 0
					&& !gen.pos.isCheckWhite()
					&& !KingSafe.pos(gen.pos).isSafeWhite(IConst.WK_STARTPOS + 1)) {
				gen.add(CK);
			}
			if(castling == IConst.CANCASTLE_WHITE){
				wmoves(gen,X);
			} else if((castling & IConst.CANCASTLE_WHITEQUEEN) != 0){
				wmoves(gen,XQ);
			} else {
				wmoves(gen,XK);
			}
		} else {
			super.genLegal(gen);
		}
	}
}

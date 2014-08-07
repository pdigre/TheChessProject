package no.pdigre.chess.engine.base;

import java.util.List;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MKBlackStart extends MKBlack {
	final MOVEDATA CQ,CK;
	final MOVEDATA[][] X,XQ,XK;

	public MKBlackStart(int from) {
		super(from);
		X=castling(M,IConst.CANCASTLE_BLACK);
		XQ=castling(M,IConst.CANCASTLE_BLACKQUEEN);
		XK=castling(M,IConst.CANCASTLE_BLACKKING);
		CQ=MOVEDATAX.create(BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS - 2, IConst.CANCASTLE_WHITE | IConst.SPECIAL));
		CK=MOVEDATAX.create(BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS + 2, IConst.CANCASTLE_WHITE | IConst.SPECIAL));
	}

	protected void add(int offset, List<MOVEDATA[]> list) {
		int to = from + offset;
		if (IBase.BASE.inside(to, from)){
			MOVEDATA[] m=new MOVEDATA[6];
			list.add(m);
			long bitmap = BITS.assemble(IConst.BK, from, to, IBase.CANCASTLE_WHITE | IBase.HALFMOVES);
			m[5]=MOVEDATAX.create(bitmap & ~IConst.CANCASTLE_BLACK);
			for (int i = 0; i < 5; i++)
				m[i]=MOVEDATAX.create((purge(bitmap, PSQT.pVal(to, BCAPTURES[i]))) | ((BCAPTURES[i] & 7) << IBase._CAPTURE)); 
		}
	}

	@Override
	public void genLegal(Movegen gen) {
		long castling = gen.castling & IConst.CANCASTLE_BLACK;
		if(castling != 0){
			if ((IConst.CBQ & gen.bb_piece) == 0
					&& (castling & IConst.CANCASTLE_BLACKQUEEN) != 0
					&& !gen.pos.isCheckBlack()
					&& !KingSafe.pos(gen.pos).isSafeBlack(IConst.BK_STARTPOS - 1)) {
				gen.add(CQ);
			}
			if ((IConst.CBK & gen.bb_piece) == 0
					&& (castling & IConst.CANCASTLE_BLACKKING) != 0
					&& !gen.pos.isCheckBlack()
					&& !KingSafe.pos(gen.pos).isSafeBlack(IConst.BK_STARTPOS + 1)) {
				gen.add(CK);
			}
			if(castling == IConst.CANCASTLE_BLACK){
				bmoves(gen,X);
			} else if((castling & IConst.CANCASTLE_BLACKQUEEN) != 0){
				bmoves(gen,XQ);
			} else {
				bmoves(gen,XK);
			}
		} else {
			super.genLegal(gen);
		}
	}

}

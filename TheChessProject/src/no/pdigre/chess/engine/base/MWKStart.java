package no.pdigre.chess.engine.base;

import java.util.List;

public class MWKStart extends MWK {
	static MOVEDATA CQ,CK;
	static MOVEDATA[][] X,XQ,XK;

	public MWKStart(int from) {
		super(from);
		if(from==IConst.WK_STARTPOS){
			X=castling(M,IConst.CANCASTLE_WHITE);
			XQ=castling(M,IConst.CANCASTLE_WHITEQUEEN);
			XK=castling(M,IConst.CANCASTLE_WHITEKING);
			CK=MOVEDATAX.create(BITS.assemble(IConst.WK, IConst.WK_STARTPOS, IConst.WK_STARTPOS + 2, IConst.CANCASTLE_BLACK | IConst.SPECIAL));
			CQ=MOVEDATAX.create(BITS.assemble(IConst.WK, IConst.WK_STARTPOS, IConst.WK_STARTPOS - 2, IConst.CANCASTLE_BLACK | IConst.SPECIAL));
		}
	}
	
	protected void add(int offset, List<MOVEDATA[]> list) {
		int to = from + offset;
		if (BASE.inside(to, from)){
			MOVEDATA[] m=new MOVEDATA[6];
			list.add(m);
			long bitmap = BITS.assemble(IConst.WK, from, to, CANCASTLE_BLACK | HALFMOVES);
			m[5]=MOVEDATAX.create(bitmap & ~IConst.CANCASTLE_WHITE);
			for (int i = 0; i < 5; i++)
				m[i]=MOVEDATAX.create((purge(bitmap, PSQT.pVal(to, WCAPTURES[i]))) | ((WCAPTURES[i] & 7) << _CAPTURE)); 
		}
	}

	@Override
	public void genLegal(Movegen gen) {
		kmoves(gen,getCastlingMoves(gen));
	}

	public MOVEDATA[][] getCastlingMoves(Movegen gen) {
		final boolean qc=(gen.castling & IConst.CANCASTLE_WHITEQUEEN) != 0;
		final boolean kc=(gen.castling & IConst.CANCASTLE_WHITEKING) != 0;
		return qc?(kc?X:XQ):(kc?XK:M);
	}

	public static void genCastling(Movegen gen) {
		long castling = gen.castling & IConst.CANCASTLE_WHITE;
		if ((IConst.CWQ & gen.bb_piece) == 0
				&& (castling & IConst.CANCASTLE_WHITEQUEEN) != 0
				&& KingSafe.pos(gen.pos).isSafeWhite(IConst.WK_STARTPOS - 1)) {
			add(gen,CQ);
		}
		if ((IConst.CWK & gen.bb_piece) == 0
				&& (castling & IConst.CANCASTLE_WHITEKING) != 0
				&& KingSafe.pos(gen.pos).isSafeWhite(IConst.WK_STARTPOS + 1)) {
			add(gen,CK);
		}
	}
}

package no.pdigre.chess.engine.base;

import java.util.List;

public class MBKStart extends MBK {
	static MOVEDATA CQ,CK;
	static MOVEDATA[][] X,XQ,XK;

	public MBKStart(int from) {
		super(from);
		X=castling(M,IConst.CANCASTLE_BLACK);
		XQ=castling(M,IConst.CANCASTLE_BLACKQUEEN);
		XK=castling(M,IConst.CANCASTLE_BLACKKING);
		CQ=MOVEDATAX.create(BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS - 2, IConst.CANCASTLE_WHITE | IConst.SPECIAL));
		CK=MOVEDATAX.create(BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS + 2, IConst.CANCASTLE_WHITE | IConst.SPECIAL));
	}

	protected void add(int offset, List<MOVEDATA[]> list) {
		int to = from + offset;
		if (BASE.inside(to, from)){
			MOVEDATA[] m=new MOVEDATA[6];
			list.add(m);
			long bitmap = BITS.assemble(IConst.BK, from, to, CANCASTLE_WHITE | HALFMOVES);
			m[5]=MOVEDATAX.create(bitmap & ~IConst.CANCASTLE_BLACK);
			for (int i = 0; i < 5; i++)
				m[i]=MOVEDATAX.create((purge(bitmap, PSQT.pVal(to, BCAPTURES[i]))) | ((BCAPTURES[i] & 7) << _CAPTURE)); 
		}
	}

	@Override
	public void genLegal(Movegen gen) {
		kmoves(gen,getCastlingMoves(gen));
	}

	public MOVEDATA[][] getCastlingMoves(Movegen gen) {
		final boolean qc=(gen.castling & IConst.CANCASTLE_BLACKQUEEN) != 0;
		final boolean kc=(gen.castling & IConst.CANCASTLE_BLACKKING) != 0;
		return qc?(kc?X:XQ):(kc?XK:M);
	}

	public static void genCastling(Movegen gen) {
		long castling = gen.castling & IConst.CANCASTLE_BLACK;
		if ((IConst.CBQ & gen.bb_piece) == 0
				&& (castling & IConst.CANCASTLE_BLACKQUEEN) != 0
				&& KingSafe.pos(gen.pos).isSafeBlack(IConst.BK_STARTPOS - 1)) {
			add(gen,CQ);
		}
		if ((IConst.CBK & gen.bb_piece) == 0
				&& (castling & IConst.CANCASTLE_BLACKKING) != 0
				&& KingSafe.pos(gen.pos).isSafeBlack(IConst.BK_STARTPOS + 1)) {
			add(gen,CK);
		}
	}
}

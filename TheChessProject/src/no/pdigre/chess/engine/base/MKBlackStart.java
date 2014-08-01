package no.pdigre.chess.engine.base;

import java.util.List;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MKBlackStart extends MKBlack {
	final static long SIDE_BK = BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS + 1, IConst.CANCASTLE_WHITE);
	final static long SIDE_BQ = BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS - 1, IConst.CANCASTLE_WHITE);

	MOVEDATA CK;
	MOVEDATA CQ;

	public MKBlackStart(int from) {
		super(from);
		CK=MOVEDATAX.create(BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS + 2, IConst.CANCASTLE_WHITE | IConst.SPECIAL));
		CQ=MOVEDATAX.create(BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS - 2, IConst.CANCASTLE_WHITE | IConst.SPECIAL));
	}

	protected void add(int offset, List<MOVEDATA[]> list) {
		int to = from + offset;
		if (IBase.BASE.inside(to, from)){
			MOVEDATA[] m=new MOVEDATA[6];
			list.add(m);
			long bitmap = BITS.assemble(IConst.BK, from, to, IBase.CANCASTLE_WHITE | IBase.HALFMOVES);
			m[5]=MOVEDATAX.create(bitmap & ~IConst.CANCASTLE_BLACK);
			for (int i = 0; i < 5; i++)
				m[i]=MOVEDATAX.create((purge(bitmap, PSQT.pVal(to, BCAPTURES[i]))) | ((BCAPTURES[i] & 7) << GMovegen._CAPTURE)); 
		}
	}

	@Override
	public void all(Movegen gen) {
		if ((IConst.CBQ & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_BLACKQUEEN) != 0
				&& !gen.pos.isCheckBlack()
				&& !gen.pos.move(SIDE_BQ).isCheckBlack()) {
			gen.add(CQ);
		}
		if ((IConst.CBK & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_BLACKKING) != 0
				&& !gen.pos.isCheckBlack()
				&& !gen.pos.move(SIDE_BK).isCheckBlack()) {
			gen.add(CK);
		}
		super.all(gen);
	}

}

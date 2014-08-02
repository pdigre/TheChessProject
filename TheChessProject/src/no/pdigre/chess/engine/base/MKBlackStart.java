package no.pdigre.chess.engine.base;

import java.util.List;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MKBlackStart extends MKBlack {
	final MOVEDATA CQ;
	final MOVEDATA CK;
	final MOVEDATA SQ;
	final MOVEDATA SK;

	public MKBlackStart(int from) {
		super(from);
		CQ=MOVEDATAX.create(BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS - 2, IConst.CANCASTLE_WHITE | IConst.SPECIAL));
		CK=MOVEDATAX.create(BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS + 2, IConst.CANCASTLE_WHITE | IConst.SPECIAL));
		SQ=M[2][5];
		SK=M[3][5];
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
	public void genLegal(Movegen gen) {
		if ((IConst.CBQ & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_BLACKQUEEN) != 0
				&& !gen.pos.isCheckBlack()
				&& !gen.pos.isSafeBlack(IConst.BK_STARTPOS - 1)) {
			gen.add(CQ);
		}
		if ((IConst.CBK & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_BLACKKING) != 0
				&& !gen.pos.isCheckBlack()
				&& !gen.pos.isSafeBlack(IConst.BK_STARTPOS + 1)) {
			gen.add(CK);
		}
		super.genLegal(gen);
	}

}

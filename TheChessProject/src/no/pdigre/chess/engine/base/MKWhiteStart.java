package no.pdigre.chess.engine.base;

import java.util.List;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MKWhiteStart extends MKWhite {
	final MOVEDATA CQ;
	final MOVEDATA CK;
	final MOVEDATA SQ;
	final MOVEDATA SK;

	public MKWhiteStart(int from) {
		super(from);
		CK=MOVEDATAX.create(BITS.assemble(IConst.WK, IConst.WK_STARTPOS, IConst.WK_STARTPOS + 2, IConst.CANCASTLE_BLACK | IConst.SPECIAL));
		CQ=MOVEDATAX.create(BITS.assemble(IConst.WK, IConst.WK_STARTPOS, IConst.WK_STARTPOS - 2, IConst.CANCASTLE_BLACK | IConst.SPECIAL));
		SQ=M[2][5];
		SK=M[3][5];
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
				m[i]=MOVEDATAX.create((purge(bitmap, PSQT.pVal(to, WCAPTURES[i]))) | ((WCAPTURES[i] & 7) << GMovegen._CAPTURE)); 
		}
	}

	@Override
	public void all(Movegen gen) {
		if ((IConst.CWQ & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_WHITEQUEEN) != 0
				&& !gen.pos.isCheckWhite()
				&& !gen.pos.isSafeWhite(IConst.WK_STARTPOS - 1)) {
			gen.add(CQ);
		}
		if ((IConst.CWK & gen.bb_piece) == 0
				&& (gen.castling & IConst.CANCASTLE_WHITEKING) != 0
				&& !gen.pos.isCheckWhite()
				&& !gen.pos.isSafeWhite(IConst.WK_STARTPOS + 1)) {
			gen.add(CK);
		}
		super.all(gen);
	}
}

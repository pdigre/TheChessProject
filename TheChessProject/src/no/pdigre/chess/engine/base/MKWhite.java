package no.pdigre.chess.engine.base;

import java.util.ArrayList;
import java.util.List;

import no.pdigre.chess.engine.base.IConst.BITS;
import static no.pdigre.chess.engine.base.IBase.BASE.*;


public class MKWhite extends MBase {

	final MOVEDATA[][] M;

	public MKWhite(int from) {
		super(from);			
		ArrayList<MOVEDATA[]> list=new ArrayList<MOVEDATA[]>();
		add(UP,list);
		add(DOWN,list);
		add(LEFT,list);
		add(RIGHT,list);
		add(UP + LEFT,list);
		add(UP + RIGHT,list);
		add(DOWN + LEFT,list);
		add(DOWN + RIGHT,list);
		M=list.toArray(new MOVEDATA[list.size()][]);
	}

	protected void add(int offset, List<MOVEDATA[]> list) {
		int to = from + offset;
		if (IBase.BASE.inside(to, from)){
			MOVEDATA[] m=new MOVEDATA[6];
			list.add(m);
			m[5]=MOVEDATA.create(BITS.assemble(IConst.WK, from, to, IBase.CANCASTLE_BLACK | IBase.HALFMOVES));
			IBase.REV[to].RK |= (1L<<from);
			for (int i = 0; i < 5; i++)
				m[i]=MOVEDATA.create((purge(BITS.assemble(IConst.WK, from, to, IBase.CANCASTLE_BLACK | IBase.HALFMOVES), PSQT.pVal(to, WCAPTURES[i]))) | ((WCAPTURES[i] & 7) << GMovegen._CAPTURE)); 
		}
	}

	public void genLegal(Movegen gen) {
		wmoves(gen,M);
	}

}

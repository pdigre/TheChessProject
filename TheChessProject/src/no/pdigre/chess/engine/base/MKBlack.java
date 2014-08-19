package no.pdigre.chess.engine.base;

import static no.pdigre.chess.engine.base.IBase.BASE.DOWN;
import static no.pdigre.chess.engine.base.IBase.BASE.LEFT;
import static no.pdigre.chess.engine.base.IBase.BASE.RIGHT;
import static no.pdigre.chess.engine.base.IBase.BASE.UP;

import java.util.ArrayList;
import java.util.List;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MKBlack extends MBase {

	final MOVEDATA[][] M;
	
	public MKBlack(int from) {
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
			m[5]=MOVEDATA.create(BITS.assemble(IConst.BK, from, to, IBase.CANCASTLE_WHITE | IBase.HALFMOVES));
			for (int i = 0; i < 5; i++)
				m[i]=MOVEDATA.create((purge(BITS.assemble(IConst.BK, from, to, IBase.CANCASTLE_WHITE | IBase.HALFMOVES), PSQT.pVal(to, BCAPTURES[i]))) | ((BCAPTURES[i] & 7) << IBase._CAPTURE)); 
		}
	}

	public void genLegal(Movegen gen) {
		kmoves(gen,M);
	}
	
	public void kmoves(Movegen gen, MOVEDATA[][] moves) {
		for (MOVEDATA[] m : moves){
			long bto = m[5].bto;
			if ((gen.bb_piece & bto) == 0) {
				add(gen,m[5]);
			} else if ((gen.bb_white & bto) != 0) {
				add(gen,m[gen.ctype(bto)]);
			}
		}
	}

	final void add(Movegen gen,MOVEDATA md) {
		KingSafe p = KingSafe.pos(gen.pos,md);
		int to = BITS.getTo(md.bitmap);
		boolean safe = p.isSafeBlack(to);
		if(safe){
			gen.add(md);
//		} else {
//			System.out.println("hi");
		}
	}
	

}

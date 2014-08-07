package no.pdigre.chess.engine.base;

import java.util.ArrayList;
import java.util.List;

import no.pdigre.chess.engine.base.IConst.BITS;
import static no.pdigre.chess.engine.base.IBase.BASE.*;

public class MNWhite extends MBase{
	public MNWhite(int from) {
		super(from);
		ArrayList<MOVEDATA[]> list=new ArrayList<MOVEDATA[]>();
		for (int i = 0; i < KNIGHT_MOVES.length; i++)
			add(KNIGHT_MOVES[i], list);
		M=list.toArray(new MOVEDATA[list.size()][]);
	}

	private void add(int offset, List<MOVEDATA[]> list) {
		int to = from + offset;
		if (inside(to, from)){
			MOVEDATA[] m=new MOVEDATA[6];
			list.add(m);
			m[5]=MOVEDATA.create(BITS.assemble(IConst.WN, from, to, IBase.CASTLING_STATE | IBase.HALFMOVES));
			for (int i = 0; i < 5; i++)
				m[i]=MOVEDATA.createxw((purge(BITS.assemble(IConst.WN, from, to, IBase.CASTLING_STATE | IBase.HALFMOVES), PSQT.pVal(to, WCAPTURES[i]))) | ((WCAPTURES[i] & 7) << IBase._CAPTURE)); 
		}
	}
	
	final MOVEDATA[][] M;

	public void genLegal(Movegen gen) {
		for (MOVEDATA[] m : M){
			long bto = m[5].bto;
			if ((gen.bb_piece & bto) == 0) {
				gen.add(m[5]);
			} else if ((gen.bb_black & bto) != 0) {
				gen.add(m[gen.ctype(bto)]);
			}
		}
		gen.pruneWhite();
	}
}

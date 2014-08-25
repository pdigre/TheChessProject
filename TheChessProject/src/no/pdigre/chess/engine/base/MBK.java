package no.pdigre.chess.engine.base;

import static no.pdigre.chess.engine.base.BASE.DOWN;
import static no.pdigre.chess.engine.base.BASE.LEFT;
import static no.pdigre.chess.engine.base.BASE.RIGHT;
import static no.pdigre.chess.engine.base.BASE.UP;

import java.util.ArrayList;
import java.util.List;

public class MBK extends MBase {

	final MOVEDATA[][] M;
	final static MOVEDATA CQ,CK;
	final static MOVEDATA[][] X,XQ,XK;
	
	final static MBK[] BK;
	static {
		BK=new MBK[64];
		for (int from = 0; from < 64; from++)
			BK[from] = new MBK(from);
		MOVEDATA[][] M=BK[IConst.BK_STARTPOS].M;
		X=castling(M,IConst.CANCASTLE_BLACK);
		XQ=castling(M,IConst.CANCASTLE_BLACKQUEEN);
		XK=castling(M,IConst.CANCASTLE_BLACKKING);
		CQ=MOVEDATAX.create(BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS - 2, IConst.CANCASTLE_WHITE | IConst.SPECIAL));
		CK=MOVEDATAX.create(BITS.assemble(IConst.BK, IConst.BK_STARTPOS, IConst.BK_STARTPOS + 2, IConst.CANCASTLE_WHITE | IConst.SPECIAL));
	}

	public MBK(int from) {
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
		if (BASE.inside(to, from)){
			MOVEDATA[] m=new MOVEDATA[6];
			list.add(m);
			m[5]=MOVEDATA.create(BITS.assemble(IConst.BK, from, to, CANCASTLE_WHITE | HALFMOVES));
			for (int i = 0; i < 5; i++)
				m[i]=MOVEDATA.create((purge(BITS.assemble(IConst.BK, from, to, CANCASTLE_WHITE | HALFMOVES), PSQT.pVal(to, BCAPTURES[i]))) | ((BCAPTURES[i] & 7) << _CAPTURE)); 
		}
	}

	public void genLegal(Movegen gen) {
		kmoves(gen,from == IConst.BK_STARTPOS?getCastlingMoves(gen):M);
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

	final static void add(Movegen gen,MOVEDATA md) {
		KingSafe p = KingSafe.pos(gen.pos,md);
		int to = BITS.getTo(md.bitmap);
		if(p.isSafeBlack(to))
			gen.add(md);
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
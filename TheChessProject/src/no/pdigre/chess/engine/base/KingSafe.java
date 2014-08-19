package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IBase.BASE;
import no.pdigre.chess.engine.base.IBase.REVERSE;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.Position;

public class KingSafe implements IConst {

	public static int getCheckState(Position pos) {
		if (!(pos.whiteNext() ? pos.isCheckWhite() : pos.isCheckBlack()))
			return 0;
		return NodeGen.getLegalMoves64(pos).length==0? MATE: CHECK;
	}

	final private long bb_black;
	final private long bb_piece;
	final private long bb_bit1;
	final private long bb_bit2;
	final private long bb_bit3;

	public KingSafe(long bb_black, long bb_bit1, long bb_bit2, long bb_bit3) {
		this.bb_bit1 = bb_bit1;
		this.bb_bit2 = bb_bit2;
		this.bb_bit3 = bb_bit3;
		this.bb_piece = bb_bit1 | bb_bit2 | bb_bit3;
		this.bb_black = bb_black;
	}

	public static KingSafe pos(Position pos) {
		return new KingSafe(pos.get64black(), pos.get64bit1(), pos.get64bit2(), pos.get64bit3());
	}

	public static KingSafe pos(Position pos,MOVEDATA md) {
		return new KingSafe(pos.get64black()^md.b_black, pos.get64bit1()^md.b_bit1, pos.get64bit2()^md.b_bit2, pos.get64bit3()^md.b_bit3);
	}

	final public boolean isSafeWhite() {
		return isSafeWhite(Long.numberOfTrailingZeros(bb_bit1 & bb_bit2 & ~bb_bit3 & ~bb_black));
	}
	
	final public boolean isSafeBlack() {
		return isSafeBlack(Long.numberOfTrailingZeros(bb_bit1 & bb_bit2 & ~bb_bit3 & bb_black));
	}
	
	final public boolean isSafeWhite(int king) {
		REVERSE rev = IBase.REV[king];
		long e=bb_black;
		if (((~bb_bit1 & bb_bit2 & ~bb_bit3 & e) & rev.RN) != 0)
			return false;
		MQWhite x = BASE.WQ[king];
		long slider=bb_bit3 & e;
		if((slider & rev.RQ) !=0){
			if ((bb_bit1 & slider & rev.RB) != 0) {
				if(bdiag(x.UL)||bdiag(x.UR)||bdiag(x.DL)||bdiag(x.DR))
					return false;
			}
			if ((bb_bit2 & slider & rev.RR) != 0) {
				if(bline(x.U)||bline(x.D)||bline(x.L)||bline(x.R))
					return false;
			}
		}
		if (((bb_bit1 & ~bb_bit2 & ~bb_bit3 & e) & rev.RPB) != 0)
			return false;
		if (((bb_bit1 & bb_bit2 & ~bb_bit3 & e) & rev.RK) != 0)
			return false;
		return true;
	}

	final public boolean isSafeBlack(int king) {
		REVERSE rev = IBase.REV[king];
		long e=~bb_black;
		if (((~bb_bit1 & bb_bit2 & ~bb_bit3 & e) & rev.RN) != 0)
			return false;
		MQWhite x = BASE.WQ[king];
		long slider=bb_bit3 & e;
		if((slider & rev.RQ) !=0){
			if ((bb_bit1 & slider & rev.RB) != 0) {
				if(wdiag(x.UL)||wdiag(x.UR)||wdiag(x.DL)||wdiag(x.DR))
					return false;
			}
			if ((bb_bit2 & slider & rev.RR) != 0) {
				if(wline(x.U)||wline(x.D)||wline(x.L)||wline(x.R))
					return false;
			}
		}
		if (((bb_bit1 & ~bb_bit2 & ~bb_bit3 & e) & rev.RPW) != 0)
			return false;
		if (((bb_bit1 & bb_bit2 & ~bb_bit3 & e) & rev.RK) != 0)
			return false;
		return true;
	}

	private boolean wdiag(MOVEDATA[] s) {
		for (MOVEDATA m : s) {
			long bit = m.bto;
			if ((bb_piece & bit) != 0)
				return (bb_black & bit) == 0 && (bb_bit1 & bit) != 0 &&  (bb_bit3 & bit) != 0;
		}
		return false;
	}

	private boolean wline(MOVEDATA[] s) {
		for (MOVEDATA m : s) {
			long bit = m.bto;
			if ((bb_piece & bit) != 0)
				return (bb_black & bit) == 0 && (bb_bit2 & bit) != 0 &&  (bb_bit3 & bit) != 0;
		}
		return false;
	}
	
	private boolean bdiag(MOVEDATA[] s) {
		for (MOVEDATA m : s) {
			long bit = m.bto;
			if ((bb_piece & bit) != 0)
				return (bb_black & bit) != 0 && (bb_bit1 & bit) != 0 &&  (bb_bit3 & bit) != 0;
		}
		return false;
	}

	private boolean bline(MOVEDATA[] s) {
		for (MOVEDATA m : s) {
			long bit = m.bto;
			if ((bb_piece & bit) != 0)
				return (bb_black & bit) != 0 && (bb_bit2 & bit) != 0 &&  (bb_bit3 & bit) != 0;
		}
		return false;
	}
	
	@Override
	public String toString() {
		return FEN.board2string(bb_bit1,bb_bit2,bb_bit3,bb_black);
	}
}

package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IBase.BASE;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPosition64;
import no.pdigre.chess.engine.fen.Position64;

public class KingSafe implements IConst {

	public static int getCheckState(IPosition64 pos) {
		if (!(pos.whiteNext() ? pos.isCheckWhite() : pos.isCheckBlack()))
			return 0;
		if (NodeGen.getLegalMoves64(pos).length==0)
			return MATE;
		return CHECK;
	}

	final private long bb_black;
	final private long bb_piece;
	final private long bb_bit1;
	final private long bb_bit2;
	final private long bb_bit3;
	final private int wking;
	final private int bking;

	public KingSafe(long bb_black, long bb_bit1, long bb_bit2, long bb_bit3, int wking, int bking) {
		this.bb_bit1 = bb_bit1;
		this.bb_bit2 = bb_bit2;
		this.bb_bit3 = bb_bit3;
		this.bb_piece = bb_bit1 | bb_bit2 | bb_bit3;
		this.bb_black = bb_black;
		this.wking = wking;
		this.bking = bking;
	}

	public static KingSafe pos(IPosition in) {
		IPosition64 pos = Position64.getPosition64(in);
		return new KingSafe(pos.get64black(), pos.get64bit1(), pos.get64bit2(), pos.get64bit3(), pos.getWKpos(), pos.getBKpos());
	}

	final public boolean isCheckBlack() {
		if (((~bb_bit1 & bb_bit2 & ~bb_bit3 & ~bb_black) & IBase.REV[bking].RN) != 0)
			return true;
		if (((bb_bit1 & bb_bit2 & ~bb_bit3 & ~bb_black) & IBase.REV[bking].RK) != 0)
			return true;
		if (((bb_bit1 & bb_bit3 & ~bb_black) & IBase.REV[bking].RB) != 0) {
			for (long[] slide : BASE.WB[bking].M) {
				for (long p : slide) {
					long bit = 1L << BITS.getTo(p);
					if ((bb_piece & bit) == 0)
						continue;
					if ((bb_black & bit) != 0)
						break;
					int type = type(bit);
					if (type == WQ || type == WB)
						return true;
					break;
				}
			}
		}
		if (((bb_bit2 & bb_bit3 & ~bb_black) & IBase.REV[bking].RR) != 0) {
			for (long[] slide : BASE.WR[bking].M) {
				for (long p : slide) {
					long bit = 1L << BITS.getTo(p);
					if ((bb_piece & bit) == 0)
						continue;
					if ((bb_black & bit) != 0)
						break;
					int type = type(bit);
					if (type == WQ || type == WR)
						return true;
					break;
				}
			}
		}
		if (((bb_bit1 & ~bb_bit2 & ~bb_bit3 & ~bb_black) & IBase.REV[bking].RPW) != 0)
			return true;
		return false;
	}

	String format64(long b64) {
		String string64 = Long.toBinaryString(b64);
		return ".0000000.0000000.0000000.0000000.0000000.0000000.0000000.0000000".substring(0, 64 - string64.length()) + string64;
	}

	final public boolean isCheckWhite() {
		if (((~bb_bit1 & bb_bit2 & ~bb_bit3 & bb_black) & IBase.REV[wking].RN) != 0)
			return true;
		if (((bb_bit1 & bb_bit2 & ~bb_bit3 & bb_black) & IBase.REV[wking].RK) != 0)
			return true;
		if (((bb_bit1 & bb_bit3 & bb_black) & IBase.REV[wking].RB) != 0) {
			for (long[] slide : BASE.WB[wking].M) {
				for (long p : slide) {
					long bit = 1L << BITS.getTo(p);
					if ((bb_piece & bit) == 0)
						continue;
					if ((bb_black & bit) == 0)
						break;
					int type = type(bit);
					if (type == WQ || type == WB)
						return true;
					break;
				}
			}
		}
		if (((bb_bit2 & bb_bit3 & bb_black) & IBase.REV[wking].RR) != 0) {
			for (long[] slide : BASE.WR[wking].M) {
				for (long p : slide) {
					long bit = 1L << BITS.getTo(p);
					if ((bb_piece & bit) == 0)
						continue;
					if ((bb_black & bit) == 0)
						break;
					int type = type(bit);
					if (type == WQ || type == WR)
						return true;
					break;
				}
			}
		}
		if (((bb_bit1 & ~bb_bit2 & ~bb_bit3 & bb_black) & IBase.REV[wking].RPB) != 0)
			return true;
		return false;
	}

	final private int type(long bit) {
		return ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4);
	}

}

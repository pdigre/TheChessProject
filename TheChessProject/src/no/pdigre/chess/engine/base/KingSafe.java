package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPosition64;
import no.pdigre.chess.engine.fen.Position64Wrapper;

public class KingSafe implements IConst {

	public static int getCheckState(IPosition pos) {
		KingSafe kingSafe = KingSafe.pos(pos);
		if (!(pos.whiteNext() ? kingSafe.isCheckWhite() : kingSafe.isCheckBlack()))
			return 0;
		if (NodeGen.getLegalMoves64(pos).isEmpty())
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
		IPosition64 pos = (in instanceof IPosition64 ? (IPosition64) in : new Position64Wrapper(in));
		return new KingSafe(pos.get64black(), pos.get64bit1(), pos.get64bit2(), pos.get64bit3(), pos.getWKpos(), pos.getBKpos());
	}

	public static KingSafe move(IPosition in, int move) {
		IPosition64 pos = (in instanceof IPosition64 ? (IPosition64) in : new Position64Wrapper(in));
		long bb_black = pos.get64black();
		long bb_bit1 = pos.get64bit1();
		long bb_bit2 = pos.get64bit2();
		long bb_bit3 = pos.get64bit3();
		int wking = pos.getWKpos();
		int bking = pos.getBKpos();

		// Apply move
		int from = BITS.getFrom(move);
		int to = BITS.getTo(move);
		int piece = BITS.getPiece(move);
		if (from == wking)
			wking = to;
		if (from == bking)
			bking = to;
		{
			long bfrom = 1L << from;
			long bto = 1L << to;
			long mask = ~(bfrom | bto);
			bb_bit1 = (bb_bit1 & mask)|((piece&1)==0?0:bto);
			bb_bit2 = (bb_bit2 & mask)|((piece&2)==0?0:bto);
			bb_bit3 = (bb_bit3 & mask)|((piece&4)==0?0:bto);
			bb_black = (bb_black & mask)|((piece&8)==0?0:bto);
		}

		if (BITS.isCastling(move)) {
			if (from > to) {
				to = from - 1;
				from = from - 4;
			} else {
				to = from + 1;
				from = from + 3;
			}
			long bfrom = 1L << from;
			long bto = 1L << to;
			long mask = ~(bfrom | bto);
			bb_bit1 = (bb_bit1 & mask)|((piece&1)==0?0:bto);
			bb_bit2 = (bb_bit2 & mask)|((piece&2)==0?0:bto);
			bb_bit3 = (bb_bit3 & mask)|((piece&4)==0?0:bto);
			bb_black = (bb_black & mask)|((piece&8)==0?0:bto);
		} else if (BITS.isEnpassant(move)) {
			from = to + (to > from ? -8 : 8);
			long bfrom = 1L << from;
			long mask = ~bfrom;
			bb_black = bb_black & mask;
			bb_bit1 = bb_bit1 & mask;
			bb_bit2 = bb_bit2 & mask;
			bb_bit3 = bb_bit3 & mask;
		}
		return new KingSafe(bb_black, bb_bit1, bb_bit2, bb_bit3, wking, bking);
	}

	final boolean isCheckBlack() {
		for (int p : IBase.M32_WHITE_KNIGHT[bking]) {
			long bit = 1L << BITS.getTo(p);
			if ((bb_piece & bit) == 0 || (bb_black & bit) != 0)
				continue;
			int type = type(bit);
			if (type == WHITE_KNIGHT)
				return true;
		}
		for (int p : IBase.M32_WHITE_KING[bking]) {
			long bit = 1L << BITS.getTo(p);
			if ((bb_piece & bit) == 0 || (bb_black & bit) != 0)
				continue;
			int type = type(bit);
			if (type == WHITE_KING)
				return true;
		}
		for (int[] slide : IBase.M32_WHITE_BISHOP[bking]) {
			for (int p : slide) {
				long bit = 1L << BITS.getTo(p);
				if ((bb_piece & bit) == 0)
					continue;
				if ((bb_black & bit) != 0)
					break;
				int type = type(bit);
				if (type == WHITE_QUEEN || type == WHITE_BISHOP)
					return true;
				break;
			}
		}
		for (int[] slide : IBase.M32_WHITE_ROOK[bking]) {
			for (int p : slide) {
				long bit = 1L << BITS.getTo(p);
				if ((bb_piece & bit) == 0)
					continue;
				if ((bb_black & bit) != 0)
					break;
				int type = type(bit);
				if (type == WHITE_QUEEN || type == WHITE_ROOK)
					return true;
				break;
			}
		}
		int x = bking & 7;
		if (bking > 15) {
			if ((x != 0) && testPiece(bking - 9, WHITE_PAWN))
				return true;
			if ((x != 7) && testPiece(bking - 7, WHITE_PAWN))
				return true;
		}
		return false;
	}

	final boolean isCheckWhite() {
		for (int p : IBase.M32_WHITE_KNIGHT[wking]) {
			long bit = 1L << BITS.getTo(p);
			if ((bb_piece & bit) == 0 || (bb_black & bit) == 0)
				continue;
			if (type(bit) == WHITE_KNIGHT)
				return true;
		}
		for (int p : IBase.M32_WHITE_KING[wking]) {
			long bit = 1L << BITS.getTo(p);
			if ((bb_piece & bit) == 0 || (bb_black & bit) == 0)
				continue;
			if (type(bit) == WHITE_KING)
				return true;
		}
		for (int[] slide : IBase.M32_WHITE_BISHOP[wking]) {
			for (int p : slide) {
				long bit = 1L << BITS.getTo(p);
				if ((bb_piece & bit) == 0)
					continue;
				if ((bb_black & bit) == 0)
					break;
				int type = type(bit);
				if (type == WHITE_QUEEN || type == WHITE_BISHOP)
					return true;
				break;
			}
		}
		for (int[] slide : IBase.M32_WHITE_ROOK[wking]) {
			for (int p : slide) {
				long bit = 1L << BITS.getTo(p);
				if ((bb_piece & bit) == 0)
					continue;
				if ((bb_black & bit) == 0)
					break;
				int type = type(bit);
				if (type == WHITE_QUEEN || type == WHITE_ROOK)
					return true;
				break;
			}
		}
		int x = wking & 7;
		if (wking < 48) {
			if ((x != 0) && testPiece(wking + 7, BLACK_PAWN))
				return true;
			if ((x != 7) && testPiece(wking + 9, BLACK_PAWN))
				return true;
		}
		return false;
	}

	final private int type(long bit) {
		return ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4);
	}

	final private boolean testPiece(int i, int piece) {
		long bit = 1L << i;
		return (bb_piece & bit) != 0
				&& (((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4) | ((bb_black & bit) == 0 ? 0 : 8)) == piece;
	}

}

package no.pdigre.chess.engine.base;

import java.util.Arrays;

import no.pdigre.chess.engine.fen.Position64;

public class GNodegen implements IConst {

	final Position64 pos;
	final long halfmoves;
	final long castling;
	final long bb_piece;
	final long bb_white;
	final long bb_black;
	final long bb_bit1;
	final long bb_bit2;
	final long bb_bit3;
	final long[] moves = new long[99];
	int imoves = 0;
	final int wking;
	final int bking;
	final public int enpassant;

	GNodegen(Position64 pos) {
		this.pos = pos;
		long inherit = pos.getBitmap();
		this.bb_black = pos.get64black();
		this.bb_bit1 = pos.get64bit1();
		this.bb_bit2 = pos.get64bit2();
		this.bb_bit3 = pos.get64bit3();
		this.bb_piece = bb_bit1 | bb_bit2 | bb_bit3;
		this.bb_white = bb_piece ^ bb_black;
		this.enpassant = BITS.getEnpassant(inherit);
		this.wking=pos.getWKpos();
		this.bking=pos.getBKpos();
		halfmoves = (BITS.halfMoves(inherit) + 1) << _HALFMOVES;
		castling = ~CASTLING_STATE | inherit; // all other are set
	}

	final public Position64[] moves() {

		// *********************************************************************************************
		// *
		// *
		// *********************************************************************************************
		final Position64[] list = new Position64[99];
		int n = 0;
		int test = 0;
		if (pos.whiteNext()) {
			{   // Pawn
				long b=bb_white &(bb_bit1)&(~bb_bit2)&(~bb_bit3);
				long bits=Long.bitCount(b);
				for (int j = 0; j < bits; j++) {
					int from = Long.numberOfTrailingZeros(b);
					IBase.MM[from].WP.move(this);
					b&=~(1L<<from);
				}
			}
			{   // Knight
				long b=bb_white &(~bb_bit1)&(bb_bit2)&(~bb_bit3);
				long bits=Long.bitCount(b);
				for (int j = 0; j < bits; j++) {
					int from = Long.numberOfTrailingZeros(b);
					IBase.MM[from].WN.move(this);
					b&=~(1L<<from);
				}
			}
			{   // Bishop
				long b=bb_white &(bb_bit1)&(~bb_bit2)&(bb_bit3);
				long bits=Long.bitCount(b);
				for (int j = 0; j < bits; j++) {
					int from = Long.numberOfTrailingZeros(b);
					IBase.MM[from].WB.move(this);
					b&=~(1L<<from);
				}
			}
			{   // Rook
				long b=bb_white &(~bb_bit1)&(bb_bit2)&(bb_bit3);
				long bits=Long.bitCount(b);
				for (int j = 0; j < bits; j++) {
					int from = Long.numberOfTrailingZeros(b);
					IBase.MM[from].WR.move(this);
					b&=~(1L<<from);
				}
			}
			{   // Queen
				long b=bb_white &(bb_bit1)&(bb_bit2)&(bb_bit3);
				long bits=Long.bitCount(b);
				for (int j = 0; j < bits; j++) {
					int from = Long.numberOfTrailingZeros(b);
					IBase.MM[from].WQ.move(this);
					b&=~(1L<<from);
				}
			}
			{   // King
				IBase.MM[wking].WK.move(this);
				while (test < imoves) {
				Position64 next = pos.move(moves[test++]);
				if (!next.isCheckWhite())
					list[n++] = next;
				}
			}
		} else {
			{   // Pawn
				long b=bb_black &(bb_bit1)&(~bb_bit2)&(~bb_bit3);
				long bits=Long.bitCount(b);
				for (int j = 0; j < bits; j++) {
					int from = Long.numberOfTrailingZeros(b);
					IBase.MM[from].BP.move(this);
					b&=~(1L<<from);
				}
			}
			{   // Knight
				long b=bb_black &(~bb_bit1)&(bb_bit2)&(~bb_bit3);
				long bits=Long.bitCount(b);
				for (int j = 0; j < bits; j++) {
					int from = Long.numberOfTrailingZeros(b);
					IBase.MM[from].BN.move(this);
					b&=~(1L<<from);
				}
			}
			{   // Bishop
				long b=bb_black &(bb_bit1)&(~bb_bit2)&(bb_bit3);
				long bits=Long.bitCount(b);
				for (int j = 0; j < bits; j++) {
					int from = Long.numberOfTrailingZeros(b);
					IBase.MM[from].BB.move(this);
					b&=~(1L<<from);
				}
			}
			{   // Rook
				long b=bb_black &(~bb_bit1)&(bb_bit2)&(bb_bit3);
				long bits=Long.bitCount(b);
				for (int j = 0; j < bits; j++) {
					int from = Long.numberOfTrailingZeros(b);
					IBase.MM[from].BR.move(this);
					b&=~(1L<<from);
				}
			}
			{   // Queen
				long b=bb_black &(bb_bit1)&(bb_bit2)&(bb_bit3);
				long bits=Long.bitCount(b);
				for (int j = 0; j < bits; j++) {
					int from = Long.numberOfTrailingZeros(b);
					IBase.MM[from].BQ.move(this);
					b&=~(1L<<from);
				}
			}
			{   // King
				IBase.MM[bking].BK.move(this);
				while (test < imoves) {
				Position64 next = pos.move(moves[test++]);
				if (!next.isCheckBlack())
					list[n++] = next;
				}
			}
		}
		Position64[] mvs = Arrays.copyOfRange(list, 0, n);
		NodeGen.mergeSort(list, mvs, 0, n, 0);
		return mvs;
	}

}

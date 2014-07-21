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
	final  long bb_bit3;
	final long[] moves = new long[99];
	int imoves = 0;
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
			long bit = 1L;
			int from = 0;
			while (bit != 0) {
				if ((bb_white & bit) != 0) {
					int ptype = ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4);
					switch (ptype) {
					case WB:
						IBase.MM[from].WB.move(this);
						break;
					case WR:
						IBase.MM[from].WR.move(this);
						break;
					case WQ:
						IBase.MM[from].WQ.move(this);
						break;
					case WN:
						IBase.MM[from].WN.move(this);
						break;
					case WK:
						IBase.MM[from].WK.move(this);
						break;
					case WP:
						IBase.MM[from].WP.move(this);
						break;
					}
					while (test < imoves) {
						Position64 next = pos.move(moves[test++]);
						if (!next.isCheckWhite())
							list[n++] = next;
					}
				}
				bit = bit << 1;
				from++;
			}
		} else {
			long bit = 1L;
			int from = 0;
			while (bit != 0) {
				if ((bb_black & bit) != 0) {
					int ptype = ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4)
							| 8;
					switch (ptype) {
					case BB:
						IBase.MM[from].BB.move(this);
						break;
					case BR:
						IBase.MM[from].BR.move(this);
						break;
					case BQ:
						IBase.MM[from].BQ.move(this);
						break;
					case BN:
						IBase.MM[from].BN.move(this);
						break;
					case BK:
						IBase.MM[from].BK.move(this);
						break;
					case BP:
						IBase.MM[from].BP.move(this);
						break;
					}
					while (test < imoves) {
						Position64 next = pos.move(moves[test++]);
						if (!next.isCheckBlack())
							list[n++] = next;
					}
				}
				bit = bit << 1;
				from++;
			}
		}
		Position64[] mvs = Arrays.copyOfRange(list, 0, n);
		NodeGen.mergeSort(list, mvs, 0, n, 0);
		return mvs;
	}

}

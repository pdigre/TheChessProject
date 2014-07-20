package no.pdigre.chess.engine.base;

import java.util.Arrays;

import no.pdigre.chess.engine.fen.Position64;

public class GNodegenQ implements IConst {

	final private Position64 pos;
	final private long castling;
	final private long bb_piece;
	final private long bb_white;
	final private long bb_black;
	final private long bb_bit1;
	final private long bb_bit2;
	final private long bb_bit3;
	final private boolean whiteNext;
	final long[] moves = new long[99];
	int imoves = 0;

	GNodegenQ(Position64 pos) {
		this.pos = pos;
		long inherit = pos.getBitmap();
		this.bb_black = pos.get64black();
		this.bb_bit1 = pos.get64bit1();
		this.bb_bit2 = pos.get64bit2();
		this.bb_bit3 = pos.get64bit3();
		this.whiteNext = pos.whiteNext();
		this.bb_piece = bb_bit1 | bb_bit2 | bb_bit3;
		this.bb_white = bb_piece ^ bb_black;
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
		long bit = 1L;
		int from = 0;
		if (whiteNext) {
			while (bit != 0) {
				if ((bb_white & bit) != 0) {
					int ptype = ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4)
							| ((bb_black & bit) == 0 ? 0 : 8);
					switch (ptype) {
					case WB:
						for (long[] slides : IBase.MM[from].WB.M)
							for (int i = 0; i < slides.length && slideQWhite(slides[i]); i++)
								;
						break;
					case WR:
						for (long[] slides : IBase.MM[from].WR.M)
							for (int i1 = 0; i1 < slides.length && slideQWhite(slides[i1]); i1++)
								;
						break;
					case WQ:
						for (long[] slides : IBase.MM[from].WQ.M)
							for (int i = 0; i < slides.length && slideQWhite(slides[i]); i++)
								;
						break;
					case WN:
						for (long bitmap : IBase.MM[from].WN.M)
							slideQWhite(bitmap);
						break;
					case WK:
						for (long bitmap : IBase.MM[from].WK.M)
							slideQWhite(bitmap);
						break;
					case WP:
						for (long bitmap : IBase.MM[from].WP.C)
							slideQWhite(bitmap);
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
			while (bit != 0) {
				if ((bb_black & bit) != 0) {
					int ptype = ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4)
							| ((bb_black & bit) == 0 ? 0 : 8);
					switch (ptype) {
					case BB:
						for (long[] slides : IBase.MM[from].BB.M)
							for (int i = 0; i < slides.length && slideQBlack(slides[i]); i++)
								;
						break;
					case BR:
						for (long[] slides : IBase.MM[from].BR.M)
							for (int i = 0; i < slides.length && slideQBlack(slides[i]); i++)
								;
						break;
					case BQ:
						for (long[] slides : IBase.MM[from].BQ.M)
							for (int i = 0; i < slides.length && slideQBlack(slides[i]); i++)
								;
						break;
					case BN:
						for (long bitmap : IBase.MM[from].BN.M)
							slideQBlack(bitmap);
						break;
					case BK:
						for (long bitmap : IBase.MM[from].BK.M)
							slideQBlack(bitmap);
						break;
					case BP:
						for (long bitmap : IBase.MM[from].BP.C)
							slideQBlack(bitmap);
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

	final private boolean slideQWhite(long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if ((bb_piece & bto) == 0) {
			return true;
		} else if ((bb_black & bto) != 0) {
			int type = type(bto);
			add((purge(bitmap, PSQT.pVal(to, type + 8)) & castling) | (type << _CAPTURE));
		}
		return false;
	}

	final private boolean slideQBlack(long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if ((bb_piece & bto) == 0) {
			return true;
		} else if ((bb_white & bto) != 0) {
			int type = type(bto);
			add((purge(bitmap, PSQT.pVal(to, type)) & castling) | (type << _CAPTURE));
		}
		return false;
	}


	final private long purge(long bitmap, int subtract) {
		int score = BITS.score(bitmap) - subtract;
		return (((long) score) << 32) | ((int) bitmap);
	}

	final private void add(long bitmap) {
		moves[imoves++] = bitmap;
	}

	final private int type(long bit) {
		return ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4);
	}

}

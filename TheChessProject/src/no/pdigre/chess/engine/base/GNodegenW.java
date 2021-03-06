package no.pdigre.chess.engine.base;

import java.util.Arrays;

import no.pdigre.chess.engine.fen.Position64;

public class GNodegenW implements IConst {

	final private int enpassant;
	final private Position64 pos;
	final private long halfmoves;
	final private long castling;
	final private long bb_piece;
	final private long bb_white;
	final private long bb_black;
	final private long bb_bit1;
	final private long bb_bit2;
	final private long bb_bit3;
	final long[] moves = new long[99];
	int imoves = 0;

	GNodegenW(Position64 pos) {
		this.pos = pos;
		long inherit = pos.getBitmap();
		this.bb_black = pos.get64black();
		this.bb_bit1 = pos.get64bit1();
		this.bb_bit2 = pos.get64bit2();
		this.bb_bit3 = pos.get64bit3();
		this.bb_piece = bb_bit1 | bb_bit2 | bb_bit3;
		this.bb_white = bb_piece ^ bb_black;
		halfmoves = (BITS.halfMoves(inherit) + 1) << _HALFMOVES;
		castling = ~CASTLING_STATE | inherit; // all other are set
		enpassant = BITS.getEnpassant(inherit);
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
		while (bit != 0) {
		if ((bb_white & bit) != 0) {
			int ptype = ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4)
					| ((bb_black & bit) == 0 ? 0 : 8);
			switch (ptype) {
			case WB:
				for (long[] slides : IBase.M32_WB[from])
					for (int i = 0; i < slides.length && slideWhite(slides[i]); i++);
				break;
			case WR:
				for (long[] slides : IBase.M32_WR[from])
					for (int i1 = 0; i1 < slides.length && slideWhite(slides[i1]); i1++);
				break;
			case WQ:
				for (long[] slides : IBase.M32_WQ[from])
					for (int i = 0; i < slides.length && slideWhite(slides[i]); i++);
				break;
			case WN:
				for (long bitmap : IBase.M32_WN[from])
					slideWhite(bitmap);
				break;
			case WK:
				for (long bitmap : IBase.M32_WK[from])
					slideWhite(bitmap);
				if(from==IConst.WK_STARTPOS){
				if ((castling & CANCASTLE_WHITEQUEEN) != 0) {
					if (!board(WK_STARTPOS - 1) && !board(WK_STARTPOS - 2) && !board(WK_STARTPOS - 3))
						if (!pos.isCheckWhite() && !pos.move(IBase.SIDE_WQ).isCheckWhite())
							add(IBase.CASTLING_WQ & castling);
				}
				if ((castling & CANCASTLE_WHITEKING) != 0) {
					if (!board(WK_STARTPOS + 1) && !board(WK_STARTPOS + 2))
						if (!pos.isCheckWhite() && !pos.move(IBase.SIDE_WK).isCheckWhite())
							add(IBase.CASTLING_WK & castling);
				}
				}
				break;
			case WP:
				for (long[] slides : IBase.M32_WP[from])
					for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++);
				for (long bitmap : IBase.M32_WP_CAPTURE[from]) {
					int to = BITS.getTo(bitmap);
					long bto = 1L << to;
					if (enpassant == to) {
						add((purge(bitmap, Piece_Square_Tables.pVal(to - 8, BP)) & castling) | (WP << _CAPTURE) | SPECIAL);
					} else {
						if ((bb_black & bto) != 0) {
							int type = type(bto);
							if (type == WR) {
								if (to == BR_KING_STARTPOS)
									bitmap = bitmap & ~CANCASTLE_BLACKKING;
								if (to == BR_QUEEN_STARTPOS)
									bitmap = bitmap & ~CANCASTLE_BLACKQUEEN;
							}
							add((purge(bitmap, Piece_Square_Tables.pVal(to, type + 8)) & castling) | (type << _CAPTURE));
						}
					}
				}
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
		Position64[] mvs = Arrays.copyOfRange(list, 0, n);
		NodeGen.mergeSort(list, mvs, 0, n, 0);
		return mvs;
	}

	final private boolean slideWhite(long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if (!((bb_piece & bto) != 0)) {
			add((bitmap & castling) | halfmoves);
			return true;
		} else if ((bb_black & bto) != 0) {
			int type = type(bto);
			if (type == WR) {
				if (to == BR_KING_STARTPOS)
					bitmap = bitmap & ~CANCASTLE_BLACKKING;
				if (to == BR_QUEEN_STARTPOS)
					bitmap = bitmap & ~CANCASTLE_BLACKQUEEN;
			}
			add((purge(bitmap, Piece_Square_Tables.pVal(to, type + 8)) & castling) | (type << _CAPTURE));
		}
		return false;
	}

	final private long purge(long bitmap, int subtract) {
		int score = BITS.score(bitmap) - subtract;
		return (((long) score) << 32) | ((int) bitmap);
	}

	final private boolean pawnSlide(long bitmap) {
		if ((bb_piece & BITS.bitsTo(bitmap)) == 0) {
			add(bitmap & castling);
			return true;
		}
		return false;
	}

	final private void add(long bitmap) {
		moves[imoves++] = bitmap;
	}

	final private boolean board(int i) {
		return (bb_piece & 1L << i) != 0;
	}

	final private int type(long bit) {
		return ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4);
	}

}

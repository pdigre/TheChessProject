package no.pdigre.chess.engine.base;

import java.util.Arrays;

import no.pdigre.chess.engine.fen.Position64;

public class GNodegen implements IConst {

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

	GNodegen(Position64 pos) {
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
	}

	final public Position64[] moves() {

		// *********************************************************************************************
		// *
		// *
		// *********************************************************************************************
		final Position64[] list = new Position64[99];
		int n = 0;
		int test = 0;
		long inherit = pos.getBitmap();
		int enpassant = BITS.getEnpassant(inherit);
		if (pos.whiteNext()) {
			long bit = 1L;
			int from = 0;
			while (bit != 0) {
				if ((bb_white & bit) != 0) {
					int ptype = ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4);
					MOVEMAP mm = IBase.MM[from];
					switch (ptype) {
					case WB:
						mm.B.moveW(this);
						break;
					case WR:
						mm.R.moveW(this);
						break;
					case WQ:
						mm.Q.moveW(this);
						break;
					case WN:
						mm.N.moveW(this);
						break;
					case WK:
						for (long bitmap : mm.K.MW)
							slideWhite(bitmap);
						if (from == WK_STARTPOS) {
							if ((CWQ & bb_piece) == 0 && (castling & CANCASTLE_WHITEQUEEN) != 0 && !pos.isCheckWhite()
									&& !pos.move(IBase.SIDE_WQ).isCheckWhite()) {
								add(IBase.CASTLING_WQ & castling);
							}
							if ((CWK & bb_piece) == 0 && (castling & CANCASTLE_WHITEKING) != 0 && !pos.isCheckWhite()
									&& !pos.move(IBase.SIDE_WK).isCheckWhite()) {
								add(IBase.CASTLING_WK & castling);
							}
						}
						break;
					case WP:
						for (long[] slides : mm.P.MW)
							for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++)
								;
						for (long bitmap : mm.P.CW) {
							int to = BITS.getTo(bitmap);
							long bto = 1L << to;
							if (enpassant == to) {
								add((purge(bitmap, PSQT.pVal(to - 8, BP)) & castling) | (WP << _CAPTURE) | SPECIAL);
							} else {
								if ((bb_black & bto) != 0) {
									int type = type(bto);
									if (type == WR) {
										if (to == BR_KING_STARTPOS)
											bitmap = bitmap & ~CANCASTLE_BLACKKING;
										if (to == BR_QUEEN_STARTPOS)
											bitmap = bitmap & ~CANCASTLE_BLACKQUEEN;
									}
									add((purge(bitmap, PSQT.pVal(to, type + 8)) & castling) | (type << _CAPTURE));
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
		} else {
			long bit = 1L;
			int from = 0;
			while (bit != 0) {
				if ((bb_black & bit) != 0) {
					int ptype = ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4)
							| 8;
					MOVEMAP mm = IBase.MM[from];
					switch (ptype) {
					case BB:
						mm.B.moveB(this);
						break;
					case BR:
						mm.R.moveB(this);
						break;
					case BQ:
						mm.Q.moveB(this);
						break;
					case BN:
						mm.N.moveB(this);
						break;
					case BK:
						for (long bitmap : mm.K.MB)
							slideBlack(bitmap);
						if (from == BK_STARTPOS) {
							if ((CBQ & bb_piece) == 0 && (castling & CANCASTLE_BLACKQUEEN) != 0 && !pos.isCheckBlack()
									&& !pos.move(IBase.SIDE_BQ).isCheckBlack()) {
								add(IBase.CASTLING_BQ & castling);
							}
							if ((CBK & bb_piece) == 0 && (castling & CANCASTLE_BLACKKING) != 0 && !pos.isCheckBlack() && !pos.move(IBase.SIDE_BK).isCheckBlack()) {
								add(IBase.CASTLING_BK & castling);
							}
						}
						break;
					case BP:
						for (long[] slides : mm.P.MB)
							for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++)
								;
						for (long bitmap : mm.P.CB) {
							int to = BITS.getTo(bitmap);
							long bto = 1L << to;
							if (enpassant == to) {
								add((purge(bitmap, PSQT.pVal(to + 8, WP)) & castling) | (WP << _CAPTURE) | SPECIAL);
							} else {
								if ((bb_white & bto) != 0) {
									int type = type(bto);
									if (type == WR) {
										if (to == WR_KING_STARTPOS)
											bitmap = bitmap & ~CANCASTLE_WHITEKING;
										if (to == WR_QUEEN_STARTPOS)
											bitmap = bitmap & ~CANCASTLE_WHITEQUEEN;
									}
									add((purge(bitmap, PSQT.pVal(to, type)) & castling) | (type << _CAPTURE));
								}
							}
						}
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


	final boolean slideWhite(long bitmap) {
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
			add((purge(bitmap, PSQT.pVal(to, type + 8)) & castling) | (type << _CAPTURE));
		}
		return false;
	}

	final boolean slideBlack(long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if (!((bb_piece & bto) != 0)) {
			add((bitmap & castling) | halfmoves);
			return true;
		} else if ((bb_white & bto) != 0) {
			int type = type(bto);
			if (type == WR) {
				if (to == WR_KING_STARTPOS)
					bitmap = bitmap & ~CANCASTLE_WHITEKING;
				if (to == WR_QUEEN_STARTPOS)
					bitmap = bitmap & ~CANCASTLE_WHITEQUEEN;
			}
			add((purge(bitmap, PSQT.pVal(to, type)) & castling) | (type << _CAPTURE));
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

	final private int type(long bit) {
		return ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4);
	}

}

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
					switch (ptype) {
					case WHITE_BISHOP:
						for (long[] slides : IBase.M32_WHITE_BISHOP[from])
							for (int i = 0; i < slides.length && slideWhite(slides[i]); i++)
								;
						break;
					case WHITE_ROOK:
						for (long[] slides : IBase.M32_WHITE_ROOK[from])
							for (int i1 = 0; i1 < slides.length && slideWhite(slides[i1]); i1++)
								;
						break;
					case WHITE_QUEEN:
						for (long[] slides : IBase.M32_WHITE_QUEEN[from])
							for (int i = 0; i < slides.length && slideWhite(slides[i]); i++)
								;
						break;
					case WHITE_KNIGHT:
						for (long bitmap : IBase.M32_WHITE_KNIGHT[from])
							slideWhite(bitmap);
						break;
					case WHITE_KING:
						for (long bitmap : IBase.M32_WHITE_KING[from])
							slideWhite(bitmap);
						if (from == WHITE_KING_STARTPOS) {
							if ((CWQ & bb_piece) == 0 && (castling & CANCASTLE_WHITEQUEEN) != 0 && !pos.isCheckWhite()
									&& !pos.move(IBase.WHITE_QUEENSIDE).isCheckWhite()) {
								add(IBase.CASTLING_WHITE_QUEEN & castling);
							}
							if ((CWK & bb_piece) == 0 && (castling & CANCASTLE_WHITEKING) != 0 && !pos.isCheckWhite()
									&& !pos.move(IBase.WHITE_KINGSIDE).isCheckWhite()) {
								add(IBase.CASTLING_WHITE_KING & castling);
							}
						}
						break;
					case WHITE_PAWN:
						for (long[] slides : IBase.M32_WHITE_PAWN[from])
							for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++)
								;
						for (long bitmap : IBase.M32_WHITE_PAWN_CAPTURE[from]) {
							int to = BITS.getTo(bitmap);
							long bto = 1L << to;
							if (enpassant == to) {
								add((purge(bitmap, Piece_Square_Tables.pVal(to - 8, BLACK_PAWN)) & castling) | (WHITE_PAWN << _CAPTURE) | SPECIAL);
							} else {
								if ((bb_black & bto) != 0) {
									int type = type(bto);
									if (type == WHITE_ROOK) {
										if (to == BLACK_ROOK_KING_STARTPOS)
											bitmap = bitmap & ~CANCASTLE_BLACKKING;
										if (to == BLACK_ROOK_QUEEN_STARTPOS)
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
		} else {
			long bit = 1L;
			int from = 0;
			while (bit != 0) {
				if ((bb_black & bit) != 0) {
					int ptype = ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4)
							| 8;
					switch (ptype) {
					case BLACK_BISHOP:
						for (long[] slides : IBase.M32_BLACK_BISHOP[from])
							for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
								;
						break;
					case BLACK_ROOK:
						for (long[] slides : IBase.M32_BLACK_ROOK[from])
							for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
								;
						break;
					case BLACK_QUEEN:
						for (long[] slides : IBase.M32_BLACK_QUEEN[from])
							for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
								;
						break;
					case BLACK_KNIGHT:
						for (long bitmap : IBase.M32_BLACK_KNIGHT[from])
							slideBlack(bitmap);
						break;
					case BLACK_KING:
						for (long bitmap : IBase.M32_BLACK_KING[from])
							slideBlack(bitmap);
						if (from == BLACK_KING_STARTPOS) {
							if ((CBQ & bb_piece) == 0 && (castling & CANCASTLE_BLACKQUEEN) != 0 && !pos.isCheckBlack()
									&& !pos.move(IBase.BLACK_QUEENSIDE).isCheckBlack()) {
								add(IBase.CASTLING_BLACK_QUEEN & castling);
							}
							if ((CBK & bb_piece) == 0 && (castling & CANCASTLE_BLACKKING) != 0 && !pos.isCheckBlack() && !pos.move(IBase.BLACK_KINGSIDE).isCheckBlack()) {
								add(IBase.CASTLING_BLACK_KING & castling);
							}
						}
						break;
					case BLACK_PAWN:
						for (long[] slides : IBase.M32_BLACK_PAWN[from])
							for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++)
								;
						for (long bitmap : IBase.M32_BLACK_PAWN_CAPTURE[from]) {
							int to = BITS.getTo(bitmap);
							long bto = 1L << to;
							if (enpassant == to) {
								add((purge(bitmap, Piece_Square_Tables.pVal(to + 8, WHITE_PAWN)) & castling) | (WHITE_PAWN << _CAPTURE) | SPECIAL);
							} else {
								if ((bb_white & bto) != 0) {
									int type = type(bto);
									if (type == WHITE_ROOK) {
										if (to == WHITE_ROOK_KING_STARTPOS)
											bitmap = bitmap & ~CANCASTLE_WHITEKING;
										if (to == WHITE_ROOK_QUEEN_STARTPOS)
											bitmap = bitmap & ~CANCASTLE_WHITEQUEEN;
									}
									add((purge(bitmap, Piece_Square_Tables.pVal(to, type)) & castling) | (type << _CAPTURE));
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


	final private boolean slideWhite(long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if (!((bb_piece & bto) != 0)) {
			add((bitmap & castling) | halfmoves);
			return true;
		} else if ((bb_black & bto) != 0) {
			int type = type(bto);
			if (type == WHITE_ROOK) {
				if (to == BLACK_ROOK_KING_STARTPOS)
					bitmap = bitmap & ~CANCASTLE_BLACKKING;
				if (to == BLACK_ROOK_QUEEN_STARTPOS)
					bitmap = bitmap & ~CANCASTLE_BLACKQUEEN;
			}
			add((purge(bitmap, Piece_Square_Tables.pVal(to, type + 8)) & castling) | (type << _CAPTURE));
		}
		return false;
	}

	final private boolean slideBlack(long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if (!((bb_piece & bto) != 0)) {
			add((bitmap & castling) | halfmoves);
			return true;
		} else if ((bb_white & bto) != 0) {
			int type = type(bto);
			if (type == WHITE_ROOK) {
				if (to == WHITE_ROOK_KING_STARTPOS)
					bitmap = bitmap & ~CANCASTLE_WHITEKING;
				if (to == WHITE_ROOK_QUEEN_STARTPOS)
					bitmap = bitmap & ~CANCASTLE_WHITEQUEEN;
			}
			add((purge(bitmap, Piece_Square_Tables.pVal(to, type)) & castling) | (type << _CAPTURE));
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

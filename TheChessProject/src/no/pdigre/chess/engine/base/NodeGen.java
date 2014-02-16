package no.pdigre.chess.engine.base;

import java.util.Arrays;

import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Position64;

public class NodeGen implements IConst {

	final private long[] moves = new long[99];
	private int imoves;
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
	final private int wking;
	final private int bking;
	final private boolean whiteNext;

	private NodeGen(Position64 pos) {
		this.pos = pos;
		long inherit = pos.getBitmap();
		this.bb_black = pos.get64black();
		this.bb_bit1 = pos.get64bit1();
		this.bb_bit2 = pos.get64bit2();
		this.bb_bit3 = pos.get64bit3();
		this.wking = pos.getWKpos();
		this.bking = pos.getBKpos();
		this.whiteNext = pos.whiteNext();
		this.bb_piece = bb_bit1 | bb_bit2 | bb_bit3;
		this.bb_white = bb_piece ^ bb_black;
		halfmoves = (BITS.halfMoves(inherit) + 1) << _HALFMOVES;
		castling = ~CASTLING_STATE | inherit; // all other are set
		enpassant = BITS.getEnpassant(inherit);
	}

	final private long[] getAllLegalMoves() {
		Position64[] list = getAllLegalMoves64();
		long[] ret = new long[list.length];
		for (int i = 0; i < ret.length; i++)
			ret[i] = list[i].getBitmap();
		return ret;
	}

	final private Position64[] getAllLegalMoves64() {
		final Position64[] list = new Position64[99];
		int n = 0;
		int test = 0;
		long bit = 1L;
		int i = 0;
		if (whiteNext) {
			while (bit != 0) {
				if ((bb_white & bit) != 0) {
					getMoves(i, piece(bit));
					while (test < imoves) {
						Position64 next = pos.move(moves[test++]);
						if (!next.isCheckWhite())
							list[n++] = next;
					}
				}
				bit = bit << 1;
				i++;
			}
		} else {
			while (bit != 0) {
				if ((bb_black & bit) != 0) {
					getMoves(i, piece(bit));
					while (test < imoves) {
						Position64 next = pos.move(moves[test++]);
						if (!next.isCheckBlack())
							list[n++] = next;
					}
				}
				bit = bit << 1;
				i++;
			}
		}
		Position64[] mvs = Arrays.copyOfRange(list, 0, n);
		mergeSort(list, mvs, 0, n, 0);
		return mvs;
	}

	final private Position64[] getQuiescence64() {
		final Position64[] list = new Position64[99];
		int n = 0;
		int test = 0;
		long bit = 1L;
		int i = 0;
		if (whiteNext) {
			while (bit != 0) {
				if ((bb_white & bit) != 0) {
					getQMoves(i, piece(bit));
					while (test < imoves) {
						Position64 next = pos.move(moves[test++]);
						if (!next.isCheckWhite())
							list[n++] = next;
					}
				}
				bit = bit << 1;
				i++;
			}
		} else {
			while (bit != 0) {
				if ((bb_black & bit) != 0) {
					getQMoves(i, piece(bit));
					while (test < imoves) {
						Position64 next = pos.move(moves[test++]);
						if (!next.isCheckBlack())
							list[n++] = next;
					}
				}
				bit = bit << 1;
				i++;
			}
		}
		Position64[] mvs = Arrays.copyOfRange(list, 0, n);
		mergeSort(list, mvs, 0, n, 0);
		return mvs;
	}

	final private void getMoves(int from, int ptype) {
		switch (ptype) {
		case WHITE_BISHOP:
			for (long[] slides : IBase.M32_WHITE_BISHOP[from])
				for (int i = 0; i < slides.length && slideWhite(slides[i]); i++)
					;
			break;
		case BLACK_BISHOP:
			for (long[] slides : IBase.M32_BLACK_BISHOP[from])
				for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
					;
			break;
		case WHITE_ROOK:
			for (long[] slides : IBase.M32_WHITE_ROOK[from])
				for (int i1 = 0; i1 < slides.length && slideWhite(slides[i1]); i1++)
					;
			break;
		case BLACK_ROOK:
			for (long[] slides : IBase.M32_BLACK_ROOK[from])
				for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
					;
			break;
		case WHITE_QUEEN:
			for (long[] slides : IBase.M32_WHITE_QUEEN[from])
				for (int i = 0; i < slides.length && slideWhite(slides[i]); i++)
					;
			break;
		case BLACK_QUEEN:
			for (long[] slides : IBase.M32_BLACK_QUEEN[from])
				for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
					;
			break;
		case WHITE_KNIGHT:
			for (long bitmap : IBase.M32_WHITE_KNIGHT[from])
				slideWhite(bitmap);
			break;
		case BLACK_KNIGHT:
			for (long bitmap : IBase.M32_BLACK_KNIGHT[from])
				slideBlack(bitmap);
			break;
		case WHITE_KING:
			for (long bitmap : IBase.M32_WHITE_KING[from])
				slideWhite(bitmap);
			if ((castling & CANCASTLE_WHITEQUEEN) != 0) {
				if (!board(WHITE_KING_STARTPOS - 1) && !board(WHITE_KING_STARTPOS - 2) && !board(WHITE_KING_STARTPOS - 3))
					if (!pos.isCheckWhite() && !pos.move(IBase.WHITE_QUEENSIDE).isCheckWhite())
						add(IBase.CASTLING_WHITE_QUEEN & castling);
			}
			if ((castling & CANCASTLE_WHITEKING) != 0) {
				if (!board(WHITE_KING_STARTPOS + 1) && !board(WHITE_KING_STARTPOS + 2))
					if (!pos.isCheckWhite() && !pos.move(IBase.WHITE_KINGSIDE).isCheckWhite())
						add(IBase.CASTLING_WHITE_KING & castling);
			}
			break;
		case BLACK_KING:
			for (long bitmap : IBase.M32_BLACK_KING[from])
				slideBlack(bitmap);
			if ((castling & CANCASTLE_BLACKQUEEN) != 0) {
				if (!board(BLACK_KING_STARTPOS - 1) && !board(BLACK_KING_STARTPOS - 2) && !board(BLACK_KING_STARTPOS - 3))
					if (!pos.isCheckBlack() && !pos.move(IBase.BLACK_QUEENSIDE).isCheckBlack()) {
						add(IBase.CASTLING_BLACK_QUEEN & castling);
					}
			}
			if ((castling & CANCASTLE_BLACKKING) != 0) {
				if (!board(BLACK_KING_STARTPOS + 1) && !board(BLACK_KING_STARTPOS + 2))
					if (!pos.isCheckBlack() && !pos.move(IBase.BLACK_KINGSIDE).isCheckBlack()) {
						add(IBase.CASTLING_BLACK_KING & castling);
					}
			}
			break;
		case BLACK_PAWN:
			for (long[] slides : IBase.M32_BLACK_PAWN[from])
				for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++)
					;
			for (long bitmap : IBase.M32_BLACK_PAWN_CAPTURE[from])
				pawnCaptureBlack(bitmap);
			break;
		case WHITE_PAWN:
			for (long[] slides : IBase.M32_WHITE_PAWN[from])
				for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++)
					;
			for (long bitmap : IBase.M32_WHITE_PAWN_CAPTURE[from])
				pawnCaptureWhite(bitmap);
			break;
		}
	}

	final private void getQMoves(int from, int ptype) {
		switch (ptype) {
		case WHITE_BISHOP:
			for (long[] slides : IBase.M32_WHITE_BISHOP[from])
				for (int i = 0; i < slides.length && slideQWhite(slides[i]); i++)
					;
			break;
		case BLACK_BISHOP:
			for (long[] slides : IBase.M32_BLACK_BISHOP[from])
				for (int i = 0; i < slides.length && slideQBlack(slides[i]); i++)
					;
			break;
		case WHITE_ROOK:
			for (long[] slides : IBase.M32_WHITE_ROOK[from])
				for (int i1 = 0; i1 < slides.length && slideQWhite(slides[i1]); i1++)
					;
			break;
		case BLACK_ROOK:
			for (long[] slides : IBase.M32_BLACK_ROOK[from])
				for (int i = 0; i < slides.length && slideQBlack(slides[i]); i++)
					;
			break;
		case WHITE_QUEEN:
			for (long[] slides : IBase.M32_WHITE_QUEEN[from])
				for (int i = 0; i < slides.length && slideQWhite(slides[i]); i++)
					;
			break;
		case BLACK_QUEEN:
			for (long[] slides : IBase.M32_BLACK_QUEEN[from])
				for (int i = 0; i < slides.length && slideQBlack(slides[i]); i++)
					;
			break;
		case WHITE_KNIGHT:
			for (long bitmap : IBase.M32_WHITE_KNIGHT[from])
				slideQWhite(bitmap);
			break;
		case BLACK_KNIGHT:
			for (long bitmap : IBase.M32_BLACK_KNIGHT[from])
				slideQBlack(bitmap);
			break;
		case WHITE_KING:
			for (long bitmap : IBase.M32_WHITE_KING[from])
				slideQWhite(bitmap);
			break;
		case BLACK_KING:
			for (long bitmap : IBase.M32_BLACK_KING[from])
				slideQBlack(bitmap);
			break;
		case WHITE_PAWN:
			for (long bitmap : IBase.M32_WHITE_PAWN_CAPTURE[from])
				slideQWhite(bitmap);
			break;
		case BLACK_PAWN:
			for (long bitmap : IBase.M32_BLACK_PAWN_CAPTURE[from])
				slideQBlack(bitmap);
			break;
		}
	}

	final private boolean board(int i) {
		return (bb_piece & 1L << i) != 0;
	}

	final private int type(long bit) {
		return ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4);
	}

	final private int piece(long bit) {
		return ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4) | ((bb_black & bit) == 0 ? 0 : 8);
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

	final private boolean slideQWhite(long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if ((bb_piece & bto) == 0) {
			return true;
		} else if ((bb_black & bto) != 0) {
			int type = type(bto);
			add((purge(bitmap, Piece_Square_Tables.pVal(to, type + 8)) & castling) | (type << _CAPTURE));
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
			add((purge(bitmap, Piece_Square_Tables.pVal(to, type)) & castling) | (type << _CAPTURE));
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

	final private void pawnCaptureWhite(long bitmap) {
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

	final private void pawnCaptureBlack(long bitmap) {
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

	public static final long[] getLegalMoves(IPosition pos) {
		return create(pos).getAllLegalMoves();
	}

	private static final NodeGen create(IPosition pos) {
		return new NodeGen(Position64.getPosition64(pos));
	}

	public static final Position64[] getLegalMoves64(IPosition pos) {
		return create(pos).getAllLegalMoves64();
	}

	public static final Position64[] getQuiescence64(IPosition pos) {
		return create(pos).getQuiescence64();
	}

	/**
	 * Tuning parameter: list size at or below which insertion sort will be used
	 * in preference to mergesort. To be removed in a future release.
	 */
	private static final int INSERTIONSORT_THRESHOLD = 7;

	/**
	 * Src is the source array that starts at index 0 Dest is the (possibly
	 * larger) array destination with a possible offset low is the index in dest
	 * to start sorting high is the end index in dest to end sorting off is the
	 * offset to generate corresponding low, high in src To be removed in a
	 * future release.
	 */
	private static void mergeSort(Position64[] src, Position64[] dest, int low, int high, int off) {
		int length = high - low;

		// Insertion sort on smallest arrays
		if (length < INSERTIONSORT_THRESHOLD) {
			for (int i = low; i < high; i++)
				for (int j = i; j > low && dest[j - 1].score > dest[j].score; j--) {
					int b = j - 1;
					Position64 t = dest[j];
					dest[j] = dest[b];
					dest[b] = t;
				}
			return;
		}

		// Recursively sort halves of dest into src
		int destLow = low;
		int destHigh = high;
		low += off;
		high += off;
		int mid = (low + high) >>> 1;
		mergeSort(dest, src, low, mid, -off);
		mergeSort(dest, src, mid, high, -off);

		// If list is already sorted, just copy from src to dest. This is an
		// optimization that results in faster sorts for nearly ordered lists.
		if (src[mid - 1].score <= src[mid].score) {
			System.arraycopy(src, low, dest, destLow, length);
			return;
		}

		// Merge sorted halves (now in src) into dest
		for (int i = destLow, p = low, q = mid; i < destHigh; i++) {
			if (q >= high || p < mid && src[p].score <= src[q].score)
				dest[i] = src[p++];
			else
				dest[i] = src[q++];
		}
	}

}

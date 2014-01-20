package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.fen.IPosition;

public class NodeGen implements IConst {

	final private int[] moves = new int[300];
	private int imoves;
	final private int enpassant;
	final private IPosition pos;
	final private int halfmoves;
	final private int castling;
	final private long bb_pieces;
	final private long bb_white;
	final private long bb_black;
	final private long bb_bit1;
	final private long bb_bit2;
	final private long bb_bit3;
	final private int wking;
	final private int bking;

	private NodeGen(IPosition pos) {
		this.pos = pos;
		int inherit = pos.getBitmap();
		halfmoves = (BITS.halfMoves(inherit) + 1) << _HALFMOVES;
		castling = ~CASTLING_STATE | inherit; // all other are set
		enpassant = BITS.getEnpassant(inherit);
		long bb_white = 0;
		long bb_black = 0;
		long bb_bit1 = 0;
		long bb_bit2 = 0;
		long bb_bit3 = 0;
		int wking = 0;
		int bking = 0;
		for (int i = 0; i < 64; i++) {
			int p = pos.getPiece(i);
			if (p != 0) {
				long bit = 1L << i;
				if (BITS.white(p)) {
					bb_white |= bit;
				} else {
					bb_black |= bit;
				}
				switch (p) {
				case KING:
					bb_bit3 |= bit;
					wking = i;
					break;
				case BLACK_KING:
					bb_bit3 |= bit;
					bking = i;
					break;
				case QUEEN:
				case BLACK_QUEEN:
					bb_bit1 |= bit;
					bb_bit2 |= bit;
					bb_bit3 |= bit;
					break;
				case ROOK:
				case BLACK_ROOK:
					bb_bit1 |= bit;
					bb_bit2 |= bit;
					break;
				case BISHOP:
				case BLACK_BISHOP:
					bb_bit1 |= bit;
					bb_bit3 |= bit;
					break;
				case KNIGHT:
				case BLACK_KNIGHT:
					bb_bit1 |= bit;
					break;
				case PAWN:
				case BLACK_PAWN:
					break;
				}
			}
		}
		this.bb_pieces = bb_white | bb_black;
		this.bb_white = bb_white;
		this.bb_black = bb_black;
		this.bb_bit1 = bb_bit1;
		this.bb_bit2 = bb_bit2;
		this.bb_bit3 = bb_bit3;
		this.wking = wking;
		this.bking = bking;
		// String bits = Long.toBinaryString(bb_pieces);
		// for (int i = 0; i < 64; i++) {
		// boolean p=board[i]!=0;
		// boolean b=board(i);
		// if(b!=p){
		// boolean c=board(i);
		// System.out.println("hi");
		// }
		// }
	}

	final private void getMoves(int from, int ptype) {
		switch (ptype) {
		case BISHOP:
			for (int[] slides : IBase.BISHOP_MOVES[from])
				for (int i = 0; i < slides.length && slideWhite(slides[i]); i++)
					;
			break;
		case BLACK_BISHOP:
			for (int[] slides : IBase.BISHOP_MOVES_BLACK[from])
				for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
					;
			break;
		case ROOK:
			for (int[] slides : IBase.ROOK_MOVES[from])
				for (int i1 = 0; i1 < slides.length && slideWhite(slides[i1]); i1++)
					;
			break;
		case BLACK_ROOK:
			for (int[] slides : IBase.ROOK_MOVES_BLACK[from])
				for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
					;
			break;
		case QUEEN:
			for (int[] slides : IBase.QUEEN_MOVES[from])
				for (int i = 0; i < slides.length && slideWhite(slides[i]); i++)
					;
			break;
		case BLACK_QUEEN:
			for (int[] slides : IBase.QUEEN_MOVES_BLACK[from])
				for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
					;
			break;
		case KNIGHT:
			for (int bitmap : IBase.KNIGHT_MOVES[from])
				slideWhite(bitmap);
			break;
		case BLACK_KNIGHT:
			for (int bitmap : IBase.KNIGHT_MOVES_BLACK[from])
				slideBlack(bitmap);
			break;
		case KING:
			break;
		case BLACK_KING:
			break;
		case BLACK_PAWN:
			for (int[] slides : IBase.PAWN_MOVES_BLACK[from])
				for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++)
					;
			for (int bitmap : IBase.PAWN_CAPTURES_BLACK[from])
				pawnCaptureBlack(bitmap);
			break;
		case PAWN:
			for (int[] slides : IBase.PAWN_MOVES[from])
				for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++)
					;
			for (int bitmap : IBase.PAWN_CAPTURES[from])
				pawnCaptureWhite(bitmap);
			break;
		}
	}

	private void getWhiteKingMoves() {
		for (int bitmap : IBase.KING_MOVES[wking])
			slideWhite(bitmap);
		if ((castling & CANCASTLE_WHITEQUEEN) != 0) {
			if (!board(KING_POS - 1) && !board(KING_POS - 2) && !board(KING_POS - 3))
				if (!isCheckWhite(pos.getBoard(), KING_POS) && !isCheckWhite(pos.getBoard(), KING_POS - 1))
					add(IBase.CASTLING_QUEEN_WHITE & castling);
		}
		if ((castling & CANCASTLE_WHITEKING) != 0) {
			if (!board(KING_POS + 1) && !board(KING_POS + 2))
				if (!isCheckWhite(pos.getBoard(), KING_POS) && !isCheckWhite(pos.getBoard(), KING_POS + 1))
					add(IBase.CASTLING_KING_WHITE & castling);
		}
	}

	private void getBlackKingMoves() {
		for (int bitmap : IBase.KING_MOVES_BLACK[bking])
			slideBlack(bitmap);
		if ((castling & CANCASTLE_BLACKQUEEN) != 0) {
			if (!board(BLACK_KING_POS - 1) && !board(BLACK_KING_POS - 2) && !board(BLACK_KING_POS - 3))
				if (!isCheckBlack(pos.getBoard(), BLACK_KING_POS) && !isCheckBlack(pos.getBoard(), BLACK_KING_POS - 1)) {
					add(IBase.CASTLING_QUEEN_BLACK & castling);
				}
		}
		if ((castling & CANCASTLE_BLACKKING) != 0) {
			if (!board(BLACK_KING_POS + 1) && !board(BLACK_KING_POS + 2))
				if (!isCheckBlack(pos.getBoard(), BLACK_KING_POS) && !isCheckBlack(pos.getBoard(), BLACK_KING_POS + 1)) {
					add(IBase.CASTLING_KING_BLACK & castling);
				}
		}
	}

	private boolean board(int i) {
		return (bb_pieces & 1L << i) != 0;
	}

	private boolean black(int i) {
		return (bb_black & 1L << i) != 0;
	}

	private boolean white(int i) {
		return (bb_white & 1L << i) != 0;
	}

	private int victim(int to) {
		return pos.getPiece(to) & BITS3;
	}

	final private static boolean isCheck(int[] board, final int kingpos, final boolean white) {
		return white ? isCheckWhite(board, kingpos) : isCheckBlack(board, kingpos);
	}

	final private static boolean isCheckWhite(int[] board, final int kingpos) {
		for (int p : IBase.KNIGHT_MOVES[kingpos]) {
			if (board[BITS.getTo(p)] == BLACK_KNIGHT)
				return true;
		}
		for (int p : IBase.KING_MOVES[kingpos]) {
			if (board[BITS.getTo(p)] == BLACK_KING)
				return true;
		}
		for (int[] slide : IBase.BISHOP_MOVES[kingpos]) {
			for (int p : slide) {
				int type = board[BITS.getTo(p)];
				if (type == 0)
					continue;
				if ((type & BLACK) == 0)
					break;
				if (type == BLACK_QUEEN || type == BLACK_BISHOP)
					return true;
				break;
			}
		}
		for (int[] slide : IBase.ROOK_MOVES[kingpos]) {
			for (int p : slide) {
				int type = board[BITS.getTo(p)];
				if (type == 0)
					continue;
				if ((type & BLACK) == 0)
					break;
				if (type == BLACK_QUEEN || type == BLACK_ROOK)
					return true;
				break;
			}
		}
		int x = kingpos & 7;
		if (kingpos < 48) {
			if ((x != 0) && board[kingpos + 7] == BLACK_PAWN)
				return true;
			if ((x != 7) && board[kingpos + 9] == BLACK_PAWN)
				return true;
		}
		return false;
	}

	final private static boolean isCheckBlack(int[] board, final int from) {
		for (int p : IBase.KNIGHT_MOVES[from]) {
			if (board[BITS.getTo(p)] == KNIGHT)
				return true;
		}
		for (int p : IBase.KING_MOVES[from]) {
			if (board[BITS.getTo(p)] == KING)
				return true;
		}
		for (int[] slide : IBase.BISHOP_MOVES[from]) {
			for (int p : slide) {
				int type = board[BITS.getTo(p)];
				if (type == 0)
					continue;
				if ((type & BLACK) != 0)
					break;
				if (type == QUEEN || type == BISHOP)
					return true;
				break;
			}
		}
		for (int[] slide : IBase.ROOK_MOVES[from]) {
			for (int p : slide) {
				int type = board[BITS.getTo(p)];
				if (type == 0)
					continue;
				if ((type & BLACK) != 0)
					break;
				if (type == QUEEN || type == ROOK)
					return true;
				break;
			}
		}
		int x = from & 7;
		if (from > 15) {
			if ((x != 0) && board[from - 9] == PAWN)
				return true;
			if ((x != 7) && board[from - 7] == PAWN)
				return true;
		}
		return false;
	}

	final private boolean slideWhite(int bitmap) {
		int to = BITS.getTo(bitmap);
		if (!board(to)) {
			add((bitmap & castling) | halfmoves);
			return true;
		} else if (black(to)) {
			add((bitmap & castling) | (victim(to) << _CAPTURE));
		}
		return false;
	}

	final private boolean slideBlack(int bitmap) {
		int to = BITS.getTo(bitmap);
		if (!board(to)) {
			add((bitmap & castling) | halfmoves);
			return true;
		} else if (white(to)) {
			add((bitmap & castling) | (victim(to) << _CAPTURE));
		}
		return false;
	}

	final private void pawnCaptureWhite(int bitmap) {
		int to = BITS.getTo(bitmap);
		if (enpassant == to) {
			add((bitmap & castling) | (PAWN << _CAPTURE) | SPECIAL);
		} else {
			if (black(to))
				add((bitmap & castling) | (victim(to) << _CAPTURE));
		}
	}

	final private void pawnCaptureBlack(int bitmap) {
		int to = BITS.getTo(bitmap);
		if (enpassant == to) {
			add((bitmap & castling) | (PAWN << _CAPTURE) | SPECIAL);
		} else {
			if (white(to))
				add((bitmap & castling) | (victim(to) << _CAPTURE));
		}
	}

	final private boolean pawnSlide(int bitmap) {
		if (!board(BITS.getTo(bitmap))) {
			add(bitmap & castling);
			return true;
		}
		return false;
	}

	final private void add(int bitmap) {
		moves[imoves++] = bitmap;
	}

	private int[] getAllLegal() {
		int safe = 0;
		int test = 0;
		int[] board = pos.getBoard();
		if (pos.whiteNext()) {
			getWhiteKingMoves();
			for (int i = 0; i < 64; i++) {
				if (white(i)) {
					getMoves(i, pos.getPiece(i));
					while (test < imoves) {
						int bitmap = moves[test++];
						int[] brd = IPosition.BOARD88.apply(board, bitmap);
						boolean checkWhite = isCheckWhite(brd, BITS.getPiece(bitmap) == KING ? BITS.getTo(bitmap) : wking);
						if (!checkWhite)
							moves[safe++] = bitmap;
					}
				}
			}
		} else {
			getBlackKingMoves();
			for (int i = 0; i < 64; i++) {
				if (black(i)) {
					getMoves(i, pos.getPiece(i));
					while (test < imoves) {
						int bitmap = moves[test++];
						int[] brd = IPosition.BOARD88.apply(board, bitmap);
						boolean checkBlack = isCheckBlack(brd, BITS.getPiece(bitmap) == BLACK_KING ? BITS.getTo(bitmap) : bking);
						if (!checkBlack)
							moves[safe++] = bitmap;

					}
				}
			}
		}
		int[] ret = new int[safe];
		System.arraycopy(moves, 0, ret, 0, safe);
		return ret;
	}

	public static final int[] getLegalMoves(IPosition pos) {
		return new NodeGen(pos).getAllLegal();
	}

	public static final IPosition[] children(IPosition pos) {
		int[] p = getLegalMoves(pos);
		IPosition[] all = new IPosition[p.length];
		for (int i = 0; i < p.length; i++)
			all[i] = pos.move(p[i]);
		return all;
	}

	/**
	 * @param pos
	 * @return
	 */
	public static int getCheckState(IPosition pos) {
		int[] board = pos.getBoard();
		boolean whiteNext = pos.whiteNext();
		int kingPos = NodeGen.getKingPos(board, whiteNext);
		if (!NodeGen.isCheck(board, kingPos, whiteNext))
			return 0;
		if (getLegalMoves(pos).length > 0)
			return CHECK;
		return MATE;
	}

	final private static int getKingPos(int[] board, boolean white) {
		int kingtype = white ? KING : BLACK_KING;
		for (int i = 0; i < 64; i++)
			if (board[i] == kingtype)
				return i;
		return 0;
	}

}

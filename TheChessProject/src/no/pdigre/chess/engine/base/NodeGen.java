package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.fen.IPosition;

public class NodeGen implements IConst {

	final private int[] moves = new int[300];
	private int imoves;

	final private boolean white;
	final private int kingpos;
	final private int enpassant;
	final private int[] board;
	final private IPosition pos;
	final private int halfmoves;
	final private int castling;
	final private boolean castleWQ;
	final private boolean castleWK;
	final private boolean castleBQ;
	final private boolean castleBK;

	private NodeGen(IPosition pos) {
		this.pos = pos;
		board = pos.getBoard();
		int inherit = pos.getBitmap();
		halfmoves = (BITS.halfMoves(inherit) + 1) << _HALFMOVES;
		castling = ~CASTLING_STATE | inherit; // all other are set
		white = !BITS.white(inherit);
		kingpos = getKingPos(board, white);
		enpassant = BITS.getEnpassant(inherit);
		castleWQ = (inherit & CANCASTLE_WHITEQUEEN) != 0;
		castleWK = (inherit & CANCASTLE_WHITEKING) != 0;
		castleBQ = (inherit & CANCASTLE_BLACKQUEEN) != 0;
		castleBK = (inherit & CANCASTLE_BLACKKING) != 0;
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
			for (int bitmap : IBase.KING_MOVES[from])
				slideWhite(bitmap);
			if (castleWQ) {
				if (board[KING_POS - 1] == 0 && board[KING_POS - 2] == 0 && board[KING_POS - 3] == 0)
					if (!isCheckWhite(board, KING_POS) && !isCheckWhite(board, KING_POS - 1))
						add(IBase.CASTLING_QUEEN_WHITE & castling);
			}
			if (castleWK) {
				if (board[KING_POS + 1] == 0 && board[KING_POS + 2] == 0)
					if (!isCheckWhite(board, KING_POS) && !isCheckWhite(board, KING_POS + 1))
						add(IBase.CASTLING_KING_WHITE & castling);
			}
			break;
		case BLACK_KING:
			for (int bitmap : IBase.KING_MOVES_BLACK[from])
				slideBlack(bitmap);
			if (castleBQ){
				if (board[BLACK_KING_POS - 1] == 0 && board[BLACK_KING_POS - 2] == 0 && board[BLACK_KING_POS - 3] == 0)
					if (!isCheckBlack(board, BLACK_KING_POS) && !isCheckBlack(board, BLACK_KING_POS - 1)){
						add(IBase.CASTLING_QUEEN_BLACK & castling);
					}
			}
			if (castleBK){
				if (board[BLACK_KING_POS + 1] == 0 && board[BLACK_KING_POS + 2] == 0)
					if (!isCheckBlack(board, BLACK_KING_POS) && !isCheckBlack(board, BLACK_KING_POS + 1)){
						add(IBase.CASTLING_KING_BLACK & castling);
					}
			}
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

	final private static int getKingPos(int[] board, boolean white) {
		int kingtype = white ? KING : BLACK_KING;
		for (int i = 0; i < 64; i++)
			if (board[i] == kingtype)
				return i;
		return 0;
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
		int victim = board[to];
		if (victim == 0) {
			add((bitmap & castling) | halfmoves);
			return true;
		} else if ((victim & BLACK) != 0) {
			add((bitmap & castling) | ((victim & BITS3) << _CAPTURE));
		}
		return false;
	}

	final private boolean slideBlack(int bitmap) {
		int to = BITS.getTo(bitmap);
		int victim = board[to];
		if (victim == 0) {
			add((bitmap & castling) | halfmoves);
			return true;
		} else if ((victim & BLACK) == 0) {
			add((bitmap & castling) | ((victim & BITS3) << _CAPTURE));
		}
		return false;
	}

	final private void pawnCaptureWhite(int bitmap) {
		int to = BITS.getTo(bitmap);
		if (enpassant == to) {
			add((bitmap & castling) | (PAWN << _CAPTURE) | SPECIAL);
		} else {
			int victim = board[to];
			if (victim != 0 && (victim & BLACK) != 0)
				add((bitmap & castling) | ((victim & BITS3) << _CAPTURE));
		}
	}

	final private void pawnCaptureBlack(int bitmap) {
		int to = BITS.getTo(bitmap);
		if (enpassant == to) {
			add((bitmap & castling) | (PAWN << _CAPTURE) | SPECIAL);
		} else {
			int victim = board[to];
			if (victim != 0 && (victim & BLACK) == 0)
				add((bitmap & castling) | ((victim & BITS3) << _CAPTURE));
		}
	}

	final private boolean pawnSlide(int bitmap) {
		int victim = board[BITS.getTo(bitmap)];
		if (victim == 0) {
			add(bitmap);
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
		if (white) {
			for (int i = 0; i < 64; i++) {
				int p = pos.getPiece(i);
				if (p != 0 && BITS.white(p)) {
					getMoves(i, p);
					while (test < imoves) {
						int bitmap = moves[test++];
						int[] brd = IPosition.BOARD88.apply(board, bitmap);
						boolean checkWhite = isCheckWhite(brd, BITS.getPiece(bitmap)==KING?BITS.getTo(bitmap):kingpos);
						if (!checkWhite)
							moves[safe++] = bitmap;
					}
				}
			}
		} else {
			for (int i = 0; i < 64; i++) {
				int p = pos.getPiece(i);
				if (p != 0 && !BITS.white(p)) {
					getMoves(i, p);
					while (test < imoves) {
						int bitmap = moves[test++];
						int[] brd = IPosition.BOARD88.apply(board, bitmap);
						boolean checkBlack = isCheckBlack(brd, BITS.getPiece(bitmap)==BLACK_KING?BITS.getTo(bitmap):kingpos);
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

}

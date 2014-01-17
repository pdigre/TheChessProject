package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;
import no.pdigre.chess.engine.fen.IPosition;

public class NodeGen {

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
		halfmoves = (BITS.halfMoves(inherit) + 1) << IConst._HALFMOVES;
		castling = ~IConst.CASTLING_STATE | inherit; // all other are set
		white = !BITS.white(inherit);
		kingpos = getKingPos(board, white);
		enpassant = BITS.getEnpassant(inherit);
		castleWQ = (inherit&IConst.CANCASTLE_WHITEQUEEN)!=0;
		castleWK = (inherit&IConst.CANCASTLE_WHITEKING)!=0;
		castleBQ = (inherit&IConst.CANCASTLE_BLACKQUEEN)!=0;
		castleBK = (inherit&IConst.CANCASTLE_BLACKKING)!=0;
	}

	final private void getMoves(int from, int ptype) {
		switch (ptype) {
		case IConst.BISHOP:
			for (int[] slides : IBase.BISHOP_MOVES[from])
				for (int i = 0; i < slides.length && slideWhite(slides[i]); i++)
					;
			break;
		case IConst.BLACK_BISHOP:
			for (int[] slides : IBase.BISHOP_MOVES_BLACK[from])
				for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
					;
			break;
		case IConst.ROOK:
			for (int[] slides : IBase.ROOK_MOVES[from])
				for (int i1 = 0; i1 < slides.length && slideWhite(slides[i1]); i1++)
					;
			break;
		case IConst.BLACK_ROOK:
			for (int[] slides : IBase.ROOK_MOVES_BLACK[from])
				for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
					;
			break;
		case IConst.QUEEN:
			for (int[] slides : IBase.QUEEN_MOVES[from])
				for (int i = 0; i < slides.length && slideWhite(slides[i]); i++)
					;
			break;
		case IConst.BLACK_QUEEN:
			for (int[] slides : IBase.QUEEN_MOVES_BLACK[from])
				for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
					;
			break;
		case IConst.KNIGHT:
			for (int bitmap : IBase.KNIGHT_MOVES[from])
				slideWhite(bitmap);
			break;
		case IConst.BLACK_KNIGHT:
			for (int bitmap : IBase.KNIGHT_MOVES_BLACK[from])
				slideBlack(bitmap);
			break;
		case IConst.KING:
			for (int bitmap : IBase.KING_MOVES[from])
				slideWhite(bitmap);
			if (castleWQ){
				if (board[IConst.KING_POS -1] == 0 && board[IConst.KING_POS -2] == 0 && board[IConst.KING_POS -3] == 0)
					if (!isCheckWhite(board, IConst.KING_POS -1) && !isCheckWhite(board, IConst.KING_POS -2))
						add(IBase.CASTLING_QUEEN_WHITE & castling);
			}
			if (castleWK){
				if (board[IConst.KING_POS +1] == 0 && board[IConst.KING_POS +2] == 0)
					if (!isCheckWhite(board, IConst.KING_POS +1) && !isCheckWhite(board, IConst.KING_POS +2))
						add(IBase.CASTLING_KING_WHITE & castling);
			}
			break;
		case IConst.BLACK_KING:
			for (int bitmap : IBase.KING_MOVES_BLACK[from])
				slideBlack(bitmap);
			if (castleBQ)
				if (board[IConst.BLACK_KING_POS -1] == 0 && board[IConst.BLACK_KING_POS -2] == 0 && board[IConst.BLACK_KING_POS -3] == 0) 
					if (!isCheckBlack(board, IConst.BLACK_KING_POS -1) && !isCheckBlack(board, IConst.BLACK_KING_POS -2)) 
						add(IBase.CASTLING_QUEEN_BLACK & castling);
			if (castleBK)
				if (board[IConst.BLACK_KING_POS +1] == 0 && board[IConst.BLACK_KING_POS +2] == 0) 
					if (!isCheckBlack(board, IConst.BLACK_KING_POS +1) && !isCheckBlack(board, IConst.BLACK_KING_POS +2))
						add(IBase.CASTLING_KING_BLACK & castling);
			break;
		case IConst.BLACK_PAWN:
			for (int[] slides : IBase.PAWN_MOVES_BLACK[from])
				for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++)
					;
			for (int bitmap : IBase.PAWN_CAPTURES_BLACK[from])
				pawnCaptureBlack(bitmap);
			break;
		case IConst.PAWN:
			for (int[] slides : IBase.PAWN_MOVES[from])
				for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++)
					;
			for (int bitmap : IBase.PAWN_CAPTURES[from])
				pawnCaptureWhite(bitmap);
			break;
		}
	}

	final private static int getKingPos(int[] board, boolean white) {
		int kingtype = white ? IConst.KING : IConst.BLACK_KING;
		for (int i = 0; i < 64; i++)
			if (board[i] == kingtype)
				return i;
		return 0;
	}

	final private static boolean isCheck(int[] board, final int from, final boolean white) {
		return white?isCheckWhite(board, from):isCheckBlack(board, from);
	}

	final private static boolean isCheckWhite(int[] board, final int from) {
		for (int p : IBase.KNIGHT_MOVES[from]) {
			if (board[IConst.BITS.getTo(p)] == IConst.BLACK_KNIGHT)
				return true;
		}
		for (int p : IBase.KING_MOVES[from]) {
			if (board[IConst.BITS.getTo(p)] == IConst.BLACK_KING)
				return true;
		}
		for (int[] slide : IBase.BISHOP_MOVES[from]) {
			for (int p : slide) {
				int type = board[IConst.BITS.getTo(p)];
				if (type == 0)
					continue;
				if ((type & IConst.BLACK) == 0)
					break;
				int t = type & IConst.PIECETYPE;
				if (t == IConst.BLACK_QUEEN || t == IConst.BLACK_BISHOP)
					return true;
				break;
			}
		}
		for (int[] slide : IBase.ROOK_MOVES[from]) {
			for (int p : slide) {
				int type = board[IConst.BITS.getTo(p)];
				if (type == 0)
					continue;
				if (((type & IConst.BLACK) == 0) == true)
					break;
				int t = type & IConst.PIECETYPE;
				if (t == IConst.BLACK_QUEEN || type == IConst.BLACK_ROOK)
					return true;
				break;
			}
		}
		int x = from & 7;
		if (from < 48) {
			if ((x != 0) && board[from + 7] == IConst.BLACK_PAWN)
				return true;
			if ((x != 7) && board[from + 9] == IConst.BLACK_PAWN)
				return true;
		}
		return false;
	}

	final private static boolean isCheckBlack(int[] board, final int from) {
		for (int p : IBase.KNIGHT_MOVES[from]) {
			if (board[IConst.BITS.getTo(p)] == IConst.KNIGHT)
				return true;
		}
		for (int p : IBase.KING_MOVES[from]) {
			if (board[IConst.BITS.getTo(p)] == IConst.KING)
				return true;
		}
		for (int[] slide : IBase.BISHOP_MOVES[from]) {
			for (int p : slide) {
				int type = board[IConst.BITS.getTo(p)];
				if (type == 0)
					continue;
				if ((type & IConst.BLACK) != 0)
					break;
				if (type == IConst.QUEEN || type == IConst.BISHOP)
					return true;
				break;
			}
		}
		for (int[] slide : IBase.ROOK_MOVES[from]) {
			for (int p : slide) {
				int type = board[IConst.BITS.getTo(p)];
				if (type == 0)
					continue;
				if ((type & IConst.BLACK) != 0)
					break;
				if (type == IConst.QUEEN || type == IConst.ROOK)
					return true;
				break;
			}
		}
		int x = from & 7;
		if (from > 15) {
			if ((x != 0) && board[from - 9] == IConst.PAWN)
				return true;
			if ((x != 7) && board[from - 7] == IConst.PAWN)
				return true;
		}
		return false;
	}

	final private boolean slideWhite(int bitmap) {
		int to = IConst.BITS.getTo(bitmap);
		int victim = board[to];
		if (victim == 0) {
			add((bitmap & castling)|halfmoves);
			return true;
		} else if ((victim & IConst.BLACK) != 0) {
			add((bitmap & castling) | ((victim & IConst.BITS3) << IConst._CAPTURE));
		}
		return false;
	}

	final private boolean slideBlack(int bitmap) {
		int to = IConst.BITS.getTo(bitmap);
		int victim = board[to];
		if (victim == 0) {
			add((bitmap & castling)|halfmoves);
			return true;
		} else if ((victim & IConst.BLACK) == 0) {
			add((bitmap & castling) | ((victim & IConst.BITS3) << IConst._CAPTURE));
		}
		return false;
	}

	final private void pawnCaptureWhite(int bitmap) {
		int to = IConst.BITS.getTo(bitmap);
		if(enpassant==to){
			add(bitmap	| (IConst.PAWN << IConst._CAPTURE) | IConst.SPECIAL);
		} else {
			int victim = board[to];
			if (victim != 0 && (victim & IConst.BLACK) != 0)
				add(bitmap	| ((victim & IConst.BITS3) << IConst._CAPTURE));
		}
	}

	final private void pawnCaptureBlack(int bitmap) {
		int to = IConst.BITS.getTo(bitmap);
		if(enpassant==to){
			add(bitmap	| (IConst.PAWN << IConst._CAPTURE) | IConst.SPECIAL);
		} else {
			int victim = board[to];
			if (victim != 0 && (victim & IConst.BLACK) == 0)
				add(bitmap	| ((victim & IConst.BITS3) << IConst._CAPTURE));
		}
	}

	final private boolean pawnSlide(int bitmap) {
		int victim = board[IConst.BITS.getTo(bitmap)];
		if (victim == 0){
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
		for (int i = 0; i < 64; i++) {
			int p = pos.getPiece(i);
			if (p != 0 && white == BITS.white(p)) {
				getMoves(i, p);
				while (test < imoves) {
					int bitmap = moves[test++];
					int[] brd = IPosition.BOARD88.apply(board, bitmap);
					if (!isCheck(brd, i == kingpos ? BITS.getTo(bitmap) : kingpos, white))
						moves[safe++] = bitmap;
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
			return IConst.CHECK;
		return IConst.MATE;
	}

}

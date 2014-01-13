package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;
import no.pdigre.chess.engine.base.IConst.MOVE;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Position;

public class NodeGen {

	final private int[] moves = new int[300];

	final private boolean white;

	final private int kingpos;

	final private int enpassant;

	final private int pawn_fwd;

	final private int pawn_left;

	final private int pawn_right;

	final private int goalline;

	final private int home;

	final private int castle_rook;

	final private boolean castle_queen;

	final private boolean castle_king;

	private int imoves;

	final private int pawnline;

	final private int[] board;
	final private int inherit;
	final private IPosition pos;
	final private int halfmoves;
	final private int castling;

	private NodeGen(IPosition pos) {
		this.pos = pos;
		board = pos.getBoard();
		inherit = pos.getBitmap();
		halfmoves = (BITS.halfMoves(inherit) + 1) << IConst._HALFMOVES;
		castling = ~0 & (inherit & IConst.CASTLING_STATE); // all other are set
		white = !BITS.white(inherit);
		kingpos = getKingPos(board, white);
		enpassant = BITS.getEnpassant(inherit);
		pawn_fwd = forward(white);
		pawn_left = pawn_fwd + IBase.BASE.LEFT;
		pawn_right = pawn_fwd + IBase.BASE.RIGHT;
		goalline = goalline(white);
		home = home(white);
		pawnline = pawnline(white);
		castle_rook = white ? IConst.ROOK : IConst.BLACK_ROOK;
		castle_queen = (inherit & (white ? IConst.NOCASTLE_WHITEQUEEN : IConst.NOCASTLE_BLACKQUEEN)) == 0;
		castle_king = (inherit & (white ? IConst.NOCASTLE_WHITEKING : IConst.NOCASTLE_BLACKKING)) == 0;
	}

	final private void getMoves(int from, int ptype) {
		switch (ptype) {
		case IConst.BISHOP:
			for (int[] bitmaps : IBase.BISHOP_MOVES[from])
				for (int i = 0; i < bitmaps.length && addSlide(bitmaps[i]); i++)
					;
			break;
		case IConst.BLACK_BISHOP:
			for (int[] bitmaps : IBase.BISHOP_MOVES_BLACK[from])
				for (int i = 0; i < bitmaps.length && addSlide(bitmaps[i]); i++)
					;
			break;
		case IConst.ROOK:
			for (int[] bitmaps : IBase.ROOK_MOVES[from])
				for (int i1 = 0; i1 < bitmaps.length && addSpecial2(bitmaps[i1]); i1++)
					;
			break;
		case IConst.BLACK_ROOK:
			for (int[] bitmaps : IBase.ROOK_MOVES_BLACK[from])
				for (int i = 0; i < bitmaps.length && addSpecial2(bitmaps[i]); i++)
					;
			break;
		case IConst.QUEEN:
			for (int[] bitmaps : IBase.QUEEN_MOVES[from])
				for (int i = 0; i < bitmaps.length && addSlide(bitmaps[i]); i++)
					;
			break;
		case IConst.BLACK_QUEEN:
			for (int[] bitmaps : IBase.QUEEN_MOVES_BLACK[from])
				for (int i = 0; i < bitmaps.length && addSlide(bitmaps[i]); i++)
					;
			break;
		case IConst.KNIGHT:
			for (int bitmap : IBase.KNIGHT_MOVES[from])
				addSlide(bitmap);
			break;
		case IConst.BLACK_KNIGHT:
			for (int bitmap : IBase.KNIGHT_MOVES_BLACK[from])
				addSlide(bitmap);
			break;
		case IConst.KING:
			movesKingWhite(from);
			break;
		case IConst.BLACK_KING:
			movesKingBlack(from);
			break;
		case IConst.PAWN:
			movesPawn(from);
			break;
		case IConst.BLACK_PAWN:
			movesPawn(from);
			break;
		}
	}

	private void movesKingWhite(int from) {
		for (int bitmap : IBase.KING_MOVES[from])
			addSlide(bitmap);
		if ((inherit&IConst.NOCASTLE_WHITEQUEEN)!=0) {
			if (board[IConst.KING_POS -1] == 0 && board[IConst.KING_POS -2] == 0 && board[IConst.KING_POS -3] == 0 && board[IConst.KING_POS -4] == castle_rook) {
				if (!isCheck(board, IConst.KING_POS -1, true) && !isCheck(board, IConst.KING_POS -2, true)) {
					int piece = board[from];
					int bitmap = piece | (from << IConst._FROM) | (home + 2 << IConst._TO) | IConst.SPECIAL
							| (inherit & IConst.CASTLING_STATE);
					int bitmap2 = MOVE.castling(bitmap);
					add(bitmap2);
				}
			}
		}
		if ((inherit&IConst.NOCASTLE_WHITEKING)!=0) {
			if (board[IConst.KING_POS +1] == 0 && board[IConst.KING_POS +2] == 0 && board[IConst.KING_POS +3] == castle_rook) {
				if (!isCheck(board, IConst.KING_POS +1, true) && !isCheck(board, IConst.KING_POS +2, true)) {
					int piece = board[from];
					int bitmap = piece | (from << IConst._FROM) | (home + 6 << IConst._TO) | IConst.SPECIAL
							| (inherit & IConst.CASTLING_STATE);
					int bitmap2 = MOVE.castling(bitmap);
					add(bitmap2);
				}
			}
		}
	}

	private void movesKingBlack(int from) {
		for (int bitmap : IBase.KING_MOVES_BLACK[from])
			addSlide(bitmap);
		if ((inherit&IConst.NOCASTLE_BLACKQUEEN)!=0) {
			if (board[IConst.BLACK_KING_POS -1] == 0 && board[IConst.BLACK_KING_POS -2] == 0 && board[IConst.BLACK_KING_POS -3] == 0 && board[IConst.BLACK_KING_POS -4] == castle_rook) {
				if (!isCheck(board, IConst.BLACK_KING_POS -1, false) && !isCheck(board, IConst.BLACK_KING_POS -2, false)) {
					int piece = board[from];
					int bitmap = piece | (from << IConst._FROM) | (home + 2 << IConst._TO) | IConst.SPECIAL
							| (inherit & IConst.CASTLING_STATE);
					int bitmap2 = MOVE.castling(bitmap);
					add(bitmap2);
				}
			}
		}
		if ((inherit&IConst.NOCASTLE_BLACKKING)!=0) {
			if (board[IConst.BLACK_KING_POS +1] == 0 && board[IConst.BLACK_KING_POS +2] == 0 && board[IConst.BLACK_KING_POS +3] == castle_rook) {
				if (!isCheck(board, IConst.BLACK_KING_POS +1, false) && !isCheck(board, IConst.BLACK_KING_POS +2, false)) {
					int piece = board[from];
					int bitmap = piece | (from << IConst._FROM) | (home + 6 << IConst._TO) | IConst.SPECIAL
							| (inherit & IConst.CASTLING_STATE);
					int bitmap2 = MOVE.castling(bitmap);
					add(bitmap2);
				}
			}
		}
	}

	private void movesPawn(int from) {
		{
			int to = from + pawn_fwd;
			if (board[to] == 0) {
				int piece = board[from];
				boolean isPawn = BITS.getType(piece) == IConst.PAWN;
				int bm2 = isPawn ? piece : ((BITS.halfMoves(inherit) + 1) << IConst._HALFMOVES) | piece;
				if (to >= goalline && to < goalline + 8) {
					int bitmap = (piece & IConst.BLACK) | 0 | (from << IConst._FROM) | (to << IConst._TO)
							| IConst.SPECIAL;
					add(bitmap | IConst.QUEEN);
					add(bitmap | IConst.ROOK);
					add(bitmap | IConst.KNIGHT);
					add(bitmap | IConst.BISHOP);
				} else {
					int bm = bm2 | (from << IConst._FROM) | (to << IConst._TO) | (inherit & IConst.CASTLING_STATE);
					add(MOVE.castling(bm));
				}
				if (from >= pawnline && from < pawnline + 8) {
					if (board[to + pawn_fwd] == 0) {
						add(MOVE.castling(bm2 | (from << IConst._FROM) | (to + pawn_fwd << IConst._TO)
								| (inherit & IConst.CASTLING_STATE)));
					}
				}
			}
		}
		int x = from & 7;
		if (x != 0) {
			int to = from + pawn_left;
			int piece = board[to];
			if (piece != 0) {
				if (((piece & IConst.BLACK) != 0) == white) {
					if (to >= goalline && to < goalline + 8) {
						int bitmap = (board[from] & IConst.BLACK) | 0 | (from << IConst._FROM) | (to << IConst._TO)
								| IConst.SPECIAL | ((board[to] & IConst.BITS3) << IConst._CAPTURE);
						add(bitmap | IConst.QUEEN);
						add(bitmap | IConst.ROOK);
						add(bitmap | IConst.KNIGHT);
						add(bitmap | IConst.BISHOP);
					} else {
						add(board[from] | (from << IConst._FROM) | (to << IConst._TO)
								| ((board[to] & IConst.BITS3) << IConst._CAPTURE));
					}
				}
			} else {
				if (enpassant == to) {
					add(board[from] | (from << IConst._FROM) | (to << IConst._TO) | (IConst.PAWN << IConst._CAPTURE)
							| IConst.SPECIAL);
				}
			}
		}
		if (x != 7) {
			int to = from + pawn_right;
			int piece = board[to];
			if (piece != 0) {
				if (((piece & IConst.BLACK) != 0) == white) {
					if (to >= goalline && to < goalline + 8) {
						int bitmap = (board[from] & IConst.BLACK) | 0 | (from << IConst._FROM) | (to << IConst._TO)
								| IConst.SPECIAL | ((board[to] & IConst.BITS3) << IConst._CAPTURE);
						add(bitmap | IConst.QUEEN);
						add(bitmap | IConst.ROOK);
						add(bitmap | IConst.KNIGHT);
						add(bitmap | IConst.BISHOP);
					} else {
						add(board[from] | (from << IConst._FROM) | (to << IConst._TO)
								| ((board[to] & IConst.BITS3) << IConst._CAPTURE));
					}
				}
			} else {
				if (enpassant == to) {
					add(board[from] | (from << IConst._FROM) | (to << IConst._TO) | (IConst.PAWN << IConst._CAPTURE)
							| IConst.SPECIAL);
				}
			}
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
		int enemy = white ? IConst.BLACK_KNIGHT : IConst.KNIGHT;
		for (int p : IBase.KNIGHT_MOVES[from]) {
			if (board[IConst.BITS.getTo(p)] == enemy)
				return true;
		}
		enemy = white ? IConst.BLACK_KING : IConst.KING;
		for (int p : IBase.KING_MOVES[from]) {
			if (board[IConst.BITS.getTo(p)] == enemy)
				return true;
		}
		for (int[] slide : IBase.BISHOP_MOVES[from]) {
			for (int p : slide) {
				int type = board[IConst.BITS.getTo(p)];
				if (type == 0)
					continue;
				if (((type & IConst.BLACK) == 0) == white)
					break;
				int t = type & IConst.PIECETYPE;
				if (t == IConst.QUEEN || t == IConst.BISHOP)
					return true;
				break;
			}
		}
		for (int[] slide : IBase.ROOK_MOVES[from]) {
			for (int p : slide) {
				int type = board[IConst.BITS.getTo(p)];
				if (type == 0)
					continue;
				if (((type & IConst.BLACK) == 0) == white)
					break;
				int t = type & IConst.PIECETYPE;
				if (t == IConst.QUEEN || t == IConst.ROOK)
					return true;
				break;
			}
		}

		int x = from & 7;
		if (white) {
			if (from < 48) {
				if ((x != 0) && board[from + 7] == IConst.BLACK_PAWN)
					return true;
				if ((x != 7) && board[from + 9] == IConst.BLACK_PAWN)
					return true;
			}
		} else {
			if (from > 15) {
				if ((x != 0) && board[from - 9] == IConst.PAWN)
					return true;
				if ((x != 7) && board[from - 7] == IConst.PAWN)
					return true;
			}
		}
		return false;
	}

	final private static int home(boolean white) {
		return white ? 0 : 56;
	}

	final private static int forward(boolean white) {
		return white ? 8 : -8;
	}

	final private static int pawnline(boolean white) {
		return white ? 8 : 48;
	}

	final private static int goalline(boolean white) {
		return white ? 56 : 0;
	}

	/**
	 * Calculate is move is within borders return true if can continue like
	 * queen
	 * 
	 * @param to
	 * @param from
	 * @return
	 */
	final private boolean addSlide(int bitmap) {
		int piece = IConst.BITS.getPiece(bitmap);
		int from = IConst.BITS.getFrom(bitmap);
		int to = IConst.BITS.getTo(bitmap);
		int victim = board[to];
		if (victim == 0) {
			int move1 = (BITS.getType(piece) == IConst.PAWN ? piece
					: ((BITS.halfMoves(bitmap) + 1) << IConst._HALFMOVES) | piece)
					| (from << IConst._FROM)
					| (to << IConst._TO);
			int move = MOVE.castling(move1 | (bitmap & IConst.CASTLING_STATE));
			add(move);
		} else if (((victim & IConst.BLACK) == 0) != white) {
			add(board[from] | (from << IConst._FROM) | (to << IConst._TO)
					| ((board[to] & IConst.BITS3) << IConst._CAPTURE));
		}
		return victim == 0;
	}

	final private boolean addSpecial2(int bitmap) {
		int piece = IConst.BITS.getPiece(bitmap);
		int from = IConst.BITS.getFrom(bitmap);
		int to = IConst.BITS.getTo(bitmap);
		int victim = board[to];
		if (victim == 0) {
			int move1 = (BITS.getType(piece) == IConst.PAWN ? piece
					: ((BITS.halfMoves(bitmap) + 1) << IConst._HALFMOVES) | piece)
					| (from << IConst._FROM)
					| (to << IConst._TO);
			int move = MOVE.castling(move1 | (bitmap & IConst.CASTLING_STATE));
			add(move);
		} else if (((victim & IConst.BLACK) == 0) != white) {
			add(piece | (from << IConst._FROM) | (to << IConst._TO) | ((victim & IConst.BITS3) << IConst._CAPTURE));
		}
		return victim == 0;
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
					int t = moves[test++];
					int[] brd = IPosition.BOARD88.apply(board, t);
					if (!isCheck(brd, i == kingpos ? BITS.getTo(t) : kingpos, BITS.white(t)))
						moves[safe++] = t;
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
		int bitmap = pos.getBitmap();
		int[] board = pos.getBoard();
		boolean white = BITS.white(bitmap);
		Position next = new Position(board, bitmap & (IConst.CASTLING_STATE | IConst.HALFMOVES));
		int kingPos = NodeGen.getKingPos(next.getBoard(), white);
		boolean ch = NodeGen.isCheck(board, kingPos, white);
		if (!ch)
			return 0;
		if (getLegalMoves(next).length > 0)
			return IConst.CHECK;
		return IConst.MATE;
	}

}

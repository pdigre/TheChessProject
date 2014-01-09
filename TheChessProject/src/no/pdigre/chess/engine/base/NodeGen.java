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
	final private int state;
	final private IPosition pos;

	private NodeGen(IPosition pos) {
		this.pos=pos;
		board = pos.getBoard();
		inherit = pos.getBitmap();
		int half=(BITS.halfMoves(inherit)+1)<<IConst._HALFMOVES;
		state=inherit&IConst.CASTLING_STATE&(half>>IConst._HALFMOVES);
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
			addSlider(IBase.BISHOP_MOVES[from], from);
			break;
		case IConst.ROOK:
			addSliderSpecial(IBase.ROOK_MOVES[from], from);
			break;
		case IConst.QUEEN:
			addSlider(IBase.QUEEN_MOVES[from], from);
			break;
		case IConst.KNIGHT:
			addSimple(IBase.KNIGHT_MOVES[from], from);
			break;
		case IConst.KING:
			movesKing(from);
			break;
		case IConst.PAWN:
			movesPawn(from);
			break;
		case IConst.BLACK_BISHOP:
			addSlider(IBase.BISHOP_MOVES_BLACK[from], from);
			break;
		case IConst.BLACK_ROOK:
			addSlider(IBase.ROOK_MOVES_BLACK[from], from);
			break;
		case IConst.BLACK_QUEEN:
			addSlider(IBase.QUEEN_MOVES_BLACK[from], from);
			break;
		case IConst.BLACK_KNIGHT:
			addSimple(IBase.KNIGHT_MOVES_BLACK[from], from);
			break;
		case IConst.BLACK_KING:
			movesKing(from);
			break;
		case IConst.BLACK_PAWN:
			movesPawn(from);
			break;
		}
	}

	private void movesKing(int from) {
		addSimple(IBase.KING_MOVES[from], from);
		if (castle_queen) {
			if (board[home + 3] == 0 && board[home + 2] == 0 && board[home + 1] == 0 && board[home + 0] == castle_rook) {
				if (!isCheck(board, home + 3, white) && !isCheck(board, home + 4, white)) {
					addSpecial(MOVE.bitCastling(board[from], inherit, from, home + 2));
				}
			}
		}
		if (castle_king) {
			if (board[home + 5] == 0 && board[home + 6] == 0 && board[home + 7] == castle_rook) {
				if (!isCheck(board, home + 4, white) && !isCheck(board, home + 5, white)) {
					addSpecial(MOVE.bitCastling(board[from], inherit, from, home + 6));
				}
			}
		}
	}

	private void movesPawn(int from) {
		int to1 = from + pawn_fwd;
		if (board[to1] == 0) {
			if (to1 >= goalline && to1 < goalline + 8) {
				int bitmap = MOVE.bitPawnPromote(board[from], inherit, from, to1);
				add(bitmap | IConst.QUEEN);
				add(bitmap | IConst.ROOK);
				add(bitmap | IConst.KNIGHT);
				add(bitmap | IConst.BISHOP);
			} else {
				add(MOVE.bitMove(board[from], inherit, from, to1));
			}
			if (from >= pawnline && from < pawnline + 8) {
				int to2 = to1 + pawn_fwd;
				if (board[to2] == 0) {
					add(MOVE.bitMove(board[from], inherit, from, to2));
				}
			}
		}
		int x = from & 7;
		if (x != 0) {
			int to2 = from + pawn_left;
			int piece = board[to2];
			if (piece != 0) {
				if (((piece & IConst.BLACK) != 0) == white) {
					if (to2 >= goalline && to2 < goalline + 8) {
						int bitmap = MOVE.bitPawnCapturePromote(board[from], inherit,from, to2, board[to2] & IConst.BITS3);
						add(bitmap | IConst.QUEEN);
						add(bitmap | IConst.ROOK);
						add(bitmap | IConst.KNIGHT);
						add(bitmap | IConst.BISHOP);
					} else {
						add(MOVE.bitPawnCapture(board[from],inherit, from, to2, board[to2] & IConst.BITS3));
					}
				}
			} else {
				if (enpassant == to2) {
					add(MOVE.bitPawnEnpassant(board[from], inherit, from, to2));
				}
			}
		}
		if (x != 7) {
			int to3 = from + pawn_right;
			int piece = board[to3];
			if (piece != 0) {
				if (((piece & IConst.BLACK) != 0) == white) {
					if (to3 >= goalline && to3 < goalline + 8) {
						int bitmap = MOVE.bitPawnCapturePromote(board[from],inherit, from, to3, board[to3] & IConst.BITS3);
						add(bitmap | IConst.QUEEN);
						add(bitmap | IConst.ROOK);
						add(bitmap | IConst.KNIGHT);
						add(bitmap | IConst.BISHOP);
					} else {
						add(MOVE.bitPawnCapture(board[from],inherit, from, to3, board[to3] & IConst.BITS3));
					}
				}
			} else {
				if (enpassant == to3) {
					add(MOVE.bitPawnEnpassant(board[from], inherit, from, to3));
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
			if (board[p] == enemy)
				return true;
		}
		enemy = white ? IConst.BLACK_KING : IConst.KING;
		for (int p : IBase.KING_MOVES[from]) {
			if (board[p] == enemy)
				return true;
		}
		for (int[] slide : IBase.BISHOP_MOVES[from]) {
			for (int p : slide) {
				int type = board[p];
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
				int type = board[p];
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

	final private void addSlider(int[][] moves, int from) {
		for (int[] slide : moves) {
			for (int i = 0; i < slide.length && add(slide[i], from); i++) {
				// not
			}
		}
	}

	final private void addSliderSpecial(int[][] moves, int from) {
		for (int[] slide : moves) {
			for (int i = 0; i < slide.length && addSpecial(slide[i], from); i++) {
				// not
			}
		}
	}

	final private void addSimple(int[] moves, int from) {
		for (int to : moves)
			add(to, from);
	}

	/**
	 * Calculate is move is within borders return true if can continue like
	 * queen
	 * @param to
	 * @param from
	 * @return
	 */
	final private boolean add(int to, int from) {
		int victim = board[to];
		if (victim == 0) {
			add(MOVE.bitMove(board[from], inherit, from, to));
		} else if (((victim & IConst.BLACK) == 0) != white) {
			add(MOVE.bitPawnCapture(board[from],inherit, from, to, board[to] & IConst.BITS3));
		}
		return victim == 0;
	}

	final private boolean addSpecial(int to, int from) {
		int victim = board[to];
		if (victim == 0) {
			addSpecial(MOVE.bitMove(board[from], inherit, from, to));
		} else if (((victim & IConst.BLACK) == 0) != white) {
			addSpecial(MOVE.bitPawnCapture(board[from],inherit, from, to, board[to] & IConst.BITS3));
		}
		return victim == 0;
	}

	final private void add(int bitmap) {
		moves[imoves++] = bitmap; // |state;
	}

	final private void addSpecial(int bitmap) {
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

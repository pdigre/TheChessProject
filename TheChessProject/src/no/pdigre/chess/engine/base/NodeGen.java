package no.pdigre.chess.engine.base;

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
    
    private NodeGen(IPosition pos) {
        board = pos.getBoard();
        inherit = pos.getBitmap();
        white = !Bitmap.white(inherit);
        kingpos = getKingPos(board,white);
        enpassant = Bitmap.getEnpassant(inherit);
        pawn_fwd = forward(white);
        pawn_left = pawn_fwd + BaseNodes.LEFT;
        pawn_right = pawn_fwd + BaseNodes.RIGHT;
        goalline = goalline(white);
        home = home(white);
        pawnline = pawnline(white);
        castle_rook = white ? IConst.ROOK : IConst.BLACK_ROOK;
        castle_queen = (inherit & (white ? IConst.NOCASTLE_WHITEQUEEN : IConst.NOCASTLE_BLACKQUEEN)) == 0;
        castle_king = (inherit & (white ? IConst.NOCASTLE_WHITEKING : IConst.NOCASTLE_BLACKKING)) == 0;
    }

    final private void getMoves(final int from,final int sqr) {
        switch (sqr & 7) {
            case IConst.KNIGHT:
                addSimple(board, BaseNodes.KNIGHT_MOVES[from], white, from, inherit);
                break;
            case IConst.BISHOP:
                addSlider(board, BaseNodes.BISHOP_MOVES[from], white, from, inherit);
                break;
            case IConst.ROOK:
                addSlider(board, BaseNodes.ROOK_MOVES[from], white, from, inherit);
                break;
            case IConst.QUEEN:
                addSlider(board, BaseNodes.QUEEN_MOVES[from], white, from, inherit);
                break;
            case IConst.KING:
                addSimple(board, BaseNodes.KING_MOVES[from], white, from, inherit);
                if (castle_queen) {
                    if (board[home + 3] == 0 && board[home + 2] == 0 && board[home + 1] == 0
                        && board[home + 0] == castle_rook) {
                        if (!isCheck(board, home + 3, white) && !isCheck(board, home + 4, white)) {
                            add(Bitmap.bitCastling(board, inherit, from, home + 2));
                        }
                    }
                }
                if (castle_king) {
                    if (board[home + 5] == 0 && board[home + 6] == 0 && board[home + 7] == castle_rook) {
                        if (!isCheck(board, home + 4, white) && !isCheck(board, home + 5, white)) {
                            add(Bitmap.bitCastling(board, inherit, from, home + 6));
                        }
                    }
                }
                break;
            case IConst.PAWN: {
                int to1 = from + pawn_fwd;
                if (board[to1] == 0) {
                    if (to1 >= goalline && to1 < goalline + 8) {
                        int bitmap = Bitmap.bitPawnPromote(board, inherit, from, to1);
                        add(bitmap | IConst.QUEEN);
                        add(bitmap | IConst.ROOK);
                        add(bitmap | IConst.KNIGHT);
                        add(bitmap | IConst.BISHOP);
                    } else {
                        add(Bitmap.bitMove(from, inherit, to1, board[from]));
                    }
                    if (from >= pawnline && from < pawnline + 8) {
                        int to2 = to1 + pawn_fwd;
                        if (board[to2] == 0) {
                            add(Bitmap.bitMove(from, inherit, to2, board[from]));
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
                                int bitmap = Bitmap.bitPawnCapturePromote(board, inherit, from, to2);
                                add(bitmap | IConst.QUEEN);
                                add(bitmap | IConst.ROOK);
                                add(bitmap | IConst.KNIGHT);
                                add(bitmap | IConst.BISHOP);
                            } else {
                                add(Bitmap.bitPawnCapture(board, inherit, from, to2));
                            }
                        }
                    } else {
                        if (enpassant == to2) {
                            add(Bitmap.bitPawnEnpassant(board, inherit, from, to2));
                        }
                    }
                }
                if (x != 7) {
                    int to3 = from + pawn_right;
                    int piece = board[to3];
                    if (piece != 0) {
                        if (((piece & IConst.BLACK) != 0) == white) {
                            if (to3 >= goalline && to3 < goalline + 8) {
                                int bitmap = Bitmap.bitPawnCapturePromote(board, inherit, from, to3);
                                add(bitmap | IConst.QUEEN);
                                add(bitmap | IConst.ROOK);
                                add(bitmap | IConst.KNIGHT);
                                add(bitmap | IConst.BISHOP);
                            } else {
                                add(Bitmap.bitPawnCapture(board, inherit, from, to3));
                            }
                        }
                    } else {
                        if (enpassant == to3) {
                            add(Bitmap.bitPawnEnpassant(board, inherit, from, to3));
                        }
                    }
                }
                break;
            }
        }
    }

    final private static int getKingPos(int[] board,boolean white) {
        int kingtype = white ? IConst.KING : IConst.BLACK_KING;
        for (int i = 0; i < 64; i++)
            if (board[i] == kingtype)
                return i;
        return 0;
    }

    final private static boolean isCheck(int[] board, final int from, final boolean white) {
        int enemy = white ? IConst.BLACK_KNIGHT : IConst.KNIGHT;
        for (int pos : BaseNodes.KNIGHT_MOVES[from]) {
            if (board[pos] == enemy)
                return true;
        }
        enemy = white ? IConst.BLACK_KING : IConst.KING;
        for (int pos : BaseNodes.KING_MOVES[from]) {
            if (board[pos] == enemy)
                return true;
        }
        for (int[] slide : BaseNodes.BISHOP_MOVES[from]) {
            for (int pos : slide) {
                int type = board[pos];
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
        for (int[] slide : BaseNodes.ROOK_MOVES[from]) {
            for (int pos : slide) {
                int type = board[pos];
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

    final private void addSlider(int[] board, int[][] moves, boolean white, int from, int inherit) {
        for (int[] slide : moves) {
            for (int i = 0; i < slide.length && add(board, slide[i], white, from, inherit); i++) {
                // not
            }
        }
    }

    final private void addSimple(int[] board, int[] moves, boolean white, int from, int inherit) {
        for (int to : moves)
            add(board, to, white, from, inherit);
    }

    /**
     * Calculate is move is within borders return true if can continue like
     * queen
     * 
     * @param board
     * @param to
     * @param white
     * @param from
     * @param inherit
     * @return
     */
    final private boolean add(int[] board, int to, boolean white, int from, int inherit) {
        int victim = board[to];
        if (victim == 0) {
            int bitmap = Bitmap.bitMove(from, inherit, to, board[from]);
            add(bitmap);
        } else if (((victim & IConst.BLACK) == 0) != white) {
            int bitmap = Bitmap.bitPawnCapture(board, inherit, from, to);
            add(bitmap);
        }
        return victim == 0;
    }

    final private void add(int bitmap) {
        moves[imoves] = bitmap;
        imoves++;
    }

	private int[] getAllLegal() {
    	int safe=0;
    	int test=0;
    	for (int i = 0; i < 64; i++) {
			int p = board[i];
			if(p!=0 && white == Bitmap.white(p)){
				getMoves(i,p);
				while(test<imoves){
					int t=moves[test++];
			        int[] brd = Bitmap.apply(board, t);
			        if (!isCheck(brd, i == kingpos ? Bitmap.getTo(t) : kingpos, Bitmap.white(t)))
			        	moves[safe++]=t;
		    	}
			}
		}
    	int[] ret=new int[safe];
    	System.arraycopy(moves, 0, ret, 0, safe);
    	return ret;
	}

    public static final int[] getLegalMoves(IPosition pos) {
    	return new NodeGen(pos).getAllLegal();
    }

    public static final IPosition[] children(IPosition pos) {
    	int[] p=getLegalMoves(pos);
    	IPosition[] all=new IPosition[p.length];
        for (int i = 0; i < p.length; i++)
			all[i]=pos.move(p[i]);
        return all;
    }

    /**
     * @param pos
     * @return
     */
    public static int getCheckState(IPosition pos) {
        int bitmap = pos.getBitmap();
        int[] board = pos.getBoard();
        boolean white = Bitmap.white(bitmap);
        Position next = new Position(board, bitmap & (IConst.CASTLING_STATE | IConst.HALFMOVES));
        int kingPos = NodeGen.getKingPos(next.getBoard(), white);
        boolean ch = NodeGen.isCheck(board, kingPos, white);
        if (!ch)
            return 0;
        if (getLegalMoves(next).length>0)
            return IConst.CHECK;
        return IConst.MATE;
    }

}

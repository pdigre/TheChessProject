package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.base.KingSafe;

public class FEN implements IConst {

    public static char type2fen(int type) {
        return PieceType.types[type].fen;
    }

    public static String type2name(int type) {
        return PieceType.types[type].name();
    }

    public static int[] fen2board(String fen_board) {
        int[] board = new int[64];
        int y = 56;
        int x = 0;
        for (int i = 0; i < fen_board.length(); i++) {
            char c = fen_board.charAt(i);
            if (c == '/') {
                y -= 8;
                x = 0;
            } else if (c == ' ') {
                break;
            } else if (c >= '0' && c <= '9') {
                x += Integer.parseInt(String.valueOf(c));
            } else if (c >= 'A' && c <= 'z') {
                board[x + y] = PieceType.lookup(c).bitmap;
                x++;
            }
        }
        return board;
    }

    /**
     * Standard Forsyth–Edwards Notation
     * 
     * @return
     */
    final public static String getFen(IPosition pos) {
        StringBuilder fen = new StringBuilder();
        fen.append(FEN.board2fen(pos));
        fen.append(" ");
        fen.append(pos.whiteNext() ? "w" : "b");
        fen.append(" ");
        fen.append(FEN.getFenCastling(pos));
        fen.append(" ");
        fen.append(FEN.pos2string(BITS.getEnpassant(pos.getBitmap())));
        fen.append(" ");
        fen.append(BITS.halfMoves(pos.getBitmap()));
        if (pos instanceof IPositionWithLog) {
            fen.append(" ");
            fen.append(((IPositionWithLog) pos).totalMoves());
        }
        return fen.toString();
    }

    final public static String pos2string(int pos) {
        if (pos == -1)
            return "-";
        StringBuilder sb = new StringBuilder();
        sb.append("abcdefgh".charAt(pos & 7));
        sb.append("12345678".charAt(pos >> 3));
        return sb.toString();
    }

    final public static int text2pos(String pos) {
        if (pos == null || pos.length() != 2)
            return -1;
        return "abcdefgh".indexOf(pos.charAt(0)) + 8 * (pos.charAt(1) - '1');
    }

    final public static String board2string(IPosition pos) {
        StringBuilder fen = new StringBuilder();
        for (int y = 8; y-- > 0;) {
            fen.append(String.valueOf(y+1)+" ");
            for (int x = 0; x < 8; x++) {
                PieceType type = PieceType.types[pos.getPiece(y * 8 + x)];
                fen.append(type == null ? "." : type.fen);
            }
            fen.append("\n");
        }
        fen.append("  ABCDEFGH\n");
        return fen.toString();
    }

    final public static String board2string(int[] brd) {
        StringBuilder fen = new StringBuilder();
        for (int y = 8; y-- > 0;) {
            fen.append(String.valueOf(y+1)+" ");
            for (int x = 0; x < 8; x++) {
                PieceType type = PieceType.types[brd[y * 8 + x]];
                fen.append(type == null ? "." : type.fen);
            }
            fen.append("\n");
        }
        fen.append("  ABCDEFGH\n");
        return fen.toString();
    }

    final public static String board2fen(IPosition pos) {
        StringBuilder fen = new StringBuilder();
        for (int y = 8; y-- > 0;) {
            int i = 0;
            if (y != 7)
                fen.append("/");
            for (int x = 0; x < 8; x++) {
                PieceType type = PieceType.types[pos.getPiece(y * 8 + x)];
                if (type == null) {
                    i++;
                } else {
                    if (i > 0) {
                        fen.append(i);
                        i = 0;
                    }
                    fen.append(type.fen);
                }
            }
            if (i > 0)
                fen.append(i);
        }
        return fen.toString();
    }

    final public static String getFenCastling(IPosition move) {
        StringBuilder sb = new StringBuilder();
        int state = BITS.getCastlingState(move.getBitmap());
        if ((state & IConst.CANCASTLE_WHITEKING) != 0)
            sb.append("K");
        if ((state & IConst.CANCASTLE_WHITEQUEEN) != 0)
            sb.append("Q");
        if ((state & IConst.CANCASTLE_BLACKKING) != 0)
            sb.append("k");
        if ((state & IConst.CANCASTLE_BLACKQUEEN) != 0)
            sb.append("q");
        return sb.toString();
    }

    public static void printPiece(int type, int pos) {
        PieceType pt = PieceType.types[type];
        System.out.println(pt == null ? "<none>" : pt.toString() + " " + pos2string(pos));
    }

    public static String printMove(IPosition pos) {
        int bitmap = pos.getBitmap();
        StringBuilder sb = new StringBuilder();
        sb.append(PieceType.types[bitmap & PIECE]);
        sb.append(" from " + FEN.pos2string(BITS.getFrom(bitmap)) + " to "
            + FEN.pos2string(BITS.getTo(bitmap)));
        int capture = ((bitmap >> _CAPTURE) & 7);
        if (capture != 0)
            sb.append(" beats " + PieceType.types[capture | ((bitmap & BLACK) ^ BLACK)]);
        if (BITS.isEnpassant(bitmap))
            sb.append(" enpassant");
        if (BITS.isCastling(bitmap))
            sb.append(" castling");
        if (BITS.isPromotion(bitmap))
            sb.append(" promoted");
        switch (KingSafe.getCheckState(Position64.getPosition64(pos))) {
            case IConst.CHECK:
                sb.append(" check");
                break;
            case IConst.MATE:
                sb.append(" checkmate");
                break;
        }
        sb.append(", " + notation(pos));
        return sb.toString();
    }

    public static String notation(IPosition pos) {
        int bitmap = pos.getBitmap();
        int from = BITS.getFrom(bitmap);
        int to = BITS.getTo(bitmap);
        String capture = ((bitmap >> _CAPTURE) & 7) != 0 ? "x" : "";
        String p = piecePrefix(bitmap & PIECETYPE);
        String prefix = capture + FEN.pos2string(from);
        String suffix = capture + FEN.pos2string(to);
        if (BITS.isPromotion(bitmap)) {
            suffix += "=" + p;
        } else {
            prefix = p + prefix;
            suffix = p + suffix;
            if (BITS.isEnpassant(bitmap))
                suffix += "e.p.";
            if (BITS.isCastling(bitmap)) {
                int col = from & 7;
                suffix = col == 2 ? "O-O-O" : "O-O";
            }
        }
        switch (KingSafe.getCheckState(Position64.getPosition64(pos))) {
            case IConst.CHECK:
                suffix += "+";
                break;
            case IConst.MATE:
                suffix += "++";
                break;
        }
        return prefix + " " + suffix;
    }

    public static String notation(int bitmap) {
        int from = BITS.getFrom(bitmap);
        int to = BITS.getTo(bitmap);
        String capture = ((bitmap >> _CAPTURE) & 7) != 0 ? "x" : "";
        String p = piecePrefix(bitmap & PIECETYPE);
        String prefix = capture + FEN.pos2string(from);
        String suffix = capture + FEN.pos2string(to);
        if (BITS.isPromotion(bitmap)) {
            suffix += "=" + p;
        } else {
            prefix = p + prefix;
            suffix = p + suffix;
            if (BITS.isEnpassant(bitmap))
                suffix += "e.p.";
            if (BITS.isCastling(bitmap)) {
                int col = from & 7;
                suffix = col == 2 ? "O-O-O" : "O-O";
            }
        }
        return prefix + " " + suffix;
    }

    private static String piecePrefix(int type) {
        switch (type) {
            case IConst.WHITE_KING:
                return "K";
            case IConst.WHITE_QUEEN:
                return "Q";
            case IConst.WHITE_ROOK:
                return "R";
            case IConst.WHITE_BISHOP:
                return "B";
            case IConst.WHITE_KNIGHT:
                return "N";
        }
        return "";
    }

	public final static String move2literal(int bitmap) {
		return FEN.pos2string(IConst.BITS.getFrom(bitmap))+FEN.pos2string(IConst.BITS.getTo(bitmap));
	}

}

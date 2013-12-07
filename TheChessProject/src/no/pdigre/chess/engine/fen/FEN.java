package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.base.NodeGen;

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
	final public static String getFen(IPosition move) {
		StringBuilder fen = new StringBuilder();
		fen.append(FEN.board2String(move.getBoard()));
		fen.append(" ");
		fen.append(move.whiteNext() ? "w" : "b");
		fen.append(" ");
		fen.append(FEN.getFenCastling(move));
		fen.append(" ");
		fen.append(FEN.pos2string(Bitmap.getEnpassant(move.getBitmap())));
		fen.append(" ");
		fen.append(Bitmap.halfMoves(move.getBitmap()));
		if (move instanceof IPositionWithLog) {
			fen.append(" ");
			fen.append(((IPositionWithLog) move).totalMoves());
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

	final public static String board2String(int[] board) {
		StringBuilder fen = new StringBuilder();
		for (int y = 8; y-- > 0;) {
			int i = 0;
			if (y != 7)
				fen.append("/");
			for (int x = 0; x < 8; x++) {
				PieceType type = PieceType.types[board[y * 8 + x]];
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
		int state = Bitmap.getCastlingState(move.getBitmap());
		if ((state & IConst.NOCASTLE_WHITEKING) == 0)
			sb.append("K");
		if ((state & IConst.NOCASTLE_WHITEQUEEN) == 0)
			sb.append("Q");
		if ((state & IConst.NOCASTLE_BLACKKING) == 0)
			sb.append("k");
		if ((state & IConst.NOCASTLE_BLACKQUEEN) == 0)
			sb.append("q");
		return sb.toString();
	}

	public static String printBoard(int[] board) {
		StringBuffer sb = new StringBuffer();
		for (int y = 56; y >= 0; y -= 8) {
			for (int x = 0; x < 8; x++) {
				PieceType type = PieceType.types[board[x + y]];
				sb.append(type == null ? "." : type.fen);
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	public static void printPiece(int type, int pos) {
		PieceType pt = PieceType.types[type];
		System.out.println(pt == null ? "<none>" : pt.toString() + " "
				+ pos2string(pos));
	}

	public static String printMove(IPosition pos) {
		int bitmap = pos.getBitmap();
		int[] board = pos.getBoard();
		StringBuilder sb = new StringBuilder();
		sb.append(PieceType.types[bitmap & PIECE]);
		sb.append(" from " + FEN.pos2string(Bitmap.getFrom(bitmap)) + " to "
				+ FEN.pos2string(Bitmap.getTo(bitmap)));
		int capture = ((bitmap >> _CAPTURE) & 7);
		if (capture != 0)
			sb.append(" beats "
					+ PieceType.types[capture | ((bitmap & BLACK) ^ BLACK)]);
		if (Bitmap.isEnpassant(bitmap))
			sb.append(" enpassant");
		if (Bitmap.isCastling(bitmap))
			sb.append(" castling");
		if (Bitmap.isPromotion(bitmap))
			sb.append(" promoted");
		boolean white = Bitmap.white(bitmap);
		if (!NodeGen.checkSafe(board, NodeGen.getKingPos(board, white), white)) {
			sb.append(" check");
			if (!(new NodeGen(new Position(board, bitmap)).nextSafe() != 0))
				sb.append("mate");
		}
		sb.append(", ");
		sb.append(notation(pos));
		return sb.toString();
	}

	private static String notation(IPosition pos) {
		int bitmap = pos.getBitmap();
		int[] board = pos.getBoard();
		int from = Bitmap.getFrom(bitmap);
		int to = Bitmap.getTo(bitmap);
		String capture = ((bitmap >> _CAPTURE) & 7) != 0 ? "x" : "";
		String p = piecePrefix(bitmap & PIECETYPE);
		String prefix = capture + FEN.pos2string(from);
		String suffix = capture + FEN.pos2string(to);
		if (Bitmap.isPromotion(bitmap)) {
			suffix += "=" + p;
		} else {
			prefix = p + prefix;
			suffix = p + suffix;
			if (Bitmap.isEnpassant(bitmap))
				suffix += "e.p.";
			if (Bitmap.isCastling(bitmap)) {
				int col = from & 7;
				suffix = col == 2 ? "O-O-O" : "O-O";
			}
		}
		boolean white = Bitmap.white(bitmap);
		if (!NodeGen.checkSafe(board, NodeGen.getKingPos(board, white), white)) {
			suffix += "+";
			if (!(new NodeGen(new Position(board, bitmap)).nextSafe() != 0))
				suffix += "+";
		}
		return prefix + " " + suffix;
	}

	private static String piecePrefix(int type) {
		switch (type) {
		case Bitmap.KING:
			return "K";
		case Bitmap.QUEEN:
			return "Q";
		case Bitmap.ROOK:
			return "R";
		case Bitmap.BISHOP:
			return "B";
		case Bitmap.KNIGHT:
			return "N";
		}
		return "";
	}

}

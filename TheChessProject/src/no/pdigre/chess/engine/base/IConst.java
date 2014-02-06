package no.pdigre.chess.engine.base;


/**
 * 4 1-4 - Piecetype
 * 
 * 3 5-7 - Capture
 * 
 * 6 8-13 - From 6 14-19 - To
 * 
 * 4 20 - Castling 6 24 - Halfmoves
 */
public interface IConst {

	int BITS1 = 1;

	int BITS2 = 3;

	int BITS3 = 7;

	int BITS4 = 15;

	int BITS6 = 63;

	// Moving Piece
	int _PIECE = 0;

	int PIECETYPE = BITS3 << _PIECE;

	int PIECE = BITS4 << _PIECE;

	int BLACK = BITS1 << _PIECE + 3;

	// From to
	int _FROM = 4;

	int FROM = BITS6 << _FROM;

	int _TO = 10;

	int TO = BITS6 << _TO;

	// **** Special move ****
	// capture of
	// promotion special bit
	// en-passant special bit
	int _CAPTURE = 16;

	int CAPTURE = BITS3 << _CAPTURE;

	int SPECIAL = BITS1 << _CAPTURE + 3;

	// Game state
	int _CASTLING = 20;

	int CASTLING_STATE = BITS4 << _CASTLING;

	int CANCASTLE_WHITEQUEEN = BITS1 << (_CASTLING);

	int CANCASTLE_WHITEKING = BITS1 << (_CASTLING + 1);

	int CANCASTLE_WHITE = CANCASTLE_WHITEQUEEN | CANCASTLE_WHITEKING;

	int CANCASTLE_BLACKQUEEN = BITS1 << (_CASTLING + 2);

	int CANCASTLE_BLACKKING = BITS1 << (_CASTLING + 3);

	int CANCASTLE_BLACK = CANCASTLE_BLACKQUEEN | CANCASTLE_BLACKKING;

	int _HALFMOVES = 24;

	int HALFMOVES = BITS6 << _HALFMOVES;

	// piecetype
	int NONE = 0;

	int WHITE_BISHOP = 1;

	int WHITE_ROOK = 2;

	int WHITE_QUEEN = 3;

	int WHITE_PAWN = 5;

	int WHITE_KNIGHT = 6;

	int WHITE_KING = 7;

	int BLACK_PAWN = WHITE_PAWN | BLACK;

	int BLACK_KNIGHT = WHITE_KNIGHT | BLACK;

	int BLACK_BISHOP = WHITE_BISHOP | BLACK;

	int BLACK_ROOK = WHITE_ROOK | BLACK;

	int BLACK_QUEEN = WHITE_QUEEN | BLACK;

	int BLACK_KING = WHITE_KING | BLACK;

	// game state
	int CHECK = 1;

	int MATE = 2;

	int GOAL_LINE = 56;
	int WHITE_KING_STARTPOS = 4;
	int BLACK_KING_STARTPOS = WHITE_KING_STARTPOS + GOAL_LINE;
	int BLACK_ROOK_KING_STARTPOS=63;
	int BLACK_ROOK_QUEEN_STARTPOS=56;
	int WHITE_ROOK_KING_STARTPOS=7;
	int WHITE_ROOK_QUEEN_STARTPOS=0;

	class BITS {

		final public static int assemble(int piece,int from,int to,int extra) {
			return (piece <<_PIECE)|(from <<_FROM)|(to <<_TO)|extra;
		}

		final public static int getCastlingState(final int bitmap) {
			return bitmap & CASTLING_STATE;
		}

		final static public int getFrom(final int bitmap) {
			return (bitmap >> _FROM) & BITS6;
		}

		final static public int getTo(final int bitmap) {
			return (bitmap >> _TO) & BITS6;
		}

		final public static boolean isCapture(final int bitmap) {
			return (bitmap & CAPTURE) != 0;
		}

		/**
		 * Did white make the last move
		 * 
		 * @param bitmap
		 * @return
		 */
		final static public boolean white(final int bitmap) {
			return (bitmap & IConst.BLACK) == 0;
		}
		
		/**
		 * Did black make the last move
		 * 
		 * @param bitmap
		 * @return
		 */
		final static public boolean black(final int bitmap) {
			return (bitmap & IConst.BLACK) != 0;
		}

		/**
		 * Is white next to move
		 * 
		 * @param bitmap
		 * @return
		 */
		final static public boolean whiteNext(final int bitmap) {
			return (bitmap & IConst.BLACK) > 0;
		}

		final static public boolean isCastling(final int bitmap) {
			return (bitmap & SPECIAL) != 0 && BITS.getType(bitmap) == WHITE_KING;
		}

		final static public boolean isEnpassant(final int bitmap) {
			return (bitmap & SPECIAL) != 0 && BITS.getType(bitmap) == WHITE_PAWN;
		}

		final public static boolean isPromotion(final int bitmap) {
			return ((bitmap & SPECIAL) != 0) && BITS.getType(bitmap) != WHITE_KING && BITS.getType(bitmap) != WHITE_PAWN;
		}

		final public static int getPiece(final int bitmap) {
			return (bitmap & PIECE) >> _PIECE;
		}

		final public static int getType(final int bitmap) {
			return (bitmap & PIECETYPE) >> _PIECE;
		}

		final public static int halfMoves(final int bitmap) {
			return (bitmap >> _HALFMOVES) & BITS6;
		}

		public static int getEnpassant(final int bitmap) {
			int from2 = getFrom(bitmap);
			int to2 = getTo(bitmap);
			switch (getPiece(bitmap)) {
			case WHITE_PAWN:
				if (from2 - to2 == -16)
					return from2 + 8;
				return -1;
			case BLACK_PAWN:
				if (from2 - to2 == 16)
					return from2 - 8;
				return -1;
			default:
				return -1;
			}
		}

		public static int getCapturedType(int bitmap) {
			return (bitmap & IConst.CAPTURE) >>> IConst._CAPTURE;
		}
		

	}
	

}

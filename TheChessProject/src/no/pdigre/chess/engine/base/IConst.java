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

	long CASTLING_STATE = BITS4 << _CASTLING;

	long CANCASTLE_WHITEQUEEN = BITS1 << (_CASTLING);

	long CANCASTLE_WHITEKING = BITS1 << (_CASTLING + 1);

	long CANCASTLE_WHITE = CANCASTLE_WHITEQUEEN | CANCASTLE_WHITEKING;

	long CANCASTLE_BLACKQUEEN = BITS1 << (_CASTLING + 2);

	long CANCASTLE_BLACKKING = BITS1 << (_CASTLING + 3);

	long CANCASTLE_BLACK = CANCASTLE_BLACKQUEEN | CANCASTLE_BLACKKING;

	int _HALFMOVES = 24;

	long HALFMOVES = BITS6 << _HALFMOVES;

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
	int BLACK_ROOK_KING_STARTPOS = 63;
	int BLACK_ROOK_QUEEN_STARTPOS = 56;
	int WHITE_ROOK_KING_STARTPOS = 7;
	int WHITE_ROOK_QUEEN_STARTPOS = 0;

	class BITS {

		final public static long assemble2(int piece, int from, int to, long extra) {
			int score = 0;
			return (piece << _PIECE) | (from << _FROM) | (to << _TO) | extra | ((score | 0L) << 32);
		}

		final public static long assemble(int piece, int from, int to, long extra) {
			int score = Piece_Square_Tables.pVal(to, piece) - Piece_Square_Tables.pVal(from, piece);
			return (piece << _PIECE) | (from << _FROM) | (to << _TO) | extra | ((score | 0L) << 32);
		}

		final public static long assemblePromote(int pawn, int promote, int from, int to, long extra) {
			int score = Piece_Square_Tables.pVal(to, promote) - Piece_Square_Tables.pVal(from, pawn);
			return (promote << _PIECE) | (from << _FROM) | (to << _TO) | extra | ((score | 0L) << 32);
		}

		final public static long getCastlingState(final long bitmap) {
			return bitmap & CASTLING_STATE;
		}

		final static public int getFrom(final long bitmap) {
			return (int) ((bitmap >> _FROM) & BITS6);
		}

		final static public long bitsFrom(final long bitmap) {
			return 1L << ((bitmap >> _FROM) & BITS6);
		}

		final static public int getTo(final long bitmap) {
			return (int) ((bitmap >> _TO) & BITS6);
		}

		final static public long bitsTo(final long bitmap) {
			return 1L << ((bitmap >> _TO) & BITS6);
		}

		final public static boolean isCapture(final long bitmap) {
			return (bitmap & CAPTURE) != 0;
		}

		/**
		 * Did white make the last move
		 * 
		 * @param bitmap
		 * @return
		 */
		final static public boolean white(final long bitmap) {
			return (bitmap & IConst.BLACK) == 0;
		}

		/**
		 * Did black make the last move
		 * 
		 * @param bitmap
		 * @return
		 */
		final static public boolean black(final long bitmap) {
			return (bitmap & IConst.BLACK) != 0;
		}

		/**
		 * Is white next to move
		 * 
		 * @param bitmap
		 * @return
		 */
		final static public boolean whiteNext(final long bitmap) {
			return (bitmap & IConst.BLACK) > 0;
		}

		final static public boolean isCastling(final long bitmap) {
			return (bitmap & SPECIAL) != 0 && BITS.getType(bitmap) == WHITE_KING;
		}

		final static public boolean isEnpassant(final long bitmap) {
			return (bitmap & SPECIAL) != 0 && BITS.getType(bitmap) == WHITE_PAWN;
		}

		final public static boolean isPromotion(final long bitmap) {
			return ((bitmap & SPECIAL) != 0) && BITS.getType(bitmap) != WHITE_KING && BITS.getType(bitmap) != WHITE_PAWN;
		}

		final public static int getPiece(final long bitmap) {
			return (int) ((bitmap & PIECE) >> _PIECE);
		}

		final public static int getType(final long bitmap) {
			return (int) ((bitmap & PIECETYPE) >> _PIECE);
		}

		final public static int halfMoves(final long bitmap) {
			return (int) ((bitmap >> _HALFMOVES) & BITS6);
		}

		public static int getEnpassant(final long bitmap) {
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

		public static int getCapturedType(long bitmap) {
			return (int) ((bitmap & IConst.CAPTURE) >>> IConst._CAPTURE);
		}

		public static int getCaptured(long bitmap) {
			return (int) (((bitmap & IConst.CAPTURE) >>> IConst._CAPTURE) | (~bitmap&IConst.BLACK));
		}

		public static int score(long bitmap) {
			return (int)(bitmap>>32);
		}

	}

}

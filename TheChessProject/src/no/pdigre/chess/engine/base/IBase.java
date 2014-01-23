package no.pdigre.chess.engine.base;

import java.util.ArrayList;

/**
 * Arrays of possible moves for each position of the board sliders have sub
 * arrays - piece - from - to - x - castling
 * 
 * @author pdigre
 * 
 */
public interface IBase extends IConst {

	int[][] M32_WHITE_KNIGHT = new int[64][];
	int[][] M32_BLACK_KNIGHT = new int[64][];
	int[][] M32_WHITE_KING = new int[64][];
	int[][] M32_BLACK_KING = new int[64][];
	int[][][] M32_WHITE_BISHOP = new int[64][][];
	int[][][] M32_BLACK_BISHOP = new int[64][][];
	int[][][] M32_WHITE_ROOK = new int[64][][];
	int[][][] M32_BLACK_ROOK = new int[64][][];
	int[][][] M32_WHITE_QUEEN = new int[64][][];
	int[][][] QUEEN_MOVES_BLACK = new int[64][][];
	int CASTLING_WHITE_KING = BITS.assemble(WHITE_KING, WHITE_KING_STARTPOS, WHITE_KING_STARTPOS + 2, CANCASTLE_BLACK | SPECIAL);
	int CASTLING_WHITE_QUEEN = BITS.assemble(WHITE_KING, WHITE_KING_STARTPOS, WHITE_KING_STARTPOS - 2, CANCASTLE_BLACK | SPECIAL);
	int CASTLING_BLACK_KING = BITS.assemble(BLACK_KING, BLACK_KING_STARTPOS, BLACK_KING_STARTPOS + 2, CANCASTLE_WHITE | SPECIAL);
	int CASTLING_BLACK_QUEEN = BITS.assemble(BLACK_KING, BLACK_KING_STARTPOS, BLACK_KING_STARTPOS - 2, CANCASTLE_WHITE | SPECIAL);
	int WHITE_KINGSIDE = BITS.assemble(WHITE_KING, WHITE_KING_STARTPOS, WHITE_KING_STARTPOS + 1, CANCASTLE_BLACK);
	int WHITE_QUEENSIDE = BITS.assemble(WHITE_KING, WHITE_KING_STARTPOS, WHITE_KING_STARTPOS - 1, CANCASTLE_BLACK);
	int BLACK_KINGSIDE = BITS.assemble(BLACK_KING, BLACK_KING_STARTPOS, BLACK_KING_STARTPOS + 1, CANCASTLE_WHITE);
	int BLACK_QUEENSIDE = BITS.assemble(BLACK_KING, BLACK_KING_STARTPOS, BLACK_KING_STARTPOS - 1, CANCASTLE_WHITE);
	int[][][] M32_WHITE_PAWN = new int[64][][];
	int[][][] M32_BLACK_PAWN = new int[64][][];
	int[][] M32_WHITE_PAWN_CAPTURE = new int[64][];
	int[][] M32_BLACK_PAWN_CAPTURE = new int[64][];

	BASE base = new BASE();

	class BASE {
		final public static int LEFT = -1;

		final public static int RIGHT = 1;

		final public static int UP = 8;

		final public static int DOWN = -8;

		static {
			for (int from = 0; from < 64; from++) {
				M32_WHITE_KNIGHT[from] = getKnightMoves(from, WHITE_KNIGHT, CASTLING_STATE | HALFMOVES);
				M32_BLACK_KNIGHT[from] = getKnightMoves(from, BLACK_KNIGHT, CASTLING_STATE | HALFMOVES);
			}
		}

		private static int[] getKnightMoves(int from, int piece, int mask) {
			ArrayList<Integer> moves = new ArrayList<Integer>();
			add(moves, piece, from, UP + LEFT + LEFT, mask);
			add(moves, piece, from, UP + UP + LEFT, mask);
			add(moves, piece, from, UP + RIGHT + RIGHT, mask);
			add(moves, piece, from, UP + UP + RIGHT, mask);
			add(moves, piece, from, DOWN + LEFT + LEFT, mask);
			add(moves, piece, from, DOWN + DOWN + LEFT, mask);
			add(moves, piece, from, DOWN + RIGHT + RIGHT, mask);
			add(moves, piece, from, DOWN + DOWN + RIGHT, mask);
			return toArray(moves);
		}

		static {
			for (int from = 0; from < 64; from++) {
				M32_WHITE_ROOK[from] = getRookMoves(from, WHITE_ROOK, CASTLING_STATE | HALFMOVES);
				M32_BLACK_ROOK[from] = getRookMoves(from, BLACK_ROOK, CASTLING_STATE | HALFMOVES);
			}
			for (int[] b : M32_WHITE_ROOK[0])
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_WHITEQUEEN;
			for (int[] b : M32_WHITE_ROOK[7])
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_WHITEKING;
			for (int[] b : M32_BLACK_ROOK[56])
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_BLACKQUEEN;
			for (int[] b : M32_BLACK_ROOK[63])
				for (int i = 0; i < b.length; i++)
					b[i] ^= CANCASTLE_BLACKKING;
		}

		private static int[][] getRookMoves(int from, int piece, int mask) {
			ArrayList<int[]> slide = new ArrayList<int[]>();
			slide(slide, from, UP, piece, mask);
			slide(slide, from, DOWN, piece, mask);
			slide(slide, from, LEFT, piece, mask);
			slide(slide, from, RIGHT, piece, mask);
			return toArray2(slide);
		}

		static {
			for (int from = 0; from < 64; from++) {
				M32_WHITE_BISHOP[from] = getBishopMoves(from, WHITE_BISHOP, CASTLING_STATE | HALFMOVES);
				M32_BLACK_BISHOP[from] = getBishopMoves(from, BLACK_BISHOP, CASTLING_STATE | HALFMOVES);
			}
		}

		private static int[][] getBishopMoves(int from, int piece, int mask) {
			ArrayList<int[]> slide = new ArrayList<int[]>();
			slide(slide, from, UP + LEFT, piece, mask);
			slide(slide, from, UP + RIGHT, piece, mask);
			slide(slide, from, DOWN + LEFT, piece, mask);
			slide(slide, from, DOWN + RIGHT, piece, mask);
			return toArray2(slide);
		}

		static {
			for (int from = 0; from < 64; from++) {
				M32_WHITE_QUEEN[from] = getQueenMoves(from, WHITE_QUEEN, CASTLING_STATE | HALFMOVES);
				QUEEN_MOVES_BLACK[from] = getQueenMoves(from, BLACK_QUEEN, CASTLING_STATE | HALFMOVES);
			}
		}

		private static int[][] getQueenMoves(int from, int piece, int mask) {
			ArrayList<int[]> slide = new ArrayList<int[]>();
			slide(slide, from, UP, piece, mask);
			slide(slide, from, DOWN, piece, mask);
			slide(slide, from, LEFT, piece, mask);
			slide(slide, from, RIGHT, piece, mask);
			slide(slide, from, UP + LEFT, piece, mask);
			slide(slide, from, UP + RIGHT, piece, mask);
			slide(slide, from, DOWN + LEFT, piece, mask);
			slide(slide, from, DOWN + RIGHT, piece, mask);
			return toArray2(slide);
		}

		static {
			for (int from = 0; from < 64; from++) {
				M32_WHITE_KING[from] = getKingMoves(from, WHITE_KING, CANCASTLE_BLACK | HALFMOVES);
				M32_BLACK_KING[from] = getKingMoves(from, BLACK_KING, CANCASTLE_WHITE | HALFMOVES);
			}
		}

		private static int[] getKingMoves(int from, int piece, int mask) {
			ArrayList<Integer> moves = new ArrayList<Integer>();
			add(moves, piece, from, UP, mask);
			add(moves, piece, from, DOWN, mask);
			add(moves, piece, from, LEFT, mask);
			add(moves, piece, from, RIGHT, mask);
			add(moves, piece, from, UP + LEFT, mask);
			add(moves, piece, from, UP + RIGHT, mask);
			add(moves, piece, from, DOWN + LEFT, mask);
			add(moves, piece, from, DOWN + RIGHT, mask);
			return toArray(moves);
		}

		static {
			for (int from = 0; from < 64; from++) {
				M32_WHITE_PAWN[from] = getWhitePawnMoves(from);
				M32_BLACK_PAWN[from] = getBlackPawnMoves(from);
				M32_WHITE_PAWN_CAPTURE[from] = getWhitePawnCaptures(from);
				M32_BLACK_PAWN_CAPTURE[from] = getBlackPawnCaptures(from);
			}
		}

		private static int[] getWhitePawnCaptures(int from) {
			ArrayList<Integer> moves = new ArrayList<Integer>();
			int x = from & 7;
			if (x != 0)
				pwcapture(moves, from, from + 7);
			if (x != 7)
				pwcapture(moves, from, from + 9);
			return toArray(moves);
		}

		private static void pwcapture(ArrayList<Integer> moves, int from, int to) {
			if (to >= 56 && to < 64) {
				moves.add(BITS.assemble(WHITE_QUEEN, from, to, CASTLING_STATE|SPECIAL));
				moves.add(BITS.assemble(WHITE_ROOK, from, to, CASTLING_STATE|SPECIAL));
				moves.add(BITS.assemble(WHITE_KNIGHT, from, to, CASTLING_STATE|SPECIAL));
				moves.add(BITS.assemble(WHITE_BISHOP, from, to, CASTLING_STATE|SPECIAL));
			} else {
				moves.add(BITS.assemble(WHITE_PAWN, from, to, CASTLING_STATE));
			}
		}

		private static int[] getBlackPawnCaptures(int from) {
			ArrayList<Integer> moves = new ArrayList<Integer>();
			int x = from & 7;
			if (x != 0)
				pbcapture(moves, from, from - 9);
			if (x != 7)
				pbcapture(moves, from, from - 7);
			return toArray(moves);
		}

		private static void pbcapture(ArrayList<Integer> moves, int from, int to) {
			if (to >= 0 && to < 8) {
				moves.add(BITS.assemble(BLACK_QUEEN, from, to, CASTLING_STATE|SPECIAL));
				moves.add(BITS.assemble(BLACK_ROOK, from, to, CASTLING_STATE|SPECIAL));
				moves.add(BITS.assemble(BLACK_KNIGHT, from, to, CASTLING_STATE|SPECIAL));
				moves.add(BITS.assemble(BLACK_BISHOP, from, to, CASTLING_STATE|SPECIAL));
			} else {
				moves.add(BITS.assemble(BLACK_PAWN, from, to, CASTLING_STATE));
			}
		}

		private static int[][] getWhitePawnMoves(int from) {
			ArrayList<int[]> moves = new ArrayList<int[]>();
			int to = from + 8;
			if (to >= 56 && to < 64) {
				moves.add(new int[] { BITS.assemble(WHITE_QUEEN, from, to, CASTLING_STATE|SPECIAL), BITS.assemble(WHITE_ROOK, from, to, CASTLING_STATE|SPECIAL),
						BITS.assemble(WHITE_KNIGHT, from, to, CASTLING_STATE|SPECIAL), BITS.assemble(WHITE_BISHOP, from, to, CASTLING_STATE|SPECIAL) });
			} else if (from >= 8 && from < 16) {
				moves.add(new int[] { BITS.assemble(WHITE_PAWN, from, to, CASTLING_STATE), BITS.assemble(WHITE_PAWN, from, to + 8,CASTLING_STATE) });
			} else {
				moves.add(new int[] { BITS.assemble(WHITE_PAWN, from, to, CASTLING_STATE) });
			}
			return toArray2(moves);
		}

		private static int[][] getBlackPawnMoves(int from) {
			ArrayList<int[]> moves = new ArrayList<int[]>();
			int to = from - 8;
			if (to >= 0 && to < 8) {
				moves.add(new int[] { BITS.assemble(BLACK_QUEEN, from, to, CASTLING_STATE|SPECIAL), BITS.assemble(BLACK_ROOK, from, to, CASTLING_STATE|SPECIAL),
						BITS.assemble(BLACK_KNIGHT, from, to, CASTLING_STATE|SPECIAL), BITS.assemble(BLACK_BISHOP, from, to, CASTLING_STATE|SPECIAL) });
			} else if (from >= 48 && from < 56) {
				moves.add(new int[] { BITS.assemble(BLACK_PAWN, from, to, CASTLING_STATE), BITS.assemble(BLACK_PAWN, from, to - 8, CASTLING_STATE) });
			} else {
				moves.add(new int[] { BITS.assemble(BLACK_PAWN, from, to, CASTLING_STATE) });
			}
			return toArray2(moves);
		}

		static int[] toArray(ArrayList<Integer> moves) {
			int[] ret = new int[moves.size()];
			for (int i = 0; i < moves.size(); i++) {
				ret[i] = moves.get(i);
			}
			return ret;
		}

		static int[][] toArray2(ArrayList<int[]> moves) {
			int[][] ret = new int[moves.size()][];
			for (int i = 0; i < moves.size(); i++) {
				ret[i] = moves.get(i);
			}
			return ret;
		}

		/**
		 * Calculate is move is within borders return true if can continue like
		 * queen
		 * 
		 * @param moves
		 * @param piece
		 * @param from
		 * @param offset
		 * @param mask
		 * @return
		 */
		static boolean add(ArrayList<Integer> moves, int piece, int from, int offset, int mask) {
			int to = from + offset;
			boolean has = inside(to, from);
			if (has)
				moves.add(BITS.assemble(piece, from, to, mask));
			return has;
		}

		static boolean addSlide(ArrayList<Integer> moves, int piece, int from, int offset, int mask, int from2) {
			int to = from + offset;
			boolean has = inside(to, from);
			if (has)
				moves.add(BITS.assemble(piece, from2, to, mask));
			return has;
		}

		/**
		 * is it inside the board = legal move
		 * 
		 * @param to
		 * @param from
		 * @return
		 */
		static boolean inside(int to, int from) {
			if (to < 0 || to > 63)
				return false;
			int x1 = to % 8;
			int x2 = from % 8;
			if ((x1 < 3 && x2 > 4) || (x2 < 3 && x1 > 4))
				return false;
			return true;
		}

		/**
		 * Repeated moves like rook and queen
		 * 
		 * @param from
		 * @param offset
		 * @param piece
		 *            TODO
		 * @param mark
		 *            TODO
		 * @param M32_WHITE_ROOK
		 * @param board
		 */
		static void slide(ArrayList<int[]> main, int from, int offset, int piece, int mark) {
			ArrayList<Integer> moves = new ArrayList<Integer>();
			for (int slidefrom = from; addSlide(moves, piece, slidefrom, offset, mark, from); slidefrom += offset)
				;
			int[] mv = toArray(moves);
			if (mv.length > 0)
				main.add(mv);
		}
	}

}

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

	int[][] KNIGHT_MOVES = new int[64][];
	int[][] KNIGHT_MOVES_BLACK = new int[64][];
	int[][] KING_MOVES = new int[64][];
	int[][] KING_MOVES_BLACK = new int[64][];
	int[][][] BISHOP_MOVES = new int[64][][];
	int[][][] BISHOP_MOVES_BLACK = new int[64][][];
	int[][][] ROOK_MOVES = new int[64][][];
	int[][][] ROOK_MOVES_BLACK = new int[64][][];
	int[][][] QUEEN_MOVES = new int[64][][];
	int[][][] QUEEN_MOVES_BLACK = new int[64][][];
	int CASTLING_KING_WHITE = BITS.assemble(KING, KING_POS, KING_POS + 2, NOCASTLE_BLACKKING | NOCASTLE_BLACKQUEEN | SPECIAL);
	int CASTLING_QUEEN_WHITE = BITS.assemble(KING, KING_POS, KING_POS - 2, NOCASTLE_BLACKKING | NOCASTLE_BLACKQUEEN | SPECIAL);
	int CASTLING_KING_BLACK = BITS.assemble(BLACK_KING, BLACK_KING_POS, BLACK_KING_POS + 2, NOCASTLE_BLACKKING | NOCASTLE_WHITEQUEEN | SPECIAL);
	int CASTLING_QUEEN_BLACK = BITS.assemble(BLACK_KING, BLACK_KING_POS, BLACK_KING_POS - 2, NOCASTLE_BLACKKING | NOCASTLE_WHITEQUEEN | SPECIAL);
	int[][][] PAWN_MOVES = new int[64][][];
	int[][][] PAWN_MOVES_BLACK = new int[64][][];
	int[][] PAWN_CAPTURES = new int[64][];
	int[][] PAWN_CAPTURES_BLACK = new int[64][];

	BASE base = new BASE();

	class BASE {
		final public static int LEFT = -1;

		final public static int RIGHT = 1;

		final public static int UP = 8;

		final public static int DOWN = -8;

		static {
			for (int from = 0; from < 64; from++) {
				KNIGHT_MOVES[from] = getKnightMoves(from, KNIGHT, CASTLING_STATE | HALFMOVES);
				KNIGHT_MOVES_BLACK[from] = getKnightMoves(from, BLACK_KNIGHT, CASTLING_STATE | HALFMOVES);
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
				ROOK_MOVES[from] = getRookMoves(from, ROOK, CASTLING_STATE | HALFMOVES);
				ROOK_MOVES_BLACK[from] = getRookMoves(from, BLACK_ROOK, CASTLING_STATE | HALFMOVES);
			}
			for (int[] b : ROOK_MOVES[0])
				for (int i = 0; i < b.length; i++)
					b[i] ^= NOCASTLE_WHITEQUEEN;
			for (int[] b : ROOK_MOVES[7])
				for (int i = 0; i < b.length; i++)
					b[i] ^= NOCASTLE_WHITEKING;
			for (int[] b : ROOK_MOVES_BLACK[56])
				for (int i = 0; i < b.length; i++)
					b[i] ^= NOCASTLE_BLACKQUEEN;
			for (int[] b : ROOK_MOVES_BLACK[63])
				for (int i = 0; i < b.length; i++)
					b[i] ^= NOCASTLE_BLACKKING;
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
				BISHOP_MOVES[from] = getBishopMoves(from, BISHOP, CASTLING_STATE | HALFMOVES);
				BISHOP_MOVES_BLACK[from] = getBishopMoves(from, BLACK_BISHOP, CASTLING_STATE | HALFMOVES);
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
				QUEEN_MOVES[from] = getQueenMoves(from, QUEEN, CASTLING_STATE | HALFMOVES);
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
				KING_MOVES[from] = getKingMoves(from, KING, NOCASTLE_WHITEKING | NOCASTLE_WHITEQUEEN | HALFMOVES);
				KING_MOVES_BLACK[from] = getKingMoves(from, BLACK_KING, NOCASTLE_BLACKKING | NOCASTLE_BLACKQUEEN | HALFMOVES);
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
				PAWN_MOVES[from] = getWhitePawnMoves(from);
				PAWN_MOVES_BLACK[from] = getBlackPawnMoves(from);
				PAWN_CAPTURES[from] = getWhitePawnCaptures(from);
				PAWN_CAPTURES_BLACK[from] = getBlackPawnCaptures(from);
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
				moves.add(BITS.assemble(QUEEN, from, to, 0));
				moves.add(BITS.assemble(ROOK, from, to, 0));
				moves.add(BITS.assemble(KNIGHT, from, to, 0));
				moves.add(BITS.assemble(BISHOP, from, to, 0));
			} else {
				moves.add(BITS.assemble(PAWN, from, to, 0));
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
				moves.add(BITS.assemble(BLACK_QUEEN, from, to, 0));
				moves.add(BITS.assemble(BLACK_ROOK, from, to, 0));
				moves.add(BITS.assemble(BLACK_KNIGHT, from, to, 0));
				moves.add(BITS.assemble(BLACK_BISHOP, from, to, 0));
			} else {
				moves.add(BITS.assemble(BLACK_PAWN, from, to, 0));
			}
		}

		private static int[][] getWhitePawnMoves(int from) {
			ArrayList<int[]> moves = new ArrayList<int[]>();
			int to = from + 8;
			if (to >= 56 && to < 64) {
				moves.add(new int[] { BITS.assemble(QUEEN, from, to, SPECIAL), BITS.assemble(ROOK, from, to, SPECIAL),
						BITS.assemble(KNIGHT, from, to, SPECIAL), BITS.assemble(BISHOP, from, to, SPECIAL) });
			} else if (from >= 8 && from < 16) {
				moves.add(new int[] { BITS.assemble(PAWN, from, to, 0), BITS.assemble(PAWN, from, to + 8, 0) });
			} else {
				moves.add(new int[] { BITS.assemble(PAWN, from, to, 0) });
			}
			return toArray2(moves);
		}

		private static int[][] getBlackPawnMoves(int from) {
			ArrayList<int[]> moves = new ArrayList<int[]>();
			int to = from - 8;
			if (to >= 0 && to < 8) {
				moves.add(new int[] { BITS.assemble(BLACK_QUEEN, from, to, SPECIAL), BITS.assemble(BLACK_ROOK, from, to, SPECIAL),
						BITS.assemble(BLACK_KNIGHT, from, to, SPECIAL), BITS.assemble(BLACK_BISHOP, from, to, SPECIAL) });
			} else if (from >= 48 && from < 56) {
				moves.add(new int[] { BITS.assemble(BLACK_PAWN, from, to, 0), BITS.assemble(BLACK_PAWN, from, to - 8, 0) });
			} else {
				moves.add(new int[] { BITS.assemble(BLACK_PAWN, from, to, 0) });
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

		static boolean add(ArrayList<Integer> moves, int piece, int from, int offset, int mask, int from2) {
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
		 * @param ROOK_MOVES
		 * @param board
		 */
		static void slide(ArrayList<int[]> main, int from, int offset, int piece, int mark) {
			ArrayList<Integer> moves = new ArrayList<Integer>();
			for (int slidefrom = from; add(moves, piece, slidefrom, offset, mark, from); slidefrom += offset)
				;
			int[] mv = toArray(moves);
			if (mv.length > 0)
				main.add(mv);
		}
	}

}

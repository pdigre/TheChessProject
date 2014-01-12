package no.pdigre.chess.engine.base;

import java.util.ArrayList;

public interface IBase {

	int[][] PAWN_MOVES = new int[64][];
	int[][] PAWN_MOVES_BLACK = new int[64][];
	int[][] PAWN_CAPTURES = new int[64][];
	int[][] PAWN_CAPTURES_BLACK = new int[64][];
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

	BASE base=new BASE();
	class BASE {
		final public static int LEFT = -1;

		final public static int RIGHT = 1;

		final public static int UP = 8;

		final public static int DOWN = -8;

		static {
			for (int from = 0; from < 64; from++) {
				KNIGHT_MOVES[from] = getKnightMoves(from,IConst.KNIGHT);
				KNIGHT_MOVES_BLACK[from] = getKnightMoves(from,IConst.BLACK_KNIGHT);
			}
		}

		private static int[] getKnightMoves(int from,int piece) {
			ArrayList<Integer> moves = new ArrayList<Integer>();
			add(moves, piece, from, UP + LEFT + LEFT, 0);
			add(moves, piece, from, UP + UP + LEFT, 0);
			add(moves, piece, from, UP + RIGHT + RIGHT, 0);
			add(moves, piece, from, UP + UP + RIGHT, 0);
			add(moves, piece, from, DOWN + LEFT + LEFT, 0);
			add(moves, piece, from, DOWN + DOWN + LEFT, 0);
			add(moves, piece, from, DOWN + RIGHT + RIGHT, 0);
			add(moves, piece, from, DOWN + DOWN + RIGHT, 0);
			return toArray(moves);
		}

		static {
			for (int from = 0; from < 64; from++) {
				ROOK_MOVES[from] = getRookMoves(from,IConst.ROOK,IConst.CASTLING_STATE);
				ROOK_MOVES_BLACK[from] = getRookMoves(from,IConst.BLACK_ROOK,IConst.CASTLING_STATE);
			}
			for (int[] b : ROOK_MOVES[0])
				for (int i = 0; i < b.length; i++)
					b[i]^=IConst.NOCASTLE_WHITEQUEEN;
			for (int[] b : ROOK_MOVES[7])
				for (int i = 0; i < b.length; i++)
					b[i]^=IConst.NOCASTLE_WHITEKING;
			for (int[] b : ROOK_MOVES_BLACK[56])
				for (int i = 0; i < b.length; i++)
					b[i]^=IConst.NOCASTLE_BLACKQUEEN;
			for (int[] b : ROOK_MOVES_BLACK[63])
				for (int i = 0; i < b.length; i++)
					b[i]^=IConst.NOCASTLE_BLACKKING;
		}

		private static int[][] getRookMoves(int from,int piece,int mask) {
			ArrayList<int[]> slide = new ArrayList<int[]>();
			slide(slide, from, UP, piece, mask);
			slide(slide, from, DOWN, piece, mask);
			slide(slide, from, LEFT, piece, mask);
			slide(slide, from, RIGHT, piece, mask);
			return toArray2(slide);
		}

		static {
			for (int from = 0; from < 64; from++) {
				BISHOP_MOVES[from] = getBishopMoves(from,IConst.BISHOP);
				BISHOP_MOVES_BLACK[from] = getBishopMoves(from,IConst.BLACK_BISHOP);
			}
		}

		private static int[][] getBishopMoves(int from,int piece) {
			ArrayList<int[]> slide = new ArrayList<int[]>();
			slide(slide, from, UP + LEFT, piece, 0);
			slide(slide, from, UP + RIGHT, piece, 0);
			slide(slide, from, DOWN + LEFT, piece, 0);
			slide(slide, from, DOWN + RIGHT, piece, 0);
			return toArray2(slide);
		}

		static {
			for (int from = 0; from < 64; from++) {
				QUEEN_MOVES[from] = getQueenMoves(from,IConst.QUEEN);
				QUEEN_MOVES_BLACK[from] = getQueenMoves(from,IConst.BLACK_QUEEN);
			}
		}

		private static int[][] getQueenMoves(int from,int piece) {
			ArrayList<int[]> slide = new ArrayList<int[]>();
			slide(slide, from, UP, piece, 0);
			slide(slide, from, DOWN, piece, 0);
			slide(slide, from, LEFT, piece, 0);
			slide(slide, from, RIGHT, piece, 0);
			slide(slide, from, UP + LEFT, piece, 0);
			slide(slide, from, UP + RIGHT, piece, 0);
			slide(slide, from, DOWN + LEFT, piece, 0);
			slide(slide, from, DOWN + RIGHT, piece, 0);
			return toArray2(slide);
		}

		static {
			for (int from = 0; from < 64; from++) {
				KING_MOVES[from] = getKingMoves(from,IConst.KING,IConst.NOCASTLE_WHITEKING|IConst.NOCASTLE_WHITEQUEEN);
				KING_MOVES_BLACK[from] = getKingMoves(from,IConst.BLACK_KING,IConst.NOCASTLE_BLACKKING|IConst.NOCASTLE_BLACKQUEEN);
			}
		}

		private static int[] getKingMoves(int from,int piece,int mask) {
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
		 * @param piece TODO
		 * @param offset
		 * @param bitmap TODO
		 * @param pieces
		 * @return
		 */
		static boolean add(ArrayList<Integer> moves, int piece, int from, int offset, int mask) {
			int to = from + offset;
			boolean has = inside(to, from);
			if (has) {
				int bitmap = (piece<<IConst._PIECE)|(from<<IConst._FROM)|(to<<IConst._TO);
				moves.add(bitmap);
			}
			return has;
		}

		static boolean add(ArrayList<Integer> moves, int piece, int from, int offset, int mask, int from2) {
			int to = from + offset;
			boolean has = inside(to, from);
			if (has) {
				int bitmap = (piece<<IConst._PIECE)|(from2<<IConst._FROM)|(to<<IConst._TO);
				moves.add(bitmap);
			}
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
		 * @param from
		 * @param offset
		 * @param piece TODO
		 * @param mark TODO
		 * @param ROOK_MOVES
		 * @param board
		 */
		static void slide(ArrayList<int[]> main, int from, int offset, int piece, int mark) {
			ArrayList<Integer> moves = new ArrayList<Integer>();
			for (int slidefrom = from; add(moves, piece, slidefrom, offset,mark, from); slidefrom += offset) {
				// not
			}
			int[] mv = toArray(moves);
			if (mv.length > 0)
				main.add(mv);
		}
	}
}

package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.IConst;

public abstract interface IPosition extends IConst {

	public abstract boolean whiteNext();

	public abstract int getPiece(int square);

	public abstract int[] getBoard();

	/**
	 * Returns the castling and halfmoves state
	 * 
	 * @return
	 */
	public abstract int getBitmap();

	/**
	 * Returns a new IPosition based on current
	 * 
	 * @param bitmap
	 * @return
	 */
	public IPosition move(int bitmap);

	class BOARD88 {
		final static public int[] apply(final int[] in, final int bitmap) {
			int[] out = in.clone();
			int from = BITS.getFrom(bitmap);
			out[from] = 0;
			int to = BITS.getTo(bitmap);
			out[to] = bitmap & PIECE;
			if (BITS.isCastling(bitmap)) {
				if (from > to) {
					out[from - 4] = 0;
					out[from - 1] = in[from - 4];
				} else {
					out[from + 3] = 0;
					out[from + 1] = in[from + 3];
				}
			} else if (BITS.isEnpassant(bitmap)) {
				out[to + (to > from ? -8 : 8)] = 0;
			}
			return out;
		}

	}
}

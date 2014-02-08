package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.IConst;

public abstract interface IPosition extends IConst {

	public abstract boolean whiteNext();

	public abstract int getPiece(int square);

	public abstract int[] getBoard();

	int getWKpos();

	int getBKpos();

    int getScore();

    int getQuality();

	/**
	 * Returns the castling and halfmoves state
	 * 
	 * @return
	 */
	public abstract long getBitmap();

	/**
	 * Returns a new IPosition based on current
	 * 
	 * @param bitmap
	 * @return
	 */
	public IPosition move(long bitmap);

	class BOARD88 {
		final static public int getWKpos(IPosition pos){
			int kingpos=0;
			while(pos.getPiece(kingpos) != WHITE_KING)
				kingpos++;
			return kingpos;
		}

		final static public int getBKpos(IPosition pos){
			int kingpos=0;
			while(pos.getPiece(kingpos) != BLACK_KING)
				kingpos++;
			return kingpos;
		}
		
		final static public int[] apply(final int[] in, final long bitmap) {
			int[] out = in.clone();
			int from = BITS.getFrom(bitmap);
			out[from] = 0;
			int to = BITS.getTo(bitmap);
			out[to] = (int) (bitmap & PIECE);
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
	
	long getZobristKey();
}

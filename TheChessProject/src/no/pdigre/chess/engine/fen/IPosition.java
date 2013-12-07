package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.IConst;

public abstract interface IPosition extends IConst{


    public abstract boolean whiteNext();

    public abstract int[] getBoard();

    /**
     * Returns the castling and halfmoves state
     * @return
     */
    public abstract int getBitmap();

    /**
     * Returns a new IPosition based on current
     * @param bitmap
     * @return
     */
    public IPosition move(int bitmap);

    /**
     * Calculate next moves
     * @return
     */
    public abstract int[] getAllBestFirst();
}

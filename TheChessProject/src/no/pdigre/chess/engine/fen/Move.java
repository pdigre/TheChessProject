package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;

public final class Move implements IPositionWithLog {

    final private IPositionWithLog parent;

    final private int bitmap;

    public Move(final IPositionWithLog parent, final int bitmap) {
        this.parent = parent;
        this.bitmap = bitmap;
    }

    @Override
    public String toString() {
        return FEN.printMove(this);
    }

    @Override
    final public int totalMoves() {
        int i = parent.totalMoves();
        if ((getBitmap() & BLACK) != 0)
            i++;
        return i;
    }

    @Override
    final public int[] getBoard() {
        return Bitmap.apply(parent.getBoard(), getBitmap());
    }

    @Override
    final public boolean whiteNext() {
        return (getBitmap() & BLACK) != 0;
    }

    @Override
    public int getBitmap() {
        return bitmap;
    }

    @Override
    public IPosition move(int bitmap2) {
        return new Position(Bitmap.apply(getBoard(), bitmap2), bitmap2);
    }

    @Override
    public int[] getAllBestFirst() {
        return NodeUtil.getAllBestFirst(this);
    }

    @Override
    public int getPiece(int square) {
        return getBoard()[square];
    }

}

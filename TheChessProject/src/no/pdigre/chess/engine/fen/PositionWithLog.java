package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.Bitmap;

public final class PositionWithLog extends Position implements IPositionWithLog {

    final private IPositionWithLog parent;

    public PositionWithLog(final IPositionWithLog parent, final int bitmap) {
        super(Bitmap.apply(parent.getBoard(), bitmap), bitmap);
        this.parent = parent;
    }

    @Override
    final public int totalMoves() {
        int i = parent.totalMoves();
        if ((getBitmap() & BLACK) != 0)
            i++;
        return i;
    }

    @Override
    public IPosition move(int bitmap2) {
        return new PositionWithLog(parent, bitmap2);
    }

}

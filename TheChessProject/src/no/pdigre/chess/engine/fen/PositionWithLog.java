package no.pdigre.chess.engine.fen;


public final class PositionWithLog extends Position implements IPositionWithLog {

    final private IPositionWithLog parent;

    public PositionWithLog(final IPositionWithLog parent, final int bitmap) {
        super(IPosition.BOARD88.apply(parent.getBoard(), bitmap), bitmap);
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
        return new PositionWithLog(this, bitmap2);
    }

    @Override
    public String toString() {
        return FEN.printMove(this)+"\n"+FEN.board2string(this);
    }
}

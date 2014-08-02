package no.pdigre.chess.engine.fen;


public class PositionWithLog extends Position implements IPositionWithLog {

    final private IPositionWithLog parent;

    public PositionWithLog(final IPositionWithLog parent, final long bitmap) {
    	super();
        this.parent = parent;
    }

    public PositionWithLog() {
    	super();
    	parent=null;
	}

	@Override
    public int totalMoves() {
        int i = parent.totalMoves();
        if ((getBitmap() & BLACK) != 0)
            i++;
        return i;
    }

    @Override
    public String toString() {
        return FEN.printMove(this)+"\n"+FEN.board2string(this);
    }
}

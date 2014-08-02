package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.MOVEDATA;




public class PositionNext extends Position {
    int[] parent;
    
    public PositionNext(int[] parent, long bitmap) {
        super();
        this.parent = parent;
    }
    
    @Override
    public String toString() {
        return FEN.printMove(this)+"\n"+FEN.board2string(this);
    }

	@Override
	public long getZobristKey() {
		return 0L;
	}

	@Override
	public int getScore() {
		return 0;
	}

	@Override
	public int getQuality() {
		return 0;
	}

	@Override
	public int compareTo(IPosition o) {
		return Integer.compare(getScore(), o.getScore());
	}

	@Override
	public Position move(MOVEDATA m, long castling) {
		return (Position) move(m,castling);
	}

}

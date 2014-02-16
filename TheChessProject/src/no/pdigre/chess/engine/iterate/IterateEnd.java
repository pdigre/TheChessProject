package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPosition;

public class IterateEnd implements IIterator {

    @Override
    public final int black(IPosition pos, int alpha, int beta) {
        return pos.getScore();
    }

    @Override
    public final int white(IPosition pos, int alpha, int beta) {
        return pos.getScore();
    }

    @Override
	public int getQuality() {
		return 0;
	}
}

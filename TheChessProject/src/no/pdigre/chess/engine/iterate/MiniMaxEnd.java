package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPosition;

public class MiniMaxEnd implements IIterator {

    @Override
    public final int black(IPosition pos, int total, int alpha, int beta) {
        return total;
    }

    @Override
    public final int white(IPosition pos, int total, int alpha, int beta) {
        return total;
    }
}

package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPositionScore;

public class MiniMaxEnd implements IIterator {

    @Override
    public final int black(IPositionScore pos, int total, int alpha, int beta) {
        return total;
    }

    @Override
    public final int white(IPositionScore pos, int total, int alpha, int beta) {
        return total;
    }
}

package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPositionScore;

public interface IIterator{

    final static int MAX = 32000;

    final static int MIN = -MAX;

    /**
     * Find best black score
     * 
     * @param pos
     * @param total
     * @param min= Beta for AlphaBeta
     * @param max = Alpha for AlphaBeta
     * @return
     */
    int black(IPositionScore pos, int total, int min, int max);

    /**
     * Find best white score
     * 
     * @param pos
     * @param total
     * @param min= Beta for AlphaBeta
     * @param max = Alpha for AlphaBeta
     * @return
     */
    int white(IPositionScore pos, int total, int min, int max);

}

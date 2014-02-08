package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPosition;

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
    int black(IPosition pos, int total, int min, int max);

    /**
     * Find best white score
     * 
     * @param pos
     * @param total
     * @param min= Beta for AlphaBeta
     * @param max = Alpha for AlphaBeta
     * @return
     */
    int white(IPosition pos, int total, int min, int max);

}

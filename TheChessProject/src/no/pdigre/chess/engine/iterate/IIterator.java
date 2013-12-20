package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPosition;

public interface IIterator extends IThinker{

    final static int MAX = 32000;

    final static int MIN = -MAX;

    /**
     * Find best black score
     * 
     * @param pos
     * @param total
     * @param alpha
     * @param beta
     * @return
     */
    int black(IPosition pos, int total, int alpha, int beta);

    /**
     * Find best white score
     * 
     * @param pos
     * @param total
     * @param alpha
     * @param beta
     * @return
     */
    int white(IPosition pos, int total, int alpha, int beta);

}

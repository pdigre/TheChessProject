package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPosition;

public interface IIterator{

    final static int MAX = 32000;

    final static int MIN = -MAX;

    /**
     * MIN - Find best black score
     * 
     * @param pos
     * @param min = Alpha for AlphaBeta
     * @param max = Beta  for AlphaBeta
     * @return
     */
    int black(IPosition pos, int min, int max);

    /**
     * MAX - Find best white score
     * 
     * @param pos
     * @param min = Alpha for AlphaBeta
     * @param max = Beta for AlphaBeta
     * @return
     */
    int white(IPosition pos, int min, int max);

    int getQuality();
}

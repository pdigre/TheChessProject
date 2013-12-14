package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPosition;


public interface IThinker {

    final static int MAX=99999;
    final static int MIN=-MAX;
    int think(IPosition pos, int total, int alpha, int beta);
    IPosition getPos();
    IThinker getParent();
    void setParent(IThinker prev);
}

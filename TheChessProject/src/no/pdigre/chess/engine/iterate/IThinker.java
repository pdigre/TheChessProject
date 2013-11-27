package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPosition;


public interface IThinker {

    final static int MAX=99999;
    final static int MIN=-MAX;
    public int think(IPosition pos, int total, int alpha, int beta);
    public int getBitmap();
    public IThinker getParent();
    public void setParent(IThinker prev);
}

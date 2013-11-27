package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPosition;

public class NegaMaxEnd implements IThinker {

    public NegaMaxEnd() {
    }

    @Override
    public int think(IPosition pos, int total, int alpha, int beta) {
        return total+ pos.tacticValue();
    }

    @Override
    public int getBitmap() {
        return 0;
    }

    @Override
    public IThinker getParent() {
        return null;
    }

    @Override
    public void setParent(IThinker prev) {
        // none
    }
}

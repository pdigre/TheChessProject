package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;

public class NegaMaxEnd implements IThinker {
    private IEvaluator eval;

    public NegaMaxEnd(IEvaluator eval) {
        this.eval=eval;
    }

    @Override
    public int think(IPosition pos, int total, int alpha, int beta) {
        return total+ eval.tactical(pos);
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

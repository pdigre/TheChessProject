package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;

public class MiniMaxEnd implements IIterator {
    private IEvaluator eval;

    public MiniMaxEnd(IEvaluator eval) {
        this.eval=eval;
    }

    @Override
    public int think(IPosition pos, int total, int alpha, int beta) {
        return eval.score(pos,total);
    }

    @Override
    public IThinker getParent() {
        return null;
    }

    @Override
    public void setParent(IThinker prev) {
        // none
    }

    @Override
    public IPosition getPos() {
        return null;
    }

    @Override
    public final int black(IPosition pos, int total, int alpha, int beta) {
        return total;
    }

    @Override
    public final int white(IPosition pos, int total, int alpha, int beta) {
        return total;
    }
}

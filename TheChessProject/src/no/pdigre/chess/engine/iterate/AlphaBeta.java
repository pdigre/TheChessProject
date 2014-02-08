package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.test.util.IterateScores;

public class AlphaBeta implements IIterator {

    private IIterator next;
    private IEvaluator eval;

    private IPosition pos;

    public AlphaBeta(IIterator next,IEvaluator eval) {
        this.eval=eval;
        this.next = next;
    }

    @Override
    public String toString() {
        return FEN.board2fen(pos) + "\n" + FEN.printMove(pos);
    }

    @Override
    public int black(IPosition pos, int total, int min, int max) {
        for (IPosition n:new IterateScores(pos, eval)) {
            int score = next.white(n, n.getScore(), min, max);
            if (score <= min)
                return min;
            if (score < max)
                max = score;
        }
        return max;
    }

    @Override
    public int white(IPosition pos, int total, int min, int max) {
        for (IPosition n:new IterateScores(pos, eval)) {
            int score = next.black(n, n.getScore(), min, max);
            if (score >= max)
                return max;
            if (score > min)
                min = score;
        }
        return min;
    }
}

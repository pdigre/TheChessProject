package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPositionScore;
import no.pdigre.chess.test.util.IterateScores;

public class MiniMax implements IIterator {

    private IIterator next;

    private IPosition pos;
    
    private IEvaluator eval;

    public MiniMax(IIterator next,IEvaluator eval) {
        this.eval=eval;
        this.next = next;
    }

    @Override
    public String toString() {
        return FEN.board2fen(pos) + "\n" + FEN.printMove(pos);
    }

    @Override
    public int black(IPositionScore pos, int total, int alpha, int beta) {
        int res = IIterator.MAX;
        for (IPositionScore move : new IterateScores(pos,eval)) {
            int score = next.white(move, move.getScore(), alpha,beta);
            if (score < res)
                res = score;
        }
        return res;
    }

    @Override
    public int white(IPositionScore pos, int total, int alpha, int beta) {
        int res = IIterator.MIN;
        for (IPositionScore move : new IterateScores(pos,eval)) {
            int score = next.black(move, move.getScore(), alpha,beta);
            if (score > res)
                res = score;
        }
        return res;
    }

}

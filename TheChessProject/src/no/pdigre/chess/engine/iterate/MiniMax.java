package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.PositionScore;
import no.pdigre.chess.test.util.IterateScores;

public class MiniMax implements IIterator {

    private IIterator next;

    private IPosition pos;
    
    @Override
    public IPosition getPos() {
        return pos;
    }

    private IEvaluator eval;
    private IThinker parent;

    private int counter;

    @Override
    public void setParent(IThinker parent) {
        this.parent = parent;
    }

    public MiniMax(IIterator next,IEvaluator eval) {
        this.eval=eval;
        this.next = next;
        next.setParent(this);
    }

    @Override
    public int think(IPosition pos, int total, int alpha, int beta) {
        this.pos=pos;
        total = eval.score(pos,total);
        int max = alpha;
        for (IPosition move : new IterateScores(pos,eval)) {
            int score = -next.think(move, -total, -beta, -alpha);
            if (score > max)
                max = score;
            counter++;
        }
        return max;
    }

    @Override
    public IThinker getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return FEN.board2fen(pos) + "\n" + FEN.printMove(pos);
    }

    public void printHitrate() {
        System.out.println("Hitrate:" + counter + "/" + counter);
    }

    @Override
    public int black(IPosition pos, int total, int alpha, int beta) {
        int res = IThinker.MAX;
        for (IPosition move : new IterateScores(pos,eval)) {
            int score = next.white(move, ((PositionScore)move).getScore(), alpha,beta);
            if (score < res)
                res = score;
        }
        return res;
    }

    @Override
    public int white(IPosition pos, int total, int alpha, int beta) {
        int res = IThinker.MIN;
        for (IPosition move : new IterateScores(pos,eval)) {
            int score = next.black(move, ((PositionScore)move).getScore(), alpha,beta);
            if (score > res)
                res = score;
        }
        return res;
    }

}

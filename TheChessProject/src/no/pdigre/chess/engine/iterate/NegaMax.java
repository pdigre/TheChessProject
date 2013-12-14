package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.test.util.MovesIterator;

public class NegaMax implements IThinker {

    private IThinker next;

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

    public NegaMax(IThinker next,IEvaluator eval) {
        this.eval=eval;
        this.next = next;
        next.setParent(this);
    }

    @Override
    public int think(IPosition pos, int total, int alpha, int beta) {
        this.pos=pos;
        total += eval.tactical(pos);
        int max = alpha;
        for (IPosition move : new MovesIterator(pos)) {
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
        return FEN.board2String(pos) + "\n" + FEN.printMove(pos);
    }

    public void printHitrate() {
        System.out.println("Hitrate:" + counter + "/" + counter);
    }


}

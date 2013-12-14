package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;

public class NegaMaxCutoff implements IThinker {

    private IThinker next;

    private IThinker parent;
    private IEvaluator eval;

    private int counter;

    private int countertot;

    private IPosition pos;

    @Override
    public void setParent(IThinker parent) {
        this.parent = parent;
    }

    public NegaMaxCutoff(IThinker next,IEvaluator eval) {
        this.eval=eval;
        this.next = next;
        next.setParent(this);
    }

    @Override
    public int think(IPosition pos, int total, int alpha, int beta) {
        this.pos=pos;
        total += eval.tactical(pos);
        int[] moves = pos.getAllBestFirst();
        countertot+=moves.length;
        for (int i = 0; i < moves.length; i++) {
            int bitmap1 = moves[i];
            counter++;
            int score = -next.think(pos.move(bitmap1), -total, -beta, -alpha);
            if (score >= beta)
                return beta;
            if (score > alpha)
                alpha = score;
        }
        return alpha;
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
        System.out.println("Scanning:" + counter + "/" + countertot);
    }

    @Override
    public IPosition getPos() {
        return pos;
    }
}

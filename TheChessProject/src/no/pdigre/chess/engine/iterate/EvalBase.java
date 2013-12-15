package no.pdigre.chess.engine.iterate;

import java.util.Arrays;
import java.util.Comparator;

import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Position;

public class EvalBase implements IThinker {

    final IPosition pos;
    
    final StringBuilder sb = new StringBuilder();

    public Integer score;

    public int pass;

    @Override
    public String toString() {
        return FEN.printMove(pos) + " (" + sb.toString() + ")";
    }

    public EvalBase(int[] board, int bitmap) {
        pos=new Position(board, bitmap);
    }

    public EvalBase(IPosition pos) {
        this.pos=pos;
    }

    @Override
    public int think(IPosition pos, int total, int alpha, int beta) {
        return 0;
    }

    @Override
    public IThinker getParent() {
        return null;
    }

    @Override
    public void setParent(IThinker prev) {
        //;
    }

    public void run(NegaMax thinker) {
        score = thinker.think(pos, 0, IThinker.MIN, IThinker.MAX);
        if(sb.length()>0)
            sb.append(",");
        sb.append(score);
    }
    
    public static EvalBase[] sort(EvalBase[] all) {
        Arrays.sort(all, new Comparator<EvalBase>(){

            @Override
            public int compare(EvalBase e1, EvalBase e2) {
                return e2.score > e1.score?1:e1.score==e2.score?0:-1;
            }
            
        });
        return all;
    }

    @Override
    public IPosition getPos() {
        return pos;
    }
}

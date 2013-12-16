package no.pdigre.chess.engine.iterate;

import java.util.HashSet;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.PositionScore;
import no.pdigre.chess.test.util.IterateScores;

public class NegaMaxTransposition implements IThinker {
    private IEvaluator eval;

    public static long FROMTO_1 = 63 | (63 << 6);

    public static long FROMTO_2 = FROMTO_1 << 12;

    public static long FROMTO_3 = FROMTO_2 << 12;

    public HashSet<Long> tt;

    private IThinker next;

    private IThinker parent;

    private int total;

    private int hits;

    private int adds;

    private boolean lAdd;

    private IPosition pos;

    @Override
    public void setParent(IThinker parent) {
        this.parent = parent;
    }

    public NegaMaxTransposition(IThinker next,HashSet<Long> tt,IEvaluator eval) {
        this.eval=eval;
        this.next = next;
        this.tt=tt;
        next.setParent(this);
    }

    @Override
    public int think(IPosition pos, int aggr, int alpha, int beta) {
        this.pos=pos;
        int bitmap = pos.getBitmap();
        aggr += eval.score(pos);
        long ft1 = Bitmap.getFromTo(getParent().getPos().getBitmap());
        long ft2 = Bitmap.getFromTo(bitmap);
        long ft2x = ft2 << 12;
        long commonkey = ft1 | ft2x;
        long commontrn = ft2x | (ft1 << 24);
        IterateScores moves = new IterateScores(pos, eval);
        total += moves.size();
        for (PositionScore n : moves) {
            int bitmap1 = n.getBitmap();
            int score = 0;
            long ft3 = Bitmap.getFromTo(bitmap1);
            Long trans = ft3 | commontrn;
            if (tt.contains(trans)) {
                hits++;
                continue;
            }
            if(lAdd){
                adds++;
                Long key = commonkey | (ft3 << 24);
                tt.add(key);
            }
            score = -next.think(n, -aggr, -beta, -alpha);
            // if (score >= beta)
            // return beta;
            if (score > alpha)
                alpha = score;
        }
        return alpha;
    }

    public static String[] S1 = "1,2,3,4,5,6,7,8".split(",");

    public static String[] S2 = "A,B,C,D,E,F,G,H".split(",");

    public static String fromto(int p) {
        return (S2[p & 7]) + (S1[(p >> 3) & 7]) + (S2[(p >> 6) & 7]) + (S1[(p >> 9) & 7]);
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
        System.out.println("Scanning:" + tt.size() + "/" + total + " (hits:" + hits + ",adds:" + adds + ")");
    }

    public static NegaMaxTransposition createAndFill(IThinker tail, HashSet<Long> tt,IEvaluator eval) {
        NegaMaxTransposition nm = new NegaMaxTransposition(tail,tt,eval);
        nm.lAdd=true;
        return nm;
    }

    public static NegaMaxTransposition create(IThinker tail, HashSet<Long> tt,IEvaluator eval) {
        return new NegaMaxTransposition(tail,tt,eval);
    }

    @Override
    public IPosition getPos() {
        return pos;
    }
}

package no.pdigre.chess.engine.iterate;

import java.util.HashSet;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPositionScore;

@SuppressWarnings("unused")
public class NegaMaxTransposition implements IIterator {
    private IEvaluator eval;

    public static long FROMTO_1 = 63 | (63 << 6);

    public static long FROMTO_2 = FROMTO_1 << 12;

    public static long FROMTO_3 = FROMTO_2 << 12;

    public HashSet<Long> tt;

    private IIterator next;

    private IIterator parent;

    private int total;

    private int hits;

    private int adds;

    private boolean lAdd;

    private IPosition pos;

    public void setParent(IIterator parent) {
        this.parent = parent;
    }

    public NegaMaxTransposition(IIterator next,HashSet<Long> tt,IEvaluator eval) {
        this.eval=eval;
        this.next = next;
        this.tt=tt;
//        next.setParent(this);
    }

    /**
     * @param pos
     * @param total
     * @param alpha
     * @param beta
     * @return
     */
    public int think(IPosition pos, int total, int alpha, int beta) {
//        this.pos=pos;
//        int bitmap = pos.getBitmap();
//        total = eval.score(pos,total);
//        long ft1 = Bitmap.getFromTo(getParent().getPos().getBitmap());
//        long ft2 = Bitmap.getFromTo(bitmap);
//        long ft2x = ft2 << 12;
//        long commonkey = ft1 | ft2x;
//        long commontrn = ft2x | (ft1 << 24);
//        IterateScores moves = new IterateScores(pos, eval);
//        total += moves.size();
//        for (PositionScore n : moves) {
//            int bitmap1 = n.getBitmap();
//            int score = 0;
//            long ft3 = Bitmap.getFromTo(bitmap1);
//            Long trans = ft3 | commontrn;
//            if (tt.contains(trans)) {
//                hits++;
//                continue;
//            }
//            if(lAdd){
//                adds++;
//                Long key = commonkey | (ft3 << 24);
//                tt.add(key);
//            }
//            score = -next.white(n, -total, -beta, -alpha);
//            // if (score >= beta)
//            // return beta;
//            if (score > alpha)
//                alpha = score;
//        }
        return alpha;
    }

    public static String[] S1 = "1,2,3,4,5,6,7,8".split(",");

    public static String[] S2 = "A,B,C,D,E,F,G,H".split(",");

    public static String fromto(int p) {
        return (S2[p & 7]) + (S1[(p >> 3) & 7]) + (S2[(p >> 6) & 7]) + (S1[(p >> 9) & 7]);
    }

    public IIterator getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return FEN.board2fen(pos) + "\n" + FEN.printMove(pos);
    }

    public void printHitrate() {
        System.out.println("Scanning:" + tt.size() + "/" + total + " (hits:" + hits + ",adds:" + adds + ")");
    }

    public static NegaMaxTransposition createAndFill(IIterator tail, HashSet<Long> tt,IEvaluator eval) {
        NegaMaxTransposition nm = new NegaMaxTransposition(tail,tt,eval);
        nm.lAdd=true;
        return nm;
    }

    public static NegaMaxTransposition create(IIterator tail, HashSet<Long> tt,IEvaluator eval) {
        return new NegaMaxTransposition(tail,tt,eval);
    }

    public IPosition getPos() {
        return pos;
    }

    @Override
    public int black(IPositionScore pos, int total, int alpha, int beta) {
        return think(pos, total, alpha, beta);
    }

    @Override
    public int white(IPositionScore pos, int total, int alpha, int beta) {
        return think(pos, total, alpha, beta);
    }
}

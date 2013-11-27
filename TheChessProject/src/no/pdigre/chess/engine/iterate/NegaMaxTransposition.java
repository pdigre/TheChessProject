package no.pdigre.chess.engine.iterate;

import java.util.HashSet;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;

public class NegaMaxTransposition implements IThinker {

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

    public NegaMaxTransposition(IThinker next,HashSet<Long> tt) {
        this.next = next;
        this.tt=tt;
        next.setParent(this);
    }

    @Override
    public int think(IPosition pos, int aggr, int alpha, int beta) {
        this.pos=pos;
        int bitmap = pos.getBitmap();
        aggr += pos.tacticValue();
        long ft1 = Bitmap.getFromTo(getParent().getBitmap());
        long ft2 = Bitmap.getFromTo(bitmap);
        long ft2x = ft2 << 12;
        long commonkey = ft1 | ft2x;
        long commontrn = ft2x | (ft1 << 24);
        int[] moves = pos.getAllBestFirst();
        total += moves.length;
        for (int i = 0; i < moves.length; i++) {
            int bitmap1 = moves[i];
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
            score = -next.think(pos.move(bitmap1), -aggr, -beta, -alpha);
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
    public int getBitmap() {
        return pos.getBitmap();
    }

    @Override
    public String toString() {
        return FEN.board2String(pos.getBoard()) + "\n" + FEN.printMove(pos.getBitmap(), pos.getBoard());
    }

    public void printHitrate() {
        System.out.println("Scanning:" + tt.size() + "/" + total + " (hits:" + hits + ",adds:" + adds + ")");
    }

    public static NegaMaxTransposition createAndFill(IThinker tail, HashSet<Long> tt) {
        NegaMaxTransposition nm = new NegaMaxTransposition(tail,tt);
        nm.lAdd=true;
        return nm;
    }

    public static NegaMaxTransposition create(IThinker tail, HashSet<Long> tt) {
        return new NegaMaxTransposition(tail,tt);
    }

}

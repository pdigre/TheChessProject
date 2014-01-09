package no.pdigre.chess.test.util;

import java.util.concurrent.RecursiveTask;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;

public class CountMore extends RecursiveTask<Counter[]> {

    private static final long serialVersionUID = -3058348234963748664L;

    final protected Counter[] counters;

    final protected IPosition pos;

    public CountMore(IPosition pos, int depth) {
        this.pos = pos;
        counters = new Counter[depth];
        for (int i = 0; i < depth; i++)
            counters[i] = new Counter();
    }

    protected void count(IPosition pos) {
        counters[0].moves++;
        int bitmap = pos.getBitmap();
        if (Bitmap.isCapture(bitmap)) {
            counters[0].captures++;
            if (Bitmap.isEnpassant(bitmap))
                counters[0].enpassants++;
        } else {
            if (Bitmap.isCastling(bitmap))
                counters[0].castlings++;
        }
        if (Bitmap.isPromotion(bitmap))
            counters[0].promotions++;
        switch (NodeGen.getCheckState(pos)) {
            case IConst.CHECK:
                counters[0].checks++;
                break;
            case IConst.MATE:
                counters[0].checks++;
                counters[0].mates++;
                break;
        }
    }

    @Override
    public Counter[] compute() {
        for (IPosition next : NodeGen.children(pos)) {
            count(next);
            if (counters.length > 1)
                Counter.total(counters, new CountMore(next, counters.length - 1).compute());
        }
        return counters;
    }

}

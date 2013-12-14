package no.pdigre.chess.test.util;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Position;

public class CountForkJoinPool extends CountMore {

    private static final long serialVersionUID = -3058348904963758664L;

    public CountForkJoinPool(IPosition pos, int depth) {
        super(pos, depth);
    }

    @Override
    public Counter[] compute() {
        NodeGen pull = new NodeGen(pos);
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        ArrayList<CountMore> tasks = new ArrayList<CountMore>();
        int bitmap2 = pull.nextSafe();
        while (bitmap2 != 0) {
            count(bitmap2);
            int[] board2 = Bitmap.apply(pos.getBoard(), bitmap2);
            countMove(bitmap2, board2);
            if (counters.length > 1) {
                CountMore task = new CountMore(new Position(board2,bitmap2), counters.length - 1);
                tasks.add(task);
                pool.execute(task);
            }
            bitmap2 = pull.nextSafe();
        }
        for (CountMore task : tasks)
            Counter.total(counters, task.join());
        return counters;
    }

}

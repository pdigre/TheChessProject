package no.pdigre.chess.test.util;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.Position;

public class CountMoreParallel2 extends CountMore {

    private static final long serialVersionUID = -3058348904963758664L;

    public CountMoreParallel2(int bitmap, int depth, int[] board) {
        super(bitmap, depth, board);
    }

    @Override
    public Counter[] compute() {
        NodeGen pull = new NodeGen(new Position(board, bitmap));
        int processors = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(processors);
        ArrayList<CountMore> tasks = new ArrayList<CountMore>();
        int bitmap = pull.nextSafe();
        while (bitmap != 0) {
            count(bitmap);
            int[] board2 = Bitmap.apply(board, bitmap);
            countMove(bitmap, board2);
            if (counters.length > 1) {
                CountMore task = new CountMoreParallel(bitmap, counters.length - 1, board2);
                tasks.add(task);
                pool.execute(task);
            }
            bitmap = pull.nextSafe();
        }
        for (CountMore task : tasks)
            Counter.total(counters, task.join());
        return counters;
    }

}

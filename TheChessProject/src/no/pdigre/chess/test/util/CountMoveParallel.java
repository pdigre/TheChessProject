package no.pdigre.chess.test.util;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;

public class CountMoveParallel extends CountMove {

    private static final long serialVersionUID = -3158348904963758664L;

    public CountMoveParallel(IPosition pos, int depth) {
        super(pos, depth);
    }

    @Override
    public int[] compute() {
        int processors = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(processors);
        ArrayList<CountMove> tasks = new ArrayList<CountMove>();

        for (IPosition next : NodeGen.getLegalMoves64(pos)) {
            counters[0]++;
            if (counters.length > 1) {
                CountMove task = new CountMove(next, counters.length - 1);
                tasks.add(task);
                pool.execute(task);
            }
        }
        for (CountMove task : tasks)
            Counter.total(counters, task.join());
        return counters;
    }

}

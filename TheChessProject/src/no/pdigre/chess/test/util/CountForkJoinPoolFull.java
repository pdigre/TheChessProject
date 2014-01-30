package no.pdigre.chess.test.util;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;

public class CountForkJoinPoolFull extends CountFull {

    private static final long serialVersionUID = -3058348904963758664L;

    public CountForkJoinPoolFull(IPosition pos, int depth) {
        super(pos, depth);
    }

    @Override
    public Counter[] compute() {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        ArrayList<CountFull> tasks = new ArrayList<CountFull>();
        for (IPosition next : NodeGen.getLegalMoves64(pos)) {
            count(next);
            if (counters.length > 1) {
                CountFull task = new CountFull(next, counters.length - 1);
                tasks.add(task);
                pool.execute(task);
            }
        }
        for (CountFull task : tasks)
            PerftResults.total(counters, task.join());
        return counters;
    }

}

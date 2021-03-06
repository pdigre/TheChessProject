package no.pdigre.chess.test.util;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;

public class CountForkJoinPool2Full extends CountFull {

    private static final long serialVersionUID = -3058348904963758664L;

    public CountForkJoinPool2Full(IPosition pos, int depth) {
        super(pos, depth);
    }

    @Override
    public Counter[] compute() {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        ArrayList<CountFull> tasks = new ArrayList<CountFull>();
        for (IPosition next : NodeGen.getLegalMoves64(pos)) {
            count(next);
            if (counters.length > 1) {
                CountFull task = new CountForkJoinPoolFull(next, counters.length - 1);
                tasks.add(task);
                pool.execute(task);
            }
        }
        for (CountFull task : tasks)
        	PerftResults.total(counters, task.join());
        return counters;
    }

}

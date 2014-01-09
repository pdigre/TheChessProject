package no.pdigre.chess.test.util;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;

public class CountForkJoinPool2 extends CountMore {

    private static final long serialVersionUID = -3058348904963758664L;

    public CountForkJoinPool2(IPosition pos, int depth) {
        super(pos, depth);
    }

    @Override
    public Counter[] compute() {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        ArrayList<CountMore> tasks = new ArrayList<CountMore>();
        for (IPosition next : NodeGen.children(pos)) {
            count(next);
            if (counters.length > 1) {
                CountMore task = new CountForkJoinPool(next, counters.length - 1);
                tasks.add(task);
                pool.execute(task);
            }
        }
        for (CountMore task : tasks)
            Counter.total(counters, task.join());
        return counters;
    }

}

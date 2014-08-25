package no.pdigre.chess.test.util;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.Position;

public class CountForkJoinPoolFull extends CountFull {

    private static final long serialVersionUID = -3058348904963758664L;

    public CountForkJoinPoolFull(Position pos, int depth) {
        super(depth, pos);
    }

    @Override
    public Counter[] compute() {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        ArrayList<CountFull> tasks = new ArrayList<CountFull>();
        for (Position next : NodeGen.getLegalMoves64(pos)) {
            count(next);
            if (counters.length > 1) {
                CountFull task = new CountFull(counters.length - 1, next);
                tasks.add(task);
                pool.execute(task);
            }
        }
        for (CountFull task : tasks)
            PerftResults.total(counters, task.join());
        return counters;
    }

}

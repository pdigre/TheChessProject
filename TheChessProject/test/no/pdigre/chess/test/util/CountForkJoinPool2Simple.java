package no.pdigre.chess.test.util;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.Position;

public class CountForkJoinPool2Simple extends CountSimple {

    private static final long serialVersionUID = -3058348904963758664L;

    public CountForkJoinPool2Simple(Position pos, int depth) {
        super(pos, depth);
    }

    @Override
    public int[] compute() {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        ArrayList<CountSimple> tasks = new ArrayList<CountSimple>();
        for (Position next : NodeGen.getLegalMoves64(pos)) {
            count(next);
            if (counters.length > 1) {
            	CountSimple task = new CountForkJoinPoolSimple(next, counters.length - 1);
                tasks.add(task);
                pool.execute(task);
            }
        }
        for (CountSimple task : tasks){
        	int[] add = task.join();
            for (int i = 0; i < add.length; i++)
            	counters[i+1]+=add[i];
        }
        return counters;
    }

}

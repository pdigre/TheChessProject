package no.pdigre.chess.test.util;

import java.util.concurrent.RecursiveTask;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;

public class CountMove extends RecursiveTask<int[]> {

    private static final long serialVersionUID = -3058548234963758664L;

    final protected IPosition pos;

    final protected int[] counters;

    public CountMove(IPosition pos, int depth) {
        this.pos = pos;
        counters = new int[depth];
    }

    @Override
    protected int[] compute() {
        if (counters.length > 1) {
            for (IPosition next : NodeGen.getLegalMoves64(pos)) {
                counters[0]++;
                Counter.total(counters, new CountMove(next, counters.length - 1).compute());
            }
        }
        return counters;
    }

}

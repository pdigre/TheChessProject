package no.pdigre.chess.test.util;

import java.util.concurrent.RecursiveTask;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;

public class CountSimple extends RecursiveTask<int[]> {

    private static final long serialVersionUID = -3058348234963748664L;

    final protected IPosition pos;

	protected final int[] counters;

    public CountSimple(IPosition pos, int depth) {
        this.pos = pos;
		counters=new int[depth];
    }

    protected void count(IPosition pos) {
        counters[0]++;
    }

    @Override
    public int[] compute() {
        for (IPosition next : NodeGen.getLegalMoves64(pos)) {
            count(next);
            if (counters.length > 1){
            	int[] add=new CountSimple(next, counters.length - 1).compute();
                for (int i = 0; i < add.length; i++)
                	counters[i+1]+=add[i];
            }
        }
        return counters;
    }

}

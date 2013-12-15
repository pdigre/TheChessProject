package no.pdigre.chess.engine.iterate;

import java.util.concurrent.RecursiveTask;

import no.pdigre.chess.engine.fen.IPosition;

public class ThinkTask extends RecursiveTask<Integer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2971959747250168203L;
	final private IThinker thinker;
    private IPosition pos;
	
	public ThinkTask(IThinker thinker, IPosition pos) {
		this.thinker = thinker;
		this.pos = pos;
	}
	
	@Override
	protected Integer compute() {
		return thinker.think(pos, 0, IThinker.MIN, IThinker.MAX);
	}

}

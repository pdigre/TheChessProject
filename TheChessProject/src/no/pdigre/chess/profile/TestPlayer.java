package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.AlphaBeta;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.Quiescence;
import no.pdigre.chess.engine.iterate.QuiescenceTT;

public abstract class TestPlayer extends Player {

	public final IIterator iter;
	public final IIterator end;
	public final String label;

	public TestPlayer(String label, int depth, IIterator end) {
		this.label = label + depth;
		this.end = end;
		setTimeout(9000000);
		iter = stackIterators(depth, end);
	}

	@Override
	public void run() {
		printTestHeader();
		processUntilTimeout(iter);
		printScore(moves, label);
		if (end instanceof Quiescence)
			System.out.println("Quiescence:" + Quiescence.quiesce);
		if (end instanceof QuiescenceTT)
			System.out.println("Quiescence:" + QuiescenceTT.quiesce);
		makeMove();
	}

	public IIterator stackIterators(int depth, IIterator iter) {
		for (int i = 0; i < depth; i++)
			iter = addIterator(iter);
		return iter;
	}

	public IIterator addIterator(IIterator iter) {
		return new AlphaBeta(iter);
	}

	public String getLabel() {
		return "AlphaBeta";
	}

}

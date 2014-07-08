package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.MiniMax;
import no.pdigre.chess.engine.iterate.Quiescence;

public class P_MiniMaxQ extends TestPlayer {

    public P_MiniMaxQ(int depth) {
		super("MiniMaxQuiesce", depth,new Quiescence());
	}

    @Override
    public IIterator addIterator(IIterator iter) {
    	return new MiniMax(iter);
    }

}

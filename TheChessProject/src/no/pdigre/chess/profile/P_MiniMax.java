package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.IterateEnd;
import no.pdigre.chess.engine.iterate.MiniMax;

public class P_MiniMax extends TestPlayer {

    public P_MiniMax(int depth) {
		super("MiniMax", depth,new IterateEnd());
	}

    @Override
    public IIterator addIterator(IIterator iter) {
    	return new MiniMax(iter);
    }

}

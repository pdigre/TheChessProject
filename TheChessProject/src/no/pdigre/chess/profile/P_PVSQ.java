package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.PVS;
import no.pdigre.chess.engine.iterate.Quiescence;

public class P_PVSQ extends TestPlayer {
	
    public P_PVSQ(int depth) {
		super("PVSQuiesce", depth, new Quiescence());
	}

    @Override
    public IIterator addIterator(IIterator iter) {
    	return new PVS(0,iter);
    }
}

package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.Quiescence;

public class P_AlphaBetaQ extends TestPlayer {

	public P_AlphaBetaQ(int depth){
		super("AlphaBetaQuiesce",depth,new Quiescence());
	}

}

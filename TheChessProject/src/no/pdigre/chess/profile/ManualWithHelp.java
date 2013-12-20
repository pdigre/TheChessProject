package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.AlphaBetaOld;

public class ManualWithHelp extends Manual {

    @Override
    public void run() {
    	printFEN();
        AlphaBetaOld eval = new AlphaBetaOld(getPosition(), 5);
        bitmaps = eval.getBitmaps();
        scores = eval.getScores();
		game.updateBoard();
    }
}

package no.pdigre.chess.profile;

import no.pdigre.chess.engine.fen.Position;
import no.pdigre.chess.engine.iterate.AlphaBeta;

public class ManualWithHelp extends Manual {

    @Override
    public void run() {
    	printFEN();
        AlphaBeta eval = new AlphaBeta(new Position(getBoard(), getBitmap()), 5);
        bitmaps = eval.getBitmaps();
        scores = eval.getScores();
		game.updateBoard();
    }
}

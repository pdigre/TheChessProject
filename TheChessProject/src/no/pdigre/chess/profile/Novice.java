package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.AlphaBeta;

public class Novice extends Player {

    @Override
    public void run() {
        printFEN();
        bitmaps = new AlphaBeta(getPosition(), 5).getBitmaps();
        int bitmap = bitmaps[0];
		makeMove(bitmap);
    }
}

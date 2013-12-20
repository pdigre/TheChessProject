package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.AlphaBetaOld;

public class Novice extends Player {

    @Override
    public void run() {
        printFEN();
        bitmaps = new AlphaBetaOld(getPosition(), 5).getBitmaps();
        makeMove(game.findBest(bitmaps,scores)); 
    }

}

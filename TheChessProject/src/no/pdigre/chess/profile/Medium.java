package no.pdigre.chess.profile;

import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.iterate.AlphaBeta;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.IterateEnd;

public class Medium extends Player {

    @Override
    public String getDescription() {
        return "Medium AlphaBeta timed to 9 secs with Tactical evaluation";
    }

    @Override
    public void run() {
        int n = checkPolyglot();
        if(n>0){
            int pick = (int)(Math.random()*Math.random()*n);
            makeMove(((IPosition)moves.toArray()[pick]).getBitmap());
            return;
        }
        IIterator iter0 = new IterateEnd();
        IIterator iter1 = new AlphaBeta(iter0);
        IIterator iter2 = new AlphaBeta(iter1);
        IIterator iter3 = new AlphaBeta(iter2);
        IIterator iter4 = new AlphaBeta(iter3);

        setTimeout(9000);
        for (IPosition m : moves.getSortedArray())
            runThinker(m, moves, iter3);
        processUntilTimeout(iter4);
        makeMove(moves.first().getBitmap());
    }



}

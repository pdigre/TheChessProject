package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.AlphaBeta;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.IterateEnd;

public class P_AlphaBeta6 extends Player {

	
    @Override
    public String getDescription() {
        return "Medium AlphaBeta timed to 9 secs with Tactical evaluation";
    }

    @Override
    public void run() {
        printTestHeader();
        IIterator iter0 = new IterateEnd();
        IIterator iter1 = new AlphaBeta(iter0);
        IIterator iter2 = new AlphaBeta(iter1);
        IIterator iter3 = new AlphaBeta(iter2);
        IIterator iter4 = new AlphaBeta(iter3);
        IIterator iter5 = new AlphaBeta(iter4);
        IIterator iter6 = new AlphaBeta(iter5);
        setTimeout(60000);
        processUntilTimeout(iter6);
        printScore(moves, "PASS 6");
        makeMove();
    }
}

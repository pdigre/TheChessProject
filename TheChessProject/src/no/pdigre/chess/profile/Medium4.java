package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.AlphaBeta2;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.MiniMaxEnd;

public class Medium4 extends Player {

	
    @Override
    public String getDescription() {
        return "Medium AlphaBeta timed to 9 secs with Tactical evaluation";
    }

    @Override
    public void run() {
        printTestHeader();
        IIterator iter0 = new MiniMaxEnd();
        IIterator iter1 = new AlphaBeta2(iter0);
        IIterator iter2 = new AlphaBeta2(iter1);
        IIterator iter3 = new AlphaBeta2(iter2);
        IIterator iter4 = new AlphaBeta2(iter3);
        IIterator iter5 = new AlphaBeta2(iter4);
        IIterator iter6 = new AlphaBeta2(iter5);
        IIterator iter7 = new AlphaBeta2(iter6);
        setTimeout(60000);
        processUntilTimeout(iter7);
        printScore(moves, "PASS 7");
        makeMove();
    }
}

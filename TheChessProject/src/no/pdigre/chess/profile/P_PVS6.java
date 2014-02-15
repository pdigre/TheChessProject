package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.IterateEnd;
import no.pdigre.chess.engine.iterate.PVS;

public class P_PVS6 extends Player {

	
    @Override
    public String getDescription() {
        return "Medium AlphaBeta timed to 9 secs with Tactical evaluation";
    }

    @Override
    public void run() {
        printTestHeader();
        IIterator iter0 = new IterateEnd();
        IIterator iter1 = new PVS(0,iter0);
        IIterator iter2 = new PVS(0,iter1);
        IIterator iter3 = new PVS(0,iter2);
        IIterator iter4 = new PVS(0,iter3);
        IIterator iter5 = new PVS(0,iter4);
        IIterator iter6 = new PVS(0,iter5);
        setTimeout(60000);
        processUntilTimeout(iter4);
        printScore(moves, "PASS 5");
        makeMove();
    }
}

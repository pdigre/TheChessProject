package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.AlphaBeta;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.IterateEnd;

public class P_AlphaBeta4 extends Player {

    @Override
    public String getDescription() {
        return "Medium MiniMax timed to 30 secs with Tactical evaluation";
    }

    @Override
    public void run() {
        printTestHeader();
        IIterator iter0 = new IterateEnd();
        IIterator iter1 = new AlphaBeta(iter0);
        IIterator iter2 = new AlphaBeta(iter1);
        IIterator iter3 = new AlphaBeta(iter2);
        IIterator iter4 = new AlphaBeta(iter3);

        setTimeout(9000);
//        printScore(moves, "PASS 0");
//        for (IPosition m : moves.getSortedArray())
//            runThinker(m, moves, iter0);
//        printScore(moves, "PASS 1");
//        for (IPosition m : moves.getSortedArray())
//            runThinker(m, moves, iter1);
//        printScore(moves, "PASS 2");
//        for (IPosition m : moves.getSortedArray())
//            runThinker(m, moves, iter2);
//        printScore(moves, "PASS 3");
//        for (IPosition m : moves.getSortedArray())
//            runThinker(m, moves, iter3);
//        printScore(moves, "PASS 4");
        processUntilTimeout(iter4);
        printScore(moves, "AlphaBeta 4");
        makeMove();
    }


}

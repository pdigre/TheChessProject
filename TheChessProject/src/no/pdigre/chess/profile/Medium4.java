package no.pdigre.chess.profile;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;
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
        IIterator iter1 = new AlphaBeta2(iter0, IEvaluator.TACTICAL);
        IIterator iter2 = new AlphaBeta2(iter1, IEvaluator.TACTICAL);
        IIterator iter3 = new AlphaBeta2(iter2, IEvaluator.TACTICAL);
        IIterator iter4 = new AlphaBeta2(iter3, IEvaluator.TACTICAL);

        setTimeout(9000);
        printScore(moves, "PASS 0");
        for (IPosition m : moves.getSortedArray())
            runThinker(m, moves, iter0);
        printScore(moves, "PASS 1");
        for (IPosition m : moves.getSortedArray())
            runThinker(m, moves, iter1);
        printScore(moves, "PASS 2");
        for (IPosition m : moves.getSortedArray())
            runThinker(m, moves, iter2);
        printScore(moves, "PASS 3");
        for (IPosition m : moves.getSortedArray())
            runThinker(m, moves, iter3);
        printScore(moves, "PASS 4");
        processUntilTimeout(iter4);
        printScore(moves, "PASS 5");
        makeMove();
    }
}

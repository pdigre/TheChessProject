package no.pdigre.chess.profile;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.iterate.AlphaBeta;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.MiniMaxEnd;

public class Medium3 extends Player {

    @Override
    public String getDescription() {
        return "Medium MiniMax timed to 30 secs with Tactical evaluation";
    }

    @Override
    public void run() {
        printTestHeader();
        IIterator iter0 = new MiniMaxEnd();
        IIterator iter1 = new AlphaBeta(iter0, IEvaluator.FULL);
        IIterator iter2 = new AlphaBeta(iter1, IEvaluator.FULL);
        IIterator iter3 = new AlphaBeta(iter2, IEvaluator.FULL);
        IIterator iter4 = new AlphaBeta(iter3, IEvaluator.FULL);

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

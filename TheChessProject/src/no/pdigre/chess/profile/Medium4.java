package no.pdigre.chess.profile;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPositionScore;
import no.pdigre.chess.engine.iterate.AlphaBeta;
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
        IIterator iter1 = new AlphaBeta(iter0, IEvaluator.TACTICAL);
        IIterator iter2 = new AlphaBeta(iter1, IEvaluator.TACTICAL);
        IIterator iter3 = new AlphaBeta(iter2, IEvaluator.TACTICAL);
//        IIterator iter4 = new AlphaBeta(iter3, IEvaluator.TACTICAL);

//        setTimeout(9000);
        printScore(moves, "PASS 0");
        for (IPositionScore m : moves.getSortedArray())
            runThinker(m, moves, iter0);
        printScore(moves, "PASS 1");
        for (IPositionScore m : moves.getSortedArray())
            runThinker(m, moves, iter1);
        printScore(moves, "PASS 2");
        for (IPositionScore m : moves.getSortedArray())
            runThinker(m, moves, iter2);
        printScore(moves, "PASS 3");
        for (IPositionScore m : moves.getSortedArray())
            runThinker(m, moves, iter3);
        printScore(moves, "PASS 4");
//        processUntilTimeout(iter4);
//        printScore(moves, "PASS 5");
        makeMove();
    }
}

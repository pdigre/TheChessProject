package no.pdigre.chess.profile;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPositionScore;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.MiniMax;
import no.pdigre.chess.engine.iterate.MiniMaxEnd;
import no.pdigre.chess.test.util.IterateScores;

public class Medium2 extends Player {

    @Override
    public String getDescription() {
        return "Medium MiniMax timed to 30 secs with Tactical evaluation";
    }

    @Override
    public void run() {
        printTestHeader();
        IIterator iter0 = new MiniMaxEnd();
        IIterator iter1 = new MiniMax(iter0, IEvaluator.TACTICAL);
        IIterator iter2 = new MiniMax(iter1, IEvaluator.TACTICAL);
        IIterator iter3 = new MiniMax(iter2, IEvaluator.TACTICAL);
        IIterator iter4 = new MiniMax(iter3, IEvaluator.TACTICAL);

        setTimeout(9000);
        printScore(moves, "PASS 0");
        IterateScores copy = (IterateScores) moves.clone();
        for (IPositionScore m : copy)
            runThinker(m, moves, iter0);
        printScore(moves, "PASS 1");
        for (IPositionScore m : copy)
            runThinker(m, moves, iter1);
        printScore(moves, "PASS 2");
        for (IPositionScore m : copy)
            runThinker(m, moves, iter2);
        printScore(moves, "PASS 3");
        for (IPositionScore m : copy)
            if (state == RunState.RUNNING)
            runThinker(m, moves, iter3);
        printScore(moves, "PASS 4");
        for (IPositionScore m : copy) {
            if (state != RunState.RUNNING)
                break;
            System.out.println("Processing:"+FEN.notation(m));
            runThinker(m, moves, iter4);
        }
        printScore(moves, "PASS 5");
        makeMove(moves.first().getBitmap());
    }

}

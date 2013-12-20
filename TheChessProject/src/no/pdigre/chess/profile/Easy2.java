package no.pdigre.chess.profile;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPositionScore;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.MiniMax;
import no.pdigre.chess.engine.iterate.MiniMaxEnd;
import no.pdigre.chess.test.util.IterateScores;

public class Easy2 extends Player {

    @Override
    public String getDescription() {
        return "Easy 3 iterations MiniMax with Tactical evaluation";
    }
    
    @Override
    public void run() {
        printTestHeader();
        IIterator iter0 = new MiniMaxEnd();
        IIterator iter1 = new MiniMax(iter0, IEvaluator.TACTICAL);
        IIterator iter2 = new MiniMax(iter1, IEvaluator.TACTICAL);
        IIterator iter3 = new MiniMax(iter2, IEvaluator.TACTICAL);
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
            runThinker(m, moves, iter3);
        printScore(moves, "PASS 4");
        makeMove(moves.first().getBitmap());
    }

}

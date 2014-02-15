package no.pdigre.chess.profile;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.MiniMax;
import no.pdigre.chess.engine.iterate.MiniMaxEnd;

public class Easy2 extends Player {

    @Override
    public String getDescription() {
        return "Easy 3 iterations MiniMax with Tactical evaluation";
    }
    
    @Override
    public void run() {
        printTestHeader();
        IIterator iter0 = new MiniMaxEnd();
        IIterator iter1 = new MiniMax(iter0, IEvaluator.FULL);
        IIterator iter2 = new MiniMax(iter1, IEvaluator.FULL);
        IIterator iter3 = new MiniMax(iter2, IEvaluator.FULL);
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
        for (IPosition m : moves.getSortedArray())
            runThinker(m, moves, iter3);
//        printScore(moves, "PASS 4");
        makeMove();
    }

}

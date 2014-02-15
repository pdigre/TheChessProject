package no.pdigre.chess.profile;

import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.MiniMax;
import no.pdigre.chess.engine.iterate.IterateEnd;

public class P_MiniMax4 extends Player {

    @Override
    public String getDescription() {
        return "Medium MiniMax timed to 30 secs with Tactical evaluation";
    }

    @Override
    public void run() {
        printTestHeader();
        IIterator iter0 = new IterateEnd();
        IIterator iter1 = new MiniMax(iter0);
        IIterator iter2 = new MiniMax(iter1);
        IIterator iter3 = new MiniMax(iter2);
        IIterator iter4 = new MiniMax(iter3);

        setTimeout(90000);
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
//            if (state == RunState.RUNNING)
//            runThinker(m, moves, iter3);
//        printScore(moves, "PASS 4");
        for (IPosition m : moves.getSortedArray()) {
            if (state != RunState.RUNNING)
                break;
            System.out.println("Processing:"+FEN.notation(m));
            runThinker(m, moves, iter4);
        }
        printScore(moves, "PASS 4");
        makeMove();
    }

}

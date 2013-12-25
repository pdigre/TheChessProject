package no.pdigre.chess.profile;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPositionScore;
import no.pdigre.chess.engine.iterate.AlphaBeta;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.MiniMaxEnd;
import no.pdigre.chess.test.util.IterateScores;

public class Medium extends Player {

    @Override
    public String getDescription() {
        return "Medium AlphaBeta timed to 9 secs with Tactical evaluation";
    }

    @Override
    public void run() {
        int n = checkPolyglot();
        if(n>0){
            int pick = (int)(Math.random()*Math.random()*n);
            makeMove(((IPositionScore)moves.toArray()[pick]).getBitmap());
            return;
        }
        IIterator iter0 = new MiniMaxEnd();
        IIterator iter1 = new AlphaBeta(iter0, IEvaluator.TACTICAL);
        IIterator iter2 = new AlphaBeta(iter1, IEvaluator.TACTICAL);
        IIterator iter3 = new AlphaBeta(iter2, IEvaluator.TACTICAL);
        IIterator iter4 = new AlphaBeta(iter3, IEvaluator.TACTICAL);

        setTimeout(9000);
        for (IPositionScore m : moves.getSortedArray())
            runThinker(m, moves, iter3);
        processUntilTimeout(iter4);
        makeMove(moves.first().getBitmap());
    }



}

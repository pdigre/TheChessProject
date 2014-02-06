package no.pdigre.chess.profile;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.iterate.AlphaBeta;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.MiniMaxEnd;

public class Easy extends Player {

    @Override
    public String getDescription() {
        return "Easy 3 iterations MiniMax with Tactical evaluation";
    }
    
    @Override
    public void run() {
        IIterator iter0 = new MiniMaxEnd();
        IIterator iter1 = new AlphaBeta(iter0, IEvaluator.TACTICAL);
        IIterator iter2 = new AlphaBeta(iter1, IEvaluator.TACTICAL);
        IIterator iter3 = new AlphaBeta(iter2, IEvaluator.TACTICAL);
        processAndMove(iter3);
    }

}

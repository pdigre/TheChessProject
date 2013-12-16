package no.pdigre.chess.profile;

import java.util.HashSet;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.PositionScore;
import no.pdigre.chess.engine.iterate.IThinker;
import no.pdigre.chess.engine.iterate.NegaMax;
import no.pdigre.chess.engine.iterate.NegaMaxCutoff;
import no.pdigre.chess.engine.iterate.NegaMaxEnd;
import no.pdigre.chess.engine.iterate.NegaMaxTransposition;
import no.pdigre.chess.test.util.IterateScores;

public class Intermediate2 extends Player {

    @Override
    public void run() {
        IThinker first = new NegaMaxCutoff(new NegaMaxEnd(IEvaluator.BASIC), IEvaluator.TACTICAL);
        HashSet<Long> tt = new HashSet<Long>();
        NegaMaxTransposition nm = NegaMaxTransposition.createAndFill(first, tt, IEvaluator.TACTICAL);
        IThinker second = new NegaMax(nm, IEvaluator.TACTICAL);
        IPosition pos = getPosition();
        initRun(pos);
        IterateScores moves = new IterateScores(pos, IEvaluator.FULL);
        printScore(moves, "PASS 0");
        PositionScore[] all = moves.toArray(new PositionScore[moves.size()]);
        for (PositionScore m : all)
            runThinker(m, moves, first);
        printScore(moves, "PASS 1");
        for (PositionScore m : all)
            runThinker(m, moves, second);
        printScore(moves, "PASS 2");
        makeMove(moves.first().getBitmap());
    }


}

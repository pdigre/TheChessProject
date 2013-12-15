package no.pdigre.chess.profile;

import java.util.ArrayList;
import java.util.HashSet;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
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
		checkPolyglot();
		if (bitmaps.length > 0) {
			makeMove(bitmaps[0]);
			return;
		}
        IThinker first = new NegaMaxCutoff(new NegaMaxEnd(IEvaluator.BASIC),IEvaluator.BASIC);
        HashSet<Long> tt=new HashSet<Long>();
        NegaMaxTransposition nm = NegaMaxTransposition.createAndFill(first,tt,IEvaluator.BASIC);
        IThinker second = new NegaMax(nm,IEvaluator.BASIC);
        IPosition pos = getPosition();
        IterateScores moves = new IterateScores(pos, IEvaluator.BASIC);
        for (PositionScore m : new ArrayList<PositionScore>(moves))
            runThinker(m, moves, first);
        printScore(moves, "PASS 1");
        for (PositionScore m : new ArrayList<PositionScore>(moves))
            runThinker(m, moves, second);
        printScore(moves, "PASS 2");
        makeMove(moves.first().getBitmap());
    }

    public static void printScore(IterateScores moves, String txt) {
        System.out.println("\n**** "+txt+" ****");
        for (PositionScore m : new ArrayList<PositionScore>(moves))
            System.out.println(m.score+":"+FEN.notation(m));
    }

    public static void runThinker(PositionScore move, IterateScores moves, IThinker thinker) {
        move.score = thinker.think(move, 0, IThinker.MIN, IThinker.MAX);
        move.run++;
        moves.remove(move);
        moves.add(move);
    }


}

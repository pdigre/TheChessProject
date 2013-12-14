package no.pdigre.chess.profile;

import java.util.HashSet;

import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.iterate.Evaluator;
import no.pdigre.chess.engine.iterate.IThinker;
import no.pdigre.chess.engine.iterate.NegaMax;
import no.pdigre.chess.engine.iterate.NegaMaxCutoff;
import no.pdigre.chess.engine.iterate.NegaMaxEnd;
import no.pdigre.chess.engine.iterate.NegaMaxTransposition;

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
        int[] board = pos.getBoard();
        int[] moves = NodeUtil.getAllBestFirst(pos);
        Evaluator[] evals = new Evaluator[moves.length];
        for (int i = 0; i < moves.length; i++)
            evals[i] = new Evaluator(board, moves[i]);
        for (Evaluator eval : evals)
            eval.sync(second);
        Evaluator.sort(evals);
        for (Evaluator eval : evals)
            System.out.println(eval.toString());
        nm.printHitrate();
        
        makeMove(evals[0].getBitmap());
    }


}

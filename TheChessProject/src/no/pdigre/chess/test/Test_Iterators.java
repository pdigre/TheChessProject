package no.pdigre.chess.test;

import java.util.HashSet;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.PositionScore;
import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.engine.iterate.EvalUnit;
import no.pdigre.chess.engine.iterate.Evaluator;
import no.pdigre.chess.engine.iterate.IThinker;
import no.pdigre.chess.engine.iterate.NegaMax;
import no.pdigre.chess.engine.iterate.NegaMaxCutoff;
import no.pdigre.chess.engine.iterate.NegaMaxEnd;
import no.pdigre.chess.engine.iterate.NegaMaxTransposition;
import no.pdigre.chess.test.util.IterateScores;

import org.junit.Test;

/**
 * Count at level 3
 * Negamax  13391      - 197s
 * w/cutoff 1891/13391 - 2.5s
 * w/transp 1300/13391 - 2.1s
 * @author Per Digre
 *
 */
@SuppressWarnings("static-method")
public class Test_Iterators {

    @Test
    public void negamax_194_47() {
        String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
        NegaMaxEnd iter0 = new NegaMaxEnd(IEvaluator.BASIC);
        NegaMax iter1 = new NegaMax(iter0,IEvaluator.BASIC);
        NegaMax iter2 = new NegaMax(iter1,IEvaluator.BASIC);
        testThinker(fen, iter1, new NegaMax(iter2,IEvaluator.BASIC));
        iter2.printHitrate();
    }

    @Test
    public void negamaxCutoff_1978_750() {
        String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
        NegaMaxEnd iter0 = new NegaMaxEnd(IEvaluator.BASIC);
        NegaMaxCutoff iter1 = new NegaMaxCutoff(iter0,IEvaluator.BASIC);
        NegaMaxCutoff iter2 = new NegaMaxCutoff(iter1,IEvaluator.BASIC);
        IThinker iter3 = new NegaMaxCutoff(iter2,IEvaluator.BASIC);
        NegaMaxCutoff iter4 = new NegaMaxCutoff(iter3,IEvaluator.BASIC);
        testThinker(fen, iter3, new NegaMaxCutoff(iter4,IEvaluator.BASIC));
        iter4.printHitrate();
    }

    @Test
    public void negamaxCutoff_TT_480_110() {
        String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
        IThinker first = new NegaMaxCutoff(new NegaMaxEnd(IEvaluator.BASIC),IEvaluator.BASIC);
        HashSet<Long> tt=new HashSet<Long>();
        NegaMaxTransposition nm = NegaMaxTransposition.createAndFill(first,tt,IEvaluator.BASIC);
        testThinker2(fen, first, new NegaMax(nm,IEvaluator.BASIC));
        nm.printHitrate();
    }

    @Test
    public void evalUnit1_1321_390() {
        String fen = "rnbqkb1r/p1p2ppp/1p2pn2/3p4/3P1B2/2N5/PPPQPPPP/R3KBNR w KQkq - 2 5";
        EvalUnit top = new EvalUnit(new StartGame(fen));
        top.runFirstPass();
        top.runSecondPass(20);
        top.printScore();
    }

    @Test
    public void evalUnit2_12() {
        String fen = "8/4p3/8/3P3p/P2pK3/6P1/7b/3k4 w - - 0 1";
        EvalUnit top = new EvalUnit(new StartGame(fen));
        top.runFirstPass();
        top.runSecondPass(20);
        top.printScore();
        
    }

    public static void testThinker(String fen, IThinker first, IThinker second) {
        StartGame pos = new StartGame(fen);
        IterateScores moves = new IterateScores(pos, IEvaluator.BASIC);
        Evaluator[] evals = new Evaluator[moves.size()];
        int i=0;
        for (PositionScore next:moves)
            evals[i++] = new Evaluator(next);
        for (Evaluator eval : evals)
            eval.async(first);
        for (Evaluator eval : evals)
            eval.join();
        Evaluator.sort(evals);
        int extra = moves.size() / 3;
        for (Evaluator eval : evals) {
            if (extra-- < 0)
                break;
            eval.async(second);
        }
        for (Evaluator eval : evals)
            eval.join();
        Evaluator.sort(evals);
        for (Evaluator eval : evals)
            System.out.println(eval.toString());
    }

    /**
     * @param fen
     * @param first
     * @param second
     */
    public static void testThinker2(String fen, IThinker first, IThinker second) {
        StartGame pos = new StartGame(fen);
        IterateScores moves = new IterateScores(pos, IEvaluator.BASIC);
        Evaluator[] evals = new Evaluator[moves.size()];
        int i=0;
        for (PositionScore n:moves)
            evals[i++] = new Evaluator(n);
        for (Evaluator eval : evals)
            eval.sync(second);
        Evaluator.sort(evals);
        for (Evaluator eval : evals)
            System.out.println(eval.toString());
    }
    
    
}

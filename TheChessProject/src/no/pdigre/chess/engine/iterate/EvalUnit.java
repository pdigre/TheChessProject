package no.pdigre.chess.engine.iterate;

import java.util.HashSet;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.PositionScore;
import no.pdigre.chess.test.util.IterateScores;


public class EvalUnit{

    private final EvalBase[] evals;
    private HashSet<Long> tt = new HashSet<Long>();

    public EvalUnit(IPosition pos) {
        IterateScores moves = new IterateScores(pos, IEvaluator.BASIC);
        evals = new EvalBase[moves.size()];
        int i = 0;
        for (PositionScore n: moves)
            evals[i++] = new EvalBase(n);
    }
    
    public void calculateStrategic(){
        //
    }
    
    public void runFirstPass(){
        IIterator tail = new AlphaBeta(new MiniMaxEnd(IEvaluator.BASIC),IEvaluator.BASIC);
        NegaMaxTransposition nm = NegaMaxTransposition.createAndFill(tail,tt,IEvaluator.BASIC);
        IIterator series = new MiniMax(nm,IEvaluator.BASIC);
        for (EvalBase eval : evals){
            eval.pass=1;
            eval.run(series);
        }
        EvalBase.sort(evals);
    }

    public void runSecondPass(int cut){
        IThinker tail = new AlphaBeta(new AlphaBeta(new MiniMaxEnd(IEvaluator.BASIC),IEvaluator.BASIC),IEvaluator.BASIC);
        NegaMaxTransposition nm = NegaMaxTransposition.create(tail,tt,IEvaluator.BASIC);
        IIterator series = new MiniMax(nm,IEvaluator.BASIC);
        int part=evals.length*cut/100;
        for (EvalBase eval : evals){
            eval.pass=2;
            eval.run(series);
            if(part--==0)
                break;
        }
        EvalBase.sort(evals);
    }

    public void runSplit(int cut){
        IThinker tail = new AlphaBeta(new AlphaBeta(new MiniMaxEnd(IEvaluator.BASIC),IEvaluator.BASIC),IEvaluator.BASIC);
        NegaMaxTransposition nm = NegaMaxTransposition.create(tail,tt,IEvaluator.BASIC);
        MiniMax series = new MiniMax(nm,IEvaluator.BASIC);
        int part=evals.length*cut/100;
        for (EvalBase eval : evals){
            eval.pass=3;
            eval.run(series);
            if(part--==0)
                break;
        }
        EvalBase.sort(evals);
        nm.printHitrate();
    }

    public void printScore() {
        for (EvalBase eval : evals)
            System.out.println(eval.toString());
    }
    

}

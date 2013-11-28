package no.pdigre.chess.engine.iterate;

import java.util.HashSet;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.Position;


public class EvalUnit{

    private final EvalBase[] evals;
    private HashSet<Long> tt = new HashSet<Long>();

    public EvalUnit(Position pos) {
        int[] moves = pos.getAllBestFirst();
        evals = new EvalBase[moves.length];
        for (int i = 0; i < moves.length; i++){
            evals[i] = new EvalBase(Bitmap.apply(pos.getBoard(), moves[i]), moves[i]);
        }
    }
    
    public void calculateStrategic(){
        //
    }
    
    public void runFirstPass(){
        IThinker tail = new NegaMaxCutoff(new NegaMaxEnd(IEvaluator.BASIC),IEvaluator.BASIC);
        NegaMaxTransposition nm = NegaMaxTransposition.createAndFill(tail,tt,IEvaluator.BASIC);
        NegaMax series = new NegaMax(nm,IEvaluator.BASIC);
        for (EvalBase eval : evals){
            eval.pass=1;
            eval.run(series);
        }
        EvalBase.sort(evals);
    }

    public void runSecondPass(int cut){
        IThinker tail = new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxEnd(IEvaluator.BASIC),IEvaluator.BASIC),IEvaluator.BASIC);
        NegaMaxTransposition nm = NegaMaxTransposition.create(tail,tt,IEvaluator.BASIC);
        NegaMax series = new NegaMax(nm,IEvaluator.BASIC);
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
        IThinker tail = new NegaMaxCutoff(new NegaMaxCutoff(new NegaMaxEnd(IEvaluator.BASIC),IEvaluator.BASIC),IEvaluator.BASIC);
        NegaMaxTransposition nm = NegaMaxTransposition.create(tail,tt,IEvaluator.BASIC);
        NegaMax series = new NegaMax(nm,IEvaluator.BASIC);
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

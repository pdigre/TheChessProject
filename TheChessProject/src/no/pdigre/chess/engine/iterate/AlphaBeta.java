package no.pdigre.chess.engine.iterate;

import java.util.Arrays;
import java.util.Comparator;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.PositionScore;
import no.pdigre.chess.test.util.IterateScores;

public class AlphaBeta {

    private int[] stack;

    public MoveScore[] moves;

    public AlphaBeta(IPosition pos, int depth) {
        IterateScores legalmoves = new IterateScores(pos, IEvaluator.BASIC);
        moves = new MoveScore[legalmoves.size()];
        int i=0;
        for (PositionScore n:legalmoves)
            moves[i++] = new MoveScore(n, alphaBeta(depth, n));

        if (!pos.whiteNext()) {
            Arrays.sort(moves, new Comparator<MoveScore>() {

                @Override
                public int compare(MoveScore o1, MoveScore o2) {
                    return MoveScore.intCompare(o1.score, o2.score);
                }
            });
        } else {
            Arrays.sort(moves, new Comparator<MoveScore>() {

                @Override
                public int compare(MoveScore o1, MoveScore o2) {
                    return MoveScore.intCompare(o2.score, o1.score);
                }
            });
        }

    }

    private final int alphaBeta(int depthleft, IPosition pos) {
        stack = new int[depthleft];
        if (pos.whiteNext())
            return blackMove(-1000000, +1000000, depthleft, pos, 0);
        return whiteMove(-1000000, +1000000, depthleft, pos, 0);
    }

    private final int whiteMove(int whiteBest, int blackBest, int depthleft, IPosition pos, int score0) {
        int score1 = evalWhiteMove(pos, score0,depthleft);
        if (depthleft == 0)
            return score1;
        depthleft--;
        stack[depthleft] = pos.getBitmap();
        for(IPosition next:new IterateScores(pos,IEvaluator.BASIC)){
            int score = blackMove(whiteBest, blackBest, depthleft, next, score1);
            if (score >= blackBest)
                return blackBest; // fail hard beta-cutoff
            if (score > whiteBest)
                whiteBest = score; // alpha acts like max in MiniMax
        }
        return whiteBest;
    }

    private final int blackMove(int whiteBest, int blackBest, int depthleft, IPosition pos, int score0) {
        int score1 = evalBlackMove(pos, score0,depthleft);
        if (depthleft == 0)
            return score1;
        depthleft--;
        stack[depthleft] = pos.getBitmap();
        for(IPosition next:new IterateScores(pos,IEvaluator.BASIC)){
            int score = whiteMove(whiteBest, blackBest, depthleft, next, score1);
            if (score <= whiteBest)
                return whiteBest; // fail hard alpha-cutoff
            if (score < blackBest)
                blackBest = score; // beta acts like min in MiniMax
        }
        return blackBest;
    }

    /**
     * @param board
     * @param depthleft 
     */
    private final static int evalWhiteMove(IPosition pos, int score, int depthleft) {
        return score - IEvaluator.BASIC.tactical(pos);
    }

    /**
     * @param board
     * @param depthleft 
     */
    private final static int evalBlackMove(IPosition pos, int score, int depthleft) {
        return score + IEvaluator.BASIC.tactical(pos);
    }

    protected void printStack(IPosition pos, int capturedValue, int total, int depthleft) {
        if(capturedValue!=0){
            for (int j = stack.length-1; j >= depthleft; j--) {
                int bit = stack[j];
                System.out.print(FEN.printMove(pos.move(bit)) + " ");
            }
            System.out.println(FEN.printMove(pos) + " "+total);
        }
    }

    public int[] getBitmaps() {
        int[] ret = new int[moves.length];
        for (int i = 0; i < moves.length; i++)
            ret[i] = moves[i].pos.getBitmap();
        return ret;
    }

    public int getScore(int bitmap) {
        for (MoveScore move : moves)
            if (move.pos.getBitmap() == bitmap)
                return move.score;
        return 0;
    }

    public int[] getScores() {
        int[] ret = new int[moves.length];
        for (int i = 0; i < moves.length; i++)
            ret[i] = moves[i].score;
        return ret;
    }

}

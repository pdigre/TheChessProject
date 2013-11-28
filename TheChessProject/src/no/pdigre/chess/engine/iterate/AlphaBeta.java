package no.pdigre.chess.engine.iterate;

import java.util.Arrays;
import java.util.Comparator;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Position;

public class AlphaBeta {

    private int[] stack;

    public MoveScore[] moves;

    public AlphaBeta(IPosition pos, int depth) {
        int[] legalmoves = pos.getAllBestFirst();
        moves = new MoveScore[legalmoves.length];
        for (int i = 0; i < moves.length; i++) {
            int bitmap1 = legalmoves[i];
            moves[i] = new MoveScore(new Position(pos.getBoard(), bitmap1), alphaBeta(depth, pos.getBoard(), bitmap1));
        }

        if (pos.whiteTurn()) {
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

    private final int alphaBeta(int depthleft, int[] board0, int bitmap0) {
        stack = new int[depthleft];
        if (Bitmap.white(bitmap0))
            return blackMove(-1000000, +1000000, depthleft, board0, bitmap0, 0);
        return whiteMove(-1000000, +1000000, depthleft, board0, bitmap0, 0);
    }

    private final int whiteMove(int whiteBest, int blackBest, int depthleft, int[] board0, int bitmap0, int score0) {
        int score1 = evalWhiteMove(bitmap0, board0, score0,depthleft);
        if (depthleft == 0)
            return score1;
        depthleft--;
        stack[depthleft] = bitmap0;
        int[] board = Bitmap.apply(board0, bitmap0);
        NodeGen pull = new NodeGen(board, bitmap0);
        while (true) {
            int bitmap = pull.nextUnsafe();
            if (bitmap == 0)
                break;
            int score = blackMove(whiteBest, blackBest, depthleft, board, bitmap, score1);
            if (score >= blackBest)
                return blackBest; // fail hard beta-cutoff
            if (score > whiteBest)
                whiteBest = score; // alpha acts like max in MiniMax
        }
        return whiteBest;
    }

    private final int blackMove(int whiteBest, int blackBest, int depthleft, int[] board0, int bitmap0, int score0) {
        int score1 = evalBlackMove(bitmap0, board0, score0,depthleft);
        if (depthleft == 0)
            return score1;
        depthleft--;
        stack[depthleft] = bitmap0;
        int[] board = Bitmap.apply(board0, bitmap0);
        NodeGen pull = new NodeGen(board, bitmap0);
        while (true) {
            int bitmap = pull.nextUnsafe();
            if (bitmap == 0)
                break;
            int score = whiteMove(whiteBest, blackBest, depthleft, board, bitmap, score1);
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
    private final static int evalWhiteMove(int bitmap, int[] board, int score, int depthleft) {
        int val = Bitmap.tacticValue(bitmap);
        int i = score - val;
//        printStack(bitmap,board, capturedValue, i,depthleft);
        return i;
    }

    /**
     * @param board
     * @param depthleft 
     */
    private final static int evalBlackMove(int bitmap, int[] board, int score, int depthleft) {
        int val = Bitmap.tacticValue(bitmap);
        int i = score + val;
//        printStack(bitmap,board, capturedValue, i,depthleft);
        return i;
    }

    protected void printStack(int bitmap,int[] board, int capturedValue, int total, int depthleft) {
        if(capturedValue!=0){
            for (int j = stack.length-1; j >= depthleft; j--) {
                int bit = stack[j];
                System.out.print(FEN.printMove(bit, board) + " ");
            }
            System.out.println(FEN.printMove(bitmap, board) + " "+total);
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

package no.pdigre.chess.profile;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.PositionScore;
import no.pdigre.chess.engine.iterate.IThinker;
import no.pdigre.chess.engine.polyglot.BookMove;
import no.pdigre.chess.engine.polyglot.Polyglot;
import no.pdigre.chess.engine.polyglot.ZobristKey;
import no.pdigre.chess.test.util.IterateScores;

public abstract class Player implements IPlayer {

    public static boolean debug=true;

    public Integer from = -1;

    public int[] bitmaps;

    public int[] scores;

    protected GameData game;

    public void setGameData(GameData game){
        this.game = game;
    }
    
    @Override
    public int[] getBitmaps() {
        return bitmaps;
    }

    @Override
    public int getScore(int bitmap) {
        if (scores != null && scores.length == bitmaps.length)
            for (int i = 0; i < bitmaps.length; i++)
                if (bitmap == bitmaps[i])
                    return scores[i];
        return 0;
    }

    @Override
    public ArrayList<Marking> getMarkers() {
        return new ArrayList<Marking>();
    }

    @Override
    public int clickSquare(int i) {
        return -1;
    }
    
    public void checkPolyglot() {
        IPosition pos = game.pos;
        ArrayList<BookMove> list = Polyglot.get(ZobristKey.getKey(pos));
        int[] moves = NodeUtil.getLegalMoves(pos);
        bitmaps=new int[list.size()];
        scores=new int[list.size()];
        for (int i = 0; i < bitmaps.length; i++){
            int move = list.get(i).move;
            int f1=Polyglot.getFrom(move);
            int t1=Polyglot.getTo(move);
            for (int bitmap : moves) {
                if(Bitmap.getFrom(bitmap)==f1 && Bitmap.getTo(bitmap)==t1)
                    bitmaps[i]=bitmap;
            }
            scores[i]=list.get(i).weight;
        }
    }


	protected void makeMove(int bitmap) {
		game.makeMove(bitmap);
	}

	protected void printFEN() {
		System.out.println(FEN.getFen(getPosition()));
	}

	protected IPosition getPosition(){
	    return game.pos;
	}
	
	public int findBest(int[] bitmaps) {
		return bitmaps[0];
	}

    public static void printScore(IterateScores moves, String txt) {
        if(debug){
            System.out.println("\n**** "+txt+" ****");
            for (PositionScore m : moves)
                System.out.println(m.score+":"+(m.whiteNext()?"b ":"w ")+FEN.notation(m));
        }
    }

    public static void runThinker(PositionScore move, IterateScores moves, IThinker thinker) {
        int think = thinker.think(move, 0, IThinker.MIN, IThinker.MAX);
        moves.remove(move);
        move.run++;
        move.score = think;
        moves.add(move);
    }

    public static void initRun(IPosition pos) {
        if (debug)
            System.out.println(FEN.board2string(pos));
    }

}

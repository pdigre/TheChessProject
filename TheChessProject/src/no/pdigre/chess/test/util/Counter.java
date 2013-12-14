package no.pdigre.chess.test.util;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Position;

public class Counter {

    public int moves;

    public int captures;

    public int checks;

    public int mates;

    public int castlings;

    public int enpassants;

    public int promotions;

    public Counter(){
    	
    }
    
    public void count(IPosition pos, int[] board) {
        moves++;
        int bitmap = pos.getBitmap();
        if (Bitmap.isCastling(bitmap)) {
            castlings++;
        }
        if (Bitmap.isPromotion(bitmap)) {
            promotions++;
        }
        if (Bitmap.isCapture(bitmap)) {
            captures++;
            if (Bitmap.isEnpassant(bitmap)) {
                enpassants++;
            }
        }
        int[] board1 = Bitmap.apply(board, bitmap);
        boolean white = pos.whiteNext();
        Position next = new Position(board1, bitmap);
        int kpos = NodeGen.getKingPos(next, white);
        if(!NodeGen.checkSafe(board1, kpos, white)){
            checks++;
            if(!(new NodeGen(next).nextSafe()!=0))
                mates++;
        }
    }

	private void add(Counter count) {
        captures += count.captures;
        castlings += count.castlings;
        checks += count.checks;
        enpassants += count.enpassants;
        mates += count.mates;
        moves += count.moves;
        promotions += count.promotions;
	}

    public static void total(Counter[] total, Counter[] add) {
        for (int i = 0; i < add.length; i++)
            total[i+1].add(add[i]);
    }

    public static void total(int[] total, int[] add) {
        for (int i = 0; i < add.length; i++)
            total[i+1]+=add[i];
    }

}
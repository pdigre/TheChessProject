package no.pdigre.chess.test.util;

import java.util.concurrent.RecursiveTask;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Position;

public class CountMore extends RecursiveTask<Counter[]>{

    private static final long serialVersionUID = -3058348234963748664L;

    final protected Counter[] counters;
//    protected int bitmap;
//    protected int[] board;
    final protected IPosition pos;
    

	public CountMore(IPosition pos, int depth) {
	    this.pos=pos;
        counters = new Counter[depth];
        for (int i = 0; i < depth; i++)
            counters[i] = new Counter();
    }

	protected void countMove(int bitmap, int[] board) {
	    counters[0].moves++;
        boolean white = Bitmap.white(bitmap);
        Position next = new Position(board, bitmap & (IConst.CASTLING_STATE | IConst.HALFMOVES));
        if (!NodeGen.checkSafe(board, NodeGen.getKingPos(next, white), white)) {
            counters[0].checks++;
            if (!(new NodeGen(next).nextSafe()!=0))
                counters[0].mates++;
        }
	}

	public void count(int bitmap) {
        if(Bitmap.isCapture(bitmap)){
            counters[0].captures++;
            if(Bitmap.isEnpassant(bitmap))
                counters[0].enpassants++;
        } else {
            if(Bitmap.isCastling(bitmap))
                counters[0].castlings++;
        }
        if(Bitmap.isPromotion(bitmap))
            counters[0].promotions++;
    }

	@Override
    public Counter[] compute() {
        NodeGen pull = new NodeGen(pos);
        int bitmap=pull.nextSafe();
        while(bitmap!=0){
            int[] board2 = Bitmap.apply(pos.getBoard(), bitmap);
            count(bitmap);
            countMove(bitmap, board2);
			if (counters.length>1)
			    Counter.total(counters, new CountMore(new Position(board2,bitmap), counters.length-1).compute());
            bitmap=pull.nextSafe();
        }
        return counters;
	}

}

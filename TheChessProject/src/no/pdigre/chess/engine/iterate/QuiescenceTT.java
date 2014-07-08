package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Position64;

public class QuiescenceTT implements IIterator {

	public static long quiesce=0;
	
    @Override
    public String toString() {
        return "Quiescence";
    }

	@Override
	public int white(IPosition pos, int alpha, int beta) {
		long time1=System.currentTimeMillis();
		int score = qwhite((Position64) pos, alpha, beta);
		quiesce+=System.currentTimeMillis()-time1;
		return score;
//		return Math.min(score,pos.getScore());
	}

	@Override
	public int black(IPosition pos, int alpha, int beta) {
		long time1=System.currentTimeMillis();
		int score = qblack((Position64) pos, alpha, beta);
		quiesce+=System.currentTimeMillis()-time1;
		return score;
//		return Math.max(score,pos.getScore());
	}

	private static int qwhite(Position64 pos, int alpha, int beta) {
		Position64[] moves = NodeGen.getQuiescence64(pos);
		if(moves.length==0)
			return pos.getScore();
		for (int i = moves.length - 1; i >= 0; i--) {
			Position64 next = moves[i];
			IPosition tt = Transposition.find(next, 0);
			int score=0;
			if(tt!=null){
				score=tt.getScore();
			} else {
				score = qblack(next, alpha, beta);
				next.score=score;
				Transposition.register(next);
			}
			if (score >= beta)
				return beta;
			if (score > alpha)
				alpha = score;
		}
		return alpha;
	}
	
	private static int qblack(Position64 pos, int alpha, int beta) {
		Position64[] moves = NodeGen.getQuiescence64(pos);
		if(moves.length==0)
			return pos.getScore();
		for (int i = 0; i < moves.length; i++) {
			Position64 next = moves[i];
			IPosition tt = Transposition.find(next, 0);
			int score=0;
			if(tt!=null){
				score=tt.getScore();
			} else {
				score = qwhite(next, alpha, beta);
				next.score=score;
				Transposition.register(next);
			}
			if (score <= alpha)
				return alpha;
			if (score < beta)
				beta = score;
		}
		return beta;
	}

	@Override
	public int getQuality() {
		return 0;
	}
}

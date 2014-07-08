package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Position64;

public class Quiescence implements IIterator {

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
	}

	@Override
	public int black(IPosition pos, int alpha, int beta) {
		long time1=System.currentTimeMillis();
		int score = qblack((Position64) pos, alpha, beta);
		quiesce+=System.currentTimeMillis()-time1;
		return score;
	}

	private static int qwhite(Position64 pos, int alpha, int beta) {
		Position64[] moves = NodeGen.getQuiescence64(pos);
		if(moves.length==0)
			return pos.getScore();
		for (int i = moves.length - 1; i >= 0; i--) {
			Position64 next = moves[i];
			int score = qblack(next, alpha, beta);
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
			int score = qwhite(next, alpha, beta);
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

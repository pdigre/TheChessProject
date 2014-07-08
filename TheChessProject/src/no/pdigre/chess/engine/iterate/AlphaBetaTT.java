package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPosition64;
import no.pdigre.chess.engine.fen.Position64;

public class AlphaBetaTT implements IIterator {

	private IIterator deeper;
	private int quality;

	public AlphaBetaTT(IIterator deeper) {
		this.deeper = deeper;
		quality = deeper.getQuality() + 1;
	}

	@Override
	public String toString() {
		return "AlphaBetaTT";
	}

	@Override
	public int white(IPosition pos, int alpha, int beta) {
		Position64[] moves = NodeGen.getLegalMoves64(pos);
		for (int i = moves.length - 1; i >= 0; i--) {
			Position64 next = moves[i];
			IPosition tt = Transposition.find(next, quality);
			int score=0;
			if(tt!=null){
				score=tt.getScore();
			} else {
				score = deeper.black(next, alpha, beta);
				next.quality=quality;
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

	@Override
	public int black(IPosition pos, int alpha, int beta) {
		Position64[] moves = NodeGen.getLegalMoves64(pos);
		for (int i = 0; i < moves.length; i++) {
			Position64 next = moves[i];
			IPosition tt = Transposition.find(next, quality);
			int score=0;
			if(tt!=null){
				score=tt.getScore();
			} else {
				score = deeper.white(next, alpha, beta);
				next.quality=quality;
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
		return quality;
	}
}

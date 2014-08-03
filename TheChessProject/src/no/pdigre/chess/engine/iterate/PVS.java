package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.Position;

public class PVS implements IIterator {

	private IIterator next;
	private Position pos;

	public PVS(int window, IIterator next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return FEN.board2fen(pos) + "\n" + FEN.printMove(pos);
	}

	@Override
	public int white(Position pos, int alpha, int beta) {
		Position[] moves = NodeGen.getLegalMoves64(pos);
		for (int i = moves.length - 1; i >= 0; i--) {
			Position n = moves[i];
			int score = next.black(n, alpha, beta);
			if (score >= beta)
				return beta;
			if (score > alpha)
				alpha = score;
		}
		return alpha;
	}

	@Override
	public int black(Position pos, int alpha, int beta) {
		Position[] moves = NodeGen.getLegalMoves64(pos);
		for (int i = 0; i < moves.length; i++) {
			Position n = moves[i];
			int score = next.white(n, alpha, beta);
			if (score <= alpha)
				return alpha;
			if (score < beta)
				beta = score;
		}
		return beta;
	}
	
	@Override
	public int getQuality() {
		return next.getQuality()+1;
	}

}

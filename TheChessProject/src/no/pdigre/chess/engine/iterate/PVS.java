package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPosition64;

public class PVS implements IIterator {

	private IIterator next;
	private IPosition pos;

	public PVS(int window, IIterator next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return FEN.board2fen(pos) + "\n" + FEN.printMove(pos);
	}

	@Override
	public int white(IPosition pos, int alpha, int beta) {
		IPosition64[] moves = NodeGen.getLegalMoves64(pos);
		for (int i = moves.length - 1; i >= 0; i--) {
			IPosition64 n = moves[i];
			int score = next.black(n, alpha, beta);
			if (score >= beta)
				return beta;
			if (score > alpha)
				alpha = score;
		}
		return alpha;
	}

	@Override
	public int black(IPosition pos, int alpha, int beta) {
		IPosition64[] moves = NodeGen.getLegalMoves64(pos);
		for (int i = 0; i < moves.length; i++) {
			IPosition64 n = moves[i];
			int score = next.white(n, alpha, beta);
			if (score <= alpha)
				return alpha;
			if (score < beta)
				beta = score;
		}
		return beta;
	}

}

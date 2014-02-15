package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPosition64;

public class AlphaBeta2 implements IIterator {

	private IIterator next;
	private IPosition pos;

	public AlphaBeta2(IIterator next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return FEN.board2fen(pos) + "\n" + FEN.printMove(pos);
	}

	@Override
	public int black(IPosition pos, int total, int min, int max) {
		IPosition64[] moves = NodeGen.getLegalMoves64(pos);
		for (int i = 0; i < moves.length; i++) {
			IPosition64 n = moves[i];
			int score = next.white(n, n.getScore(), min, max);
			if (score <= min)
				return min;
			if (score < max)
				max = score;
		}
		return max;
	}

	@Override
	public int white(IPosition pos, int total, int min, int max) {
		IPosition64[] moves = NodeGen.getLegalMoves64(pos);
		for (int i = moves.length - 1; i >= 0; i--) {
			IPosition64 n = moves[i];
			int score = next.black(n, n.getScore(), min, max);
			if (score >= max)
				return max;
			if (score > min)
				min = score;
		}
		return min;
	}
}

package no.pdigre.chess.engine.iterate;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPosition64;
import no.pdigre.chess.engine.fen.Position64;

public class AlphaBeta2 implements IIterator {

	private IIterator next;
	private IEvaluator eval;

	private IPosition pos;

	public AlphaBeta2(IIterator next, IEvaluator eval) {
		this.eval = eval;
		this.next = next;
	}

	@Override
	public String toString() {
		return FEN.board2fen(pos) + "\n" + FEN.printMove(pos);
	}

	@Override
	public int black(IPosition pos, int total, int min, int max) {
		List<IPosition64> moves = NodeGen.getLegalMoves64(pos);
		for(IPosition64 move:moves)
			((Position64)move).score=eval.score(move, total);
		Collections.sort(moves, new Comparator<IPosition64>() {

			@Override
			public int compare(IPosition64 o1, IPosition64 o2) {
				return Integer.compare(o1.getScore(), o2.getScore());
			}
		});
		for (IPosition n : moves) {
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
		List<IPosition64> moves = NodeGen.getLegalMoves64(pos);
		for(IPosition64 move:moves)
			((Position64)move).score=eval.score(move, total);
		Collections.sort(moves, new Comparator<IPosition64>() {

			@Override
			public int compare(IPosition64 o1, IPosition64 o2) {
				return Integer.compare(o1.getScore(), o2.getScore());
			}
		});
		for (IPosition n : moves) {
			int score = next.black(n, n.getScore(), min, max);
			if (score >= max)
				return max;
			if (score > min)
				min = score;
		}
		return min;
	}
}

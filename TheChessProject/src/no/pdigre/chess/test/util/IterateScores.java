package no.pdigre.chess.test.util;

import java.util.Comparator;
import java.util.TreeSet;

import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.PositionScore;

public final class IterateScores extends TreeSet<PositionScore> {

    public static class Ascending implements Comparator<PositionScore> {

        @Override
        public int compare(PositionScore in, PositionScore other) {
            if (in.score > other.score)
                return -1;
            if (in.score < other.score)
                return 1;
            return Integer.compare(in.getBitmap(), other.getBitmap());
        }
    }

    public static class Descending implements Comparator<PositionScore> {

        @Override
        public int compare(PositionScore in, PositionScore other) {
            if (in.score > other.score)
                return 1;
            if (in.score < other.score)
                return -1;
            return Integer.compare(in.getBitmap(), other.getBitmap());
        }
    }

    private static final long serialVersionUID = -6843554025281632383L;

    public IterateScores(IPosition pos, IEvaluator evaluator) {
        super(pos.whiteNext() ? new Ascending() : new Descending());
        int[] legalMoves = NodeUtil.getLegalMoves(pos);
        for (int bitmap : legalMoves) {
            PositionScore next = new PositionScore(pos.move(bitmap));
            next.score = evaluator.score(next);
            add(next);
        }
    }
}
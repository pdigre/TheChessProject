package no.pdigre.chess.test.util;

import java.util.Comparator;
import java.util.TreeSet;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPosition64;
import no.pdigre.chess.engine.fen.IPositionScore;
import no.pdigre.chess.engine.fen.PositionScore;

public final class IterateScores extends TreeSet<IPositionScore> {

    public static class Ascending implements Comparator<IPositionScore> {

        @Override
        public int compare(IPositionScore in, IPositionScore other) {
            int r1 = in.getRun();
            int r2 = other.getRun();
            if (r1 > r2)
                return -1;
            if (r1 < r2)
                return 1;
            int s1 = in.getScore();
            int s2 = other.getScore();
            if (s1 > s2)
                return -1;
            if (s1 < s2)
                return 1;
            return Integer.compare(in.getBitmap(), other.getBitmap());
        }
    }

    public static class Descending implements Comparator<IPositionScore> {

        @Override
        public int compare(IPositionScore in, IPositionScore other) {
            int r1 = in.getRun();
            int r2 = other.getRun();
            if (r1 > r2)
                return -1;
            if (r1 < r2)
                return 1;
            int s1 = in.getScore();
            int s2 = other.getScore();
            if (s1 > s2)
                return 1;
            if (s1 < s2)
                return -1;
            return Integer.compare(in.getBitmap(), other.getBitmap());
        }
    }

    private static final long serialVersionUID = -6843554025281632383L;

    public IterateScores(IPosition pos, IEvaluator evaluator) {
        super(pos.whiteNext() ? new Ascending() : new Descending());
        final int total = pos instanceof IPositionScore ? ((IPositionScore) pos).getScore() : 0;
        for (IPosition64 move64 : NodeGen.getLegalMoves64(pos)) {
            PositionScore next = new PositionScore(move64);
            next.score = evaluator.score(next, total);
            add(next);
        }
    }

    public int[] getBitmaps() {
        int[] bitmaps = new int[size()];
        int i = 0;
        for (IPositionScore score : this) {
            bitmaps[i++] = score.getBitmap();
        }
        return bitmaps;
    }

    public void improveScore(PositionScore move, int score) {
        remove(move);
        move.run++;
        move.score = score;
        add(move);
    }

    public IPositionScore[] getSortedArray() {
        return toArray(new IPositionScore[size()]);
    }

}
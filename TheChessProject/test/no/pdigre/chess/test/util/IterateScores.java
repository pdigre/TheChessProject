package no.pdigre.chess.test.util;

import java.util.Comparator;
import java.util.TreeSet;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPosition64;
import no.pdigre.chess.engine.fen.PositionScore;

public final class IterateScores extends TreeSet<IPosition> {

    public static class Ascending implements Comparator<IPosition> {

        @Override
        public int compare(IPosition in, IPosition other) {
            int r1 = in.getQuality();
            int r2 = other.getQuality();
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
            return Long.compare(in.getBitmap(), other.getBitmap());
        }
    }

    public static class Descending implements Comparator<IPosition> {

        @Override
        public int compare(IPosition in, IPosition other) {
            int r1 = in.getQuality();
            int r2 = other.getQuality();
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
            return Long.compare(in.getBitmap(), other.getBitmap());
        }
    }

    private static final long serialVersionUID = -6843554025281632383L;

    public IterateScores(IPosition pos, IEvaluator evaluator) {
        super(pos.whiteNext() ? new Ascending() : new Descending());
        final int total = pos instanceof IPosition ? ((IPosition) pos).getScore() : 0;
        for (IPosition64 move64 : NodeGen.getLegalMoves64(pos)) {
            PositionScore next = new PositionScore(move64);
            next.score = evaluator.score(next, total);
            add(next);
        }
    }

    public long[] getBitmaps() {
        long[] bitmaps = new long[size()];
        int i = 0;
        for (IPosition score : this) {
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

    public IPosition[] getSortedArray() {
        return toArray(new IPosition[size()]);
    }

}
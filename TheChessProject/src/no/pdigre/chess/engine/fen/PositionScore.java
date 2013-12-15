package no.pdigre.chess.engine.fen;

public class PositionScore extends Position implements Comparable<PositionScore> {

    public int score = 0;

    public int run = 0;

    public PositionScore(IPosition pos) {
        super(pos);
    }

    @Override
    public int compareTo(PositionScore other) {
        if(score>other.score)
            return -1;
        if(score<other.score)
            return 1;
        return Integer.compare(getBitmap(), other.getBitmap());
    }

    @Override
    public boolean equals(Object obj) {
        return getBitmap() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return getBitmap();
    }
}

package no.pdigre.chess.engine.fen;

import no.pdigre.chess.test.util.IterateScores;

public class PositionScore extends Position implements IPosition {

    public int score = 0;

    public int run = 0;

    public IterateScores children;
    
    public PositionScore(IPosition pos) {
        super(pos);
    }

    @Override
    public boolean equals(Object obj) {
        return getBitmap() == obj.hashCode();
    }

    @Override
    public int hashCode() {
        return (int) getBitmap();
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public int getQuality() {
        return run;
    }
}

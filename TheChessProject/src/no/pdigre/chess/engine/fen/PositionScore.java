package no.pdigre.chess.engine.fen;

public class PositionScore extends Position {

    public int score = 0;

    public int run = 0;

    public PositionScore(IPosition pos) {
        super(pos);
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

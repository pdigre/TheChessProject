package no.pdigre.chess.engine.fen;



public class PositionScore extends Position implements Comparable<PositionScore>{

    public int score=0;
    
    public PositionScore(IPosition pos) {
        super(pos);
    }

    @Override
    public int compareTo(PositionScore other) {
        return Integer.compare(score, other.score);
    }

}

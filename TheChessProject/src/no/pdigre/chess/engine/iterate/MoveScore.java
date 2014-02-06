package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPosition;


public class MoveScore implements Comparable<MoveScore>{
    public int score;
    public IPosition pos;
    
    public MoveScore(IPosition pos, int score) {
        super();
        this.pos=pos;
        this.score = score;
    }

    @Override
    public int compareTo(MoveScore o) {
        return intCompare(this.score, o.score);
    }

    public static int intCompare(int i1, int i2) {
        return i1 > i2?1:(i1 == i2?0:-1);
    }
    
}   

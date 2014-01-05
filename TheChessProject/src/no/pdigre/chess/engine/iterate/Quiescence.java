package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPositionScore;
import no.pdigre.chess.test.util.IterateQuiescence;

public class Quiescence implements IIterator {

    @Override
    public String toString() {
        return "Quiescence";
    }

    @Override
    public int black(IPositionScore pos, int total, int min, int max) {
        return qblack(pos,total,IIterator.MIN, IIterator.MAX);
    }

    @Override
    public int white(IPositionScore pos, int total, int min, int max) {
        return qwhite(pos,total,IIterator.MIN, IIterator.MAX);
    }
    
    public int qblack(IPositionScore pos, int total, int min, int max) {
        for (IPositionScore n:new IterateQuiescence(pos)) {
            int score = qwhite(n, total+n.getScore(), min, max);
            if (score <= min)
                return min;
            if (score < max)
                max = score;
        }
        return max;
    }

    public int qwhite(IPositionScore pos, int total, int min, int max) {
        for (IPositionScore n:new IterateQuiescence(pos)) {
            int score = qblack(n, total+n.getScore(), min, max);
            if (score >= max)
                return max;
            if (score > min)
                min = score;
        }
        return min;
    }
}

package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.test.util.IterateQuiescence;

public class Quiescence implements IIterator {

    @Override
    public String toString() {
        return "Quiescence";
    }

    @Override
    public int black(IPosition pos, int total, int min, int max) {
        return qblack(pos,total,IIterator.MIN, IIterator.MAX);
    }

    @Override
    public int white(IPosition pos, int total, int min, int max) {
        return qwhite(pos,total,IIterator.MIN, IIterator.MAX);
    }
    
    public int qblack(IPosition pos, int total, int min, int max) {
        for (IPosition n:new IterateQuiescence(pos)) {
            int score = qwhite(n, total+n.getScore(), min, max);
            if (score <= min)
                return min;
            if (score < max)
                max = score;
        }
        return max;
    }

    public int qwhite(IPosition pos, int total, int min, int max) {
        for (IPosition n:new IterateQuiescence(pos)) {
            int score = qblack(n, total+n.getScore(), min, max);
            if (score >= max)
                return max;
            if (score > min)
                min = score;
        }
        return min;
    }
}

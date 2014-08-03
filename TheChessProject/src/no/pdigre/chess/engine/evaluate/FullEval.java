package no.pdigre.chess.engine.evaluate;

import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.base.PSQT;
import no.pdigre.chess.engine.fen.Position;

public class FullEval implements IEvaluator {

    @Override
    public int score(Position pos, int total) {
        int bk = 0;
        int wk = 0;
        int pcs = 0;
        int score = 0;
        for (int i = 0; i < 64; i++) {
            int p = pos.getPiece(i);
            if (p == IConst.BK) {
                bk = i;
            } else if (p == IConst.WK) {
                wk = i;
            } else if (p > 0) {
                score += PSQT.pVal(i, p);
                pcs++;
            }
        }
        score += pcs < 15 && false? PSQT.KING[1][wk] : PSQT.KING[0][wk];
        score += pcs < 15 && false? PSQT.BKING[1][bk] : PSQT.BKING[0][bk];
        return score;
    }
}
package no.pdigre.chess.engine.evaluate;

import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.base.Piece_Square_Tables;
import no.pdigre.chess.engine.fen.IPosition;

public class FullEval implements IEvaluator {

    @Override
    public int score(IPosition pos, int total) {
        int bk = 0;
        int wk = 0;
        int pcs = 0;
        int score = 0;
        for (int i = 0; i < 64; i++) {
            int p = pos.getPiece(i);
            if (p == IConst.BLACK_KING) {
                bk = i;
            } else if (p == IConst.WHITE_KING) {
                wk = i;
            } else if (p > 0) {
                score += Piece_Square_Tables.pVal(i, p);
                pcs++;
            }
        }
        score += pcs < 15 && false? Piece_Square_Tables.WKING_END[wk] : Piece_Square_Tables.WKING_MIDDLE[wk];
        score += pcs < 15 && false? Piece_Square_Tables.BKING_END[bk] : Piece_Square_Tables.BKING_MIDDLE[bk];
        return score;
    }
}
package no.pdigre.chess.engine.evaluate;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.fen.IPosition;

public class TacticEval implements IEvaluator {

    @Override
    public int score(IPosition pos) {
            int bitmap = pos.getBitmap();
            int p = Bitmap.piece(bitmap);
            int f = Bitmap.getFrom(bitmap);
            int t = Bitmap.getTo(bitmap);
            if (p == IConst.BLACK_KING) {
                return Piece_Square_Tables.BKING_MIDDLE[t]-Piece_Square_Tables.BKING_MIDDLE[f];
            } else if (p == IConst.KING) {
                return Piece_Square_Tables.WKING_MIDDLE[t]-Piece_Square_Tables.WKING_MIDDLE[f];
            } else if (p > 0) {
                return Piece_Square_Tables.pVal(t, p)-Piece_Square_Tables.pVal(t, p);
            }
        return 0;
    }
}
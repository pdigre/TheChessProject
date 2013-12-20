package no.pdigre.chess.engine.evaluate;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.fen.IPosition;

public class TacticEval implements IEvaluator {

    @Override
    public int score(IPosition pos, int last) {
            int bitmap = pos.getBitmap();
            int p = Bitmap.piece(bitmap);
            int f = Bitmap.getFrom(bitmap);
            int t = Bitmap.getTo(bitmap);
            if(Bitmap.isCapture(bitmap))
                last+=value(Bitmap.getCapturedType(bitmap));
            if(Bitmap.isPromotion(bitmap))
                last+=promoValue(p);
                
            if (p == IConst.BLACK_KING) {
                return last+Piece_Square_Tables.BKING_MIDDLE[t]-Piece_Square_Tables.BKING_MIDDLE[f];
            } else if (p == IConst.KING) {
                return last+Piece_Square_Tables.WKING_MIDDLE[t]-Piece_Square_Tables.WKING_MIDDLE[f];
            } else if (p > 0) {
                return last+Piece_Square_Tables.pVal(t, p)-Piece_Square_Tables.pVal(t, p);
            }
        return last;
    }

    public static final int value(final int type) {
        switch (type) {
            case IConst.PAWN:
                return 100;
            case IConst.KNIGHT:
                return 320;
            case IConst.BISHOP:
                return 330;
            case IConst.ROOK:
                return 500;
            case IConst.QUEEN:
                return 900;
            case IConst.KING:
                return 20000;
            case IConst.BLACK_PAWN:
                return -100;
            case IConst.BLACK_KNIGHT:
                return -320;
            case IConst.BLACK_BISHOP:
                return -330;
            case IConst.BLACK_ROOK:
                return -500;
            case IConst.BLACK_QUEEN:
                return -900;
            case IConst.BLACK_KING:
                return -20000;
            default:
                return 0;
        }
    }
    public static final int promoValue(final int type) {
        switch (type) {
            case IConst.KNIGHT:
                return 220;
            case IConst.BISHOP:
                return 230;
            case IConst.ROOK:
                return 400;
            case IConst.QUEEN:
                return 800;
            case IConst.BLACK_KNIGHT:
                return -220;
            case IConst.BLACK_BISHOP:
                return -230;
            case IConst.BLACK_ROOK:
                return -400;
            case IConst.BLACK_QUEEN:
                return -800;
            default:
                return 0;
        }
    }
}
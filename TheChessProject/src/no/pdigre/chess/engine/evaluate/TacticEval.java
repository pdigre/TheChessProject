package no.pdigre.chess.engine.evaluate;

import no.pdigre.chess.engine.base.IConst.BITS;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.fen.IPosition;

public class TacticEval implements IEvaluator {

    @Override
    public int score(IPosition pos, int last) {
            int bitmap = pos.getBitmap();
            int p = BITS.getPiece(bitmap);
            int f = BITS.getFrom(bitmap);
            int t = BITS.getTo(bitmap);
            if(BITS.isCapture(bitmap))
                last+=value(BITS.getCapturedType(bitmap));
            if(BITS.isPromotion(bitmap))
                last+=promoValue(p);
                
            if (p == IConst.BLACK_KING) {
                return last+Piece_Square_Tables.BKING_MIDDLE[t]-Piece_Square_Tables.BKING_MIDDLE[f];
            } else if (p == IConst.WHITE_KING) {
                return last+Piece_Square_Tables.WKING_MIDDLE[t]-Piece_Square_Tables.WKING_MIDDLE[f];
            } else if (p > 0) {
                return last+Piece_Square_Tables.pVal(t, p)-Piece_Square_Tables.pVal(t, p);
            }
        return last;
    }

    public static final int value(final int type) {
        switch (type) {
            case IConst.WHITE_PAWN:
                return 100;
            case IConst.WHITE_KNIGHT:
                return 320;
            case IConst.WHITE_BISHOP:
                return 330;
            case IConst.WHITE_ROOK:
                return 500;
            case IConst.WHITE_QUEEN:
                return 900;
            case IConst.WHITE_KING:
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
            case IConst.WHITE_KNIGHT:
                return 220;
            case IConst.WHITE_BISHOP:
                return 230;
            case IConst.WHITE_ROOK:
                return 400;
            case IConst.WHITE_QUEEN:
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
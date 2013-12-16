package no.pdigre.chess.engine.evaluate;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.fen.IPosition;

public abstract interface IEvaluator {

    /**
     * Calculated gain in positional evaluation based on last move
     * 
     * @return
     */
    public abstract int score(IPosition pos);

    public final static IEvaluator BASIC = new IEvaluator() {
        public final int value(final int type) {
            switch (type) {
                case IConst.PAWN:
                    return 100;
                case IConst.KNIGHT:
                    return 300;
                case IConst.BISHOP:
                    return 325;
                case IConst.ROOK:
                    return 500;
                case IConst.QUEEN:
                    return 900;
                case IConst.KING:
                    return 100000;
                case IConst.BLACK_PAWN:
                    return -100;
                case IConst.BLACK_KNIGHT:
                    return -300;
                case IConst.BLACK_BISHOP:
                    return -325;
                case IConst.BLACK_ROOK:
                    return -500;
                case IConst.BLACK_QUEEN:
                    return -900;
                case IConst.BLACK_KING:
                    return -100000;
                default:
                    return 0;
            }
        }
        
        public final int tacticValue(int bitmap) {
            int val = value((bitmap & IConst.CAPTURE) >>> IConst._CAPTURE);
            if(Bitmap.isPromotion(bitmap))
                val+=value(Bitmap.type(bitmap));
            return val;
        }

        @Override
        public int score(IPosition pos) {
            return tacticValue(pos.getBitmap());
        }

    };

    public static IEvaluator FULL = new FullEval();
    public static IEvaluator TACTIC = new FullEval();
}

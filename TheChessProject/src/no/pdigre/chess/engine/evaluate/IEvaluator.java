package no.pdigre.chess.engine.evaluate;

import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.base.IConst.BITS;

public abstract interface IEvaluator {

    /**
     * Calculated gain in positional evaluation based on last move
     * @param total TODO
     * 
     * @return
     */
    public abstract int score(IPosition pos, int total);

    public final static IEvaluator BASIC = new IEvaluator() {
        public final int value(final int type) {
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
        
        public final int tacticValue(long bitmap) {
            int val = value(BITS.getCapturedType(bitmap));
            if(BITS.isPromotion(bitmap))
                val+=value(BITS.getType(bitmap));
            return val;
        }

        @Override
        public int score(IPosition pos, int total) {
            return tacticValue(pos.getBitmap());
        }

    };

    public static IEvaluator FULL = new FullEval();
    public static IEvaluator TACTICAL = new FullEval();
}

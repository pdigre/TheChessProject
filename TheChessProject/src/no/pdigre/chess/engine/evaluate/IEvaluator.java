package no.pdigre.chess.engine.evaluate;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.fen.IPosition;

public abstract interface IEvaluator {

    /**
     * Calculated gain in positional evaluation based on last move
     * 
     * @return
     */
    public abstract int tactical(IPosition pos);

    public static IEvaluator BASIC = new IEvaluator() {

        @Override
        public int tactical(IPosition pos) {
            return Bitmap.tacticValue(pos.getBitmap());
        }

    };

}

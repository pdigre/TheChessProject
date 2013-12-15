package no.pdigre.chess.test.util;

import java.util.TreeSet;

import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.PositionScore;

public final class IterateScores extends TreeSet<PositionScore> {

    private static final long serialVersionUID = -6843554025281632383L;

    public IterateScores(IPosition pos,IEvaluator evaluator) {
        for (int bitmap : NodeUtil.getLegalMoves(pos)) {
            PositionScore e = new PositionScore(pos.move(bitmap));
            e.score=evaluator.tactical(pos);
            add(e);
        }
    }
}
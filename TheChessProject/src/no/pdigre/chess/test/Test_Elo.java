package no.pdigre.chess.test;

import no.pdigre.chess.engine.fen.Position;
import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.engine.iterate.EvalUnit;

import org.junit.Test;


@SuppressWarnings("static-method")
public class Test_Elo {

    @Test
    public void testEvalUnit2_3() {
        String fen = "8/4p3/8/3P3p/P2pK3/6P1/7b/3k4 w - - 0 1";
        StartGame start = new StartGame(fen);
        EvalUnit top = new EvalUnit(new Position( start.getBoard(), start.getBitmap()));
        top.runFirstPass();
        top.runSecondPass(20);
        top.printScore();
    }

}

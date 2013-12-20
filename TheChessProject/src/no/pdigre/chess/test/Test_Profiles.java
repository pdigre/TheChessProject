package no.pdigre.chess.test;

import no.pdigre.chess.engine.fen.StartingGames;
import no.pdigre.chess.profile.Intermediate2;
import no.pdigre.chess.test.util.RunProfiles;

import org.junit.Test;


@SuppressWarnings("static-method")
public class Test_Profiles {

    @Test
    public void moveIntermediate_0() {
        RunProfiles.testMove(new Intermediate2(),"rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
    }

    @Test
    public void moveIntermediate_1() {
        RunProfiles.testMove(new Intermediate2(),"rnbqkbnr/pppppppp/8/8/3P4/8/PPP1PPPP/RNBQKBNR b KQkq - 1 2");
    }

    @Test
    public void moveIntermediate_2() {
        RunProfiles.testMove(new Intermediate2(),StartingGames.FEN_GAMES[2]);
    }

    @Test
    public void moveIntermediate_3() {
        RunProfiles.testMove(new Intermediate2(),"8/4p3/8/3P3p/P2pK3/6P1/7b/3k4 w - - 0 1");
    }
    
    @Test
    public void white1_Qf7_ok() {
        RunProfiles.testMove(new Intermediate2(),"5r1k/1P4pp/3P1p2/4p3/1P5P/3q2P1/Q2b2K1/B3R3 w - - 0 1");
    }
    
    @Test
    public void white1_Ka6() {
        RunProfiles.testMove(new Intermediate2(),"3B4/8/2B5/1K6/8/8/3p4/3k4 w - - 0 1");
    }
    
    @Test
    public void black1_e3() {
        RunProfiles.testMove(new Intermediate2(),"1k1r4/1pp4p/2n5/P6R/2R1p1r1/2P2p2/1PP2B1P/4K3 b - - 0 1");
    }
    
    
}

package no.pdigre.chess.test;

import no.pdigre.chess.profile.Easy2;
import no.pdigre.chess.profile.Hard;
import no.pdigre.chess.profile.Medium2;
import no.pdigre.chess.profile.Medium3;
import no.pdigre.chess.profile.Medium4;
import no.pdigre.chess.test.util.RunProfiles;

import org.junit.Test;


@SuppressWarnings("static-method")
public class Test_Profiles {

    @Test
    public void moveMed1_130() {
        RunProfiles.testMove(new Easy2(),"rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1","g4");
    }

    @Test
    public void moveMed2_230() {
        RunProfiles.testMove(new Easy2(),"rnbqkbnr/pppppppp/8/8/3P4/8/PPP1PPPP/RNBQKBNR b KQkq - 1 2","g4");
    }

    @Test
    public void moveMed3_021() {
        RunProfiles.testMove(new Easy2(),"8/4p3/8/3P3p/P2pK3/6P1/7b/3k4 w - - 0 1","g4");
    }
    
    @Test
    public void stupidity_black_1335() {
        RunProfiles.testMove(new Easy2(),"r1bqk2r/pppp1ppp/2B5/2b1P3/4n3/5N2/PPP2PPP/RNBQK2R b KQkq - 0 6","f2");
    }

    @Test
    public void white1_Ka6_17() {
        RunProfiles.testMove(new Easy2(),"3B4/8/2B5/1K6/8/8/3p4/3k4 w - - 0 1","a6");
    }
    
    @Test
    public void black1_e3_497() {
        RunProfiles.testMove(new Easy2(),"1k1r4/1pp4p/2n5/P6R/2R1p1r1/2P2p2/1PP2B1P/4K3 b - - 0 1","e3");
    }

    @Test
    public void white1_Qf7_hard() {
        RunProfiles.testMove(new Hard(),"5r1k/1P4pp/3P1p2/4p3/1P5P/3q2P1/Q2b2K1/B3R3 w - - 0 1","f7");
    }
    
    @Test
    public void white1_Qf7_minimax_9230() {
        RunProfiles.testMove(new Medium2(),"5r1k/1P4pp/3P1p2/4p3/1P5P/3q2P1/Q2b2K1/B3R3 w - - 0 1","f7");
    }
    
    @Test
    public void white1_Qf7_medium3_145() {
        RunProfiles.testMove(new Medium3(),"5r1k/1P4pp/3P1p2/4p3/1P5P/3q2P1/Q2b2K1/B3R3 w - - 0 1","f7");
    }
    
    @Test
    public void white1_Qf7_medium4_173() {
        RunProfiles.testMove(new Medium4(),"5r1k/1P4pp/3P1p2/4p3/1P5P/3q2P1/Q2b2K1/B3R3 w - - 0 1","f7");
    }
    
    @Test
    public void white1_Qf7_new_9230() {
        RunProfiles.testMove(new Medium2(),"5r1k/1P4pp/3P1p2/4p3/1P5P/3q2P1/Q2b2K1/B3R3 w - - 0 1","f7");
    }
    
}

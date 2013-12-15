package no.pdigre.chess.test;

import no.pdigre.chess.profile.Intermediate2;
import no.pdigre.chess.profile.Novice;
import no.pdigre.chess.test.util.RunProfiles;

import org.junit.Test;


@SuppressWarnings("static-method")
public class Test_Profiles {

    @Test
    public void testNovice() {
        RunProfiles.testMove(new Novice(),"8/4p3/8/3P3p/P2pK3/6P1/7b/3k4 w - - 0 1");
    }

    @Test
    public void testIntermediate2() {
        RunProfiles.testMove(new Intermediate2(),"8/4p3/8/3P3p/P2pK3/6P1/7b/3k4 w - - 0 1");
    }

}

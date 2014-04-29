package no.pdigre.chess.test;

import org.junit.Test;

public class Test_OCE extends Base_Test_OCE{
	
    @Test
    public void testOCE_1() {
    	command("setboard rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
    	command("fen");
    	command("info");
    }
	
    @Test
    public void testOCE_2() {
    	command("setboard rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
    	command("fen");
    	command("info");
    	command("divide 1");
    }
	
	
}

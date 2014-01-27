package no.pdigre.chess.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.test.util.CountForkJoinPool;
import no.pdigre.chess.test.util.CountForkJoinPool2;
import no.pdigre.chess.test.util.CountMore;
import no.pdigre.chess.test.util.Counter;
import no.pdigre.chess.test.util.FileUtils;

import org.junit.Test;

@SuppressWarnings("static-method")
public class Test_PERFT_Short {

    @Test
    public void m1_1_716() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        assertPERFT(fen, new CountMore(new StartGame(fen), 5).compute());
    }
 
    @Test
    public void m1_2_234() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        assertPERFT(fen, new CountForkJoinPool(new StartGame(fen), 5).compute());
    }

    @Test
    public void m1_3_223() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        assertPERFT(fen, new CountForkJoinPool2(new StartGame(fen), 5).compute());
    }

    @Test
    public void e_1_1637() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        assertPERFT(fen, new CountMore(new StartGame(fen), 5).compute());
    }

    @Test
    public void e_2_620() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        assertPERFT(fen, new CountForkJoinPool(new StartGame(fen), 5).compute());
    }

    @Test
    public void e_3_527() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        assertPERFT(fen, new CountForkJoinPool2(new StartGame(fen), 5).compute());
    }

    @Test
    public void m2_kiwipete_199() {
        String fen = "r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1";
        assertPERFT(fen, new CountForkJoinPool(new StartGame(fen), 4).compute());
    }
    
    @Test
    public void m3_940() {
        String fen = "8/2p5/3p4/KP5r/1R3p1k/8/4P1P1/8 w - - 0 1";
        assertPERFT(fen, new CountForkJoinPool(new StartGame(fen), 6).compute());
    }
    
    @Test
    public void m4a_955() {
        String fen = "r3k2r/Pppp1ppp/1b3nbN/nP6/BBP1P3/q4N2/Pp1P2PP/R2Q1RK1 w kq - 0 1";
        assertPERFT(fen, new CountForkJoinPool(new StartGame(fen),5).compute());
    }
    
    @Test
    public void m4b_974() {
        String fen = "r2q1rk1/pP1p2pp/Q4n2/bbp1p3/Np6/1B3NBn/pPPP1PPP/R3K2R b KQ - 0 1";
        assertPERFT(fen, new CountForkJoinPool(new StartGame(fen), 5).compute());
    }
    

    
    private void assertPERFT(String fen, Counter[] counters) {
		URL resource = this.getClass().getResource("perft.txt");
        try {
			String txt = FileUtils.stream2string((InputStream) resource.getContent());
			String prefix = "FEN="+fen;
			int i=0;
			String[] split = txt.split("\\\r\\\n");
			while(!split[++i].startsWith(prefix));
			StringBuffer sb=new StringBuffer();
			for (int j = 0; j < counters.length+2; j++)
				sb.append(split[i+j]+"\r\n");
			String cmp = sb.toString();
			String cmp2 = "FEN="+fen+"\r\n"+printCounter(counters);
			assertEquals(cmp,cmp2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


    private static String printCounter(Counter[] counters) {
    	StringBuffer sb=new StringBuffer();
        String x = "Depth,Moves,Captures,Enpassant,Castling,Promotion,Check,Mate";
        sb.append(format10(x)+"\r\n");
        for (int i = 0; i < counters.length; i++) {
            Counter cnt = counters[i];
            sb.append(format10(String.format("%d,%d,%d,%d,%d,%d,%d,%d", i + 1, cnt.moves, cnt.captures,
                cnt.enpassants, cnt.castlings, cnt.promotions, cnt.checks, cnt.mates))+"\r\n");
        }
        return sb.toString();
    }

    private static String format10(String delimited) {
        StringBuilder sb = new StringBuilder();
        for (String string : delimited.split(","))
            sb.append("          ".substring(string.length())+string);
        return sb.toString();
    }

    
	
    
    
}

package no.pdigre.chess.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import no.pdigre.chess.engine.base.IConst.BITS;
import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.PieceType;
import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.test.util.CountForkJoinPool;
import no.pdigre.chess.test.util.CountForkJoinPool2;
import no.pdigre.chess.test.util.CountMore;
import no.pdigre.chess.test.util.Counter;
import no.pdigre.chess.test.util.FileUtils;

import org.junit.Test;

@SuppressWarnings("static-method")
public class Test_MoveCount {

    private static final int MAXDEPTH = 5;

/*
     Depth     Moves  Captures Enpassant  Castling Promotion     Check      Mate
         1        20         0         0         0         0         0         0
         2       400         0         0         0         0         0         0
         3      8902        34         0         0         0        12         0
         4    197281      1576         0         0         0       469         8
         5   4865609     82719       258         0         0     27351       347
         6 119060324   2812008      5248         0         0    809099     10828
 */
    
    @Test
    public void m1_Normal_4347_795() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        Counter[] counters = new CountMore(new StartGame(fen), MAXDEPTH).compute();
        compareTo(fen, counters, "m1.txt");
    }

    @Test
    public void m1_Multi1_2190_297
    () {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        Counter[] counters = new CountForkJoinPool(new StartGame(fen), MAXDEPTH).compute();
        compareTo(fen, counters, "m1.txt");
    }

    @Test
    public void m1_Multi2_2552_291() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        Counter[] counters = new CountForkJoinPool2(new StartGame(fen), MAXDEPTH).compute();
        compareTo(fen, counters, "m1.txt");
    }

	private void compareTo(String fen, Counter[] counters, String name) {
		URL resource = this.getClass().getResource(name);
        try {
			String txt = FileUtils.stream2string((InputStream) resource.getContent());
			assertEquals(txt,"FEN="+fen+"\r\n"+printCounter(counters));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

    private static String printCounter(Counter[] counters) {
    	StringBuffer sb=new StringBuffer();
        String x = "Depth,Moves,Captures,Enpassant,Castling,Promotion,Check,Mate";
        sb.append(format10(x)+"\r\n");
        for (int i = 0; i < MAXDEPTH; i++) {
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

    /*
    Depth     Moves  Captures Enpassant  Castling Promotion     Check      Mate
        1        20         0         0         0         0         0         0
        2       400         0         0         0         0         0         0
        3      8902        34         0         0         0        12         0
        4    197281      1576         0         0         0       469         8
        5   4865609     82719       258         0         0     27351       347
        6 119060324   2812008      5248         0         0    809099     10828
*/

    @Test
    public void m2_Normal_4243_941() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        StartGame start = new StartGame(fen);
        Counter[] counters = new CountMore(start, MAXDEPTH).compute();
        compareTo(fen, counters, "m2.txt");
    }

    @Test
    public void m2_Multi1_2226_275() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        StartGame start = new StartGame(fen);
        Counter[] counters = new CountForkJoinPool(start, MAXDEPTH).compute();
        compareTo(fen, counters, "m2.txt");
    }

    @Test
    public void m2_Multi2_2552_286() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        StartGame start = new StartGame(fen);
        Counter[] counters = new CountForkJoinPool2(start, MAXDEPTH).compute();
        compareTo(fen, counters, "m2.txt");
    }

    /*
FEN=r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1
8 r...k..r
7 p.ppqpb.
6 bn..pnp.
5 ...PN...
4 .p..P...
3 ..N..Q.p
2 PPPBBPPP
1 R...K..R
  ABCDEFGH

     Depth     Moves  Captures Enpassant  Castling Promotion     Check      Mate
         1        46         8         0         2         0         0         0
         2      2039       351         1        91         0         3         0
         3     97862     17102        45      3162         0       993         1
         4   4085603    672748      1929    128013     15172     25523        43
         5 193690690  30074002     73365   4993637      8392   3309887     30171
    */
    
    @Test
    public void m3_kiwipete_11071() {
        String fen = "r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1";
        StartGame start = new StartGame(fen);
        Counter[] counters = new CountForkJoinPool2(start, MAXDEPTH).compute();
        compareTo(fen, counters, "m3.txt");
    }
    
    
}

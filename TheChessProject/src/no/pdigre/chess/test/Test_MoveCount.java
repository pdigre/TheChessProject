package no.pdigre.chess.test;

import static org.junit.Assert.assertEquals;
import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.PieceType;
import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.test.util.CountForkJoinPool;
import no.pdigre.chess.test.util.CountForkJoinPool2;
import no.pdigre.chess.test.util.CountMore;
import no.pdigre.chess.test.util.Counter;

import org.junit.Test;

@SuppressWarnings("static-method")
public class Test_MoveCount {

    private static final int MAXDEPTH = 5;

    public static String getLegalMovesFromPos(String from_txt, StartGame start) {
        int from = FEN.text2pos(from_txt);
        int type = start.getPiece(from);
        FEN.printPiece(type, from);
        StringBuffer sb = new StringBuffer();
        sb.append(PieceType.types[type].fen);
        for (int bitmap : NodeUtil.filterFrom(NodeGen.getLegalMoves(start), from)) 
            sb.append(" "+FEN.pos2string(Bitmap.getTo(bitmap)));
        return sb.toString();
    }

    @Test
    public void m1_Normal_4347_795() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        Counter[] counters = new CountMore(new StartGame(fen), MAXDEPTH).compute();
        printCounter(counters);
        assertEquals(counters[4].moves, 4865609);
        assertEquals(counters[4].captures, 82719);
        assertEquals(counters[4].enpassants, 258);
    }

    @Test
    public void m1_Multi1_2190_297
    () {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        Counter[] counters = new CountForkJoinPool(new StartGame(fen), MAXDEPTH).compute();
        printCounter(counters);
        assertEquals(counters[4].moves, 4865609);
        assertEquals(counters[4].captures, 82719);
        assertEquals(counters[4].enpassants, 258);
    }

    @Test
    public void m1_Multi2_2552_291() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        Counter[] counters = new CountForkJoinPool2(new StartGame(fen), MAXDEPTH).compute();
        printCounter(counters);
        assertEquals(counters[4].moves, 4865609);
        assertEquals(counters[4].captures, 82719);
        assertEquals(counters[4].enpassants, 258);
    }

    private static void printCounter(Counter[] counters) {
        String x = "Depth,Moves,Captures,Enpassant,Castling,Promotion,Check,Mate";
        System.out.println(format10(x));
        for (int i = 0; i < MAXDEPTH; i++) {
            Counter cnt = counters[i];
            System.out.println(format10(String.format("%d,%d,%d,%d,%d,%d,%d,%d", i + 1, cnt.moves, cnt.captures,
                cnt.enpassants, cnt.castlings, cnt.promotions, cnt.checks, cnt.mates)));
        }
    }

    private static String format10(String delimited) {
        StringBuilder sb = new StringBuilder();
        for (String string : delimited.split(","))
            sb.append("          ".substring(string.length())+string);
        return sb.toString();
    }

    @Test
    public void m2_Normal_4243_941() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        StartGame start = new StartGame(fen);
        Counter[] counters = new CountMore(start, MAXDEPTH).compute();
        printCounter(counters);
        assertEquals(counters[0].moves, 24);
        assertEquals(counters[1].moves, 496);
        assertEquals(counters[2].moves, 9483);
        assertEquals(counters[3].moves, 182838);
        assertEquals(counters[4].moves, 3605103);
    }

    @Test
    public void m2_Multi1_2226_275() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        StartGame start = new StartGame(fen);
        Counter[] counters = new CountForkJoinPool(start, MAXDEPTH).compute();
        printCounter(counters);
        assertEquals(counters[0].moves, 24);
        assertEquals(counters[1].moves, 496);
        assertEquals(counters[2].moves, 9483);
        assertEquals(counters[3].moves, 182838);
        assertEquals(counters[4].moves, 3605103);
    }

    @Test
    public void m2_Multi2_2552_286() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        StartGame start = new StartGame(fen);
        Counter[] counters = new CountForkJoinPool2(start, MAXDEPTH).compute();
        printCounter(counters);
        assertEquals(counters[0].moves, 24);
        assertEquals(counters[1].moves, 496);
        assertEquals(counters[2].moves, 9483);
        assertEquals(counters[3].moves, 182838);
        assertEquals(counters[4].moves, 3605103);
    }
}

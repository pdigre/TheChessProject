package no.pdigre.chess.test;

import static org.junit.Assert.assertEquals;
import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.PieceType;
import no.pdigre.chess.engine.fen.Position;
import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.test.util.CountMore;
import no.pdigre.chess.test.util.CountMoreParallel;
import no.pdigre.chess.test.util.CountMoreParallel2;
import no.pdigre.chess.test.util.Counter;

import org.junit.Test;

@SuppressWarnings("static-method")
public class TestBasics {

    private static final int MAXDEPTH = 5;

    public static String testAvailMoves(String from, String fen) {
        return getLegalMovesFromPos(from, new StartGame(fen));
    }

    public static String getLegalMovesFromPos(String from_txt, StartGame start) {
        int from = FEN.text2pos(from_txt);
        int[] board = start.getBoard();
        int type = board[from];
        FEN.printPiece(type, from);
        StringBuffer sb = new StringBuffer();
        sb.append(PieceType.types[type].fen);
        for (int bitmap : NodeUtil.filterFrom(NodeUtil.getAllMoves(new Position(board, start.getBitmap())), from)) {
            sb.append(" ");
            sb.append(FEN.pos2string(Bitmap.getTo(bitmap)));
        }
        return sb.toString();
    }

    @Test
    public void thinkStart1_4347_983() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        StartGame start = new StartGame(fen);
        Counter[] counters = new CountMore(start.getBitmap(), MAXDEPTH, start.getBoard()).compute();
        printCounter(counters);
        assertEquals(counters[4].moves, 4865609);
        assertEquals(counters[4].captures, 82719);
        assertEquals(counters[4].enpassants, 258);
    }

    @Test
    public void thinkStart2_2190_297
    () {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        StartGame start = new StartGame(fen);
        Counter[] counters = new CountMoreParallel(start.getBitmap(), MAXDEPTH, start.getBoard()).compute();
        printCounter(counters);
        assertEquals(counters[4].moves, 4865609);
        assertEquals(counters[4].captures, 82719);
        assertEquals(counters[4].enpassants, 258);
    }

    @Test
    public void thinkStart3_2552_291() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        StartGame start = new StartGame(fen);
        Counter[] counters = new CountMoreParallel2(start.getBitmap(), MAXDEPTH, start.getBoard()).compute();
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
        for (String string : delimited.split(",")) {
            sb.append("          ".substring(string.length()));
            sb.append(string);
        }
        return sb.toString();
    }

    @Test
    public void thinkPromo1_4243_941() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        StartGame start = new StartGame(fen);
        Counter[] counters = new CountMore(start.getBitmap(), MAXDEPTH, start.getBoard()).compute();
        printCounter(counters);
        assertEquals(counters[0].moves, 24);
        assertEquals(counters[1].moves, 496);
        assertEquals(counters[2].moves, 9483);
        assertEquals(counters[3].moves, 182838);
        assertEquals(counters[4].moves, 3605103);
    }

    @Test
    public void thinkPromo2_2226_289() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        StartGame start = new StartGame(fen);
        Counter[] counters = new CountMoreParallel(start.getBitmap(), MAXDEPTH, start.getBoard()).compute();
        printCounter(counters);
        assertEquals(counters[0].moves, 24);
        assertEquals(counters[1].moves, 496);
        assertEquals(counters[2].moves, 9483);
        assertEquals(counters[3].moves, 182838);
        assertEquals(counters[4].moves, 3605103);
    }

    @Test
    public void check_0() {
        String fen = "rnbqk1nr/ppp2ppp/4p3/3p4/1b1P4/P4P2/1PP1P1PP/RNBQKBNR w KQkq - 1 4";
        StartGame move = new StartGame(fen);
        assertEquals("King", "K f2", getLegalMovesFromPos("e1", move));
        assertEquals("Queen", "Q d2", getLegalMovesFromPos("d1", move));
        assertEquals("Pawn1", "P b4", getLegalMovesFromPos("a3", move));
        assertEquals("Pawn2", "P c3", getLegalMovesFromPos("c2", move));
    }

    @Test
    public void ordering_0() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        StartGame start = new StartGame(fen);
        int[] board = start.getBoard();
        int inherit = start.getBitmap();
        int[] sorted = new Position(board, inherit).getAllBestFirst();
        int high = 9000000;
        for (int bitmap : sorted) {
            int val = Bitmap.tacticValue(bitmap);
            if (val < high)
                high = val;
            if (val > high){
                System.out.println("=================================");
                for (int bm : sorted) {
                    System.out.println(FEN.printMove(new Position(board, bm)));
                }
                throw new AssertionError("Wrong move value ordering");
            }
        }
    }

    @Test
    public void opening_0() {
        String fen = "rnbqkb1r/pppp1ppp/5n2/4p3/3PP3/8/PPP2PPP/RNBQKBNR w KQkq - 1 3";
        assertEquals("Queen", "Q h5 g4 f3 e2 d3 d2", getLegalMovesFromPos("d1", new StartGame(fen)));
    }

    @Test
    public void whiteStart_0() {
        String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
        StartGame move = new StartGame(fen);
        assertEquals("Knight1", "N c3 a3", getLegalMovesFromPos("b1", move));
        assertEquals("Knight2", "N h3 f3", getLegalMovesFromPos("g1", move));
        assertEquals("Pawn1", "P a4 a3", getLegalMovesFromPos("a2", move));
    }

    @Test
    public void promotions_0() {
        String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
        String moves = getLegalMovesFromPos("g2", new StartGame(fen));
        assertEquals("Pawn", "p h1 h1 h1 h1 f1 f1 f1 f1 g1 g1 g1 g1", moves);
    }

    @Test
    public void enpassant_0() {
        String fen = "rnbqkbnr/ppp1pppp/8/8/1PpP4/8/P3PPPP/RNBQKBNR b KQkq b3 0 3";
        assertEquals("Pawn", "p b3 c3", getLegalMovesFromPos("c4", new StartGame(fen)));
    }


}

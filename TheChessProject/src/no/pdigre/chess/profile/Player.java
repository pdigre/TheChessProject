package no.pdigre.chess.profile;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import no.pdigre.chess.engine.base.IConst.BITS;
import no.pdigre.chess.engine.base.ZobristKey;
import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPositionWithLog;
import no.pdigre.chess.engine.fen.PositionScore;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.polyglot.BookMove;
import no.pdigre.chess.engine.polyglot.Polyglot;
import no.pdigre.chess.test.util.IterateScores;

public abstract class Player implements IPlayer {

    public volatile RunState state = RunState.READY;

    public static boolean debug = true;

    public IterateScores moves;

    protected GameData game;

    public void setGameData(GameData game) {
        this.game = game;
    }

    @Override
    public ArrayList<Marking> getMarkers() {
        return new ArrayList<Marking>();
    }

    @Override
    public int clickSquare(int i) {
        return -1;
    }

    public int checkPolyglot() {
        IPositionWithLog pos = game.pos;
        boolean white=pos.whiteNext();
        ArrayList<BookMove> list = Polyglot.get(ZobristKey.getKey(pos));
        int best = moves.first().getScore();
        IPosition[] array = moves.toArray(new IPosition[moves.size()]);
        for (BookMove book: list) {
            int bitmap = book.move;
            int f1 = Polyglot.getFrom(bitmap);
            int t1 = Polyglot.getTo(bitmap);
            for (IPosition p : array) {
                if (BITS.getFrom(p.getBitmap()) == f1 && BITS.getTo(p.getBitmap()) == t1){
                    moves.remove(p);
                    ((PositionScore)p).score=white?best+book.weight:best-book.weight;
                    moves.add(p);
                }
            }
        }
        return list.size();
    }

    protected void makeMove(long bitmap) {
        game.makeMove(bitmap);
    }

    public void makeMove() {
        game.makeMove(moves.first().getBitmap());
    }

    protected void printFEN() {
        System.out.println(FEN.getFen(getPosition()));
    }

    protected IPosition getPosition() {
        return game.pos;
    }

    public static void printScore(IterateScores moves, String txt) {
        if (debug) {
            System.out.println("\n**** " + txt + " ****");
            for (IPosition m : moves)
                System.out.println(m.getQuality() + " "+m.getScore() + ":" + (m.whiteNext() ? "b " : "w ") + FEN.notation(m));
        }
    }

    public static void runThinker(IPosition move, IterateScores moves, IIterator iter) {
        int score = 0;
        score = move.whiteNext() ? iter.white(move, IIterator.MIN, IIterator.MAX) : iter.black(move,
            IIterator.MIN, IIterator.MAX);
        moves.improveScore((PositionScore) move,score);
    }

    public static void initRun(IPosition pos) {
        if (debug)
            System.out.println(FEN.board2string(pos));
    }

    @Override
    public String getDescription() {
        return "<No description>";
    }

    public void prepare() {
        moves = new IterateScores(getPosition(), IEvaluator.FULL);
    }

    public void processAndMove(IIterator iterator) {
        IterateScores copy = (IterateScores) moves.clone();
        for (IPosition m : copy)
            runThinker(m, moves, iterator);
        makeMove();
    }

    public void printTestHeader() {
        IPosition pos = getPosition();
        System.out.println("**********************************************");
        System.out.println("START:" + FEN.getFen(pos));
        initRun(pos);
    }

    public void setTimeout(int timeout_ms) {
        state = RunState.RUNNING;
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            
            @Override
            public void run() {
                state=RunState.TIMEOUT;
            }
        }, timeout_ms);
    }

    public void processUntilTimeout(IIterator iterator) {
        for (IPosition m : moves.toArray(new IPosition[moves.size()])) {
            if (state != RunState.RUNNING)
                break;
//            System.out.println("Processing:"+FEN.notation(m));
            runThinker(m, moves, iterator);
        }
    }

    public void processSimple(IIterator iterator) {
        for (IPosition m : (IterateScores) moves.clone())
            runThinker(m, moves, iterator);
    }


    
}

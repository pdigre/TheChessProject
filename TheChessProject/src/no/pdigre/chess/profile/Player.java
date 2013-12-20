package no.pdigre.chess.profile;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPositionScore;
import no.pdigre.chess.engine.fen.IPositionWithLog;
import no.pdigre.chess.engine.fen.PositionScore;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.polyglot.BookMove;
import no.pdigre.chess.engine.polyglot.Polyglot;
import no.pdigre.chess.engine.polyglot.ZobristKey;
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
        IPositionScore[] array = moves.toArray(new IPositionScore[moves.size()]);
        for (BookMove book: list) {
            int bitmap = book.move;
            int f1 = Polyglot.getFrom(bitmap);
            int t1 = Polyglot.getTo(bitmap);
            for (IPositionScore p : array) {
                if (Bitmap.getFrom(p.getBitmap()) == f1 && Bitmap.getTo(p.getBitmap()) == t1){
                    moves.remove(p);
                    ((PositionScore)p).score=white?best+book.weight:best-book.weight;
                    moves.add(p);
                }
            }
        }
        return list.size();
    }

    protected void makeMove(int bitmap) {
        game.makeMove(bitmap);
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
            for (IPositionScore m : moves)
                System.out.println(m.getScore() + ":" + (m.whiteNext() ? "b " : "w ") + FEN.notation(m));
        }
    }

    public static void runThinker(IPositionScore move, IterateScores moves, IIterator iter) {
        int score = 0;
        final int total = move.getScore();
        score = move.whiteNext() ? iter.white(move, total, IIterator.MIN, IIterator.MAX) : iter.black(move, total,
            IIterator.MIN, IIterator.MAX);
        moves.remove(move);
        ((PositionScore)move).run++;
        ((PositionScore)move).score = score;
        moves.add(move);
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
        for (IPositionScore m : copy)
            runThinker(m, moves, iterator);
        makeMove(moves.first().getBitmap());
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
        for (IPositionScore m : moves.toArray(new IPositionScore[moves.size()])) {
            if (state != RunState.RUNNING)
                break;
            System.out.println("Processing:"+FEN.notation(m));
            runThinker(m, moves, iterator);
        }
    }


}

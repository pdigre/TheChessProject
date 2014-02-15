package no.pdigre.chess.engine.uci;

import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.iterate.AlphaBeta;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.IterateEnd;
import no.pdigre.chess.profile.GameData;
import no.pdigre.chess.profile.Player;

public class UCI_Player extends Player {

    @Override
    public String getDescription() {
        return "Medium MiniMax timed to 30 secs with Tactical evaluation";
    }

    @Override
    public void run() {
        printTestHeader();
        IIterator iter0 = new IterateEnd();
        IIterator iter1 = new AlphaBeta(iter0);
        IIterator iter2 = new AlphaBeta(iter1);
        IIterator iter3 = new AlphaBeta(iter2);
//        IIterator iter4 = new AlphaBeta(iter3, IEvaluator.TACTICAL);

//        setTimeout(9000);
        printScore(moves, "PASS 0");
        for (IPosition m : moves.getSortedArray())
            runThinker(m, moves, iter0);
        printScore(moves, "PASS 1");
        for (IPosition m : moves.getSortedArray())
            runThinker(m, moves, iter1);
        printScore(moves, "PASS 2");
        for (IPosition m : moves.getSortedArray())
            runThinker(m, moves, iter2);
        printScore(moves, "PASS 3");
        for (IPosition m : moves.getSortedArray())
            runThinker(m, moves, iter3);
        printScore(moves, "PASS 4");
//        processUntilTimeout(iter4);
//        printScore(moves, "PASS 5");
        makeMove();
    }

	public static void testMove(Player player,String fen) {
	    Player.debug=true;
		GameData game = new GameData(){

			@Override
			public void updateBoard() {
				//
			}
        	
			@Override
			public void run() {
            	getPlayer().run();
			}
			
			@Override
			public void makeMove(long bitmap) {
				System.out.println(">"+FEN.printMove(pos.move(bitmap)));
			}
			
			@Override
			public int findBest(int[] bitmaps, int[] scores) {
				for (int bitmap : bitmaps)
					System.out.println(":"+FEN.printMove(pos.move(bitmap)));
				return super.findBest(bitmaps, scores);
			}
        };
		game.start(fen, player, player);
	}

}

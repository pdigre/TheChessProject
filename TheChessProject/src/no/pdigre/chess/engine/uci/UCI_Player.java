package no.pdigre.chess.engine.uci;

import no.pdigre.chess.engine.iterate.Quiescence;
import no.pdigre.chess.profile.GameData;
import no.pdigre.chess.profile.Player;
import no.pdigre.chess.profile.TestPlayer;

public class UCI_Player extends TestPlayer {

	public UCI_Player(int depth){
		super("AlphaBetaQuiesce",depth,new Quiescence());
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
//				System.out.println(">"+FEN.printMove(pos.move(bitmap)));
			}
			
			@Override
			public int findBest(int[] bitmaps, int[] scores) {
//				for (int bitmap : bitmaps)
//					System.out.println(":"+FEN.printMove(pos.move(bitmap)));
				return super.findBest(bitmaps, scores);
			}
        };
		game.start(fen, player, player);
	}

}

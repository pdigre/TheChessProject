package no.pdigre.chess.test.util;

import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.profile.GameData;
import no.pdigre.chess.profile.Player;


public class RunProfiles {

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
			public void makeMove(int bitmap) {
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

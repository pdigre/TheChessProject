package no.pdigre.chess.test;

import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.profile.GameData;
import no.pdigre.chess.profile.Novice;
import no.pdigre.chess.profile.Player;

import org.junit.Test;


@SuppressWarnings("static-method")
public class Test_Profiles {

    @Test
    public void testNovice() {
        testMove(new Novice(),"8/4p3/8/3P3p/P2pK3/6P1/7b/3k4 w - - 0 1");
    }

	private void testMove(Player player,String fen) {
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
				System.out.println(FEN.board2String(position));
				IPosition move = position.move(bitmap);
				System.out.println(">"+FEN.printMove(move));
			}
			
			@Override
			public int findBest(int[] bitmaps, int[] scores) {
				for (int bitmap : bitmaps) {
					IPosition move = position.move(bitmap);
					System.out.println(":"+FEN.printMove(move));
				}
				return super.findBest(bitmaps, scores);
			}
        };
		game.start(fen, player, player);
		System.out.println("*** ALPHABETA *** "+FEN.printMove(game.position));
	}

}

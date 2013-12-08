package no.pdigre.chess.test;

import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.profile.GameData;
import no.pdigre.chess.profile.IPlayer.Players;

import org.junit.Test;


@SuppressWarnings("static-method")
public class Test_Profiles {

    @Test
    public void testManual() {
        String fen = "8/4p3/8/3P3p/P2pK3/6P1/7b/3k4 w - - 0 1";
        GameData game = new GameData(){

			@Override
			public void updateBoard() {
				System.out.println("<"+FEN.printMove(position));
			}
        	
			@Override
			public void run() {
            	getPlayer().run();
			}
			
			@Override
			public void makeMove(int bitmap) {
				System.out.println(">"+FEN.printMove(position.move(bitmap)));
			}
        };
        game.start(fen, Players.NOVICE, Players.NOVICE);
		System.out.println("hi");
    }

}

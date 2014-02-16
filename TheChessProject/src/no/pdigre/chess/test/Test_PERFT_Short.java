package no.pdigre.chess.test;

import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.test.util.CountForkJoinPool2Full;
import no.pdigre.chess.test.util.CountForkJoinPoolFull;
import no.pdigre.chess.test.util.CountFull;
import no.pdigre.chess.test.util.PerftResults;

import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("static-method")
public class Test_PERFT_Short {

	@BeforeClass
	public static void prepare() {
		PerftResults.readAll();
	}
	
	@Test
	public void m1_1_557() {
		String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		PerftResults.assertPERFT(fen, new CountFull(new StartGame(fen), 5));
	}

	@Test
	public void m1_2_179() {
		String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		PerftResults.assertPERFT(fen, new CountForkJoinPoolFull(new StartGame(fen), 5));
	}

	@Test
	public void m1_3_174() {
		String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		PerftResults.assertPERFT(fen, new CountForkJoinPool2Full(new StartGame(fen), 5));
	}

	@Test
	public void e_1_1083() {
		String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
		PerftResults.assertPERFT(fen, new CountFull(new StartGame(fen), 5));
	}

	@Test
	public void e_2_620() {
		String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
		PerftResults.assertPERFT(fen, new CountForkJoinPoolFull(new StartGame(fen), 5));
	}

	@Test
	public void e_3_410() {
		String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
		PerftResults.assertPERFT(fen, new CountForkJoinPool2Full(new StartGame(fen), 5));
	}

	@Test
	public void m2_kiwipete_157() {
		String fen = "r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1";
		PerftResults.assertPERFT(fen, new CountForkJoinPoolFull(new StartGame(fen), 4));
	}

	@Test
	public void m3_650() {
		String fen = "8/2p5/3p4/KP5r/1R3p1k/8/4P1P1/8 w - - 0 1";
		PerftResults.assertPERFT(fen, new CountForkJoinPoolFull(new StartGame(fen), 6));
	}

	@Test
	public void m4a_860() {
		String fen = "r3k2r/Pppp1ppp/1b3nbN/nP6/BBP1P3/q4N2/Pp1P2PP/R2Q1RK1 w kq - 0 1";
		PerftResults.assertPERFT(fen, new CountForkJoinPoolFull(new StartGame(fen), 5));
	}

	@Test
	public void m4b_853() {
		String fen = "r2q1rk1/pP1p2pp/Q4n2/bbp1p3/Np6/1B3NBn/pPPP1PPP/R3K2R b KQ - 0 1";
		PerftResults.assertPERFT(fen, new CountForkJoinPoolFull(new StartGame(fen), 5));
	}

}

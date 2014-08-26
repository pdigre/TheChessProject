package no.pdigre.chess.test;

import no.pdigre.chess.engine.base.BASE;
import no.pdigre.chess.engine.base.MovegenCache;
import no.pdigre.chess.test.util.PerftResults;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 
 * 4700ms with improvements in "kingsafe"
 * 4300ms with new MOVEDATA bits
 * 4400ms with pinned pieces - take 1 (3700 p� jobben)
 * 
 */
@SuppressWarnings("static-method")
public class Test_PERFT_5300ms {

	@BeforeClass
	public static void prepare() {
		new BASE();
		PerftResults.readAll();
	}
	
	@Test
	public void m1_1_553() {
		String fen = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1";
		PerftResults.assertPERFT(fen, new RunPerft().perft(5, fen));
	}

	@Test
	public void m2_1_1083() {
		String fen = "n1n5/PPPk4/8/8/8/8/4Kppp/5N1N b - - 0 1";
		PerftResults.assertPERFT(fen, new RunPerft().perft(5,fen));
	}

	@Test
	public void m3_kiwipete_153() {
		String fen = "r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1";
		PerftResults.assertPERFT(fen, new RunPerft().perft(4,fen));
	}

	@Test
	public void m3_kiwipete_fast_239() {
		RunPerftFast.test(4085603,4, "r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1");
	}

	@Test
	public void m4_626() {
		String fen = "8/2p5/3p4/KP5r/1R3p1k/8/4P1P1/8 w - - 0 1";
		PerftResults.assertPERFT(fen, new RunPerft().perft(6, fen));
	}

	@Test
	public void m5a_835() {
		String fen = "r3k2r/Pppp1ppp/1b3nbN/nP6/BBP1P3/q4N2/Pp1P2PP/R2Q1RK1 w kq - 0 1";
		PerftResults.assertPERFT(fen, new RunPerft().perft(5, fen));
	}

	@Test
	public void m5b_830() {
		String fen = "r2q1rk1/pP1p2pp/Q4n2/bbp1p3/Np6/1B3NBn/pPPP1PPP/R3K2R b KQ - 0 1";
		PerftResults.assertPERFT(fen, new RunPerft().perft(5, fen));
	}

	@Test
	public void m5c_830_fast() {
		RunPerftFast.test(15833292,5,"r2q1rk1/pP1p2pp/Q4n2/bbp1p3/Np6/1B3NBn/pPPP1PPP/R3K2R b KQ - 0 1");
	}

	@Test
	@Ignore
	public void e3_err_fast() {
		RunPerftFast.test(179869,6,"8/8/8/8/8/8/6k1/4K2R b K - 0 1");
	}

	@Test
	@Ignore
	public void e2_err_fast() {
		RunPerftFast.test(193690690,5,"r3k2r/p1ppqpb1/bn2pnp1/3PN3/1p2P3/2N2Q1p/PPPBBPPP/R3K2R w KQkq - 0 1");
	}

	@Test
	@Ignore
	public void e56_err_fast() {
		RunPerftFast.test(525169084,6,"R6r/8/8/2K5/5k2/8/8/r6R w - - 0 1");
	}

	@Test
	@Ignore
	public void e58_err_fast() {
		RunPerftFast.test(524966748,6,"R6r/8/8/2K5/5k2/8/8/r6R b - - 0 1");
	}

	@Test
	@Ignore
	public void e121_err_fast() {
		RunPerftFast.test(28859283,6,"8/PPPk4/8/8/8/8/4Kppp/8 w - - 0 1");
	}

	@AfterClass
	public static void finish() {
		System.out.println(MovegenCache.printStats());
	}
	

}

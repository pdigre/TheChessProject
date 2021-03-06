package no.pdigre.chess.test;

import java.util.ArrayList;

import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.test.util.CountForkJoinPool2Simple;
import no.pdigre.chess.test.util.FileUtils;

import org.junit.Test;

public class Test_PERFT_Long {

	public class Perft {

		public final String fen;

		public final int[] count;

		public Perft(String fen, int[] count) {
			this.fen = fen;
			this.count = count;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < count.length; i++)
				sb.append(count[i] + " ");
			sb.append(fen);
			return sb.toString();
		}
	}

	@Test
	public void perft_114s() {
		ArrayList<Perft> list = new ArrayList<Test_PERFT_Long.Perft>();
		for (String line : FileUtils.stream2lines(getClass().getResourceAsStream("perftsuite.epd"))) {
			String[] split = line.split("\\;");
			int[] count = new int[split.length - 1];
			for (int i = 0; i < count.length; i++)
				count[i] = Integer.parseInt(split[i + 1].split(" ")[1]);
			list.add(new Perft(split[0], count));
		}
		int line = 1;
		for (Perft perft : list) {
			System.out.print((line++) + ". " + perft);
			StartGame start = new StartGame(perft.fen);
			long time = System.currentTimeMillis();
			int[] counters = new CountForkJoinPool2Simple(start, perft.count.length).compute();
			for (int i = 0; i < perft.count.length; i++) {
				if (perft.count[i] != counters[i]) {
					System.out.println(" NOT " + (System.currentTimeMillis() - time) + "ms");
					printCounter(counters);
					throw new AssertionError("Wrong move count");
				}
			}
			System.out.println(" OK " + (System.currentTimeMillis() - time) + "ms");
		}
	}

	private static void printCounter(int[] counters) {
		String x = "Depth,Moves";
		System.out.println(format10(x));
		for (int i = 0; i < counters.length; i++) {
			System.out.println(format10(String.format("%d,%d", i + 1, counters[i])));
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
}

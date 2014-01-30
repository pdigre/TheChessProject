package no.pdigre.chess.test.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition64;
import no.pdigre.chess.engine.uci.ROCEexe;
import no.pdigre.chess.test.Test_PERFT_Short;

public class PerftResults {

	final List<IPosition64> rootmoves;
	final public int[] rootcount;
	public Counter[] counters;

	public PerftResults(List<IPosition64> rootmoves) {
		this.rootmoves = rootmoves;
		rootcount = new int[rootmoves.size()];
	}

	public static void total(Counter[] total, Counter[] add) {
		for (int i = 0; i < add.length; i++)
			total[i + 1].add(add[i]);
	}

	public String printCounter() {
		return printCounter(counters);
	}

	public static String printCounter(Counter[] counters) {
		StringBuffer sb = new StringBuffer();
		String x = "Depth,Moves,Captures,Enpassant,Castling,Promotion,Check,Mate";
		sb.append(format10(x) + "\r\n");
		for (int i = 0; i < counters.length; i++) {
			Counter cnt = counters[i];
			sb.append(format10(String.format("%d,%d,%d,%d,%d,%d,%d,%d", i + 1, cnt.moves, cnt.captures, cnt.enpassants, cnt.castlings,
					cnt.promotions, cnt.checks, cnt.mates)) + "\r\n");
		}
		return sb.toString();
	}

	private static String format10(String delimited) {
		StringBuilder sb = new StringBuilder();
		for (String string : delimited.split(","))
			sb.append("          ".substring(string.length()) + string);
		return sb.toString();
	}

	public Map<String, Integer> getDivide() {
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		for (int i = 0; i < rootcount.length; i++) {
			int count = rootcount[i];
			IPosition64 pos = rootmoves.get(i);
			int bitmap = pos.getBitmap();
			map.put(FEN.move2literal(bitmap), count);
		}
		return map;
	}

	public ArrayList<IPosition64> getDivideMisses(Map<String, Integer> div2) {
		ArrayList<IPosition64> list = new ArrayList<IPosition64>();
		Map<String, Integer> div1 = getDivide();
		Set<String> k1 = div1.keySet();
		Set<String> diff = new HashSet<String>(div2.keySet());
		diff.removeAll(k1);
		for (String key : diff) {
			if (!key.contains(":"))
				System.out.println("MISSING:" + key);
		}
		for (Entry<String, Integer> entry : div1.entrySet()) {
			String key = entry.getKey();
			int v1 = entry.getValue();
			if (!div2.containsKey(key)) {
				System.out.println("ERROR:" + key);
				continue;
			}
			int v2 = div2.get(key);
			if (v1 != v2) {
				for (IPosition64 pos : rootmoves) {
					if (FEN.move2literal(pos.getBitmap()).equals(key))
						list.add(pos);
				}
				System.out.println("Diff:" + key + " " + v1 + "/" + v2);
			}
		}
		return list;
	}

	public static void assertPERFT(String fen, CountFull runner) {
		Counter[] counters = runner.compute();
		String results = readPerftFromFile(fen, counters.length);
		assertEquals(results, "FEN=" + fen + "\r\n" + PerftResults.printCounter(counters));
	}

	public static void assertPERFT2(String fen, CountFull runner) {
		PerftResults perft = runner.perft();
		int depth = perft.counters.length;
		String results = readPerftFromFile(fen, depth);
		String cmp2 = "FEN=" + fen + "\r\n" + perft.printCounter();
		if (!results.equals(cmp2))
			analyzePerft(fen, perft);
		assertEquals(results, cmp2);
	}

	private static String readPerftFromFile(String fen, int depth) {
		URL resource = new Test_PERFT_Short().getClass().getResource("perft.txt");
		StringBuffer sb = new StringBuffer();
		try {
			String txt = FileUtils.stream2string((InputStream) resource.getContent());
			String prefix = "FEN=" + fen;
			int i = 0;
			String[] split = txt.split("\\\r\\\n");
			while (!split[++i].startsWith(prefix))
				;
			for (int j = 0; j < depth + 2; j++)
				sb.append(split[i + j] + "\r\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	private static void analyzePerft(String fen, PerftResults perft) {
		int depth = perft.counters.length;
		Map<String, Integer> rundiv = ROCEexe.getInstance().runDivide(fen, depth);
		for (IPosition64 pos : perft.getDivideMisses(rundiv)) {
			if(depth>1){
				String fen2 = FEN.getFen(pos);
				System.out.println(FEN.move2literal(pos.getBitmap())+" FEN="+fen2 + " "+ FEN.notation(pos));
				System.out.println(FEN.board2string(pos));
				CountForkJoinPoolFull runner2 = new CountForkJoinPoolFull(pos, depth-1);
				PerftResults perft2 = runner2.perft();
				analyzePerft(fen2, perft2);
			}
		}
	}

}
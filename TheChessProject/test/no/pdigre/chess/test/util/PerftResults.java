package no.pdigre.chess.test.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.Position;
import no.pdigre.chess.engine.uci.ROCEexe;
import no.pdigre.chess.test.Test_PERFT_5300ms;

public class PerftResults {

	public static HashMap<String, String> allexpected;
	
	final Position[] rootmoves;
	final public int[] rootcount;
	public Counter[] counters;

	public PerftResults(Position[] rootmoves) {
		this.rootmoves = rootmoves;
		rootcount = new int[rootmoves.length];
	}

	public static void total(Counter[] total, Counter[] add) {
		for (int i = 0; i < add.length; i++)
			total[i + 1].add(add[i]);
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
			Position pos = rootmoves[i];
			long bitmap = pos.getBitmap();
			map.put(FEN.move2literal(bitmap), count);
		}
		return map;
	}

	public ArrayList<Position> getDivideMisses(Map<String, Integer> div2, String fen) {
		boolean[] print=new boolean[]{false};
		ArrayList<Position> list = new ArrayList<Position>();
		Map<String, Integer> div1 = getDivide();
		Set<String> k1 = div1.keySet();
		Set<String> diff = new HashSet<String>(div2.keySet());
		diff.removeAll(k1);
		for (String key : diff) {
			if (!key.contains(":"))
				System.out.println(print(print,fen)+"MISSING:" + key);
		}
		for (Entry<String, Integer> entry : div1.entrySet()) {
			String key = entry.getKey();
			int v1 = entry.getValue();
			if (!div2.containsKey(key)) {
				System.out.println(print(print,fen)+"WRONG:" + key);
				continue;
			}
			int v2 = div2.get(key);
			if (v1 != v2) {
				for (Position pos : rootmoves) {
					if (FEN.move2literal(pos.getBitmap()).equals(key))
						list.add(pos);
				}
				System.out.println(print(print,fen)+"Diff:" + key + " " + v1 + "/" + v2);
			}
		}
		return list;
	}

	private String print(boolean[] print,String fen) {
		if(!print[0]){
			print[0]=true;
			System.out.println(FEN.board2string(FEN.fen2board(fen)));
		}
		return "";
	}

	public static void assertPERFT(String fen, CountFull runner) {
		Counter[] counters = runner.compute();
		String actual = "FEN=" + fen + "\r\n" + PerftResults.printCounter(counters);
		String expected = allexpected.get(fen).substring(0, actual.length());
		assertEquals(expected, actual);
	}

	public static void assertPERFT2(String fen, CountFull runner) {
		PerftResults perft = runner.perft();
		String actual = "FEN=" + fen + "\r\n" + PerftResults.printCounter(perft.counters);
		String expected = allexpected.get(fen).substring(0, actual.length());
		if (!expected.equals(actual))
			analyzePerft(fen, perft);
		assertEquals(expected, actual);
	}

	private static void analyzePerft(String fen, PerftResults perft) {
		int depth = perft.counters.length;
		Map<String, Integer> rundiv = ROCEexe.getInstance().runDivide(fen, depth);
		for (Position pos : perft.getDivideMisses(rundiv,fen)) {
			if(depth>1){
				analyzePerft(FEN.getFen(pos), new CountForkJoinPoolFull(pos, depth-1).perft());
			}
		}
	}

	public static void readAll() {
		allexpected=new HashMap<String, String>();
		URL resource = new Test_PERFT_5300ms().getClass().getResource("perft.txt");
		try {
			String txt = FileUtils.stream2string((InputStream) resource.getContent());
			int i = 0;
			String[] split = txt.split("\\\r\\\n");
			loop:
			while(i<split.length){
				while (!split[++i].startsWith("FEN=")){
					if(i+2>split.length) break loop;
				}
				String fen=split[i].substring(4);
				StringBuffer sb = new StringBuffer();
				for (; i<split.length && !split[i].equals(""); i++)
					sb.append(split[i] + "\r\n");
				allexpected.put(fen,sb.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
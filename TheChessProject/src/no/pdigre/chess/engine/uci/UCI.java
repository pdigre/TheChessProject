package no.pdigre.chess.engine.uci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UCI {
	BufferedReader br;

	private static UCI instance;

	public static UCI getInstance() {
		if (instance == null) {
			instance = new UCI();
		}
		return instance;
	}

	public UCI() {
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("pdigre Chess:");
		UCI inst = getInstance();
		do {
			String line = inst.getLine();
			inst.processUCI(line);
		} while (true);
	}

	public String getLine() {
		try {
			String line;
			while ((line = br.readLine()) != null) {
				return line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void processUCI(String line) {
		System.out.println("Reply:"+line);
	}
}

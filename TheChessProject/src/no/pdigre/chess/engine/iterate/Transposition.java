package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.fen.IPosition;

public class Transposition {
	public static final int TTSIZE = 1 << 24;
	public static final IPosition[] TT = new IPosition[TTSIZE];
	public static long hits = 0;
	public static long miss = 0;
	public static long coll = 0;
	public static long err = 0;
	public static long qual = 0;
	public static long total =0;
	public static final long MASK = TTSIZE - 1;

	public static final IPosition find(IPosition next, int quality) {
		long zobrist = next.getZobristKey();
		long k1 = (zobrist) & MASK;
		long k2 = (zobrist >> 1) & MASK;
		IPosition pos = TT[(int) k1];
		if (pos == null) {
			miss++;
			return null;
		}
		if (pos.getZobristKey() == zobrist) {
			hits++;
			if (pos.getBKpos() != next.getBKpos())
				err++;
			if (pos.getQuality() >= quality)
				return pos;
			qual++;
			return null;
		} else {
			coll++;
		}
		IPosition pos2 = TT[(int) k2];
		if (pos2 == null) {
			miss++;
			return null;
		}
		if (pos2.getZobristKey() == zobrist) {
			hits++;
			if (pos2.getBKpos() != next.getBKpos())
				err++;
			if (pos2.getQuality() >= quality)
				return pos2;
			qual++;
			return null;
		}
		miss++;
		return null;
	}

	public static final void register(IPosition next) {
		long zobrist = next.getZobristKey();
		long k1 = (zobrist) & MASK;
		long k2 = (zobrist >> 1) & MASK;
		IPosition pos = TT[(int) k1];
		if (pos != null && pos.getZobristKey() != zobrist)
			TT[(int) k2] = TT[(int) k1];
		TT[(int) k1] = next;
	}

}

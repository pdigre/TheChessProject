package no.pdigre.chess.engine.base;

public class REVERSE {
	// Reverse lookup for in-check
	public final long RN;
	public final long RB;
	public final long RR;
	public final long RQ;
	public final long RK;

	public REVERSE(long rN, long rB, long rR, long rQ,long rK) {
		RN = rN;
		RB = rB;
		RR = rR;
		RQ = rQ;
		RK = rK;
	}


}
package no.pdigre.chess.engine.base;

public class MRBlackStart extends MRBlack {

	final MOVEDATA[] XU;
	final MOVEDATA[] XD;
	final MOVEDATA[] XL;
	final MOVEDATA[] XR;

	public MRBlackStart(int from) {
		super(from);
		XU=castling(U);
		XD=castling(D);
		XL=castling(L);
		XR=castling(R);
	}

}

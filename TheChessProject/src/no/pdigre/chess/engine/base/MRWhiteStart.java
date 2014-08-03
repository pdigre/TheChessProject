package no.pdigre.chess.engine.base;

public class MRWhiteStart extends MRWhite {

	final MOVEDATA[] XU;
	final MOVEDATA[] XD;
	final MOVEDATA[] XL;
	final MOVEDATA[] XR;

	public MRWhiteStart(int from) {
		super(from);
		XU=castling(U);
		XD=castling(D);
		XL=castling(L);
		XR=castling(R);
	}


}

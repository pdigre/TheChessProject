package no.pdigre.chess.engine.base;

public class MWRStart extends MWR {

	final MOVEDATA[] XU;
	final MOVEDATA[] XD;
	final MOVEDATA[] XL;
	final MOVEDATA[] XR;

	public MWRStart(int from) {
		super(from);
		XU=castling(U);
		XD=castling(D);
		XL=castling(L);
		XR=castling(R);
	}


}

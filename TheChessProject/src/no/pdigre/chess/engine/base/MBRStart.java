package no.pdigre.chess.engine.base;

public class MBRStart extends MBR {

	final MOVEDATA[] XU;
	final MOVEDATA[] XD;
	final MOVEDATA[] XL;
	final MOVEDATA[] XR;

	public MBRStart(int from) {
		super(from);
		XU=castling(U);
		XD=castling(D);
		XL=castling(L);
		XR=castling(R);
	}

}

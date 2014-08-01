package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;

/**
 * When you need to check if Castling is broken
 */
public class MOVEDATAX extends MOVEDATA {

	final MOVEDATA normal;
	
	public MOVEDATAX(long bitmap,long bto,MOVEDATA m) {
		super(bitmap,bto);
		normal=m;
	}

	public static MOVEDATA create(long bitmap){
		int to=BITS.getTo(bitmap);
		MOVEDATA normal = new MOVEDATA(bitmap,1L << to);
		return new MOVEDATAX(bitmap,1L << to,normal);
	}

}

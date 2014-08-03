package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;

/**
 * When castling is broken
 */
public class MOVEDATAX extends MOVEDATA {

	final MOVEDATA normal;
	final long castling;
	
	public MOVEDATAX(long bitmap,long bto,MOVEDATA m) {
		super(bitmap,bto);
		normal=m;
		castling=0L;
	}

	public MOVEDATAX(MOVEDATA m) {
		super(m.bitmap^findCastling(m.bitmap),m.bto);
		normal=null;
		this.castling=findCastling(m.bitmap);
	}

	public static long findCastling(long bitmap) {
		int to=BITS.getTo(bitmap);
		int from=BITS.getFrom(bitmap);
		long castling=0L;
		if(to==IConst.WR_KING_STARTPOS)
			castling^=IConst.CANCASTLE_WHITEKING;
		else if(to==IConst.WR_QUEEN_STARTPOS)
			castling^=IConst.CANCASTLE_WHITEQUEEN;
		else if(to==IConst.BR_KING_STARTPOS)
			castling^=IConst.CANCASTLE_BLACKKING;
		else if(to==IConst.BR_QUEEN_STARTPOS)
			castling^=IConst.CANCASTLE_BLACKQUEEN;
		else if(from==IConst.WK_STARTPOS)
			castling^=IConst.CANCASTLE_WHITE;
		else if(from==IConst.BK_STARTPOS)
			castling^=IConst.CANCASTLE_BLACK;
		return castling;
	}

	public MOVEDATAX(MOVEDATA m,long mask) {
		super(m.bitmap^mask,m.bto);
		normal=null;
		this.castling=mask;
	}

	public static MOVEDATA create(long bitmap){
		int to=BITS.getTo(bitmap);
		MOVEDATA normal = new MOVEDATA(bitmap,1L << to);
		return new MOVEDATAX(bitmap,1L << to,normal);
	}

}

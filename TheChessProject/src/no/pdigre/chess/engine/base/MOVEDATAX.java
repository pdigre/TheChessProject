package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;

/**
 * When castling is broken
 */
public class MOVEDATAX extends MOVEDATA {

	public static MOVEDATA create(long bitmap){
		return new MOVEDATAX(bitmap);
	}

	private MOVEDATAX(long bitmap) {
		super(bitmap);
	}

	public static MOVEDATAX createx(long bitmap){
		return new MOVEDATAX(bitmap^findCastling(bitmap));
	}
	
	private static long findCastling(long bitmap) {
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

}

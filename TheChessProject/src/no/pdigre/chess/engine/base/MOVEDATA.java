package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.Position64;

public class MOVEDATA {
	
	public static MOVEDATA create(long bitmap){
		int to=BITS.getTo(bitmap);
		return new MOVEDATA(bitmap,1L << to);
	}
	
	public static MOVEDATA createxw(long bitmap){
		int to=BITS.getTo(bitmap);
		MOVEDATA normal = new MOVEDATA(bitmap,1L << to);
		int c=BITS.getCaptured(bitmap);
		if(c==IConst.BR){
			if(to==IConst.BR_KING_STARTPOS)
				return new MOVEDATAX(bitmap & ~IConst.CANCASTLE_BLACKKING,1L << to,normal);
			if(to==IConst.BR_QUEEN_STARTPOS)
				return new MOVEDATAX(bitmap & ~IConst.CANCASTLE_BLACKQUEEN,1L << to,normal);
		}
		return normal;
	}
	
	public static MOVEDATA createxb(long bitmap){
		int to=BITS.getTo(bitmap);
		MOVEDATA normal = new MOVEDATA(bitmap,1L << to);
		int c=BITS.getCaptured(bitmap);
		if(c==IConst.WR){
			if(to==IConst.WR_KING_STARTPOS)
				return new MOVEDATAX(bitmap & ~IConst.CANCASTLE_WHITEKING,1L << to,normal);
			if(to==IConst.WR_QUEEN_STARTPOS)
				return new MOVEDATAX(bitmap & ~IConst.CANCASTLE_WHITEQUEEN,1L << to,normal);
		}
		return normal;
	}
	
	protected MOVEDATA(long bitmap,long bto) {
		this.bitmap = bitmap;
		this.bto = bto;
	}

	public Position64 move(Position64 pos, long castling) {
		return pos.move(bitmap & castling);
	}

	final long bitmap;
	final long bto;
	
	@Override
	public String toString() {
		return FEN.move2literal(bitmap);
	}
}
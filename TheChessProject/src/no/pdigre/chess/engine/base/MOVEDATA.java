package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;
import no.pdigre.chess.engine.fen.FEN;

public class MOVEDATA {
	
	public static MOVEDATA create(long bitmap){
		return new MOVEDATA(bitmap);
	}
	
	public static MOVEDATA createxw(long bitmap){
		MOVEDATA normal = new MOVEDATA(bitmap);
		int c=BITS.getCaptured(bitmap);
		if(c==IConst.BR){
			int to=BITS.getTo(bitmap);
			if(to==IConst.BR_KING_STARTPOS)
				return new MOVEDATAX(bitmap & ~IConst.CANCASTLE_BLACKKING,normal);
			if(to==IConst.BR_QUEEN_STARTPOS)
				return new MOVEDATAX(bitmap & ~IConst.CANCASTLE_BLACKQUEEN,normal);
		}
		return normal;
	}
	
	public static MOVEDATA createxb(long bitmap){
		MOVEDATA normal = new MOVEDATA(bitmap);
		int c=BITS.getCaptured(bitmap);
		if(c==IConst.WR){
			int to=BITS.getTo(bitmap);
			if(to==IConst.WR_KING_STARTPOS)
				return new MOVEDATAX(bitmap & ~IConst.CANCASTLE_WHITEKING,normal);
			if(to==IConst.WR_QUEEN_STARTPOS)
				return new MOVEDATAX(bitmap & ~IConst.CANCASTLE_WHITEQUEEN,normal);
		}
		return normal;
	}
	
	protected MOVEDATA(long bits) {
		this.bitmap = bits;
		int piece = BITS.getPiece(bits);
		int from = BITS.getFrom(bits);
		int to = BITS.getTo(bits);
		bto = 1L << to;
		long bfrom = 1L << from;
		long bfromto = bto|bfrom;
		long b_bit1 = ((piece & 1) == 0 ? 0 : bfromto);
		long b_bit2 = ((piece & 2) == 0 ? 0 : bfromto);
		long b_bit3 = ((piece & 4) == 0 ? 0 : bfromto);
		long b_black = ((piece & 8) == 0 ? 0 : bfromto);
		if(BITS.isPromotion(bits)){
			b_bit1 ^= ((piece & 1) != 0 ? 0 : bfrom);
			b_bit2 ^= ((piece & 2) == 0 ? 0 : bfrom);
			b_bit3 ^= ((piece & 4) == 0 ? 0 : bfrom);
		}
	    if (BITS.isEnpassant(bits)) {
			long e = 1L << (to + (to > from ? -8 : 8));
			b_bit1 ^= ((piece & 1) == 0 ? 0 : e);
			b_black ^= ((piece & 8) != 0 ? 0 : e);
	    } else if(BITS.isCapture(bits)){
			int victim=BITS.getCaptured(bits);
			b_bit1 ^= ((victim & 1) == 0 ? 0 : bto);
			b_bit2 ^= ((victim & 2) == 0 ? 0 : bto);
			b_bit3 ^= ((victim & 4) == 0 ? 0 : bto);
			b_black ^= ((victim & 8) == 0 ? 0 : bto);
		} else if (BITS.isCastling(bits)) {
			if (from > to) {
				to = from - 1;
				from = from - 4;
			} else {
				to = from + 1;
				from = from + 3;
			}
			long cfrom = 1L << from;
			long cto = 1L << to;
			long cfromto =cto|cfrom;
			b_bit2 ^= cfromto;
			b_bit3 ^= cfromto;
			b_black ^= ((piece & 8) == 0 ? 0 : cfromto);
		}
		this.b_bit1=b_bit1;
		this.b_bit2=b_bit2;
		this.b_bit3=b_bit3;
		this.b_black=b_black;
	}

	final public long bitmap;
	final public long b_black;
	final public long b_bit1;
	final public long b_bit2;
	final public long b_bit3;
	final public long bto;
	
	@Override
	public String toString() {
		StringBuffer sb=new StringBuffer();
		sb.append(FEN.type2fen(BITS.getPiece(bitmap)));
		sb.append(" ");
		sb.append(FEN.move2literal(bitmap));
		if(BITS.isCapture(bitmap)){
			sb.append(" x");
			sb.append(FEN.type2fen(BITS.getCaptured(bitmap)));
		}
		return FEN.board2string(b_bit1,b_bit2,b_bit3,b_black)+" "+sb.toString();
	}
}
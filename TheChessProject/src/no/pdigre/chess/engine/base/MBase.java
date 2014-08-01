package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;


public abstract class MBase {
	
	final static int[] WPROMOTES=new int[]{IConst.WN,IConst.WB,IConst.WR,IConst.WQ};
	final static int[] BPROMOTES=new int[]{IConst.BN,IConst.BB,IConst.BR,IConst.BQ};
	final static int[] WCAPTURES=new int[]{IConst.BP,IConst.BN,IConst.BB,IConst.BR,IConst.BQ};
	final static int[] BCAPTURES=new int[]{IConst.WP,IConst.WN,IConst.WB,IConst.WR,IConst.WQ};
	
	final public int from;
	
	public void all(Movegen gen){
		//
	}

	public MBase(int from) {
		this.from = from;
	}

	final boolean slideWhite(Movegen gen,long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if (!((gen.bb_piece & bto) != 0)) {
			gen.add((bitmap & gen.castling) | gen.halfmoves);
			return true;
		} else if ((gen.bb_black & bto) != 0) {
			int type = gen.type(bto);
			if (type == GMovegen.WR) {
				if (to == GMovegen.BR_KING_STARTPOS)
					bitmap = bitmap & ~GMovegen.CANCASTLE_BLACKKING;
				if (to == GMovegen.BR_QUEEN_STARTPOS)
					bitmap = bitmap & ~GMovegen.CANCASTLE_BLACKQUEEN;
			}
			gen.add((purge(bitmap, PSQT.pVal(to, type + 8)) & gen.castling) | (type << GMovegen._CAPTURE));
		}
		return false;
	}

	final boolean slideBlack(Movegen gen,long bitmap) {
		int to = BITS.getTo(bitmap);
		long bto = 1L << to;
		if (!((gen.bb_piece & bto) != 0)) {
			gen.add((bitmap & gen.castling) | gen.halfmoves);
			return true;
		} else if ((gen.bb_white & bto) != 0) {
			int type = gen.type(bto);
			if (type == GMovegen.WR) {
				if (to == GMovegen.WR_KING_STARTPOS)
					bitmap = bitmap & ~GMovegen.CANCASTLE_WHITEKING;
				if (to == GMovegen.WR_QUEEN_STARTPOS)
					bitmap = bitmap & ~GMovegen.CANCASTLE_WHITEQUEEN;
			}
			gen.add((purge(bitmap, PSQT.pVal(to, type)) & gen.castling) | (type << GMovegen._CAPTURE));
		}
		return false;
	}

	final long purge(long bitmap, int subtract) {
		int score = BITS.score(bitmap) - subtract;
		return (((long) score) << 32) | ((int) bitmap);
	}

	public static <X extends MBase> void genMoves(Movegen gen,long b, X[] arr) {
		int bits = Long.bitCount(b);
		for (int j = 0; j < bits; j++) {
			int from = Long.numberOfTrailingZeros(b);
			b ^= 1L << from;
			arr[from].all(gen);
		}
	}
	
}

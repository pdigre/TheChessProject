package no.pdigre.chess.engine.evaluate;

import no.pdigre.chess.engine.base.IConst.BITS;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.base.Piece_Square_Tables;
import no.pdigre.chess.engine.fen.IPosition;

public class TacticEval implements IEvaluator {

	@Override
	public int score(IPosition pos, int last) {
		return _score(pos,last);
	}

	private int _score(IPosition pos, int last) {
		long bitmap = pos.getBitmap();
		int piece = BITS.getPiece(bitmap);
		int from = BITS.getFrom(bitmap);
		int to = BITS.getTo(bitmap);
		if (BITS.isCapture(bitmap)) {
			if(BITS.isEnpassant(bitmap)){
				int captured = BITS.getCaptured(bitmap);
				int to2 = BITS.white(bitmap)?(to-8):(to+8);
				int pVal = Piece_Square_Tables.pVal(to2, captured);
				last -= pVal;
			} else {
				int captured = BITS.getCaptured(bitmap);
				int pVal = Piece_Square_Tables.pVal(to, captured);
				last -= pVal;
			}
		}
		if (BITS.isPromotion(bitmap)){
			int vt = Piece_Square_Tables.pVal(to, piece);
			int vf = Piece_Square_Tables.pVal(from, BITS.white(bitmap)?IConst.WP:IConst.BP);
			return last + vt - vf;
		}
		if (piece == IConst.BK) {
			return last + Piece_Square_Tables.BKING_MIDDLE[to] - Piece_Square_Tables.BKING_MIDDLE[from];
		} else if (piece == IConst.WK) {
			int vto = Piece_Square_Tables.WKING_MIDDLE[to];
			int vfrom = Piece_Square_Tables.WKING_MIDDLE[from];
			return last + vto - vfrom;
		} else if (piece > 0) {
			int vt = Piece_Square_Tables.pVal(to, piece);
			int vf = Piece_Square_Tables.pVal(from, piece);
			return last + vt - vf;
		}
		return last;
	}

	public static final int value(final int type) {
		switch (type) {
		case IConst.WP:
			return 100;
		case IConst.WN:
			return 320;
		case IConst.WB:
			return 330;
		case IConst.WR:
			return 500;
		case IConst.WQ:
			return 900;
		case IConst.WK:
			return 20000;
		case IConst.BP:
			return -100;
		case IConst.BN:
			return -320;
		case IConst.BB:
			return -330;
		case IConst.BR:
			return -500;
		case IConst.BQ:
			return -900;
		case IConst.BK:
			return -20000;
		default:
			return 0;
		}
	}

	public static final int promoValue(final int type) {
		switch (type) {
		case IConst.WN:
			return 220;
		case IConst.WB:
			return 230;
		case IConst.WR:
			return 400;
		case IConst.WQ:
			return 800;
		case IConst.BN:
			return -220;
		case IConst.BB:
			return -230;
		case IConst.BR:
			return -400;
		case IConst.BQ:
			return -800;
		default:
			return 0;
		}
	}
}
package no.pdigre.chess.engine.base;

import static no.pdigre.chess.engine.base.IBase.BASE.inside;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MSlider extends MBase {

	MOVEDATA Q;
	MOVEDATA K;

	public MSlider(int from) {
		super(from);
	}

	public MOVEDATA[] slide(int type, int offset) {
		ArrayList<MOVEDATA> list = new ArrayList<MOVEDATA>();
		int to = from + offset;
		while (inside(to, to - offset)) {
			addSlide(type, list, to);
			to += offset;
		}
		return list.toArray(new MOVEDATA[list.size()]);
	}

	public void addSlide(int type, ArrayList<MOVEDATA> list, int to) {
		long bitmap = BITS.assemble(type, from, to, IConst.CASTLING_STATE | IConst.HALFMOVES);
		for (int i = 0; i < 5; i++) {
			if ((type & 8) > 0) {
				int c = WCAPTURES[i];
				long m = (purge(bitmap, PSQT.pVal(to, c))) | ((c & 7) << IBase._CAPTURE);
				list.add(MOVEDATA.create(m));
				if (c == IConst.BR) {
					if (to == IConst.BR_KING_STARTPOS){
						K=MOVEDATAX.create(bitmap & ~IConst.CANCASTLE_BLACKKING);
					} else if (to == IConst.BR_QUEEN_STARTPOS){
						Q=MOVEDATAX.create(bitmap & ~IConst.CANCASTLE_BLACKQUEEN);
					}
				}
			} else {
				int c = BCAPTURES[i];
				long m = (purge(bitmap, PSQT.pVal(to, c))) | ((c & 7) << IBase._CAPTURE);
				list.add(MOVEDATA.create(m));
				if (c == IConst.WR) {
					if (to == IConst.WR_KING_STARTPOS){
						K=MOVEDATAX.create(bitmap & ~IConst.CANCASTLE_WHITEKING);
					} else if (to == IConst.WR_QUEEN_STARTPOS){
						Q=MOVEDATAX.create(bitmap & ~IConst.CANCASTLE_WHITEQUEEN);
					}
				}
			}
		}
		list.add(MOVEDATA.create(bitmap));
	}

	public void bslide(Movegen gen, MOVEDATA[] m) {
		int i = 0;
		long occ = gen.bb_piece;
		while (i < m.length) {
			long bto = m[i + 5].bto;
			if ((occ & bto) != 0) {
				if ((gen.bb_white & bto) != 0)
					gen.add(m[i + gen.ctype(bto)]);
				break;
			} else {
				if(i==3 && bto==1L<<IConst.WR_KING_STARTPOS){
					gen.add(K);
				} else if(i==3 && bto==1L<<IConst.WR_QUEEN_STARTPOS){
					gen.add(Q);
				} else {
					gen.add(m[i + 5]);
				}
				i += 6;
			}
		}
	}

	public void wslide(Movegen gen, MOVEDATA[] m) {
		int i = 0;
		long occ = gen.bb_piece;
		while (i < m.length) {
			long bto = m[i + 5].bto;
			if ((occ & bto) != 0) {
				if ((gen.bb_black & bto) != 0)
					gen.add(m[i + gen.ctype(bto)]);
				break;
			} else {
				if(i==3 && bto==1L<<IConst.BR_KING_STARTPOS){
					gen.add(K);
				} else if(i==3 && bto==1L<<IConst.BR_QUEEN_STARTPOS){
					gen.add(Q);
				} else {
					gen.add(m[i + 5]);
				}
				i += 6;
			}
		}
	}

}

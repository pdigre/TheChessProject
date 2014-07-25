package no.pdigre.chess.engine.base;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MPWhite extends MBase{

	public MPWhite(int from) {
		super(from);
		{
			ArrayList<long[]> moves = new ArrayList<long[]>();
			int to = from + 8;
			if (to >= 56 && to < 64) {
				P1=new long[] { 
						BITS.assemblePromote(IConst.WP, IConst.WQ, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
						BITS.assemblePromote(IConst.WP, IConst.WR, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
						BITS.assemblePromote(IConst.WP, IConst.WN, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
						BITS.assemblePromote(IConst.WP, IConst.WB, from, to, IBase.CASTLING_STATE | IBase.SPECIAL) };
				moves.add(P1);
			} else if (from >= 8 && from < 16) {
				M1=BITS.assemble(IConst.WP, from, to, IBase.CASTLING_STATE);
				M2=BITS.assemble(IConst.WP, from, to + 8, IBase.CASTLING_STATE);
				moves.add(new long[] { M1, M2 });
			} else if (to < 64) {
				M1=BITS.assemble(IConst.WP, from, to, IBase.CASTLING_STATE);
				moves.add(new long[] { M1 });
			}
			M = IBase.BASE.toArray2(moves);
		}

		{
			ArrayList<Long> list = new ArrayList<Long>();
			int x = from & 7;
			// LEFT
			if (x != 0){
				int to=from + 7;
				if(to<56){
					CL=BITS.assemble(IConst.WP, from, to, IBase.CASTLING_STATE);
					list.add(CL);
				} else if (to >= 56 && to < 64) {
					PL=new long[]{
					BITS.assemblePromote(IConst.WP, IConst.WQ, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
					BITS.assemblePromote(IConst.WP, IConst.WR, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
					BITS.assemblePromote(IConst.WP, IConst.WN, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
					BITS.assemblePromote(IConst.WP, IConst.WB, from, to, IBase.CASTLING_STATE | IBase.SPECIAL)};
					for (int i = 0; i < PL.length; i++)
						list.add(PL[i]);
				}
			}
			// RIGHT
			if (x != 7) {
				int to = from + 9;
				if(to<56){
				    CR=BITS.assemble(IConst.WP, from, to, IBase.CASTLING_STATE);
					list.add(CR);
				} else if (to >= 56 && to < 64) {
					PR=new long[]{
					BITS.assemblePromote(IConst.WP, IConst.WQ, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
					BITS.assemblePromote(IConst.WP, IConst.WR, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
					BITS.assemblePromote(IConst.WP, IConst.WN, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
					BITS.assemblePromote(IConst.WP, IConst.WB, from, to, IBase.CASTLING_STATE | IBase.SPECIAL)};
					for (int i = 0; i < PR.length; i++)
						list.add(PR[i]);
				}
			}
			C = new long[list.size()];
			for (int i = 0; i < C.length; i++) {
				C[i]=list.get(i);
			}
		}
	}
	
	final long[][] M;
	final long[] C;

	long CL;	// Capture Left
	long CR;	// Capture right
	long EL2;  // Enpassant left
	long ER2;  // Enpassant right
	long M1;   // Move 1
	long M2;   // Move 2
	long[] P1;   // Promotion
	long[] PL;   // Promotion Capture Left
	long[] PR;   // Promotion Capture Right
	
	
	
	
	@Override
	public void all(GNodegen gen) {
		for (long[] slides : M)
			for (int i = 0; i < slides.length && pawnSlide(gen,slides[i]); i++)
				;
		for (long bitmap : C) {
			int to = BITS.getTo(bitmap);
			if (gen.enpassant == to) {
				add(gen,(purge(bitmap, PSQT.pVal(to - 8, IConst.BP)) & gen.castling) | (IConst.WP << IConst._CAPTURE) | IConst.SPECIAL);
			} else {
				long bto = 1L << to;
				if ((gen.bb_black & bto) != 0) {
					int type = type(gen,bto);
					add(gen,(purge(bitmap, PSQT.pVal(to, type + 8)) & gen.castling) | (type << IConst._CAPTURE));
				}
			}
		}
		gen.pruneWhite();
	}

	public static <X extends MBase> void genMoves(GNodegen gen,long b, X[] arr) {
		int bits = Long.bitCount(b);
		for (int j = 0; j < bits; j++) {
			int from = Long.numberOfTrailingZeros(b);
			b ^= 1L << from;
			arr[from].all(gen);
		}
		// Move 1 - check for ~(any piece shift -8)
		// Move 2 - only remainder row 2 ~(any piece shift another -8)
		// Left   - (black + ENP remove col 8)shift -7, OR 
		// Right  - (black + ENP remove col 1)shift -9, OR 
		
		// LSB each - lookup [from]
		
	}

}

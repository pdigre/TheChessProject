package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IBase.MOVEDATA;
import no.pdigre.chess.engine.base.IConst.BITS;

public class MPWhite extends MBase{

	public MPWhite(int from) {
		super(from);
		if(from>7 && from < 56){
			if (from < 48) {
				M1=BITS.assemble(IConst.WP, from, from + 8, IBase.CASTLING_STATE);
				if(from < 16)
					M2=BITS.assemble(IConst.WP, from, from + 16, IBase.CASTLING_STATE);
			} else {
				int to=from + 8;
				P1=new long[] { 
						BITS.assemblePromote(IConst.WP, IConst.WQ, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
						BITS.assemblePromote(IConst.WP, IConst.WR, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
						BITS.assemblePromote(IConst.WP, IConst.WN, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
						BITS.assemblePromote(IConst.WP, IConst.WB, from, to, IBase.CASTLING_STATE | IBase.SPECIAL) };
			}
			int x = from & 7;
			// LEFT
			if (x != 0){
				int to=from + 7;
				if(from<48){
					IBase.REV[to].RPW |= (1L << from);
					CL=BITS.assemble(IConst.WP, from, to, IBase.CASTLING_STATE);
				} else {
					IBase.REV[to].RPW |= (1L << from);
					PL=new long[]{
					BITS.assemblePromote(IConst.WP, IConst.WQ, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
					BITS.assemblePromote(IConst.WP, IConst.WR, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
					BITS.assemblePromote(IConst.WP, IConst.WN, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
					BITS.assemblePromote(IConst.WP, IConst.WB, from, to, IBase.CASTLING_STATE | IBase.SPECIAL)};
				}
			}
			// RIGHT
			if (x != 7) {
				int to = from + 9;
				if(from<48){
					IBase.REV[to].RPW |= (1L << from);
				    CR=BITS.assemble(IConst.WP, from, to, IBase.CASTLING_STATE);
				} else {
					IBase.REV[to].RPW |= (1L << from);
					PR=new long[]{
					BITS.assemblePromote(IConst.WP, IConst.WQ, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
					BITS.assemblePromote(IConst.WP, IConst.WR, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
					BITS.assemblePromote(IConst.WP, IConst.WN, from, to, IBase.CASTLING_STATE | IBase.SPECIAL),
					BITS.assemblePromote(IConst.WP, IConst.WB, from, to, IBase.CASTLING_STATE | IBase.SPECIAL)};
				}
			}
		}
	}
	
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
	public void all(Movegen gen) {
		try {
			int x = from & 7;
			// Left
			if (x != 0){
				int to = from + 7;
				if (gen.enpassant == to) {
					add(gen,(purge(CL, PSQT.pVal(to - 8, IConst.BP)) & gen.castling) | (IConst.WP << IConst._CAPTURE) | IConst.SPECIAL);
				} else {
					long bto = 1L << to;
					if ((gen.bb_black & bto) != 0) {
						int type = type(gen,bto);
						if(from<48){
							add(gen,(purge(CL, PSQT.pVal(to, type + 8)) & gen.castling) | (type << IConst._CAPTURE));
						} else {
							add(gen,(purge(PL[0], PSQT.pVal(to, type + 8)) & gen.castling) | (type << IConst._CAPTURE));
							add(gen,(purge(PL[1], PSQT.pVal(to, type + 8)) & gen.castling) | (type << IConst._CAPTURE));
							add(gen,(purge(PL[2], PSQT.pVal(to, type + 8)) & gen.castling) | (type << IConst._CAPTURE));
							add(gen,(purge(PL[3], PSQT.pVal(to, type + 8)) & gen.castling) | (type << IConst._CAPTURE));
						}
					}
				}
			}
			
			
			// Right
			if (x != 7){
				int to = from+9;
				if (gen.enpassant == to) {
					add(gen,(purge(CR, PSQT.pVal(to - 8, IConst.BP)) & gen.castling) | (IConst.WP << IConst._CAPTURE) | IConst.SPECIAL);
				} else {
					long bto = 1L << to;
					if ((gen.bb_black & bto) != 0) {
						int type = type(gen,bto);
						if(from<48){
							add(gen,(purge(CR, PSQT.pVal(to, type + 8)) & gen.castling) | (type << IConst._CAPTURE));
						} else {
							add(gen,(purge(PR[0], PSQT.pVal(to, type + 8)) & gen.castling) | (type << IConst._CAPTURE));
							add(gen,(purge(PR[1], PSQT.pVal(to, type + 8)) & gen.castling) | (type << IConst._CAPTURE));
							add(gen,(purge(PR[2], PSQT.pVal(to, type + 8)) & gen.castling) | (type << IConst._CAPTURE));
							add(gen,(purge(PR[3], PSQT.pVal(to, type + 8)) & gen.castling) | (type << IConst._CAPTURE));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		gen.pruneWhite();
	}

	public static <X extends MBase> void genMoves(Movegen gen,long b, X[] arr) {
		long e1=~(gen.bb_piece>>8);
		long e2=e1>>8;
		long b1=b&e1;
		long b2=b1&0xFF00L&e2;
		{
			int bits = Long.bitCount(b1);
			for (int j = 0; j < bits; j++) {
				int from = Long.numberOfTrailingZeros(b1);
				b1 ^= 1L << from;
				if(from>47){
					gen.moves[gen.imoves++] = new MOVEDATA(((MPWhite)arr[from]).P1[0] & gen.castling);
					gen.moves[gen.imoves++] = new MOVEDATA(((MPWhite)arr[from]).P1[1] & gen.castling);
					gen.moves[gen.imoves++] = new MOVEDATA(((MPWhite)arr[from]).P1[2] & gen.castling);
					gen.moves[gen.imoves++] = new MOVEDATA(((MPWhite)arr[from]).P1[3] & gen.castling);
				} else {
					gen.moves[gen.imoves++] = new MOVEDATA(((MPWhite)arr[from]).M1 & gen.castling);
				}
			}
		}
		{
			int bits = Long.bitCount(b2);
			for (int j = 0; j < bits; j++) {
				int from = Long.numberOfTrailingZeros(b2);
				b2 ^= 1L << from;
				gen.moves[gen.imoves++] = new MOVEDATA(((MPWhite)arr[from]).M2 & gen.castling);
			}
		}
		
							
		int bits = Long.bitCount(b);
		for (int j = 0; j < bits; j++) {
			int from = Long.numberOfTrailingZeros(b);
			b ^= 1L << from;
			arr[from].all(gen);
		}
		gen.pruneWhite();
		// Move 1 - check for ~(any piece shift -8)
		// Move 2 - only remainder row 2 ~(any piece shift another -8)
		// Left   - (black + ENP remove col 8)shift -7, OR 
		// Right  - (black + ENP remove col 1)shift -9, OR 
		
		// LSB each - lookup [from]
		
	}

}

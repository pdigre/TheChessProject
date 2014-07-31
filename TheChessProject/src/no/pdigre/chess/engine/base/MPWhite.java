package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MPWhite extends MBase{

	long[] CL;	// Capture Left
	long[] CR;	// Capture right
	long EL;  // Enpassant left
	long ER;  // Enpassant right
	long M1;   // Move 1
	long M2;   // Move 2
	long[] P1;   // Promotion
	long[] PL;   // Promotion Capture Left
	long[] PR;   // Promotion Capture Right
	
	public MPWhite(int from) {
		super(from);
		if(from>7 && from < 56){
			if (from < 48) {
				M1=move(from + 8);
				if(from < 16)
					M2=move(from + 16);
			} else {
				P1=promotes(from + 8);
			}
			int x = from & 7;
			// LEFT
			if (x != 0){
				int to=from + 7;
				if(from>47){
					IBase.REV[to].RPW |= (1L << from);
					PL=cpromotes(to);
				} else {
					IBase.REV[to].RPW |= (1L << from);
					CL=captures(to);
					if(from > 31 && from < 40)
						EL=enpassant(to);
				}
			}
			// RIGHT
			if (x != 7) {
				int to = from + 9;
				if(from>47){
					IBase.REV[to].RPW |= (1L << from);
					PR=cpromotes(to);
				} else {
					IBase.REV[to].RPW |= (1L << from);
				    CR=captures(to);
					if(from > 31 && from < 40)
						ER=enpassant(to);
				}
			}
		}
	}

	private long move(int to) {
		return BITS.assemble(IConst.WP, from, to, IBase.CASTLING_STATE);
	}

	private long enpassant(int to) {
		return purge(BITS.assemble(IConst.WP, from, to, IBase.CASTLING_STATE),PSQT.pVal(to - 8, IConst.BP)) | (IConst.WP << IConst._CAPTURE) | IConst.SPECIAL;
	}

	private long[] captures(int to) {
		long[] captures=new long[5];
		for (int c = 0; c < 5; c++) {
			long base = BITS.assemble(IConst.WP, from, to, IBase.CASTLING_STATE);
			int cval = PSQT.pVal(to,WCAPTURES[c]);
			captures[c]=purge(base, cval) | ((WCAPTURES[c] & 7) << IConst._CAPTURE);;
		}
		return captures;
	}

	private long[] promotes(int to) {
		long[] promotes=new long[4];
		for (int p = 0; p < 4; p++)
			promotes[p]=BITS.assemblePromote(IConst.WP, WPROMOTES[p], from, to, IBase.CASTLING_STATE | IBase.SPECIAL);
		return promotes;
	}

	private long[] cpromotes(int to) {
		long[] promotes=new long[20];
		for (int p = 0; p < 4; p++)
			for (int c = 0; c < 5; c++) {
				long base = BITS.assemblePromote(IConst.WP, WPROMOTES[p], from, to, IBase.CASTLING_STATE | IBase.SPECIAL);
				int cval = PSQT.pVal(to,WCAPTURES[c]);
				promotes[p*5+c]=purge(base, cval) | ((WCAPTURES[c] & 7) << IConst._CAPTURE);
			}
		return promotes;
	}

	private final static int getctype(int type) {
		return type>4?type-3:type-1;
	}

	@Override
	public void all(Movegen gen) {
	}

	public static <X extends MBase> void genMoves(final Movegen gen,long b, final X[] arr) {
		final MPWhite[] mp=(MPWhite[])arr;
		long occ=~(gen.bb_piece>>8);
		long m1=b&occ;
		new Adder(gen,m1) {

			@Override
			public void add(int from) {
				if(from>47){
					add(mp[from].P1[0]);
					add(mp[from].P1[1]);
					add(mp[from].P1[2]);
					add(mp[from].P1[3]);
				} else {
					add(mp[from].M1);
				}
			}
		};
		new Adder(gen,m1&0xFF00L&(occ>>8)) {

			@Override
			public void add(int from) {
				add(mp[from].M2);
			}
		};
		final int enp = gen.enpassant;
		long e=gen.bb_black|(1L<<enp);

		new Adder(gen,(b & ~0x0101010101010101L) &(e>>7)) {

			@Override
			public void add(int from) {
				int to=from+7;
				if (to == enp) {
					add(mp[from].EL);
				} else {
					int ctype=getctype(type(gen,1L << to));
					if(from<48){
						add(mp[from].CL[ctype]);
					} else {
						add(mp[from].PL[ctype]);
						add(mp[from].PL[ctype+5]);
						add(mp[from].PL[ctype+10]);
						add(mp[from].PL[ctype+15]);
					}
				}
			}
		};
		new Adder(gen,(b & ~0x8080808080808080L) &(e>>9)) {

			@Override
			public void add(int from) {
				int to=from+9;
				if (to == enp) {
					add(mp[from].ER);
				} else {
					int ctype=getctype(type(gen,1L << to));
					if(from<48){
						add(mp[from].CR[ctype]);
					} else {
						add(mp[from].PR[ctype]);
						add(mp[from].PR[ctype+5]);
						add(mp[from].PR[ctype+10]);
						add(mp[from].PR[ctype+15]);
					}
				}
			}
		};
		gen.pruneWhite();
	}
}

package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.base.IConst.BITS;

public class MPBlack  extends MBase{

	MOVEDATA[] CL;	// Capture Left
	MOVEDATA[] CR;	// Capture right
	MOVEDATA EL;  // Enpassant left
	MOVEDATA ER;  // Enpassant right
	MOVEDATA M1;   // Move 1
	MOVEDATA M2;   // Move 2
	MOVEDATA[] P1;   // Promotion
	MOVEDATA[] PL;   // Promotion Capture Left
	MOVEDATA[] PR;   // Promotion Capture Right

	public MPBlack(int from) {
		super(from);
		if(from>7 && from < 56){
			if (from > 15) {
				M1=move(from - 8);
				if(from > 47)
					M2=move(from - 16);
			} else {
				P1=promotes(from - 8);
			}
			int x = from & 7;
			// LEFT
			if (x != 0){
				int to=from - 9;
				IBase.REV[to].RPB |= (1L << from);
				if(from<16){
					PL=cpromotes(to);
				} else {
					CL=captures(to);
					if(from > 15 && from < 32)
						EL=enpassant(to);
				}
			}
			// RIGHT
			if (x != 7) {
				int to = from - 7;
				IBase.REV[to].RPB |= (1L << from);
				if(from<16){
					PR=cpromotes(to);
				} else {
				    CR=captures(to);
					if(from > 15 && from < 32)
						ER=enpassant(to);
				}
			}
		}
	}

	private MOVEDATA move(int to) {
		return MOVEDATA.create(BITS.assemble(IConst.BP, from, to, IBase.CASTLING_STATE));
	}

	private MOVEDATA enpassant(int to) {
		return MOVEDATA.create(purge(BITS.assemble(IConst.BP, from, to, IBase.CASTLING_STATE),PSQT.pVal(to + 8, IConst.WP)) | (IConst.WP << IConst._CAPTURE) | IConst.SPECIAL);
	}

	private MOVEDATA[] captures(int to) {
		MOVEDATA[] captures=new MOVEDATA[5];
		for (int c = 0; c < 5; c++) {
			long base = BITS.assemble(IConst.BP, from, to, IBase.CASTLING_STATE);
			int cval = PSQT.pVal(to,BCAPTURES[c]);
			captures[c]=MOVEDATA.create(purge(base, cval) | ((BCAPTURES[c] & 7) << IConst._CAPTURE));
		}
		return captures;
	}

	private MOVEDATA[] promotes(int to) {
		MOVEDATA[] promotes=new MOVEDATA[4];
		for (int p = 0; p < 4; p++)
			promotes[p]=MOVEDATA.create(BITS.assemblePromote(IConst.BP, BPROMOTES[p], from, to, IBase.CASTLING_STATE | IBase.SPECIAL));
		return promotes;
	}

	private MOVEDATA[] cpromotes(int to) {
		MOVEDATA[] promotes=new MOVEDATA[20];
		for (int p = 0; p < 4; p++)
			for (int c = 0; c < 5; c++) {
				long base = BITS.assemblePromote(IConst.BP, BPROMOTES[p], from, to, IBase.CASTLING_STATE | IBase.SPECIAL);
				int cval = PSQT.pVal(to,BCAPTURES[c]);
				promotes[p*5+c]=MOVEDATA.create(purge(base, cval) | ((BCAPTURES[c] & 7) << IConst._CAPTURE));
			}
		return promotes;
	}

	public static <X extends MBase> void genLegal(Movegen gen,long b, X[] arr) {
		final MPBlack[] mp=(MPBlack[])arr;
		long occ=~(gen.bb_piece<<8);
		long m1=b&occ;
		new Adder(gen,m1) {

			@Override
			public void add(int from) {
				if(from<16){
					add(mp[from].P1[0]);
					add(mp[from].P1[1]);
					add(mp[from].P1[2]);
					add(mp[from].P1[3]);
				} else {
					add(mp[from].M1);
				}
			}
		};
		new Adder(gen,m1&0x00FF000000000000L&(occ<<8)) {

			@Override
			public void add(int from) {
				add(mp[from].M2);
			}
		};
		
		final int enp = gen.enpassant;
		long e=gen.bb_white|(1L<<enp);

		new Adder(gen,(b & IConst.LEFTMASK) &(e<<9)) {

			@Override
			public void add(int from) {
				int to=from-9;
				if (to == enp) {
					MOVEDATA md=mp[from].EL;
					if(KingSafe.pos(gen.pos, md).isSafeBlack())
						add(md);
				} else {
					int ctype=gen.ctype(1L << to);
					if(from>15){
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
		new Adder(gen,(b & IConst.RIGHTMASK) &(e<<7)) {

			@Override
			public void add(int from) {
				int to=from-7;
				if (to == enp) {
					MOVEDATA md=mp[from].ER;
					if(KingSafe.pos(gen.pos, md).isSafeBlack())
						add(md);
				} else {
					int ctype=gen.ctype(1L << to);
					if(from>15){
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
	}
}

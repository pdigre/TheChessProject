package no.pdigre.chess.engine.base;

import java.util.Arrays;

import no.pdigre.chess.engine.base.IBase.BASE;
import no.pdigre.chess.engine.base.IBase.REVERSE;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.Position;

public class Movegen implements IConst{
	final Position pos;
	final long halfmoves;
	final long castling;
	final long bb_piece;
	final long bb_white;
	final long bb_black;
	final long bb_bit1;
	final long bb_bit2;
	final long bb_bit3;
	long pinned=0L;
	long checkers=0L;

	final int wking;
	final int bking;
	final public int enpassant;


	final MOVEDATA[] moves = new MOVEDATA[99];
	private int iAll = 0;
	private int iLegal = 0;
	private int iTested = 0;

	final void clear(){
		iLegal = 0;
		iTested = 0;
		iAll=0;
	}


	public Movegen(Position pos) {
		this.pos = pos;
		long inherit = pos.getBitmap();
		this.bb_black = pos.get64black();
		this.bb_bit1 = pos.get64bit1();
		this.bb_bit2 = pos.get64bit2();
		this.bb_bit3 = pos.get64bit3();
		this.bb_piece = bb_bit1 | bb_bit2 | bb_bit3;
		this.bb_white = bb_piece ^ bb_black;
		this.enpassant = BITS.getEnpassant(inherit);
		this.wking = pos.getWKpos();
		this.bking = pos.getBKpos();
		halfmoves = (BITS.halfMoves(inherit) + 1) << _HALFMOVES;
		castling = ~CASTLING_STATE | inherit; // all other are set
	}

	final public void pruneBlack() {
	}
	final public void pruneBlack3() {
		while (iTested < iAll) {
			MOVEDATA md = moves[iTested++];
			if (!KingSafe.pos(pos,md).isSafeBlack())
				moves[iLegal++]=md;
		}
		iAll=iLegal;
		iTested=iLegal;
	}

	final public void pruneBlack2() {
		while (iTested < iAll) {
			MOVEDATA md = moves[iTested++];
			if (!KingSafe.pos(pos,md).isSafeBlack()){
				moves[iLegal++]=md;
			} else {
				KingSafe p = KingSafe.pos(pos,md);
				boolean safeBlack = p.isSafeBlack();
				System.out.println("ERROR"+safeBlack);
			}
		}
		iAll=iLegal;
		iTested=iLegal;
	}

	final public void pruneWhite() {
		
	}
	final public void pruneWhite2() {
		while (iTested < iAll) {
			MOVEDATA md = moves[iTested++];
			if (!KingSafe.pos(pos,md).isSafeWhite()){
				moves[iLegal++]=md;
			} else {
				System.out.println("ERROR");
			}
		}
		iAll=iLegal;
		iTested=iLegal;
	}

	final public void pruneWhite3() {
		while (iTested < iAll) {
			MOVEDATA md = moves[iTested++];
			if (!KingSafe.pos(pos,md).isSafeWhite()){
				moves[iLegal++]=md;
			}
		}
		iAll=iLegal;
		iTested=iLegal;
	}

	final public void pruneSkip() {
		iLegal=iAll;
		iTested=iAll;
	}

	final void add(MOVEDATA md) {
		moves[iAll++] = md;
	}
	
	final void addkw(MOVEDATA md) {
		if(!KingSafe.pos(pos,md).isSafeWhite(BITS.getTo(md.bitmap)))
			moves[iAll++] = md;
	}
	
	final void addkb(MOVEDATA md) {
		if(!KingSafe.pos(pos,md).isSafeBlack(BITS.getTo(md.bitmap)))
			moves[iAll++] = md;
	}
	
	final void add2(MOVEDATA data) {
		if(data!=null)
			moves[iAll++] = data;
	}

	final int type(long bit) {
		return ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4);
	}
	
	final int ctype(long bit) {
		return ((bb_bit1 & bit) == 0 ? 0 : 1) + ((bb_bit2 & bit) == 0 ? 0 : 2) + ((bb_bit3 & bit) == 0 ? 0 : 2) - 1;
	}
	

	public static MOVEDATA[] legalmoves(Position pos) {
		return new Movegen(pos).legalmoves();
	}
	
	final public void evasive(boolean isWhite,long t) {
		if (isWhite) {
			MPWhite.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.WP);
			MNWhite.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.WN);
			MBWhite.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.WB);
			MRWhite.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WR);
			MQWhite.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WQ);
			pruneWhite3();
			BASE.WK[wking].genLegal(this);
		} else {
			MPBlack.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.BP);
			MNBlack.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.BN);
			MBBlack.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.BB);
			MRBlack.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BR);
			MQBlack.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BQ);
			pruneBlack3();
			BASE.BK[bking].genLegal(this);
		}
	}

	final public MOVEDATA[] legalmoves() {
		// Calculate checkers and pinners
		boolean isWhite = pos.whiteNext();
		long own = isWhite?bb_white:bb_black;
		long enemy = isWhite?bb_black:bb_white;
		int king=isWhite?wking:bking;
		REVERSE rev = IBase.REV[king];
		checkers=0L;
		pinned=0L;
		checkers|=(~bb_bit1 & bb_bit2 & ~bb_bit3 & enemy) & rev.RN; // Knight
		checkers|=(bb_bit1 & ~bb_bit2 & ~bb_bit3 & enemy) & (isWhite?rev.RPB:rev.RPW); // Pawn
		long eslider=bb_bit3 & enemy; // Sliders
		if((eslider & rev.RQ) !=0){
			pinnedSliders(king, own, bb_bit1 & eslider & rev.RB,false,isWhite);
			pinnedSliders(king, own, bb_bit2 & eslider & rev.RR,true,isWhite);
		}
		if(checkers!=0L){
			clear(); // not interested in pinned moves for evasive moves
			evasive(isWhite,own);
		} else {
			nonevasive(isWhite, own & ~pinned);
		}
		MOVEDATA[] t = Arrays.copyOfRange(moves, 0, iLegal);
		clear();
		return t;
	}

	private void nonevasive(boolean isWhite, long t) {
		if (isWhite) {
			MPWhite.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.WP);
			MNWhite.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.WN);
			MBWhite.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.WB);
			MRWhite.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WR);
			MQWhite.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WQ);
			int before=iAll;
			pruneWhite2();
			int after=iAll;
			if(before!=after){
				System.out.println("Error");
			}
			BASE.WK[wking].genLegal(this);
		} else {
			MPBlack.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.BP);
			MNBlack.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.BN);
			MBBlack.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.BB);
			MRBlack.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BR);
			MQBlack.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BQ);
			int before=iAll;
			pruneBlack2();
			int after=iAll;
			if(before!=after){
				System.out.println("Error");
			}
			BASE.BK[bking].genLegal(this);
		}
	}

	private void pinnedSliders(int king, long own, long attackers,boolean isLine,boolean isWhite) {
		if (attackers != 0) {
			int bits = Long.bitCount(attackers);
			for (int j = 0; j < bits; j++) {
				int from = Long.numberOfTrailingZeros(attackers);
				long attacker = 1L << from;
				attackers ^= attacker;
				long between = IBase.BETWEEN[from+64*king];
				long bpcs = between&bb_piece;
				if(bpcs==0L){
					checkers|=attacker;
				} else if(Long.bitCount(bpcs)==1){
					// check for slide moves
					long pinner = between&own;
					pinned|=pinner;
					if(isLine){
						if((pinner&bb_bit2&bb_bit3)!=0){		// ROOK / QUEEN
							boolean isQueen=(pinner&bb_bit1)!=0;
							if(isQueen){
								if(isWhite){
									pinnedSlide(BASE.WQ[from].U,attacker,between);
									pinnedSlide(BASE.WQ[from].D,attacker,between);
									pinnedSlide(BASE.WQ[from].L,attacker,between);
									pinnedSlide(BASE.WQ[from].R,attacker,between);
								} else {
									pinnedSlide(BASE.BQ[from].U,attacker,between);
									pinnedSlide(BASE.BQ[from].D,attacker,between);
									pinnedSlide(BASE.BQ[from].L,attacker,between);
									pinnedSlide(BASE.BQ[from].R,attacker,between);
								}
							} else {
								if(isWhite){
									pinnedSlide(BASE.WR[from].U,attacker,between);
									pinnedSlide(BASE.WR[from].D,attacker,between);
									pinnedSlide(BASE.WR[from].L,attacker,between);
									pinnedSlide(BASE.WR[from].R,attacker,between);
								} else {
									pinnedSlide(BASE.BR[from].U,attacker,between);
									pinnedSlide(BASE.BR[from].D,attacker,between);
									pinnedSlide(BASE.BR[from].L,attacker,between);
									pinnedSlide(BASE.BR[from].R,attacker,between);
								}
							}
						} else if((pinner&bb_bit1&~bb_bit2&~bb_bit3)!=0){  // PAWN FORWARD
							if(isWhite){
								if(((pinner<<8)&between)!=0){
									add2(BASE.WP[from].M1);
									if(((pinner<<16)&between)!=0)
										add2(BASE.WP[from].M2);
								}
							} else {
								if(((pinner>>8)&between)!=0){
									add2(BASE.BP[from].M1);
									if(((pinner>>16)&between)!=0)
										add2(BASE.BP[from].M2);
								}
							}
						}
					} else {
						if((pinner&bb_bit1&bb_bit3)!=0){	// BISHOP / QUEEN
							boolean isQueen=(pinner&bb_bit2)!=0;
							if(isQueen){
								if(isWhite){
									pinnedSlide(BASE.WQ[from].DL,attacker,between);
									pinnedSlide(BASE.WQ[from].DR,attacker,between);
									pinnedSlide(BASE.WQ[from].UL,attacker,between);
									pinnedSlide(BASE.WQ[from].UR,attacker,between);
								} else {
									pinnedSlide(BASE.BQ[from].DL,attacker,between);
									pinnedSlide(BASE.BQ[from].DR,attacker,between);
									pinnedSlide(BASE.BQ[from].UL,attacker,between);
									pinnedSlide(BASE.BQ[from].UR,attacker,between);
								}
							} else {
								if(isWhite){
									pinnedSlide(BASE.WB[from].DL,attacker,between);
									pinnedSlide(BASE.WB[from].DR,attacker,between);
									pinnedSlide(BASE.WB[from].UL,attacker,between);
									pinnedSlide(BASE.WB[from].UR,attacker,between);
								} else {
									pinnedSlide(BASE.BB[from].DL,attacker,between);
									pinnedSlide(BASE.BB[from].DR,attacker,between);
									pinnedSlide(BASE.BB[from].UL,attacker,between);
									pinnedSlide(BASE.BB[from].UR,attacker,between);
								}
							}
						} else if((pinner&bb_bit1&~bb_bit2&~bb_bit3)!=0){  // PAWN CAPTURE
							if(isWhite){
								if(pinner<<9==attacker) {
									MOVEDATA[] cl = BASE.WP[from].CL;
									if(cl!=null)
										add(cl[ctype(attacker)]);
								}
								if(pinner<<7==attacker) {
									MOVEDATA[] cr = BASE.WP[from].CR;
									if(cr!=null)
										add(cr[ctype(attacker)]);
								}
							} else {
								if(pinner>>9==attacker) {
									MOVEDATA[] cl = BASE.BP[from].CL;
									if(cl!=null)
										add(cl[ctype(attacker)]);
								}
								if(pinner>>7==attacker) {
									MOVEDATA[] cr = BASE.BP[from].CR;
									if(cr!=null)
										add(cr[ctype(attacker)]);
								}
							}
						}
					}
				}
			}
		}
	}

	private void pinnedSlide(MOVEDATA[] m,long attacker,long between) {
		int i = 0;
		while (i < m.length) {
			long bto = m[i + 5].bto;
			if((between&bto)!=0){
				add(m[i + 5]);
				i += 6;
				continue;
			}
			if ((attacker & bto) != 0) {
				int ctype = ctype(bto);
				add(m[i + ctype]);
			}
			break;
		}
	}
	
	final public MOVEDATA[] quiesce() {
		if (pos.whiteNext()) {
			MPWhite.genLegal(this,bb_white & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.WP);
			MNWhite.genLegal(this,bb_white & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.WN);
			MBWhite.genLegal(this,bb_white & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.WB);
			MRWhite.genLegal(this,bb_white & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WR);
			MQWhite.genLegal(this,bb_white & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WQ);
			BASE.WK[wking].genLegal(this);
		} else {
			MPBlack.genLegal(this,bb_black & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.BP);
			MNBlack.genLegal(this,bb_black & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.BN);
			MBBlack.genLegal(this,bb_black & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.BB);
			MRBlack.genLegal(this,bb_black & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BR);
			MQBlack.genLegal(this,bb_black & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BQ);
			BASE.BK[bking].genLegal(this);
		}
		MOVEDATA[] t = Arrays.copyOfRange(moves, 0, iLegal);
		clear();
		return t;
	}

	@Override
	public String toString() {
		return FEN.addHorizontal(FEN.addHorizontal(pos.toString(), FEN.board2string(pinned)), FEN.board2string(checkers));
	}

}

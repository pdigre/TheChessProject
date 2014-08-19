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

	final void add(MOVEDATA md) {
		moves[iAll++] = md;
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
	
	final public MOVEDATA[] legalmoves() {
		// Calculate checkers and pinners
		final boolean isWhite = pos.whiteNext();
		final long own = isWhite?bb_white:bb_black;
		final long enemy = isWhite?bb_black:bb_white;
		final int king=isWhite?wking:bking;
		REVERSE rev = IBase.REV[king];
		pinned=0L;
		final long regular = ~bb_bit3 & enemy;
		checkers=regular & ((~bb_bit1 & bb_bit2 & rev.RN) | (bb_bit1 & ~bb_bit2 & (isWhite?rev.RPB:rev.RPW)));
		long eslider=bb_bit3 & enemy; // Sliders
		if(checkers==0L && (eslider & rev.RQ) !=0){
			long attackers = bb_bit1 & eslider & rev.RB;
			if (attackers != 0L) {
				int bits = Long.bitCount(attackers);
				for (int j = 0; j < bits; j++) {
					int asq = Long.numberOfTrailingZeros(attackers);
					long attacker = 1L << asq;
					attackers ^= attacker;
					long between = IBase.BETWEEN[asq+64*king];
					long bpcs = between&bb_piece;
					if(bpcs==0L){
						checkers|=attacker;
					} else if(Long.bitCount(bpcs)==1){
						// check for slide moves
						long pinner = between&own;
						int from = Long.numberOfTrailingZeros(pinner);
						pinned|=pinner;
						if((pinner&bb_bit1&bb_bit3)!=0){	// BISHOP / QUEEN
							if((pinner&bb_bit2)!=0){  	// QUEEN
								slide(isWhite?BASE.WQ[from].DIAG:BASE.BQ[from].DIAG,attacker,between);
							} else {
								slide(isWhite?BASE.WB[from].DIAG:BASE.BB[from].DIAG,attacker,between);
							}
						} else if((pinner&bb_bit1&~bb_bit2&~bb_bit3)!=0){  // PAWN CAPTURE
							if(isWhite){
								if(pinner<<7==attacker && (attacker&IConst.RIGHTLANE)==0)
									moves[iAll++] = BASE.WP[from].CL[ctype(attacker)];
								if(pinner<<9==attacker && (attacker&IConst.LEFTLANE)==0)
									moves[iAll++] = BASE.WP[from].CR[ctype(attacker)];
							} else {
								if(pinner>>9==attacker && (attacker&IConst.RIGHTLANE)==0)
									moves[iAll++] = BASE.BP[from].CL[ctype(attacker)];
								if(pinner>>7==attacker && (attacker&IConst.LEFTLANE)==0)
									moves[iAll++] = BASE.BP[from].CR[ctype(attacker)];
							}
						}
					}
				}
			}
			attackers = bb_bit2 & eslider & rev.RR;
			if (checkers==0L && attackers != 0L) {
				int bits = Long.bitCount(attackers);
				for (int j = 0; j < bits; j++) {
					int asq = Long.numberOfTrailingZeros(attackers);
					long attacker = 1L << asq;
					attackers ^= attacker;
					long between = IBase.BETWEEN[asq+64*king];
					long bpcs = between&bb_piece;
					if(bpcs==0L){
						checkers|=attacker;
					} else if(Long.bitCount(bpcs)==1){
						// check for slide moves
						long pinner = between&own;
						int from = Long.numberOfTrailingZeros(pinner);
						pinned|=pinner;
						if((pinner&bb_bit2&bb_bit3)!=0){		// ROOK / QUEEN
							if((pinner&bb_bit1)!=0){	// QUEEN
								slide(isWhite?BASE.WQ[from].LINE:BASE.BQ[from].LINE,attacker,between);
							} else {
								slide(isWhite?BASE.WR[from].LINE:BASE.BR[from].LINE,attacker,between);
							}
						} else if((pinner&bb_bit1&~bb_bit2&~bb_bit3)!=0){  // PAWN FORWARD
							if(isWhite){
								if(((pinner<<8)&between)!=0){
									moves[iAll++] = BASE.WP[from].M1;
									if(from<16 && ((pinner<<16)&between)!=0)
										moves[iAll++] = BASE.WP[from].M2;
								}
							} else {
								if(((pinner>>8)&between)!=0){
									moves[iAll++] = BASE.BP[from].M1;
									if(from>47 && ((pinner>>16)&between)!=0)
										moves[iAll++] = BASE.BP[from].M2;
								}
							}
						}
					}
				}
			}
		}
		if(checkers==0L){
			nonevasive(isWhite, king,own & ~pinned);
		} else {
			clear(); // not interested in pinned moves for evasive moves
			evasive(isWhite,king,own);
		}
		MOVEDATA[] t = Arrays.copyOfRange(moves, 0, iAll);
		clear();
		return t;
	}

	final public void evasive(boolean isWhite,int king, long t) {
		if (isWhite) {
			MPWhite.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.WP);
			MNWhite.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.WN);
			MBWhite.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.WB);
			MRWhite.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WR);
			MQWhite.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WQ);
			while (iTested < iAll) {
				MOVEDATA md = moves[iTested++];
				if (KingSafe.pos(pos,md).isSafeWhite()){
					moves[iLegal++]=md;
				}
			}
			iAll=iLegal;
			BASE.WK[king].genLegal(this);
		} else {
			MPBlack.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.BP);
			MNBlack.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.BN);
			MBBlack.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.BB);
			MRBlack.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BR);
			MQBlack.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BQ);
			while (iTested < iAll) {
				MOVEDATA md = moves[iTested++];
				if (KingSafe.pos(pos,md).isSafeBlack())
					moves[iLegal++]=md;
			}
			iAll=iLegal;
			BASE.BK[king].genLegal(this);
		}
	}

	private void nonevasive(boolean isWhite,int king, long t) {
		if (isWhite) {
			MPWhite.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.WP);
			MNWhite.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.WN);
			MBWhite.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.WB);
			MRWhite.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WR);
			MQWhite.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WQ);
			BASE.WK[king].genLegal(this);
//			while (iTested < iAll) {
//				MOVEDATA md = moves[iTested++];
//				KingSafe p = KingSafe.pos(pos,md);
//				if (!p.isSafeWhite()){
//					boolean s = p.isSafeWhite();
//					System.out.println("ERROR");
//				}
//			}
		} else {
			MPBlack.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.BP);
			MNBlack.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.BN);
			MBBlack.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.BB);
			MRBlack.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BR);
			MQBlack.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BQ);
			BASE.BK[king].genLegal(this);
//			while (iTested < iAll) {
//				MOVEDATA md = moves[iTested++];
//				KingSafe p = KingSafe.pos(pos,md);
//				if (!p.isSafeBlack()){
//					boolean s = p.isSafeBlack();
//					System.out.println("ERROR");
//				}
//			}
		}
	}

	private void slide(MOVEDATA[][] mm,long attacker,long between) {
		for (MOVEDATA[] m : mm) {
			int i = 0;
			while (i < m.length) {
				long bto = m[i + 5].bto;
				if((between&bto)!=0){
					moves[iAll++] = m[i + 5];
					i += 6;
					continue;
				}
				if ((attacker & bto) != 0)
					moves[iAll++] = m[i + ctype(bto)];
				break;
			}
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

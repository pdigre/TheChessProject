package no.pdigre.chess.engine.base;

import java.util.Arrays;

import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.Position;

public class Movegen implements IConst{
	Position pos;
	Movegen parent;
	long halfmoves;
	long castling;
	long bb_piece;
	long bb_white;
	long bb_black;
	long bb_bit1;
	long bb_bit2;
	long bb_bit3;
	long pinned=0L;
	long checkers=0L;

	int wking;
	int bking;
	public int enpassant;


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
		setPos(pos);
	}

	public Movegen() {
	}

	public void setPos(Position pos) {
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
	
	final public MOVEDATA[] legalmoves() {
		clear();
		// Calculate checkers and pinners
		final boolean isWhite = pos.whiteNext();
		final long own = isWhite?bb_white:bb_black;
		final long enemy = isWhite?bb_black:bb_white;
		final int king=isWhite?wking:bking;
		SQATK rev = BASE.REV[king];
		pinned=0L;
		final long regular = ~bb_bit3 & enemy;
		checkers=regular & ((~bb_bit1 & bb_bit2 & rev.RN) | (bb_bit1 & ~bb_bit2 & (isWhite?MBP.REV[king]:MWP.REV[king])));
		long eslider=bb_bit3 & enemy; // Sliders
		if(checkers==0L && (eslider & rev.RQ) !=0){
			long attackers = bb_bit1 & eslider & rev.RB;
			if (attackers != 0L) {
				int bits = Long.bitCount(attackers);
				for (int j = 0; j < bits; j++) {
					int asq = Long.numberOfTrailingZeros(attackers);
					long attacker = 1L << asq;
					attackers ^= attacker;
					long between = BASE.BETWEEN[asq+64*king];
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
								slide(isWhite?MWQ.WQ[from].DIAG:MBQ.BQ[from].DIAG,attacker,between);
							} else {
								slide(isWhite?MWB.WB[from].DIAG:MBB.BB[from].DIAG,attacker,between);
							}
						} else if((pinner&bb_bit1&~bb_bit2&~bb_bit3)!=0){  // PAWN CAPTURE
							if(isWhite){
								if(pinner<<7==attacker && (attacker&IConst.RIGHTLANE)==0)
									moves[iAll++] = MWP.WP[from].CL[ctype(attacker)];
								if(pinner<<9==attacker && (attacker&IConst.LEFTLANE)==0)
									moves[iAll++] = MWP.WP[from].CR[ctype(attacker)];
							} else {
								if(pinner>>9==attacker && (attacker&IConst.RIGHTLANE)==0)
									moves[iAll++] = MBP.BP[from].CL[ctype(attacker)];
								if(pinner>>7==attacker && (attacker&IConst.LEFTLANE)==0)
									moves[iAll++] = MBP.BP[from].CR[ctype(attacker)];
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
					long between = BASE.BETWEEN[asq+64*king];
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
								slide(isWhite?MWQ.WQ[from].LINE:MBQ.BQ[from].LINE,attacker,between);
							} else {
								slide(isWhite?MWR.WR[from].LINE:MBR.BR[from].LINE,attacker,between);
							}
						} else if((pinner&bb_bit1&~bb_bit2&~bb_bit3)!=0){  // PAWN FORWARD
							if(isWhite){
								if(((pinner<<8)&between)!=0){
									moves[iAll++] = MWP.WP[from].M1;
									if(from<16 && ((pinner<<16)&between)!=0)
										moves[iAll++] = MWP.WP[from].M2;
								}
							} else {
								if(((pinner>>8)&between)!=0){
									moves[iAll++] = MBP.BP[from].M1;
									if(from>47 && ((pinner>>16)&between)!=0)
										moves[iAll++] = MBP.BP[from].M2;
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
		return Arrays.copyOfRange(moves, 0, iAll);
	}

	final public void evasive(boolean isWhite,int king, long t) {
		if (isWhite) {
			MWP.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), MWP.WP);
			MWN.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), MWN.WN);
			MWB.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), MWB.WB);
			MWR.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), MWR.WR);
			MWQ.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), MWQ.WQ);
			while (iTested < iAll) {
				MOVEDATA md = moves[iTested++];
				if (KingSafe.pos(pos,md).isSafeWhite()){
					moves[iLegal++]=md;
				}
			}
			iAll=iLegal;
			MWK.WK[king].genLegal(this);
		} else {
			MBP.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), MBP.BP);
			MBN.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), MBN.BN);
			MBB.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), MBB.BB);
			MBR.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), MBR.BR);
			MBQ.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), MBQ.BQ);
			while (iTested < iAll) {
				MOVEDATA md = moves[iTested++];
				if (KingSafe.pos(pos,md).isSafeBlack())
					moves[iLegal++]=md;
			}
			iAll=iLegal;
			MBK.BK[king].genLegal(this);
		}
	}

	private void nonevasive(boolean isWhite,int king, long t) {
		if (isWhite) {
			MWP.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), MWP.WP);
			MWN.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), MWN.WN);
			MWB.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), MWB.WB);
			MWR.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), MWR.WR);
			MWQ.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), MWQ.WQ);
			MWK.WK[king].genLegal(this);
			if(king==IConst.WK_STARTPOS)
				MWK.genCastling(this);
		} else {
			MBP.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), MBP.BP);
			MBN.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), MBN.BN);
			MBB.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), MBB.BB);
			MBR.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), MBR.BR);
			MBQ.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), MBQ.BQ);
			MBK.BK[king].genLegal(this);
			if(king==IConst.BK_STARTPOS)
				MBK.genCastling(this);
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
		clear();
		if (pos.whiteNext()) {
			MWP.genLegal(this,bb_white & (bb_bit1) & (~bb_bit2) & (~bb_bit3), MWP.WP);
			MWN.genLegal(this,bb_white & (~bb_bit1) & (bb_bit2) & (~bb_bit3), MWN.WN);
			MWB.genLegal(this,bb_white & (bb_bit1) & (~bb_bit2) & (bb_bit3), MWB.WB);
			MWR.genLegal(this,bb_white & (~bb_bit1) & (bb_bit2) & (bb_bit3), MWR.WR);
			MWQ.genLegal(this,bb_white & (bb_bit1) & (bb_bit2) & (bb_bit3), MWQ.WQ);
			MWK.WK[wking].genLegal(this);
		} else {
			MBP.genLegal(this,bb_black & (bb_bit1) & (~bb_bit2) & (~bb_bit3), MBP.BP);
			MBN.genLegal(this,bb_black & (~bb_bit1) & (bb_bit2) & (~bb_bit3), MBN.BN);
			MBB.genLegal(this,bb_black & (bb_bit1) & (~bb_bit2) & (bb_bit3), MBB.BB);
			MBR.genLegal(this,bb_black & (~bb_bit1) & (bb_bit2) & (bb_bit3), MBR.BR);
			MBQ.genLegal(this,bb_black & (bb_bit1) & (bb_bit2) & (bb_bit3), MBQ.BQ);
			MBK.BK[bking].genLegal(this);
		}
		return Arrays.copyOfRange(moves, 0, iLegal);
	}

	@Override
	public String toString() {
		return FEN.addHorizontal(FEN.addHorizontal(pos.toString(), FEN.board2string(pinned)), FEN.board2string(checkers));
	}

}

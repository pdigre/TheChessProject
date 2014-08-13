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

//	final long line_attack;
//	final long line_block;
//	final long line_mobile;
//	final long line_pinned;
//	final long diag_attack;
//	final long diag_block;
//	final long diag_mobile;
//	final long diag_pinned;
//
//	final long bb_check;	// pieces checking
//	final long bb_pinned;   // pieces that are blocking
	
	final MOVEDATA[] moves = new MOVEDATA[99];
	long[] pinnermoves = new long[64];
	private int iAll = 0;
	private int iLegal = 0;
	private int iTested = 0;

	final int wking;
	final int bking;
	final public int enpassant;


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
		
		// knights - cannot be blocked
		// Pawn - cannot be blocked
	    // Bishop/Queen map1
			// danger map - which enemy can potentially check
			// check map - which enemy pieces are checking the king
			// pinned map - which own pieces are blocking a check
		    // mobile map - moves until checking piece
		// Rook/Queen map2
			// danger map - which enemy can potentially check
			// check map - which enemy pieces are checking the king
			// pinned map - which own pieces are blocking a check
			// mobile map - moves until checking piece
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
				System.out.println("ERROR");
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
		if(!KingSafe.pos(pos,md).isSafeWhite())
			moves[iAll++] = md;
	}
	
	final void addkb(MOVEDATA md) {
		if(!KingSafe.pos(pos,md).isSafeBlack())
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
	
	final MOVEDATA[] getLegal(){
		MOVEDATA[] t = Arrays.copyOfRange(moves, 0, iLegal);
		iLegal = 0;
		iTested = 0;
		iAll=0;
		return t;
	}


	public static MOVEDATA[] nonevasive(Position pos) {
		return new Movegen(pos).nonevasive();
	}
	
	final public MOVEDATA[] nonevasive() {
		if (pos.whiteNext()) {
			findPinned(wking,bb_white,bb_black,true);
			long t=bb_white & ~pinned;
			MPWhite.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.WP);
			MNWhite.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.WN);
			MBWhite.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.WB);
			MRWhite.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WR);
			MQWhite.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WQ);
			BASE.WK[wking].genLegal(this);
			if(checkers==0L){
				int before=iAll;
				pruneWhite2();
				int after=iAll;
				if(before!=after){
					System.out.println("Error");
				}
			} else {
				pruneWhite3();
			}
		} else {
			findPinned(bking,bb_black,bb_white,false);
			long t=bb_black & ~pinned;
			MPBlack.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.BP);
			MNBlack.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.BN);
			MBBlack.genLegal(this,t & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.BB);
			MRBlack.genLegal(this,t & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BR);
			MQBlack.genLegal(this,t & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BQ);
			BASE.BK[bking].genLegal(this);
			if(checkers==0L){
				int before=iAll;
				pruneBlack2();
				int after=iAll;
				if(before!=after){
					System.out.println("Error");
				}
			} else {
				pruneBlack3();
			}
		}
		return getLegal();
	}

	private void findPinned(int king,long own,long enemy,boolean isWhite) {
		REVERSE rev = IBase.REV[king];
		checkers=0L;
		pinned=0L;
		// Knight
		checkers|=(~bb_bit1 & bb_bit2 & ~bb_bit3 & enemy) & rev.RN;
		// Pawn
		checkers|=(bb_bit1 & ~bb_bit2 & ~bb_bit3 & enemy) & (isWhite?rev.RPB:rev.RPW);
		// Sliders
		long eslider=bb_bit3 & enemy;
		if((eslider & rev.RQ) !=0){
			sliderStatus(king, own, bb_bit1 & eslider & rev.RB,false,isWhite);
			sliderStatus(king, own, bb_bit2 & eslider & rev.RR,true,isWhite);
		}
//		if(checkers!=0){
//			String brd = FEN.board2string(pos);
//			System.out.println("Checkers "+list(checkers));
//			System.out.println("hi");
//		}
//		if(pinned!=0){
//			String brd = FEN.board2string(pos);
//			System.out.println("Pinned "+list(pinned));
//			System.out.println("hi");
//		}
	}

	private String list(long pieces) {
		StringBuffer sb = new StringBuffer();
		int bits = Long.bitCount(pieces);
		for (int j = 0; j < bits; j++) {
			int from = Long.numberOfTrailingZeros(pieces);
			pieces ^= 1L << from;
			if(sb.length()>0)
				sb.append(" ");
			sb.append(FEN.pos2string(from));
		}
		return sb.toString();
	}

	private void sliderStatus(int king, long own, long attackers,boolean isLine,boolean isWhite) {
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
									slide(BASE.WQ[from].U,attacker,between);
									slide(BASE.WQ[from].D,attacker,between);
									slide(BASE.WQ[from].L,attacker,between);
									slide(BASE.WQ[from].R,attacker,between);
								} else {
									slide(BASE.BQ[from].U,attacker,between);
									slide(BASE.BQ[from].D,attacker,between);
									slide(BASE.BQ[from].L,attacker,between);
									slide(BASE.BQ[from].R,attacker,between);
								}
							} else {
								if(isWhite){
									slide(BASE.WR[from].U,attacker,between);
									slide(BASE.WR[from].D,attacker,between);
									slide(BASE.WR[from].L,attacker,between);
									slide(BASE.WR[from].R,attacker,between);
								} else {
									slide(BASE.BR[from].U,attacker,between);
									slide(BASE.BR[from].D,attacker,between);
									slide(BASE.BR[from].L,attacker,between);
									slide(BASE.BR[from].R,attacker,between);
								}
							}
//							System.out.println("diag slider " +FEN.pos2string(Long.numberOfTrailingZeros(pinner)));
//							System.out.println(FEN.board2string(pos));
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
//							System.out.println("pawn forward " +FEN.pos2string(Long.numberOfTrailingZeros(pinner)));
//							System.out.println(FEN.board2string(pos));
						}
					} else {
						if((pinner&bb_bit1&bb_bit3)!=0){	// BISHOP / QUEEN
							boolean isQueen=(pinner&bb_bit2)!=0;
							if(isQueen){
								if(isWhite){
									slide(BASE.WQ[from].DL,attacker,between);
									slide(BASE.WQ[from].DR,attacker,between);
									slide(BASE.WQ[from].UL,attacker,between);
									slide(BASE.WQ[from].UR,attacker,between);
								} else {
									slide(BASE.BQ[from].DL,attacker,between);
									slide(BASE.BQ[from].DR,attacker,between);
									slide(BASE.BQ[from].UL,attacker,between);
									slide(BASE.BQ[from].UR,attacker,between);
								}
							} else {
								if(isWhite){
									slide(BASE.WB[from].DL,attacker,between);
									slide(BASE.WB[from].DR,attacker,between);
									slide(BASE.WB[from].UL,attacker,between);
									slide(BASE.WB[from].UR,attacker,between);
								} else {
									slide(BASE.BB[from].DL,attacker,between);
									slide(BASE.BB[from].DR,attacker,between);
									slide(BASE.BB[from].UL,attacker,between);
									slide(BASE.BB[from].UR,attacker,between);
								}
							}
//							System.out.println("line slider " +FEN.pos2string(Long.numberOfTrailingZeros(pinner)));
//							System.out.println(FEN.board2string(pos));
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
//							System.out.println("pawn capture " +FEN.pos2string(Long.numberOfTrailingZeros(pinner)));
//							System.out.println(FEN.board2string(pos));
						}
					}
				}
			}
		}
	}

	public void slide(MOVEDATA[] m,long attacker,long between) {
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
		return getLegal();
	}

	@Override
	public String toString() {
		return pos.toString();
	}
}

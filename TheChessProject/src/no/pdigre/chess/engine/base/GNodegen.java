package no.pdigre.chess.engine.base;

import java.util.Arrays;

import no.pdigre.chess.engine.base.IBase.BASE;
import no.pdigre.chess.engine.base.IBase.MOVEDATA;
import no.pdigre.chess.engine.fen.Position64;

public class GNodegen implements IConst {

	final Position64 pos;
	final long halfmoves;
	final long castling;
	final long bb_piece;
	final long bb_white;
	final long bb_black;
	final long bb_bit1;
	final long bb_bit2;
	final long bb_bit3;
	final MOVEDATA[] moves = new MOVEDATA[99];
	int imoves = 0;
	final int wking;
	final int bking;
	final public int enpassant;

	private int n = 0;
	private int test = 0;
	private final Position64[] list = new Position64[99];

	GNodegen(Position64 pos) {
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

	final public Position64[] moves() {
		n = 0;
		test = 0;

		// *********************************************************************************************
		// *
		// *
		// *********************************************************************************************
		if (pos.whiteNext()) {
			MPWhite.genMoves(this,bb_white & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.WP);
			MBase.genMoves(this,bb_white & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.WN);
			MBase.genMoves(this,bb_white & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.WB);
			MBase.genMoves(this,bb_white & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WR);
			MBase.genMoves(this,bb_white & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WQ);
			BASE.WK[wking].all(this);
		} else {
			MBase.genMoves(this,bb_black & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.BP);
			MBase.genMoves(this,bb_black & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.BN);
			MBase.genMoves(this,bb_black & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.BB);
			MBase.genMoves(this,bb_black & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BR);
			MBase.genMoves(this,bb_black & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BQ);
			BASE.BK[bking].all(this);
		}
		Position64[] mvs = Arrays.copyOfRange(list, 0, n);
//		NodeGen.mergeSort(list, mvs, 0, n, 0);
		return mvs;
	}

	public void pruneBlack() {
		while (test < imoves) {
			Position64 next = moves[test++].move(pos);
			if (!next.isCheckBlack())
				list[n++] = next;
		}
	}

	public void pruneWhite() {
		while (test < imoves) {
			Position64 next = moves[test++].move(pos);
			if (!next.isCheckWhite())
				list[n++] = next;
		}
	}

}

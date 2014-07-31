package no.pdigre.chess.engine.base;

import java.util.Arrays;

import no.pdigre.chess.engine.base.IBase.BASE;
import no.pdigre.chess.engine.fen.Position64;

public class GMovegenQ extends Movegen {

	GMovegenQ(Position64 pos) {
		super(pos);
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
}

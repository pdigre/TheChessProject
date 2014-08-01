package no.pdigre.chess.engine.base;

import java.util.Arrays;

import no.pdigre.chess.engine.base.IBase.BASE;
import no.pdigre.chess.engine.fen.Position64;

public class GMovegen extends Movegen {


	GMovegen(Position64 pos) {
		super(pos);
	}

	/* (non-Javadoc)
	 * @see no.pdigre.chess.engine.base.IMovegen#moves()
	 */
	@Override
	final public Position64[] moves() {
		n = 0;
		test = 0;

		// *********************************************************************************************
		// *
		// *
		// *********************************************************************************************
		if (pos.whiteNext()) {
			MPWhite.genMoves(this,bb_white & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.WP);
			MNWhite.genMoves(this,bb_white & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.WN);
			MSliderWhite.genMoves(this,bb_white & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.WB);
			MSliderWhite.genMoves(this,bb_white & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WR);
			MSliderWhite.genMoves(this,bb_white & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.WQ);
			BASE.WK[wking].all(this);
		} else {
			MPBlack.genMoves(this,bb_black & (bb_bit1) & (~bb_bit2) & (~bb_bit3), BASE.BP);
			MNBlack.genMoves(this,bb_black & (~bb_bit1) & (bb_bit2) & (~bb_bit3), BASE.BN);
			MSliderBlack.genMoves(this,bb_black & (bb_bit1) & (~bb_bit2) & (bb_bit3), BASE.BB);
			MSliderBlack.genMoves(this,bb_black & (~bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BR);
			MSliderBlack.genMoves(this,bb_black & (bb_bit1) & (bb_bit2) & (bb_bit3), BASE.BQ);
			BASE.BK[bking].all(this);
		}
		Position64[] mvs = Arrays.copyOfRange(list, 0, n);
//		NodeGen.mergeSort(list, mvs, 0, n, 0);
		return mvs;
	}


}

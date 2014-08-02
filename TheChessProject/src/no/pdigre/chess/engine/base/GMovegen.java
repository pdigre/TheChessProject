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
		Position64[] mvs = Arrays.copyOfRange(list, 0, n);
//		NodeGen.mergeSort(list, mvs, 0, n, 0);
		return mvs;
	}


}

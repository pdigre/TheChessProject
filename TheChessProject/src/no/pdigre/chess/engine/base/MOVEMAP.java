package no.pdigre.chess.engine.base;

public class MOVEMAP {
	final MBase[] base=new MBase[16];
	final public int from;
	final MPWhite WP;
	final MNWhite WN;
	final MSliderWhite WB;
	final MSliderWhite WR;
	final MSliderWhite WQ;
	final MKWhite WK;

	final MPBlack BP;
	final MNBlack BN;
	final MSliderBlack BB;
	final MSliderBlack BR;
	final MSliderBlack BQ;
	final MKBlack BK;

	public MOVEMAP(int from) {
		this.from = from;
		WP=new MPWhite(from);
		WN=new MNWhite(from);
		WB=new MSliderWhite(from);
		WR=new MSliderWhite(from);
		WQ=new MSliderWhite(from);
		WK=new MKWhite(from);
		BP=new MPBlack(from);
		BN=new MNBlack(from);
		BB=new MSliderBlack(from);
		BR=new MSliderBlack(from);
		BQ=new MSliderBlack(from);
		BK=new MKBlack(from);
		base[IConst.WP]=WP;
		base[IConst.WN]=WN;
		base[IConst.WB]=WB;
		base[IConst.WR]=WR;
		base[IConst.WQ]=WQ;
		base[IConst.WK]=WK;
		base[IConst.BP]=BP;
		base[IConst.BN]=BN;
		base[IConst.BB]=BB;
		base[IConst.BR]=BR;
		base[IConst.BQ]=BQ;
		base[IConst.BK]=BK;
	}
	
}

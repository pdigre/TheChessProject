package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.fen.Position64;

public class MOVEDATA {
	public MOVEDATA(long bitmap) {
		this.bitmap=bitmap;
	}

	public Position64 move(Position64 pos, long castling){
		return pos.move(bitmap & castling);
	}

	long bitmap;
}
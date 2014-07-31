package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.fen.Position64;

public interface IMovegen {

	public abstract Position64[] moves();

}
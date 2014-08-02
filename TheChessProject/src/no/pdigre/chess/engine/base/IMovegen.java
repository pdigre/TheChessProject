package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.fen.Position;

public interface IMovegen {

	public abstract Position[] moves();

}
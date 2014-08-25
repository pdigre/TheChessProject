package no.pdigre.chess.test;

import java.util.Map;

import no.pdigre.chess.engine.fen.Position;

public interface IPerft {

	Map<String, Integer> divide(Position pos, int depth);

}

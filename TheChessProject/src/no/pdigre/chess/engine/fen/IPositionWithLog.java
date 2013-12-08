package no.pdigre.chess.engine.fen;

public interface IPositionWithLog extends IPosition {

    /**
     * Number of moves since start of game
     * 
     * @return
     */
    public abstract int totalMoves();

}

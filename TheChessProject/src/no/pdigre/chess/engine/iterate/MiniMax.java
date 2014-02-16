package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.Position64;

public class MiniMax implements IIterator {

    private IIterator deeper;

    private IPosition pos;
    
    public MiniMax(IIterator deeper) {
        this.deeper = deeper;
    }

    @Override
    public String toString() {
        return FEN.board2fen(pos) + "\n" + FEN.printMove(pos);
    }

	@Override
	public int black(IPosition pos, int min, int max) {
		Position64[] moves = NodeGen.getLegalMoves64(pos);
		for (int i = 0; i < moves.length; i++) {
			Position64 next = moves[i];
			int score = deeper.white(next, min, max);
			if (score < max)
				max = score;
		}
		return max;
	}

	@Override
	public int white(IPosition pos, int min, int max) {
		Position64[] moves = NodeGen.getLegalMoves64(pos);
		for (int i = moves.length - 1; i >= 0; i--) {
			Position64 next = moves[i];
			int score = deeper.black(next, min, max);
			if (score > min)
				min = score;
		}
		return min;
	}
	
	@Override
	public int getQuality() {
		return deeper.getQuality()+1;
	}


}

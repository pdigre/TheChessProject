package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.ZobristKey;



public class Position implements IPosition {
    int board[];
    long bitmap;
    
    public Position(IPosition pos) {
        super();
        this.board = pos.getBoard();
        this.bitmap = pos.getBitmap();
    }

    public Position(int[] board, long bitmap) {
        super();
        this.board = board;
        this.bitmap = bitmap;
    }
    
    @Override
    public String toString() {
        return FEN.printMove(this)+"\n"+FEN.board2string(this);
    }

    @Override
    public boolean whiteNext() {
        return !BITS.white(bitmap);
    }
    
    @Override
    public int[] getBoard() {
        return board;
    }
    
    @Override
    public long getBitmap() {
        return bitmap;
    }

    @Override
    public IPosition move(long bitmap2) {
        return new PositionNext(board, bitmap2);
    }

    @Override
    public int getPiece(int square) {
        return board[square];
    }

	@Override
	public int getWKpos() {
		return BOARD88.getWKpos(this);
	}

	@Override
	public int getBKpos() {
		return BOARD88.getBKpos(this);
	}

	@Override
	public long getZobristKey() {
		return ZobristKey.getKey(this);
	}

	@Override
	public int getScore() {
		return 0;
	}

	@Override
	public int getQuality() {
		return 0;
	}
}

package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.MOVEDATA;




public class PositionNext implements IPosition {
    int[] board;
    int[] parent;
    long bitmap;
    
    public PositionNext(int[] parent, long bitmap) {
        super();
        this.parent = parent;
        this.bitmap = bitmap;
    }
    
    @Override
    public boolean whiteNext() {
        return !BITS.white(bitmap);
    }
    
    @Override
    public int[] getBoard() {
        if(board==null)
            board=IPosition.BOARD88.apply(parent, bitmap);
        return board;
    }
    
    @Override
    public long getBitmap() {
        return bitmap;
    }

    @Override
    public IPosition move(long bitmap2) {
        if(board==null)
            board=IPosition.BOARD88.apply(parent, bitmap);
        return new PositionNext(board, bitmap2);
    }

    @Override
    public int getPiece(int square) {
        if(board==null)
            board=IPosition.BOARD88.apply(parent, bitmap);
        return board[square];
    }


    @Override
    public String toString() {
        return FEN.printMove(this)+"\n"+FEN.board2string(this);
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
		return 0L;
	}

	@Override
	public int getScore() {
		return 0;
	}

	@Override
	public int getQuality() {
		return 0;
	}

	@Override
	public int compareTo(IPosition o) {
		return Integer.compare(getScore(), o.getScore());
	}

	@Override
	public IPosition64 move(MOVEDATA m, long castling) {
		return (IPosition64) move(m.bitmap);
	}

}

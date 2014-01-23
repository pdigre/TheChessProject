package no.pdigre.chess.engine.fen;




public class PositionNext implements IPosition {
    int[] board;
    int[] parent;
    int bitmap;
    
    public PositionNext(int[] parent, int bitmap) {
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
    public int getBitmap() {
        return bitmap;
    }

    @Override
    public IPosition move(int bitmap2) {
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
    
}

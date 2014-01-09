package no.pdigre.chess.engine.fen;



public class Position implements IPosition {
    int board[];
    int bitmap;
    
    public Position(IPosition pos) {
        super();
        this.board = pos.getBoard();
        this.bitmap = pos.getBitmap();
    }

    public Position(int[] board, int bitmap) {
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
    public int getBitmap() {
        return bitmap;
    }

    @Override
    public IPosition move(int bitmap2) {
        return new PositionNext(board, bitmap2);
    }

    @Override
    public int getPiece(int square) {
        return board[square];
    }

}

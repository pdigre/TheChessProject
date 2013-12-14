package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.Bitmap;


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
        return !Bitmap.white(bitmap);
    }
    
    @Override
    public int[] getBoard() {
        if(board==null)
            board=Bitmap.apply(parent, bitmap);
        return board;
    }
    
    @Override
    public int getBitmap() {
        return bitmap;
    }

    @Override
    public IPosition move(int bitmap2) {
        if(board==null)
            board=Bitmap.apply(parent, bitmap);
        return new PositionNext(board, bitmap2);
    }

    @Override
    public int getPiece(int square) {
        if(board==null)
            board=Bitmap.apply(parent, bitmap);
        return board[square];
    }

}

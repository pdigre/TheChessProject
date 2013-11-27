package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.Bitmap;


public class Position implements IPosition {
    int board[];
    int bitmap;
    
    public Position(int[] board, int bitmap) {
        super();
        this.board = board;
        this.bitmap = bitmap;
    }
    
    @Override
    public boolean whiteTurn() {
        return Bitmap.white(bitmap);
    }
    @Override
    public int totalMoves() {
        return Bitmap.halfMoves(bitmap);
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
        return new Position(Bitmap.apply(board, bitmap2), bitmap2);
    }
}
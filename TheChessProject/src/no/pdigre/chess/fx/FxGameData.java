package no.pdigre.chess.fx;

import java.util.ArrayList;

import no.pdigre.chess.profile.GameData;
import no.pdigre.chess.profile.Marking;


public class FxGameData extends GameData{
    FxChessCanvas canvas;
    
    public void setCanvas(FxChessCanvas canvas){
        this.canvas=canvas;
    }
    
    @Override
    public void updateBoard() {
        ArrayList<Marking> markers = getMarkers();
        int[] board = pos.getBoard();
        canvas.drawBoard(board, markers);
    }


}

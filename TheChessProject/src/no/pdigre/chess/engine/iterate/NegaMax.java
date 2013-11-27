package no.pdigre.chess.engine.iterate;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;

public class NegaMax implements IThinker {

    private IThinker next;

    IPosition pos;

    private IThinker parent;

    private int counter;

    @Override
    public void setParent(IThinker parent) {
        this.parent = parent;
    }

    public NegaMax(IThinker next) {
        this.next = next;
        next.setParent(this);
    }

    @Override
    public int think(IPosition pos, int total, int alpha, int beta) {
        this.pos=pos;
        int bitmap = pos.getBitmap();
        int[] board = pos.getBoard();
        total += Bitmap.tacticValue(bitmap);
        int max = alpha;
        int[] moves = NodeUtil.getAllBestFirst(board, bitmap);
        counter+=moves.length;
        for (int i = 0; i < moves.length; i++) {
            int bitmap1 = moves[i];
            int score = -next.think(pos.move(bitmap1), -total, -beta, -alpha);
            if (score > max)
                max = score;
        }
        return max;
    }

    @Override
    public IThinker getParent() {
        return parent;
    }

    @Override
    public int getBitmap() {
        return pos.getBitmap();
    }

    @Override
    public String toString() {
        return FEN.board2String(pos.getBoard()) + "\n" + FEN.printMove(pos.getBitmap(), pos.getBoard());
    }

    public void printHitrate() {
        System.out.println("Hitrate:" + counter + "/" + counter);
    }


}

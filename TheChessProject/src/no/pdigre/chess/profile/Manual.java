package no.pdigre.chess.profile;

import java.util.ArrayList;

import no.pdigre.chess.engine.base.Bitmap;
import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.profile.Marking.MarkingType;

public class Manual extends Player {
 
    public Integer from = -1;

    @Override
    public void run() { 
    	System.out.println("MANUAL:"+FEN.getFen(getPosition()));
		game.updateBoard();
    }

    @Override
    public int clickSquare(int i) {
        int[] bitmaps = moves.getBitmaps();
        if(from>-1){
            int[] avail = NodeUtil.filterTo(NodeUtil.filterFrom(bitmaps, from), i);
            from=-1;
            if(avail.length>0)
                return avail[0];
        }
        if(from==-1){
            int[] avail = NodeUtil.filterFrom(bitmaps, i);
            if(avail.length>0)
                from=i;
        } 
        return -1;
    }

    @Override
    public ArrayList<Marking> getMarkers() {
        if(moves==null)
            return super.getMarkers();
        ArrayList<Marking> list = new ArrayList<Marking>();
        int[] bitmaps = moves.getBitmaps();
        if(from == -1) {
            int best = Bitmap.getFrom(bitmaps[0]);
            for (int n : bitmaps) {
                int fr = Bitmap.getFrom(n);
                list.add(new Marking(fr == best ? MarkingType.BestMoveFrom : MarkingType.MoveFrom, fr));
            }
        } else {
            list.add(new Marking(MarkingType.MarkFrom, from));
            for (int n : bitmaps) {
                if (Bitmap.getFrom(n) == from)
                    list.add(new Marking(MarkingType.MoveTo, Bitmap.getTo(n), 0));
            }
        }
        return list;
    }
}

package no.pdigre.chess.test.util;

import java.util.Iterator;

import no.pdigre.chess.engine.base.NodeUtil;
import no.pdigre.chess.engine.fen.IPosition;

public final class IterateMoves implements Iterable<IPosition>, Iterator<IPosition> {

    final IPosition pos;
    final int[] all;
    int i = 0;

    public IterateMoves(IPosition pos) {
        this.pos = pos;
        all = NodeUtil.getAllBestFirst(pos);
    }

    @Override
    public boolean hasNext() {
        return i < all.length;
    }

    @Override
    public IPosition next() {
        return pos.move(all[i++]);
    }

    @Override
    public void remove() {
        //
    }

    @Override
    public Iterator<IPosition> iterator() {
        return this;
    }
}
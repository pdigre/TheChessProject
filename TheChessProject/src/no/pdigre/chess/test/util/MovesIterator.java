package no.pdigre.chess.test.util;

import java.util.Iterator;

import no.pdigre.chess.engine.fen.IPosition;

public final class MovesIterator implements Iterable<IPosition>, Iterator<IPosition> {

    final IPosition pos;
    final int[] all;
    int i = 0;

    public MovesIterator(IPosition pos) {
        this.pos = pos;
        all = pos.getAllBestFirst();
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
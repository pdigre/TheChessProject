package no.pdigre.chess.test.util;

import java.util.Iterator;

import no.pdigre.chess.engine.base.NodeGen;
import no.pdigre.chess.engine.fen.IPosition;

public final class IterateMoves implements Iterable<IPosition>, Iterator<IPosition> {

    final private NodeGen gen;
    final private IPosition pos;

    public IterateMoves(IPosition pos) {
        this.pos=pos;
        this.gen=new NodeGen(pos);
    }

    @Override
    public boolean hasNext() {
        return gen.hasNext();
    }

    @Override
    public IPosition next() {
        return pos.move(gen.next());
    }

    @Override
    public void remove() {
        //
    }

    @Override
    public Iterator<IPosition> iterator() {
        gen.iterator();
        return this;
    }
}
package no.pdigre.chess.profile;

import no.pdigre.chess.engine.iterate.AlphaBetaTT;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.QuiescenceTT;
import no.pdigre.chess.engine.iterate.Transposition;

public class P_AlphaBetaTT extends TestPlayer {

	public P_AlphaBetaTT(int depth){
		super("AlphaBetaTT",depth,new QuiescenceTT());
	}

	@Override
	public IIterator addIterator(IIterator iter) {
		return new AlphaBetaTT(iter);
	}
	
	@Override
	public void run() {
		super.run();
		printResults();
	}

	public void printResults() {
		System.out.println("*****************************");
		System.out.println("Size:"+Transposition.TTSIZE);
		Transposition.total =Transposition.hits+Transposition.miss;
		stat("Hits", Transposition.hits);
		stat("Miss", Transposition.miss);
		stat("Coll", Transposition.coll);
		stat("Err", Transposition.err);
		stat("Qual", Transposition.qual);
		System.out.println("Hitrate:" + (1.0*Transposition.hits/(Transposition.miss))+"%");
	}

	public void stat(String name, long i) {
		System.out.println(name+":"+i + " = " + (100.0*i/Transposition.total)+"%");
	}
}

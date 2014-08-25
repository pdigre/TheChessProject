package no.pdigre.chess.test;

import no.pdigre.chess.engine.base.KingSafe;
import no.pdigre.chess.engine.base.MOVEDATA;
import no.pdigre.chess.engine.base.Movegen;
import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.test.util.Counter;

public class RunPerft {
	int levels;
	String fen;
	NodeGen[] movegen;
	Counter[] results;

	public RunPerft(int levels, String fen) {
		configure(levels, fen, false);
	}
	
	public RunPerft(int levels, String fen,boolean cache) {
		configure(levels, fen, cache);
	}

	public void configure(int levels, String fen, boolean cache) {
		this.levels = levels;
		this.fen = fen;
		movegen = new NodeGen[levels];
		results=new Counter[levels];
		NodeGen root = new RootGen();
		root.setPos(new StartGame(fen));
		movegen[0] = root;
		results[0] = root.count;
		root.isCompare=cache;
		for (int i = 1; i < levels; i++) {
			NodeGen m = i < levels - 1 ? new BranchGen() : new LeafGen();
			movegen[i] = m;
			results[i] = m.count;
			m.parent = movegen[i - 1];
			m.isCompare=cache;
			movegen[i - 1].child = m;
			if(cache && i>1)
				m.setCompare(movegen[i-2]);
		}
	}

	public Counter[] run() {
		movegen[0].run();
		return results;
	}

	public class NodeGen extends Movegen {
		Counter count = new Counter();
		NodeGen parent = null, child = null;

		public void run() {
			generate();
			stats();
			
			for (int i = 0; i < iAll; i++) {
				MOVEDATA md = moves[i];
				child.setPos(pos.move(md));
				child.run();
				if(child.checkers!=0L){
					count.checks++;
					if(child.iAll==0)
						count.mates++;
				}
			}
		}

		public void stats() {
			count.moves+=iAll;
			for (int i = 0; i < iAll; i++) {
				long bitmap = moves[i].bitmap;
				if(BITS.isPromotion(bitmap))
					count.promotions++;
				if(BITS.isCapture(bitmap)){
					count.captures++;
					if(BITS.isEnpassant(bitmap))
						count.enpassants++;
				} else if(BITS.isCastling(bitmap))
					count.castlings++;
			}
		}
	}

	public class RootGen extends NodeGen {

	}

	public class BranchGen extends NodeGen {
	}

	public class LeafGen extends NodeGen {
		@Override
		public void run() {
			generate();
			stats();
			for (int i = 0; i < iAll; i++) {
				KingSafe safe = KingSafe.pos(pos, moves[i]);
				if(isWhite?!safe.isSafeBlack():!safe.isSafeWhite()){
					count.checks++;
					Movegen next = new Movegen(pos.move(moves[i]));
					next.generate();
					if(next.iAll==0)
						count.mates++;
				}
			}
		}
	}

}

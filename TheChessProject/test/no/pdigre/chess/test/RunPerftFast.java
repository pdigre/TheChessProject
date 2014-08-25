package no.pdigre.chess.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import no.pdigre.chess.engine.base.MOVEDATA;
import no.pdigre.chess.engine.base.Movegen;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.Position;
import no.pdigre.chess.engine.fen.StartGame;
import no.pdigre.chess.test.util.PerftResults;

public class RunPerftFast implements IPerft{
	int levels;
	long count;
	private Position pos;
	public NodeGen root;

	public static void test(int test,int levels, String fen) {
		PerftResults.assertPERFT(test,fen,levels,perft(levels, fen));
	}

	public static long perft(int levels, String fen) {
		RunPerftFast inst = new RunPerftFast();
		inst.start(levels, new StartGame(fen));
		return inst.perft();
	}


	@Override
	public Map<String, Integer> divide(Position pos, int depth) {
		start(depth, pos);
		return divide();
	}

	public void start(int levels, Position pos) {
		this.levels = levels;
		this.pos = pos;
		root = new NodeGen();
		root.setPos(pos);
	}

	public long perft() {
		CountTask[] tasks = exec();
        try {
			for (RecursiveTask<Long> task : tasks)
				count+=task.get();
		} catch (Exception e) {
			e.printStackTrace();
		}
        return count;
	}
	
	public Map<String,Integer> divide() {
		LinkedHashMap<String, Integer> map=new LinkedHashMap<String, Integer>();
		if(levels<2){
	        root.generate();
	        for (int i = 0; i < root.iAll; i++) {
	    		map.put(FEN.move2literal(root.moves[i].bitmap),1);
			}
	        return map;
		}
		CountTask[] tasks = exec();
        try {
        	for (int i = 0; i < tasks.length; i++) 
        		map.put(FEN.move2literal(root.moves[i].bitmap),(int)(long)tasks[i].get());
		} catch (Exception e) {
			e.printStackTrace();
		}
        return map;
	}

	public CountTask[] exec() {
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        root.generate();
        CountTask[] tasks = new CountTask[root.iAll];
		for (int i = 0; i < root.iAll; i++) {
			CountTask task=new CountTask(pos.move(root.moves[i]));
			tasks[i]=task;
			pool.execute(task);
		}
		return tasks;
	}

	private final class CountTask extends RecursiveTask<Long> {
		private static final long serialVersionUID = -2743566188067414328L;
		long count=0;
		NodeGen[] movegen;

		public CountTask(Position pos) {
			movegen = new NodeGen[levels-1];
			for (int i = 0; i < movegen.length; i++) {
				NodeGen m = i < movegen.length - 1 ? new NodeGen() : new LeafGen(this);
				movegen[i] = m;
				NodeGen parent = i>0?movegen[i - 1]:root;
				m.parent = parent;
				parent.child = m;
			}
			movegen[0].setPos(pos);
		}

		@Override
		protected Long compute() {
			movegen[0].run();
			return count;
		}
	}

	public class NodeGen extends Movegen {
		NodeGen parent = null, child = null;

		public void run() {
			generate();
			for (int i = 0; i < iAll; i++) {
				MOVEDATA md = moves[i];
				child.setPos(pos.move(md));
				child.run();
			}
		}
	}

	public class LeafGen extends NodeGen {
		private CountTask task;

		public LeafGen(CountTask parent) {
			this.task=parent;
		}

		@Override
		public void run() {
			generate();
			task.count+=iAll;
		}
	}


}

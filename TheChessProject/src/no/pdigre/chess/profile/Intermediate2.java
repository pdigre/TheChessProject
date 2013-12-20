package no.pdigre.chess.profile;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.FEN;
import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.PositionScore;
import no.pdigre.chess.engine.iterate.IIterator;
import no.pdigre.chess.engine.iterate.MiniMax;
import no.pdigre.chess.engine.iterate.MiniMaxEnd;
import no.pdigre.chess.test.util.IterateScores;

public class Intermediate2 extends Player {

    @Override
    public void run() {
        IPosition pos = getPosition();
        System.out.println("***********************************************");
        System.out.println("START:"+FEN.getFen(pos));
        IIterator iter0 = new MiniMaxEnd(IEvaluator.TACTICAL);
        IIterator iter1 = new MiniMax(iter0, IEvaluator.TACTICAL);
        IIterator iter2 = new MiniMax(iter1, IEvaluator.TACTICAL);
        IIterator iter3 = new MiniMax(iter2, IEvaluator.TACTICAL);
        IIterator iter4 = new MiniMax(iter3, IEvaluator.TACTICAL);
        IIterator iter5 = new MiniMax(iter4, IEvaluator.TACTICAL);
        initRun(pos);
        IterateScores moves = new IterateScores(pos, IEvaluator.FULL);
        printScore(moves, "PASS 0");
        PositionScore[] all = moves.toArray(new PositionScore[moves.size()]);
        for (PositionScore m : all)
            runThinker(m, moves, iter0);
        printScore(moves, "PASS 1");
        for (PositionScore m : all)
            runThinker(m, moves, iter1);
        printScore(moves, "PASS 2");
        for (PositionScore m : all)
            runThinker(m, moves, iter2);
        printScore(moves, "PASS 3");
        for (PositionScore m : all)
            runThinker(m, moves, iter3);
        printScore(moves, "PASS 4");
//        for (PositionScore m : all)
//            runThinker(m, moves, iter4);
//        printScore(moves, "PASS 5");
//        for (PositionScore m : all)
//            runThinker(m, moves, iter5);
//        printScore(moves, "PASS 6");
        makeMove(moves.first().getBitmap());
    }
/*
 * 
8 .k.r....
7 .pp....p
6 ..n.....
5 P......R
4 ..R.p.r.
3 ..P..p..
2 .PP..B.P
1 ....K...
  ABCDEFGH


**** PASS 0 ****
-155:b Nxc6 Nxa5
-100:b Rg4 Rg2
-100:b Nc6 Nd4
-100:b Nc6 Ne5
-95:b e4 e3
-95:b Rd8 Rd2
-90:b h7 h6
-90:b Rg4 Rg1
-90:b Rg4 Rg3
-90:b Rg4 Rf4
-90:b Rg4 Rg5
-90:b Rg4 Rg6
-90:b Rg4 Rg7
-90:b Rd8 Re8
-90:b Rg4 Rg8
-85:b Rd8 Rd1
-85:b Rd8 Rd3
-85:b Nc6 Nb4
-85:b Rd8 Rd4
-85:b Rg4 Rh4
-85:b Rd8 Rd5
-85:b Rd8 Rd6
-85:b Rd8 Rd7
-85:b Nc6 Ne7
-85:b Rd8 Rc8
-85:b Rd8 Rf8
-85:b Rd8 Rg8
-85:b Rd8 Rh8
-80:b b7 b5
-80:b Kb8 Ka8
-75:b b7 b6
-70:b Kb8 Kc8
-40:b Nc6 Na7

**** PASS 1 ****
-500:b Rd8 Rd1
-490:b Rg4 Rg1
15:b e4 e3
15:b Nxc6 Nxa5
15:b b7 b5
15:b b7 b6
15:b h7 h6
15:b Rd8 Rd2
15:b Rg4 Rg2
15:b Rd8 Rd3
15:b Rg4 Rg3
15:b Nc6 Nb4
15:b Nc6 Nd4
15:b Rd8 Rd4
15:b Rg4 Rf4
15:b Rg4 Rh4
15:b Rd8 Rd5
15:b Nc6 Ne5
15:b Rg4 Rg5
15:b Rd8 Rd6
15:b Rg4 Rg6
15:b Nc6 Na7
15:b Rd8 Rd7
15:b Nc6 Ne7
15:b Rg4 Rg7
15:b Kb8 Ka8
15:b Kb8 Kc8
15:b Rd8 Rc8
15:b Rd8 Re8
15:b Rd8 Rf8
15:b Rg4 Rg8
15:b Rd8 Rg8
15:b Rd8 Rh8

**** PASS 2 ****
-490:b Rd8 Rd1
-490:b Rg4 Rg1
-140:b e4 e3
10:b b7 b6
10:b Nc6 Nd4
10:b Rd8 Rd4
10:b Nc6 Na7
10:b Kb8 Ka8
10:b Kb8 Kc8
25:b Nxc6 Nxa5
25:b b7 b5
25:b h7 h6
25:b Rd8 Rd2
25:b Rg4 Rg2
25:b Rd8 Rd3
25:b Rg4 Rg3
25:b Nc6 Nb4
25:b Rg4 Rf4
25:b Rg4 Rh4
25:b Rd8 Rd5
25:b Nc6 Ne5
25:b Rg4 Rg5
25:b Rd8 Rd6
25:b Rg4 Rg6
25:b Rd8 Rd7
25:b Nc6 Ne7
25:b Rg4 Rg7
25:b Rd8 Rc8
25:b Rd8 Re8
25:b Rd8 Rf8
25:b Rg4 Rg8
25:b Rd8 Rg8
25:b Rd8 Rh8

**** PASS 3 ****
-495:b Rd8 Rd2
-490:b e4 e3
-490:b Rg4 Rg1
-485:b Rd8 Rd1
-110:b Rd8 Rd4
-5:b Nxc6 Nxa5
0:b b7 b6
0:b Nc6 Na7
0:b Kb8 Ka8
0:b Kb8 Kc8
10:b Rg4 Rg2
10:b Nc6 Nd4
25:b b7 b5
25:b h7 h6
25:b Rd8 Rd3
25:b Rg4 Rg3
25:b Nc6 Nb4
25:b Rd8 Rd5
25:b Nc6 Ne5
25:b Rg4 Rg5
25:b Rd8 Rd6
25:b Rg4 Rg6
25:b Rd8 Rd7
25:b Nc6 Ne7
25:b Rg4 Rg7
25:b Rg4 Rg8
30:b Rg4 Rf4
30:b Rg4 Rh4
30:b Rd8 Rc8
30:b Rd8 Re8
30:b Rd8 Rf8
30:b Rd8 Rg8
30:b Rd8 Rh8
>BLACK_ROOK from d8 to d2, Rd8 Rd2
 */

}

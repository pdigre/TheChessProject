package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.evaluate.IEvaluator;
import no.pdigre.chess.engine.fen.IPosition;

public class NodeUtil {

    public static int[] getAllMoves(IPosition pos) {
        int length = 0;
        int[] array = new int[100];
        NodeGen pull = new NodeGen(pos);
        int bitmap1 = pull.nextSafe();
        while (bitmap1 != 0) {
            array[length++] = bitmap1;
            bitmap1 = pull.nextSafe();
        }
        int[] ret = new int[length];
        System.arraycopy(array, 0, ret, 0, length);
        return ret;
    }

    public static int[] getAllBestFirst(IPosition pos) {
        return sortMoves(pos,getAllMoves(pos));
    }

    public static int[] sortMoves(IPosition pos,int[] all) {
        if(all.length<2)
            return all;
        int cutoff = -9000;
        int next = 0;
        int p2 = all.length - 1;
        int b2 = all[p2];
        int v2 = IEvaluator.BASIC.tactical(pos.move(b2));
        while (next > cutoff) {
            int p1 = 0;
            int b1 = all[p1];
            int v1 = IEvaluator.BASIC.tactical(pos.move(b1));
            cutoff=next;
            next = 9000;
            while (p1 < p2) {
                if (v1 > cutoff) {
                    if (next > v1)
                        next = v1;
                    p1++;
                    b1 = all[p1];
                    v1 = IEvaluator.BASIC.tactical(pos.move(b1));
                    continue;
                }
                if (v2 <= cutoff) {
                    p2--;
                    b2 = all[p2];
                    v2 = IEvaluator.BASIC.tactical(pos.move(b2));
                    continue;
                }
                {
                    // Swap
                    all[p1] = b2;
                    all[p2] = b1;
                    int t = b1;
                    b1 = b2;
                    b2 = t;
                    t = v1;
                    v1 = v2;
                    v2 = t;
                }
            }
        }
        return all;
    }

    public static int[] filterFrom(int[] moves, int from) {
        int length = 0;
        int[] array = new int[moves.length];
        for (int i = 0; i < moves.length; i++) {
            int bitmap = moves[i];
            if (Bitmap.getFrom(bitmap) == from) {
                array[length] = bitmap;
                length++;
            }
        }
        int[] ret = new int[length];
        System.arraycopy(array, 0, ret, 0, length);
        return ret;
    }

    public static int[] filterTo(int[] moves, int to) {
        int length = 0;
        int[] array = new int[moves.length];
        for (int i = 0; i < moves.length; i++) {
            int bitmap = moves[i];
            if (Bitmap.getTo(bitmap) == to) {
                array[length] = bitmap;
                length++;
            }
        }
        int[] ret = new int[length];
        System.arraycopy(array, 0, ret, 0, length);
        return ret;
    }

}

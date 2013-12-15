package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.fen.IPosition;

public class NodeUtil {

    public static int[] getLegalMoves(IPosition pos) {
        int length = 0;
        int[] array = new int[100];
        for (Integer bitmap1 : new NodeGen(pos))
            array[length++] = bitmap1;
        int[] ret = new int[length];
        System.arraycopy(array, 0, ret, 0, length);
        return ret;
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

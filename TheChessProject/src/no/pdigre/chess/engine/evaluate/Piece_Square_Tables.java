package no.pdigre.chess.engine.evaluate;

import no.pdigre.chess.engine.base.IConst;

public class Piece_Square_Tables {

    final static int[] WPAWN = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 50, 50, 50, 50, 50, 50, 50, 50, 10, 10, 20, 30,
        30, 20, 10, 10, 5, 5, 10, 25, 25, 10, 5, 5, 0, 0, 0, 20, 20, 0, 0, 0, 5, -5, -10, 0, 0, -10, -5, 5, 5, 10,
        10, -20, -20, 10, 10, 5, 0, 0, 0, 0, 0, 0, 0, 0 };

    final static int[] WKNIGHT = new int[] { -50, -40, -30, -30, -30, -30, -40, -50, -40, -20, 0, 0, 0, 0, -20,
        -40, -30, 0, 10, 15, 15, 10, 0, -30, -30, 5, 15, 20, 20, 15, 5, -30, -30, 0, 15, 20, 20, 15, 0, -30, -30,
        5, 10, 15, 15, 10, 5, -30, -40, -20, 0, 5, 5, 0, -20, -40, -50, -40, -30, -30, -30, -30, -40, -50 };

    final static int[] WBISHOP = new int[] { -20, -10, -10, -10, -10, -10, -10, -20, -10, 0, 0, 0, 0, 0, 0, -10,
        -10, 0, 5, 10, 10, 5, 0, -10, -10, 5, 5, 10, 10, 5, 5, -10, -10, 0, 10, 10, 10, 10, 0, -10, -10, 10, 10,
        10, 10, 10, 10, -10, -10, 5, 0, 0, 0, 0, 5, -10, -20, -10, -10, -10, -10, -10, -10, -20 };

    final static int[] WROOK = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 5, 10, 10, 10, 10, 10, 10, 5, -5, 0, 0, 0, 0,
        0, 0, -5, -5, 0, 0, 0, 0, 0, 0, -5, -5, 0, 0, 0, 0, 0, 0, -5, -5, 0, 0, 0, 0, 0, 0, -5, -5, 0, 0, 0, 0, 0,
        0, -5, 0, 0, 0, 5, 5, 0, 0, 0 };

    final static int[] WQUEEN = new int[] { -20, -10, -10, -5, -5, -10, -10, -20, -10, 0, 0, 0, 0, 0, 0, -10, -10,
        0, 5, 5, 5, 5, 0, -10, -5, 0, 5, 5, 5, 5, 0, -5, 0, 0, 5, 5, 5, 5, 0, -5, -10, 5, 5, 5, 5, 5, 0, -10, -10,
        0, 5, 0, 0, 0, 0, -10, -20, -10, -10, -5, -5, -10, -10, -20 };

    final static int[] WKING_MIDDLE = new int[] { -30, -40, -40, -50, -50, -40, -40, -30, -30, -40, -40, -50, -50,
        -40, -40, -30, -30, -40, -40, -50, -50, -40, -40, -30, -30, -40, -40, -50, -50, -40, -40, -30, -20, -30,
        -30, -40, -40, -30, -30, -20, -10, -20, -20, -20, -20, -20, -20, -10, 20, 20, 0, 0, 0, 0, 20, 20, 20, 30,
        10, 0, 0, 10, 30, 20 };

    final static int[] WKING_END = new int[] { -50, -40, -30, -20, -20, -30, -40, -50, -30, -20, -10, 0, 0, -10,
        -20, -30, -30, -10, 20, 30, 30, 20, -10, -30, -30, -10, 30, 40, 40, 30, -10, -30, -30, -10, 30, 40, 40,
        30, -10, -30, -30, -10, 20, 30, 30, 20, -10, -30, -30, -30, 0, 0, 0, 0, -30, -30, -50, -30, -30, -30, -30,
        -30, -30, -50 };

    // P = 100
    // N = 320
    // B = 330
    // R = 500
    // Q = 900
    // K = 20000

    private static int[] invert(int[] table,int offset) {
        int[] inv = new int[64];
        for (int r = 0; r < 64; r++)
            table[r]+=offset;
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++)
                inv[8 * (7 - r) + c] = -table[8 * (r) + c];
        }
        return inv;
    }

    final static int[] BPAWN = invert(WPAWN,100);

    final static int[] BKNIGHT = invert(WKNIGHT,320);

    final static int[] BBISHOP = invert(WBISHOP,330);

    final static int[] BROOK = invert(WROOK,500);

    final static int[] BQUEEN = invert(WQUEEN,900);

    final static int[] BKING_MIDDLE = invert(WKING_MIDDLE,20000);

    final static int[] BKING_END = invert(WKING_END,20000);

    final static int pVal(int p, int type) {
        switch (type) {
            case IConst.PAWN:
                return WPAWN[p];
            case IConst.KNIGHT:
                return WKNIGHT[p];
            case IConst.BISHOP:
                return WBISHOP[p];
            case IConst.ROOK:
                return WROOK[p];
            case IConst.QUEEN:
                return WQUEEN[p];
            case IConst.BLACK_PAWN:
                return BPAWN[p];
            case IConst.BLACK_KNIGHT:
                return BKNIGHT[p];
            case IConst.BLACK_BISHOP:
                return BBISHOP[p];
            case IConst.BLACK_ROOK:
                return BROOK[p];
            case IConst.BLACK_QUEEN:
                return BQUEEN[p];
        }
        return 0;
    }

}

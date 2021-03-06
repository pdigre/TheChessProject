package no.pdigre.chess.engine.base;


public class Piece_Square_Tables {

    final static int[] WPAWN = new int[] //
    { 0, 0, 0, 0, 0, 0, 0, 0, //
        50, 50, 50, 50, 50, 50, 50, 50, //
        10, 10, 20, 30, 30, 20, 10, 10, //
        5, 5, 10, 25, 25, 10, 5, 5, //
        0, 0, 0, 20, 20, 0, 0, 0, //
        5, -5, -10, 0, 0, -10, -5, 5, //
        5, 10, 10, -20, -20, 10, 10, 5, //
        0, 0, 0, 0, 0, 0, 0, 0 };

    final static int[] WKNIGHT = new int[] //
    { -50, -40, -30, -30, -30, -30, -40, -50, //
        -40, -20, 0, 0, 0, 0, -20, -40, //
        -30, 0, 10, 15, 15, 10, 0, -30, //
        -30, 5, 15, 20, 20, 15, 5, -30, //
        -30, 0, 15, 20, 20, 15, 0, -30, //
        -30, 5, 10, 15, 15, 10, 5, -30, //
        -40, -20, 0, 5, 5, 0, -20, -40, //
        -50, -40, -30, -30, -30, -30, -40, -50 };

    final static int[] WBISHOP = new int[] //
    { -20, -10, -10, -10, -10, -10, -10, -20, //
        -10, 0, 0, 0,     0, 0, 0, -10, //
        -10, 0, 5, 10,   10, 5, 0, -10, //
        -10, 5, 5, 10,   10, 5, 5, -10, //
        -10, 0, 10, 10,  10, 10, 0, -10, //
        -10, 10, 10, 10, 10, 10, 10, -10, //
        -10, 5, 0, 0,     0, 0, 5, -10, //
        -20, -10, -10,  -10, -10, -10, -10, -20 };

    final static int[] WROOK = new int[] //
    { 0, 0, 0, 0, 0, 0, 0, 0, //
        5, 10, 10, 10, 10, 10, 10, 5, //
        -5, 0, 0, 0, 0, 0, 0, -5, //
        -5, 0, 0, 0, 0, 0, 0, -5, //
        -5, 0, 0, 0, 0, 0, 0, -5, //
        -5, 0, 0, 0, 0, 0, 0, -5, //
        -5, 0, 0, 0, 0, 0, 0, -5, //
        0, 0, 0, 5, 5, 0, 0, 0 };

    final static int[] WQUEEN = new int[] //
    { -20, -10, -10, -5, -5, -10, -10, -20, //
        -10, 0, 0, 0, 0, 0, 0, -10, //
        -10, 0, 5, 5, 5, 5, 0, -10, //
        -5, 0, 5, 5, 5, 5, 0, -5, //
        -5, 0, 5, 5, 5, 5, 0, -5, //
        -10, 5, 5, 5, 5, 5, 0, -10, //
        -10, 0, 5, 0, 0, 0, 0, -10, //
        -20, -10, -10, -5, -5, -10, -10, -20 };

    public final static int[] WKING_MIDDLE = new int[] //
    { -30, -40, -40, -50, -50, -40, -40, -30, //
        -30, -40, -40, -50, -50, -40, -40, -30, //
        -30, -40, -40, -50, -50, -40, -40, -30, //
        -30, -40, -40, -50, -50, -40, -40, -30, //
        -20, -30, -30, -40, -40, -30, -30, -20, //
        -10, -20, -20, -20, -20, -20, -20, -10, //
        20, 20, 0, 0, 0, 0, 20, 20, //
        20, 30, 10, 0, 0, 10, 30, 20 };

    public final static int[] WKING_END = new int[] //
    { -50, -40, -30, -20, -20, -30, -40, -50, //
        -30, -20, -10, 0, 0, -10, -20, -30, //
        -30, -10, 20, 30, 30, 20, -10, -30, //
        -30, -10, 30, 40, 40, 30, -10, -30, //
        -30, -10, 30, 40, 40, 30, -10, -30, //
        -30, -10, 20, 30, 30, 20, -10, -30, //
        -30, -30, 0, 0, 0, 0, -30, -30, //
        -50, -30, -30, -30, -30, -30, -30, -50 };

    // P = 100
    // N = 320
    // B = 330
    // R = 500
    // Q = 900
    // K = 20000

    private static int[] invert(int[] w, int offset) {
        int[] b = new int[64];
        int[] t = w.clone();
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++)
                w[8 * (7 - r) + c] = t[8 * r + c]+offset;
        for (int r = 0; r < 8; r++)
            for (int c = 0; c < 8; c++)
                b[8 * (7 - r) + c] = -w[8 * r + c];
        return b;
    }

    final static int[] BPAWN = invert(WPAWN, 100);

    final static int[] BKNIGHT = invert(WKNIGHT, 320);

    final static int[] BBISHOP = invert(WBISHOP, 330);

    final static int[] BROOK = invert(WROOK, 500);

    final static int[] BQUEEN = invert(WQUEEN, 900);

    public final static int[] BKING_MIDDLE = invert(WKING_MIDDLE, 20000);

    public final static int[] BKING_END = invert(WKING_END, 20000);

    public final static int pVal(int p, int type) {
        switch (type) {
            case IConst.WP:
                return WPAWN[p];
            case IConst.WN:
                return WKNIGHT[p];
            case IConst.WB:
                return WBISHOP[p];
            case IConst.WR:
                return WROOK[p];
            case IConst.WQ:
                return WQUEEN[p];
            case IConst.WK:
                return WKING_MIDDLE[p];
            case IConst.BP:
                return BPAWN[p];
            case IConst.BN:
                return BKNIGHT[p];
            case IConst.BB:
                return BBISHOP[p];
            case IConst.BR:
                return BROOK[p];
            case IConst.BQ:
                return BQUEEN[p];
            case IConst.BK:
                return BKING_MIDDLE[p];
        }
        return 0;
    }

}

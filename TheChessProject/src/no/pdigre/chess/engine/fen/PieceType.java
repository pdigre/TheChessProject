package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.IConst;


public enum PieceType {
    WHITE_PAWN(100, 'P', IConst.WHITE_PAWN),
    WHITE_KNIGHT(300, 'N', IConst.WHITE_KNIGHT),
    WHITE_BISHOP(300, 'B', IConst.WHITE_BISHOP),
    WHITE_ROOK(500, 'R', IConst.WHITE_ROOK),
    WHITE_QUEEN(900, 'Q', IConst.WHITE_QUEEN),
    WHITE_KING(20000, 'K', IConst.WHITE_KING),
    BLACK_PAWN(-100, 'p', IConst.BLACK_PAWN),
    BLACK_KNIGHT(-300, 'n', IConst.BLACK_KNIGHT),
    BLACK_BISHOP(-300, 'b', IConst.BLACK_BISHOP),
    BLACK_ROOK(-500, 'r', IConst.BLACK_ROOK),
    BLACK_QUEEN(-900, 'q', IConst.BLACK_QUEEN),
    BLACK_KING(-20000, 'k', IConst.BLACK_KING);

    final public int weight;

    final public char fen;

    final public int bitmap;


    final public static PieceType[] types = assign();

    PieceType(int weight, char fen, int bitmap) {
        this.weight = weight;
        this.fen = fen;
        this.bitmap = bitmap;
    }

    private static PieceType[] assign() {
    	PieceType[] pcs=new PieceType[16];
    	PieceType[] values = PieceType.values();
    	for (PieceType pt : values)
			pcs[pt.bitmap]=pt;
    	return pcs;
	}

	final public static PieceType lookup(char fen) {
        for (PieceType type : PieceType.values()) {
            if (type.fen == fen)
                return type;
        }
        return null;
    }


}
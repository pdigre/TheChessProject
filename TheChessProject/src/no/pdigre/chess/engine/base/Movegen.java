package no.pdigre.chess.engine.base;

import no.pdigre.chess.engine.fen.Position64;

public abstract class Movegen implements IConst{
	final Position64 pos;
	final long halfmoves;
	final long castling;
	final long bb_piece;
	final long bb_white;
	final long bb_black;
	final long bb_bit1;
	final long bb_bit2;
	final long bb_bit3;

//	final long line_attack;
//	final long line_block;
//	final long line_mobile;
//	final long line_pinned;
//	final long diag_attack;
//	final long diag_block;
//	final long diag_mobile;
//	final long diag_pinned;
//
//	final long bb_check;	// pieces checking
//	final long bb_pinned;   // pieces that are blocking
	
	final MOVEDATA[] moves = new MOVEDATA[99];
	int imoves = 0;
	final int wking;
	final int bking;
	final public int enpassant;

	protected int n = 0;
	protected int test = 0;
	protected final Position64[] list = new Position64[99];

	Movegen(Position64 pos) {
		this.pos = pos;
		long inherit = pos.getBitmap();
		this.bb_black = pos.get64black();
		this.bb_bit1 = pos.get64bit1();
		this.bb_bit2 = pos.get64bit2();
		this.bb_bit3 = pos.get64bit3();
		this.bb_piece = bb_bit1 | bb_bit2 | bb_bit3;
		this.bb_white = bb_piece ^ bb_black;
		this.enpassant = BITS.getEnpassant(inherit);
		this.wking = pos.getWKpos();
		this.bking = pos.getBKpos();
		halfmoves = (BITS.halfMoves(inherit) + 1) << _HALFMOVES;
		castling = ~CASTLING_STATE | inherit; // all other are set
		
		// knights - cannot be blocked
		// Pawn - cannot be blocked
	    // Bishop/Queen map1
			// danger map - which enemy can potentially check
			// check map - which enemy pieces are checking the king
			// pinned map - which own pieces are blocking a check
		    // mobile map - moves until checking piece
		// Rook/Queen map2
			// danger map - which enemy can potentially check
			// check map - which enemy pieces are checking the king
			// pinned map - which own pieces are blocking a check
			// mobile map - moves until checking piece
	}

	
	
	
	public abstract Position64[] moves();

	public void pruneBlack() {
		while (test < imoves) {
			Position64 next = (Position64) pos.move(moves[test++],castling);
			if (!next.isCheckBlack())
				list[n++] = next;
		}
	}

	public void pruneWhite() {
		while (test < imoves) {
			Position64 next = (Position64) pos.move(moves[test++],castling);
			if (!next.isCheckWhite())
				list[n++] = next;
		}
	}

	final void add(long bitmap) {
		moves[imoves++] = MOVEDATA.create(bitmap & castling);
	}

	final void add(MOVEDATA data) {
		moves[imoves++] = data;
	}

	final int type(long bit) {
		return ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4);
	}
	
	final int ctype(long bit) {
		return ((bb_bit1 & bit) == 0 ? 0 : 1) + ((bb_bit2 & bit) == 0 ? 0 : 2) + ((bb_bit3 & bit) == 0 ? 0 : 2) - 1;
	}
	
	
}

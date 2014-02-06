package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.EBase;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.base.KingSafe;
import no.pdigre.chess.engine.base.ZobristKey;

public class Position64 implements IPosition64 {

	long bb_white;
	long bb_black;
	long bb_bit1;
	long bb_bit2;
	long bb_bit3;
	int checkstate=0;
	final int wking;
	final int bking;
	final boolean whiteNext;
	final int bitmap;
	final long zobrist;
	
	@Override
	public boolean isCheckWhite(){
		if( (checkstate & 1) ==0)
			checkstate |= 1 | (KingSafe.pos(this).isCheckWhite()?2:0);
		return (checkstate & 2)!=0 ;
	}
	
	@Override
	public boolean isCheckBlack(){
		if( (checkstate & 4) ==0)
			checkstate |= 4 | (KingSafe.pos(this).isCheckBlack()?8:0);
		return (checkstate & 8)!=0 ;
	}
	
	public static IPosition64 getPosition64(IPosition pos){
		if(pos instanceof IPosition64)
			return (IPosition64) pos;
		return new Position64(pos);
	}

	public Position64(IPosition pos) {
		whiteNext = pos.whiteNext();
		bitmap = pos.getBitmap();
		int wking = 0;
		int bking = 0;
		for (int i = 0; i < 64; i++) {
			int p = pos.getPiece(i);
			if (p != 0) {
				switch (p) {
				case WHITE_KING:
					wking = i;
					break;
				case BLACK_KING:
					bking = i;
					break;
				}
				long bit = 1L << i;
				bb_bit1 |= ((p & 1) == 0 ? 0 : bit);
				bb_bit2 |= ((p & 2) == 0 ? 0 : bit);
				bb_bit3 |= ((p & 4) == 0 ? 0 : bit);
				bb_black |= ((p & 8) == 0 ? 0 : bit);
			}
		}
		this.wking = wking;
		this.bking = bking;
		this.zobrist = ZobristKey.getKey(pos);
	}

	public static Position64 move(IPosition in, int move) {
		IPosition64 pos = Position64.getPosition64(in);
		long bb_black = pos.get64black();
		long bb_bit1 = pos.get64bit1();
		long bb_bit2 = pos.get64bit2();
		long bb_bit3 = pos.get64bit3();
		int wking = pos.getWKpos();
		int bking = pos.getBKpos();
//		long zobrist = pos.getZobristKey();
		long zobrist = 0L;
		int bitmap0=pos.getBitmap();

		// Apply move
		int from = BITS.getFrom(move);
		int to = BITS.getTo(move);
		int piece = BITS.getPiece(move);
		EBase b=EBase.TYPES[piece];
		if (from == wking)
			wking = to;
		if (from == bking)
			bking = to;
		{
			long bfrom = 1L << from;
			long bto = 1L << to;
			long mask = ~(bfrom | bto);
			bb_bit1 = (bb_bit1 & mask) | ((piece & 1) == 0 ? 0 : bto);
			bb_bit2 = (bb_bit2 & mask) | ((piece & 2) == 0 ? 0 : bto);
			bb_bit3 = (bb_bit3 & mask) | ((piece & 4) == 0 ? 0 : bto);
			bb_black = (bb_black & mask) | ((piece & 8) == 0 ? 0 : bto);
			zobrist^=b.zobrist[from]^b.zobrist[to]^ZobristKey.ZOBRIST_NXT;
			int cstl = (move^bitmap0)&IConst.CASTLING_STATE;
			if(cstl!=0)
				zobrist=ZobristKey.castling(zobrist,cstl);
		}

		if (BITS.isCastling(move)) {
			if (from > to) {
				to = from - 1;
				from = from - 4;
			} else {
				to = from + 1;
				from = from + 3;
			}
			long bfrom = 1L << from;
			long bto = 1L << to;
			long mask = ~(bfrom | bto);
			bb_bit1 = (bb_bit1 & mask) | ((bb_bit1 & bfrom) == 0 ? 0 : bto);
			bb_bit2 = (bb_bit2 & mask) | ((bb_bit2 & bfrom) == 0 ? 0 : bto);
			bb_bit3 = (bb_bit3 & mask) | ((bb_bit3 & bfrom) == 0 ? 0 : bto);
			bb_black = (bb_black & mask) | ((bb_black & bfrom) == 0 ? 0 : bto);
		} else if (BITS.isEnpassant(move)) {
			from = to + (to > from ? -8 : 8);
			long bfrom = 1L << from;
			long mask = ~bfrom;
			bb_black = bb_black & mask;
			bb_bit1 = bb_bit1 & mask;
			bb_bit2 = bb_bit2 & mask;
			bb_bit3 = bb_bit3 & mask;
		}
		return new Position64(move, pos.whiteNext(), bb_black, bb_bit1, bb_bit2, bb_bit3, wking, bking,zobrist);
	}

	public Position64(int bitmap, boolean whiteNext, long bb_black, long bb_bit1, long bb_bit2, long bb_bit3, int wking, int bking,long zobrist) {
		this.bitmap = bitmap;
		this.wking = wking;
		this.bking = bking;
		this.whiteNext = !whiteNext;
		this.bb_black = bb_black;
		this.bb_bit1 = bb_bit1;
		this.bb_bit2 = bb_bit2;
		this.bb_bit3 = bb_bit3;
		this.zobrist=zobrist;
	}

	@Override
	public boolean whiteNext() {
		return whiteNext;
	}

	@Override
	public int getWKpos() {
		return wking;
	}

	@Override
	public int getBKpos() {
		return bking;
	}

	@Override
	public int getBitmap() {
		return bitmap;
	}

	@Override
	public long get64black() {
		return bb_black;
	}

	@Override
	public long get64bit1() {
		return bb_bit1;
	}

	@Override
	public long get64bit2() {
		return bb_bit2;
	}

	@Override
	public long get64bit3() {
		return bb_bit3;
	}

	@Override
	public int getPiece(int i) {
		long bit = 1L << i;
		return ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4) | ((bb_black & bit) == 0 ? 0 : 8);
	}

	@Override
	public int[] getBoard() {
		int[] board = new int[64];
		for (int i = 0; i < board.length; i++)
			board[i] = getPiece(i);
		return board;
	}

	@Override
	public String toString() {
		return FEN.printMove(this) + "\n" + FEN.board2string(this);
	}

	@Override
	public IPosition64 move(int bitmap) {
		return move(this, bitmap);
	}
	
	@Override
	public long getZobristKey() {
		return ZobristKey.getKey(this);
	}
}

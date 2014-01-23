package no.pdigre.chess.engine.fen;


public class Position64Wrapper implements IPosition64 {

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
	public int getWKpos() {
		return wking;
	}

	@Override
	public int getBKpos() {
		return bking;
	}

	@Override
	public boolean whiteNext() {
		return whiteNext;
	}

	@Override
	public int getBitmap() {
		return bitmap;
	}

	long bb_black = 0;
	long bb_bit1 = 0;
	long bb_bit2 = 0;
	long bb_bit3 = 0;
	int wking = 0;
	int bking = 0;
	final private boolean whiteNext;
	final private int bitmap;
	
	public Position64Wrapper(IPosition pos) {
		whiteNext=pos.whiteNext();
		bitmap=pos.getBitmap();
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
				bb_bit1|=((p&1)==0?0:bit);
				bb_bit2|=((p&2)==0?0:bit);
				bb_bit3|=((p&4)==0?0:bit);
				bb_black|=((p&8)==0?0:bit);
			}
		}
	}

	@Override
	public int getPiece(int i) {
		long bit = 1L << i;
		return ((bb_bit1&bit)==0?0:1)|((bb_bit2&bit)==0?0:2)|((bb_bit3&bit)==0?0:4)|((bb_black&bit)==0?0:8);
	}

	@Override
	public int[] getBoard() {
		int[] board=new int[64];
		for (int i = 0; i < board.length; i++)
			board[i]=getPiece(i);
		return board;
	}

	@Override
	public String toString() {
        return FEN.printMove(this)+"\n"+FEN.board2string(this);
	}

	@Override
	public IPosition64 move(int bitmap) {
		return Position64.move(this, bitmap);
	}
}

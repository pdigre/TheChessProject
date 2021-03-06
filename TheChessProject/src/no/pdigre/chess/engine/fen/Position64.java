package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.base.EBase;
import no.pdigre.chess.engine.base.IConst;
import no.pdigre.chess.engine.base.KingSafe;
import no.pdigre.chess.engine.base.ZobristKey;

public class Position64 implements IPosition64 {

	long bb_bit1;
	long bb_bit2;
	long bb_bit3;
	long bb_black;
	int checkstate=0;
	final int wking;
	final int bking;
	final long bitmap;
	final long zobrist;
	public int score=0;
	public int quality=0;
	
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
	
	public static Position64 getPosition64(IPosition pos){
		if(pos instanceof Position64)
			return (Position64) pos;
		return new Position64(pos);
	}

	public Position64(IPosition pos) {
		bitmap = pos.getBitmap();
		int wking = 0;
		int bking = 0;
		for (int i = 0; i < 64; i++) {
			int p = pos.getPiece(i);
			if (p != 0) {
				switch (p) {
				case WK:
					wking = i;
					break;
				case BK:
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
		this.score=pos.getScore();
	}

	public static Position64 move(IPosition in, long move) {
		IPosition64 pos = Position64.getPosition64(in);
		long bb_black = pos.get64black();
		long bb_bit1 = pos.get64bit1();
		long bb_bit2 = pos.get64bit2();
		long bb_bit3 = pos.get64bit3();
		int wking = pos.getWKpos();
		int bking = pos.getBKpos();
		long zobrist = pos.getZobristKey();
//		long zobrist = 0L;
		long bitmap0=pos.getBitmap();

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
			long cstl = (move^bitmap0)&IConst.CASTLING_STATE;
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
		return new Position64(move, pos.getScore()+(int)(move >>32),pos.whiteNext(), bb_black, bb_bit1, bb_bit2, bb_bit3, wking, bking,zobrist);
	}

	public Position64(long bitmap, int score,boolean whiteNext, long bb_black, long bb_bit1, long bb_bit2, long bb_bit3, int wking, int bking,long zobrist) {
		this.bitmap = bitmap;
		this.wking = wking;
		this.bking = bking;
		this.bb_black = bb_black;
		this.bb_bit1 = bb_bit1;
		this.bb_bit2 = bb_bit2;
		this.bb_bit3 = bb_bit3;
		this.zobrist=zobrist;
		this.score=score;
	}

	@Override
	public boolean whiteNext() {
		return BITS.black(bitmap);
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
	public long getBitmap() {
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
	public Position64 move(long bitmap) {
		return move(this, bitmap);
	}
	
	@Override
	public long getZobristKey() {
		return zobrist;
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public int getQuality() {
		return quality;
	}

	@Override
	public int compareTo(IPosition o) {
		return Integer.compare(score, o.getScore());
	}

	public static Position64 fen2pos(String fen){
		String[] split = fen.split(" ");
		String fenboard = split[0];
		boolean white = "w".equalsIgnoreCase(split[1]);
		String castling = split[2];
		int enpassant = FEN.text2pos(split[3]);
		int halfMoves = Integer.parseInt(split[4]);
//		int fullMoves = Integer.parseInt(split[5]);

        long enp=0;
        if(enpassant!=-1){
            if(white){
                enp=SPECIAL|WP|(enpassant+8)<<_FROM|(enpassant-8)<<_TO;
            }else {
                enp=SPECIAL|WP|(enpassant-8)<<_FROM|(enpassant+8)<<_TO;
            }
        }
		long cstl = (castling.contains("K") ? CANCASTLE_WHITEKING:0)
				| (castling.contains("Q") ? CANCASTLE_WHITEQUEEN:0)
				| (castling.contains("k") ? CANCASTLE_BLACKKING:0)
				| (castling.contains("q") ? CANCASTLE_BLACKQUEEN:0);
		long bitmap=(halfMoves<<_HALFMOVES)|cstl|(white?BLACK:0)|enp;


        /*********************************
         * Read board
         * *******************************/
		int[] board = new int[64];
        int y = 56;
        int x = 0;
        for (int i = 0; i < fenboard.length(); i++) {
            char c = fenboard.charAt(i);
            if (c == '/') {
                y -= 8;
                x = 0;
            } else if (c == ' ') {
                break;
            } else if (c >= '0' && c <= '9') {
                x += Integer.parseInt(String.valueOf(c));
            } else if (c >= 'A' && c <= 'z') {
                board[x + y] = PieceType.lookup(c).bitmap;
                x++;
            }
        }

        
        /*********************************
         * Assign bitmaps
         * *******************************/
        int wking = 0;
		int bking = 0;
		long bb_bit1=0L;
		long bb_bit2=0L;
		long bb_bit3=0L;
		long bb_black=0L;
		for (int i = 0; i < 64; i++) {
			int p = board[i];
			if (p != 0) {
				switch (p) {
				case WK:
					wking = i;
					break;
				case BK:
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
		

		long zobrist=0L;
		int score=0;
		return new Position64(bitmap, score, white, bb_black, bb_bit1, bb_bit2, bb_bit3, wking, bking, zobrist);
	}
}

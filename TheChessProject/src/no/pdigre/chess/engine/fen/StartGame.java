package no.pdigre.chess.engine.fen;




public class StartGame implements IPositionWithLog {

	private final String castling;
	private final boolean white;
	private final int enpassant;
	private final int halfMoves;
	private final int fullMoves;
	private final int[] board;

	public StartGame(String fen) {
		String[] split = fen.split(" ");
		board = FEN.fen2board(split[0]);
		white = "w".equalsIgnoreCase(split[1]);
		castling = split[2];
		enpassant = FEN.text2pos(split[3]);
		halfMoves = Integer.parseInt(split[4]);
		fullMoves = Integer.parseInt(split[5]);
	}

	@Override
	public int[] getBoard() {
	    return board;
	}
	@Override
	public boolean whiteNext() {
		return white;
	}

	@Override
	public int totalMoves() {
		return fullMoves;
	}

	final private int getCastlingState() {
		return (castling.contains("K") ? CANCASTLE_WHITEKING:0)
				| (castling.contains("Q") ? CANCASTLE_WHITEQUEEN:0)
				| (castling.contains("k") ? CANCASTLE_BLACKKING:0)
				| (castling.contains("q") ? CANCASTLE_BLACKQUEEN:0);
	}

    @Override
    public int getBitmap() {
        int enp=0;
        if(enpassant!=-1){
            if(white){
                enp=SPECIAL|WHITE_PAWN|(enpassant+8)<<_FROM|(enpassant-8)<<_TO;
            }else {
                enp=SPECIAL|WHITE_PAWN|(enpassant-8)<<_FROM|(enpassant+8)<<_TO;
            }
        }
        return (halfMoves<<_HALFMOVES)|getCastlingState()|(white?BLACK:0)|enp;
    }

    @Override
    public IPosition move(int bitmap2) {
        return new Position(IPosition.BOARD88.apply(board, bitmap2), bitmap2);
    }

    @Override
    public int getPiece(int square) {
        return board[square];
    }

    @Override
    public String toString() {
        return FEN.printMove(this)+"\n"+FEN.board2string(this);
    }

	@Override
	public int getWKpos() {
		return BOARD88.getWKpos(this);
	}

	@Override
	public int getBKpos() {
		return BOARD88.getBKpos(this);
	}

	@Override
	public long getZobristKey() {
		return 0L;
	}
}

package no.pdigre.chess.engine.fen;

import no.pdigre.chess.engine.evaluate.IEvaluator;

public class StartGame extends PositionWithLog {

	private final String castling;
	private final boolean white;
	private final int enpassant;
	private final int halfMoves;
	private final int fullMoves;

	public StartGame(String fen) {
		super();
		String[] split = fen.split(" ");
		setBoard(FEN.fen2board(split[0]));
		white = "w".equalsIgnoreCase(split[1]);
		castling = split[2];
		enpassant = FEN.text2pos(split[3]);
		halfMoves = Integer.parseInt(split[4]);
		fullMoves = Integer.parseInt(split[5]);
	}

	@Override
	public boolean whiteNext() {
		return white;
	}

	@Override
	public int totalMoves() {
		return fullMoves;
	}

	final private long getCastlingState() {
		return (castling.contains("K") ? CANCASTLE_WHITEKING:0)
				| (castling.contains("Q") ? CANCASTLE_WHITEQUEEN:0)
				| (castling.contains("k") ? CANCASTLE_BLACKKING:0)
				| (castling.contains("q") ? CANCASTLE_BLACKQUEEN:0);
	}

    @Override
    public long getBitmap() {
        int enp=0;
        if(enpassant!=-1){
            if(white){
                enp=SPECIAL|WP|(enpassant+8)<<_FROM|(enpassant-8)<<_TO;
            }else {
                enp=SPECIAL|WP|(enpassant-8)<<_FROM|(enpassant+8)<<_TO;
            }
        }
        return (halfMoves<<_HALFMOVES)|getCastlingState()|(white?BLACK:0)|enp;
    }

    @Override
    public String toString() {
        return FEN.printMove(this)+"\n"+FEN.board2string(this);
    }

	@Override
	public long getZobristKey() {
		return 0L;
	}

	@Override
	public int getScore() {
		return IEvaluator.FULL.score(this, 0);
	}

	@Override
	public int getQuality() {
		return 0;
	}

	@Override
	public int compareTo(IPosition o) {
		return Integer.compare(getScore(), o.getScore());
	}
}

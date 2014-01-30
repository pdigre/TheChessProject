package no.pdigre.chess.engine.base;

import java.util.ArrayList;
import java.util.List;

import no.pdigre.chess.engine.fen.IPosition;
import no.pdigre.chess.engine.fen.IPosition64;
import no.pdigre.chess.engine.fen.Position64;

public class NodeGen implements IConst {

	final private int[] moves = new int[300];
	private int imoves;
	final private int enpassant;
	final private IPosition64 pos;
	final private int halfmoves;
	final private int castling;
	final private long bb_piece;
	final private long bb_white;
	final private long bb_black;
	final private long bb_bit1;
	final private long bb_bit2;
	final private long bb_bit3;
	final private int wking;
	final private int bking;
	final private boolean whiteNext;

	private NodeGen(IPosition64 pos) {
		this.pos = pos;
		int inherit = pos.getBitmap();
		this.bb_black = pos.get64black();
		this.bb_bit1 = pos.get64bit1();
		this.bb_bit2 = pos.get64bit2();
		this.bb_bit3 = pos.get64bit3();
		this.wking = pos.getWKpos();
		this.bking = pos.getBKpos();
		this.whiteNext = pos.whiteNext();
		this.bb_piece = bb_bit1 | bb_bit2 | bb_bit3;
		this.bb_white = bb_piece ^ bb_black;

		halfmoves = (BITS.halfMoves(inherit) + 1) << _HALFMOVES;
		castling = ~CASTLING_STATE | inherit; // all other are set
		enpassant = BITS.getEnpassant(inherit);
	}

	final private int[] getAllLegalMoves() {
		ArrayList<IPosition64> list = getAllLegalMoves64();
		int[] ret = new int[list.size()];
		for (int i = 0; i < ret.length; i++) 
			ret[i]=list.get(i).getBitmap();
		return ret;
	}

	final private ArrayList<IPosition64> getAllLegalMoves64() {
		ArrayList<IPosition64> list = new ArrayList<IPosition64>();
		int test = 0;
		if (whiteNext) {
			getWhiteKingMoves();
			long bit = 1L;
			int i = 0;
			while (bit != 0) {
				if ((bb_white & bit) != 0) {
					getMoves(i, piece(bit));
					while (test < imoves) {
						int bitmap = moves[test++];
						IPosition64 next = pos.move(bitmap);
						if (!next.isCheckWhite())
							list.add(next);
					}
				}
				bit = bit << 1;
				i++;
			}
		} else {
			getBlackKingMoves();
			long bit = 1L;
			int i = 0;
			while (bit != 0) {
				if ((bb_black & bit) != 0) {
					getMoves(i, piece(bit));
					while (test < imoves) {
						int bitmap = moves[test++];
						IPosition64 next = pos.move(bitmap);
						if (!next.isCheckBlack())
							list.add(next);
					}
				}
				bit = bit << 1;
				i++;
			}
		}
		return list;
	}

	final private void getMoves(int from, int ptype) {
		switch (ptype) {
		case WHITE_BISHOP:
			for (int[] slides : IBase.M32_WHITE_BISHOP[from])
				for (int i = 0; i < slides.length && slideWhite(slides[i]); i++)
					;
			break;
		case BLACK_BISHOP:
			for (int[] slides : IBase.M32_BLACK_BISHOP[from])
				for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
					;
			break;
		case WHITE_ROOK:
			for (int[] slides : IBase.M32_WHITE_ROOK[from])
				for (int i1 = 0; i1 < slides.length && slideWhite(slides[i1]); i1++)
					;
			break;
		case BLACK_ROOK:
			for (int[] slides : IBase.M32_BLACK_ROOK[from])
				for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
					;
			break;
		case WHITE_QUEEN:
			for (int[] slides : IBase.M32_WHITE_QUEEN[from])
				for (int i = 0; i < slides.length && slideWhite(slides[i]); i++)
					;
			break;
		case BLACK_QUEEN:
			for (int[] slides : IBase.M32_BLACK_QUEEN[from])
				for (int i = 0; i < slides.length && slideBlack(slides[i]); i++)
					;
			break;
		case WHITE_KNIGHT:
			for (int bitmap : IBase.M32_WHITE_KNIGHT[from])
				slideWhite(bitmap);
			break;
		case BLACK_KNIGHT:
			for (int bitmap : IBase.M32_BLACK_KNIGHT[from])
				slideBlack(bitmap);
			break;
		case WHITE_KING:
			break;
		case BLACK_KING:
			break;
		case BLACK_PAWN:
			for (int[] slides : IBase.M32_BLACK_PAWN[from])
				for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++)
					;
			for (int bitmap : IBase.M32_BLACK_PAWN_CAPTURE[from])
				pawnCaptureBlack(bitmap);
			break;
		case WHITE_PAWN:
			for (int[] slides : IBase.M32_WHITE_PAWN[from])
				for (int i = 0; i < slides.length && pawnSlide(slides[i]); i++)
					;
			for (int bitmap : IBase.M32_WHITE_PAWN_CAPTURE[from])
				pawnCaptureWhite(bitmap);
			break;
		}
	}

	final private void getWhiteKingMoves() {
		for (int bitmap : IBase.M32_WHITE_KING[wking])
			slideWhite(bitmap);
		if ((castling & CANCASTLE_WHITEQUEEN) != 0) {
			if (!board(WHITE_KING_STARTPOS - 1) && !board(WHITE_KING_STARTPOS - 2) && !board(WHITE_KING_STARTPOS - 3))
				if (!pos.isCheckWhite() && !pos.move(IBase.WHITE_QUEENSIDE).isCheckWhite())
					add(IBase.CASTLING_WHITE_QUEEN & castling);
		}
		if ((castling & CANCASTLE_WHITEKING) != 0) {
			if (!board(WHITE_KING_STARTPOS + 1) && !board(WHITE_KING_STARTPOS + 2))
				if (!pos.isCheckWhite() && !pos.move(IBase.WHITE_KINGSIDE).isCheckWhite())
					add(IBase.CASTLING_WHITE_KING & castling);
		}
	}

	final private void getBlackKingMoves() {
		for (int bitmap : IBase.M32_BLACK_KING[bking])
			slideBlack(bitmap);
		if ((castling & CANCASTLE_BLACKQUEEN) != 0) {
			if (!board(BLACK_KING_STARTPOS - 1) && !board(BLACK_KING_STARTPOS - 2) && !board(BLACK_KING_STARTPOS - 3))
				if (!pos.isCheckBlack() && !pos.move(IBase.BLACK_QUEENSIDE).isCheckBlack()) {
					add(IBase.CASTLING_BLACK_QUEEN & castling);
				}
		}
		if ((castling & CANCASTLE_BLACKKING) != 0) {
			if (!board(BLACK_KING_STARTPOS + 1) && !board(BLACK_KING_STARTPOS + 2))
				if (!pos.isCheckBlack() && !pos.move(IBase.BLACK_KINGSIDE).isCheckBlack()) {
					add(IBase.CASTLING_BLACK_KING & castling);
				}
		}
	}

	final private boolean board(int i) {
		return (bb_piece & 1L << i) != 0;
	}

	final private boolean black(int i) {
		return (bb_black & 1L << i) != 0;
	}

	final private boolean white(int i) {
		return (bb_white & 1L << i) != 0;
	}

	final private int type(int i) {
		long bit = 1L << i;
		return ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4);
	}

	final private int piece(int i) {
		return piece(1L << i);
	}

	final private int piece(long bit) {
		return ((bb_bit1 & bit) == 0 ? 0 : 1) | ((bb_bit2 & bit) == 0 ? 0 : 2) | ((bb_bit3 & bit) == 0 ? 0 : 4) | ((bb_black & bit) == 0 ? 0 : 8);
	}

	final private boolean slideWhite(int bitmap) {
		int to = BITS.getTo(bitmap);
		if (!board(to)) {
			add((bitmap & castling) | halfmoves);
			return true;
		} else if (black(to)) {
			int type = type(to);
			if(type==WHITE_ROOK){
				if(to==BLACK_ROOK_KING_STARTPOS)
					bitmap=bitmap&~CANCASTLE_BLACKKING;
				if(to==BLACK_ROOK_QUEEN_STARTPOS)
					bitmap=bitmap&~CANCASTLE_BLACKQUEEN;
			}
			add((bitmap & castling) | (type << _CAPTURE));
		}
		return false;
	}

	final private boolean slideBlack(int bitmap) {
		int to = BITS.getTo(bitmap);
		if (!board(to)) {
			add((bitmap & castling) | halfmoves);
			return true;
		} else if (white(to)) {
			int type = type(to);
			if(type==WHITE_ROOK){
				if(to==WHITE_ROOK_KING_STARTPOS)
					bitmap=bitmap&~CANCASTLE_WHITEKING;
				if(to==WHITE_ROOK_QUEEN_STARTPOS)
					bitmap=bitmap&~CANCASTLE_WHITEQUEEN;
			}
			add((bitmap & castling) | (type << _CAPTURE));
		}
		return false;
	}

	final private void pawnCaptureWhite(int bitmap) {
		int to = BITS.getTo(bitmap);
		if (enpassant == to) {
			add((bitmap & castling) | (WHITE_PAWN << _CAPTURE) | SPECIAL);
		} else {
			if (black(to)) {
				int type = type(to);
				if(type==WHITE_ROOK){
					if(to==BLACK_ROOK_KING_STARTPOS)
						bitmap=bitmap&~CANCASTLE_BLACKKING;
					if(to==BLACK_ROOK_QUEEN_STARTPOS)
						bitmap=bitmap&~CANCASTLE_BLACKQUEEN;
				}
				add((bitmap & castling) | (type << _CAPTURE));
			}
		}
	}

	final private void pawnCaptureBlack(int bitmap) {
		int to = BITS.getTo(bitmap);
		if (enpassant == to) {
			add((bitmap & castling) | (WHITE_PAWN << _CAPTURE) | SPECIAL);
		} else {
			if (white(to)) {
				int type = type(to);
				if(type==WHITE_ROOK){
					if(to==WHITE_ROOK_KING_STARTPOS)
						bitmap=bitmap&~CANCASTLE_WHITEKING;
					if(to==WHITE_ROOK_QUEEN_STARTPOS)
						bitmap=bitmap&~CANCASTLE_WHITEQUEEN;
				}
				add((bitmap & castling) | (type << _CAPTURE));
			}
		}
	}

	final private boolean pawnSlide(int bitmap) {
		if (!board(BITS.getTo(bitmap))) {
			add(bitmap & castling);
			return true;
		}
		return false;
	}

	final private void add(int bitmap) {
		moves[imoves++] = bitmap;
	}

	public static final int[] getLegalMoves(IPosition pos) {
		return create(pos).getAllLegalMoves();
	}

	public static final NodeGen create(IPosition pos) {
		return new NodeGen(Position64.getPosition64(pos));
	}

	public static final List<IPosition64> getLegalMoves64(IPosition pos) {
		return create(pos).getAllLegalMoves64();
	}

}

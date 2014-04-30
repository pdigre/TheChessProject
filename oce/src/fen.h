/*
 * fen.h
 *
 *  Created on: 18. apr. 2014
 *      Author: pdigre
 */

#ifndef FEN_H_
#define FEN_H_

typedef struct{
	unsigned long long b0;  // Lesser (slider=bishop)  / (pawn)
	unsigned long long b1;  // Bigger (slider=rook/queen)  /  (knight/king)
	unsigned long long b2;  // Slider bit
	unsigned long long b3;  // Black bit
	unsigned long long state;
	unsigned long long zobrist;
}  M64;

typedef struct{
	M64 moves[99];
	int count;
}  MOVES64;

// Pieces
#define WP 0x1
#define WN 0x2
#define WK 0x3
#define WB 0x5
#define WR 0x6
#define WQ 0x7
#define BP 0x9
#define BN 0xA
#define BK 0xB
#define BB 0xD
#define BR 0xE
#define BQ 0xF

// State position
#define _PIECE 0
#define _LESSER 0
#define _BIGGER 1
#define _SLIDER 2
#define _BLACK 3
#define _FROM 4
#define _TO 10
#define _CAPTURE 16
#define _SPECIAL 19
#define _CASTLING 20
#define _CASTLING_WQ 20
#define _CASTLING_WK 21
#define _CASTLING_BQ 22
#define _CASTLING_BK 23
#define _HALFMOVES 24

#define MASK_PIECE  0x000FLL
#define MASK_FROM   0x03F0LL
#define MASK_TO     0xFC00LL
#define MASK_FROMTO 0xFFF0LL

#define CHECK 1
#define MATE 2
#define STALEMATE 3

#define GOAL_LINE 56
#define WK_STARTPOS 4
#define BK_STARTPOS 60
#define WRQ_STARTPOS 0
#define WRK_STARTPOS 7
#define BRQ_STARTPOS 56
#define BRK_STARTPOS 63

#define PIECE_CHAR ".PNK.BRQ.pnk.brq"

void setPiece(M64 * m64,int i,unsigned p);

unsigned getPiece(M64 * m64,int i);

void setFEN(M64 * m64,char * brd);

void getFEN(M64 * m64);

void getINFO(M64 * m64);

void move2code(int code,char * move);

int code2move(char * cmd);

int decodeMove(char * cmd);

void getPerft(M64 * m64,int lvl);

void getDivide(M64 * m64,int lvl);

void printM64(M64 * m64);

#endif /* FEN_H_ */

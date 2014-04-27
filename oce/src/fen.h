/*
 * fen.h
 *
 *  Created on: 18. apr. 2014
 *      Author: pdigre
 */

#ifndef FEN_H_
#define FEN_H_

typedef struct{
	unsigned long long b0;  // (bishop)  / (pawn)
	unsigned long long b1;  // (rook,queen)  /  (knight,king)
	unsigned long long b2;  // Slider bit
	unsigned long long b3;  // Black bit
	unsigned long long state;
	unsigned long long zobrist;
}  M64;

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

#define PIECE_CHAR ".PNK.BRQ.pnk.brq"

void setPiece(M64 * m64,int i,unsigned p);

unsigned getPiece(M64 * m64,int i);

void setFEN(M64 * m64,char * brd);

void getFEN(M64 * m64);

void getINFO(M64 * m64);

void getPerft(M64 * m64,int lvl);

void getDivide(M64 * m64,int lvl);


#endif /* FEN_H_ */

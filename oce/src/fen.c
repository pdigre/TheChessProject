/*
 ============================================================================
 Name        : uci.c
 Author      : Per
 Version     :
 Copyright   : Your copyright notice
 Description : Chess Engine in C, ANSI-style
 ============================================================================
 */

#include <windows.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "fen.h"


void setPiece(M64 * m64,int i,unsigned p){
	unsigned long long b=0x1ULL << i;
	if(p & 0x1)
		m64->b0|=b;
	if(p & 0x2)
		m64->b1|=b;
	if(p & 0x4)
		m64->b2|=b;
	if(p & 0x8)
		m64->b3|=b;
}

unsigned getPiece(M64 * m64,int i){
	unsigned long long b=0x1ULL << i;
	char p=0;
	if(b & m64->b0)
		p+=0x1;
	if(b & m64->b1)
		p+=0x2;
	if(b & m64->b2)
		p+=0x4;
	if(b & m64->b3)
		p+=0x8;
	return p;
}

void setFEN(M64 * m64,char * brd) {
	char* plr = strtok(0, " ");
	char* cst = strtok(0, " ");
	char* enp = strtok(0, " ");
	char* hlf = strtok(0, " ");
	char* mov = strtok(0, " ");
	if (!enp) {
		puts(
				"Illegal arguments for FEN - should be like \"rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1\"");
		return;
	}
	int n1 = strlen(brd);
	int i;
	int r = 56;
	int c = 0;
	for (i = 0; i < n1; i++) {
		switch (brd[i]) {
		case '/':
			r-=8;
			c = 0;
			break;
		case '1':
			c++;
			break;
		case '2':
			c += 2;
			break;
		case '3':
			c += 3;
			break;
		case '4':
			c += 4;
			break;
		case '5':
			c += 5;
			break;
		case '6':
			c += 6;
			break;
		case '7':
			c += 7;
			break;
		case '8':
			c += 8;
			break;
		case 'P':
			setPiece(m64,r + c++,WP);
			break;
		case 'N':
			setPiece(m64,r + c++,WN);
			break;
		case 'B':
			setPiece(m64,r + c++,WB);
			break;
		case 'R':
			setPiece(m64,r + c++,WR);
			break;
		case 'Q':
			setPiece(m64,r + c++,WQ);
			break;
		case 'K':
			setPiece(m64,r + c++,WK);
			break;
		case 'p':
			setPiece(m64,r + c++,BP);
			break;
		case 'n':
			setPiece(m64,r + c++,BN);
			break;
		case 'b':
			setPiece(m64,r + c++,BB);
			break;
		case 'r':
			setPiece(m64,r + c++,BR);
			break;
		case 'q':
			setPiece(m64,r + c++,BQ);
			break;
		case 'k':
			setPiece(m64,r + c++,BK);
			break;
		default:
			printf("ERROR:%c\n",brd[i]);
			break;
		}
	}
}

void getFEN(M64 * m64) {
	int r,c,i=0;
	for(r=56;r>=0;r-=8){
		if(r!=56)
			printf("/");
		for(c=0;c<8;c++){
			unsigned p=getPiece(m64,r+c);
			if(p){
				if(i>0)
					printf("%i",i);
				printf("%c",PIECE_CHAR[p]);
				i=0;
			} else {
				i++;
			}
		}
		if(i>0)
			printf("%i",i);
	}
}

void getINFO(M64 * m64) {
	int r,c;
	for(r=56;r>=0;r-=8){
		puts(" ");
		for(c=0;c<8;c++)
			printf("%c",PIECE_CHAR[getPiece(m64,r+c)]);
	}
}

void getPerft(M64 * m64,int lvl){

}

void getDivide(M64 * m64,int lvl){

}

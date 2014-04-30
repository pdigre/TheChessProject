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
#include "mov.h"


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

const char * LETTERS = "ABCDEFGH";
const char * NUMBERS = "12345678";

void move2code(int code,char * move){
	move[0]=LETTERS[code&7];
	move[1]=NUMBERS[(code>>3)&7];
}

int code2move(char * cmd){
	int i=-1;
	switch(cmd[0]){
	case 'A':
	case 'a':
		i=0;
		break;
	case 'B':
	case 'b':
		i=1;
		break;
	case 'C':
	case 'c':
		i=2;
		break;
	case 'D':
	case 'd':
		i=3;
		break;
	case 'E':
	case 'e':
		i=4;
		break;
	case 'F':
	case 'f':
		i=5;
		break;
	case 'G':
	case 'g':
		i=6;
		break;
	case 'H':
	case 'h':
		i=7;
		break;
	default:
		printf("wrong letter %c",cmd[0]);
		return -1;
	}

	switch(cmd[1]){
	case '1':
		break;
	case '2':
		i+=8;
		break;
	case '3':
		i+=16;
		break;
	case '4':
		i+=24;
		break;
	case '5':
		i+=32;
		break;
	case '6':
		i+=40;
		break;
	case '7':
		i+=48;
		break;
	case '8':
		i+=56;
		break;
	default:
		printf("wrong number %c",cmd[1]);
		return -1;
	}
	return i;
}

int decodeMove(char * cmd){
	int len = (int) strlen(cmd);
	if (len != 4) {
		printf("Wrong length %i",len);
		return -1;
	}
	int from = code2move(cmd);
	int to = code2move(&cmd[2]);
	if(from<0 || to<0)
		return -1;
	return (to<<6) | from;
}

void printM64(M64 * m64){
	unsigned long long state = m64->state;
	int from = (state >> _FROM) & 63;
	int to = (state >> _TO) & 63;
	char a[2],b[2];
	move2code(from,a);
	move2code(to,b);
	printf("from %c%c to %c%c\n",a[0],a[1],b[0],b[1]);
}


void getPerft(M64 * m64,int lvl){

}

void getDivide(M64 * m64,int lvl){
	MOVES64 moves;
	MOVES64 *pmoves = &moves;
	pmoves->count=0;
	m_wn(m64,pmoves);
	int i, n = pmoves->count;
	for (i = 0; i < n; i++) {
		printM64(&(pmoves->moves[i]));
	}
	printf("Total %i\n",n);
}

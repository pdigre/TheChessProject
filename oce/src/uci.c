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

struct M64 {
	unsigned long long b0;  // Black bit
	unsigned long long b1;  // Slider bit
	unsigned long long b2;  // (rook)  / (pawn)
	unsigned long long b3;  // (bishop,queen)  /  (knight,king)
	unsigned long long state;
	unsigned long long zobrist;
};

const int WP = 0x4;
const int WN = 0x8;
const int WB = 0xA;
const int WR = 0x6;
const int WQ = 0xE;
const int WK = 0xC;
const int BP = 0x5;
const int BN = 0x9;
const int BB = 0xB;
const int BR = 0x7;
const int BQ = 0xF;
const int BK = 0xD;

const char * PIECE_CHAR = "....PpRrNnBbKkQq";

struct M64 m64 = {0ULL,0ULL,0ULL,0ULL,0ULL,0ULL};

char** strSplit(char* a_str, const char a_delim) {
	char** result = 0;
	size_t count = 0;
	char* tmp = a_str;
	char* last_comma = 0;
	char delim[2];
	delim[0] = a_delim;
	delim[1] = 0;

	/* Count how many elements will be extracted. */
	while (*tmp) {
		if (a_delim == *tmp) {
			count++;
			last_comma = tmp;
		}
		tmp++;
	}

	/* Add space for trailing token. */
	count += last_comma < (a_str + strlen(a_str) - 1);

	/* Add space for terminating null string so caller
	 knows where the list of returned strings ends. */
	count++;

	result = malloc(sizeof(char*) * count);

	if (result) {
		size_t idx = 0;
		char* token = strtok(a_str, delim);

		while (token) {
			assert(idx < count);
			*(result + idx++) = strdup(token);
			token = strtok(0, delim);
		}
		*(result + idx) = 0;
	}

	return result;
}

char * getLine() {
	char * line = malloc(100), *linep = line;
	size_t lenmax = 100, len = lenmax;
	int c;
	if (!line)
		return NULL;
	for (;;) {
		c = fgetc(stdin);
		if (c == EOF)
			break;
		if (--len == 0) {
			len = lenmax;
			char * linen = realloc(linep, lenmax *= 2);

			if (linen == NULL) {
				free(linep);
				return NULL;
			}
			line = linen + (line - linep);
			linep = linen;
		}
		if ((*line++ = c) == '\n')
			break;
	}
	*line = '\0';
	return linep;
}

boolean active = TRUE;

void mainExit() {
	active = FALSE;
	exit(0);
}

void setPiece(int i,unsigned p){
	unsigned long long b=0x1ULL << i;
	if(p & 0x1)
		m64.b0|=b;
	if(p & 0x2)
		m64.b1|=b;
	if(p & 0x4)
		m64.b2|=b;
	if(p & 0x8)
		m64.b3|=b;
}

unsigned getPiece(int i){
	unsigned long long b=0x1ULL << i;
	char p=0;
	if(b & m64.b0)
		p+=0x1;
	if(b & m64.b1)
		p+=0x2;
	if(b & m64.b2)
		p+=0x4;
	if(b & m64.b3)
		p+=0x8;
	return p;
}

void setFEN(char * brd) {
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
	printf("<%s,%s,%s,%s,%s,%s>\n\n", brd, plr, cst, enp, hlf, mov);
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
			setPiece(r + c++,WP);
			break;
		case 'N':
			setPiece(r + c++,WN);
			break;
		case 'B':
			setPiece(r + c++,WB);
			break;
		case 'R':
			setPiece(r + c++,WR);
			break;
		case 'Q':
			setPiece(r + c++,WQ);
			break;
		case 'K':
			setPiece(r + c++,WK);
			break;
		case 'p':
			setPiece(r + c++,BP);
			break;
		case 'n':
			setPiece(r + c++,BN);
			break;
		case 'b':
			setPiece(r + c++,BB);
			break;
		case 'r':
			setPiece(r + c++,BR);
			break;
		case 'q':
			setPiece(r + c++,BQ);
			break;
		case 'k':
			setPiece(r + c++,BK);
			break;
		default:
			printf("ERROR:%c\n",brd[i]);
			break;
		}
	}
}

void getFEN() {
	printf("FEN");
}

void getINFO() {
	int r,c;
	for(r=56;r>=0;r-=8){
		puts(" ");
		for(c=0;c<8;c++)
			printf("%c",PIECE_CHAR[getPiece(r+c)]);
	}
}

/*
 Roce 0.0390 - Roman's Own Chess Engine
 quit............terminates the program
 uci.............switch to uci-mode
 e2e4............moves piece
 e7e8Q...........promotion move resulting in Queen [Q,R,B,N]
 st #............sets search time per move (1-300s)
 sd #............sets search depth (1-9)
 undo............takes back last move
 new.............resets board to initial state
 clear...........redraws the console
 disp............shows the board
 divide #........outputs the numbers of child moves
 divide2 #.......outputs the total numbers of child moves
 perft #.........counts nodes at given depth
 perft2 #........counts all nodes to given depth
 setboard <FEN>..reads a fen-string
 fen.............outputs FEN of board position
 info............outputs data-structure
 chess960........enable/disable FRC/Chess960
 eval............evaluates position
 analyze.........infinite analysis
 testmovegen.....runs a testsuite file (perft for different positions)
 stack...........shows move-stack
 sort............gives sorted move-list for Alpha-Beta
 show............gives valid moves for current pos.
 */

void mainLoop() {
	char * msg;
	while (active && (msg = getLine()) != NULL) {
		msg[strlen(msg) - 1] = 0;
		char * cmd = strdup(msg);
		strtok(cmd, " ");
		char * prm = strtok(0, " ");
		printf("<%s,%s>", cmd, prm);
		if (0 == strcasecmp(cmd, "quit")) {
			mainExit();
		} else if (0 == strcasecmp(cmd, "setboard")) {
			setFEN(prm);
		} else if (0 == strcasecmp(cmd, "fen")) {
			getFEN();
		} else if (0 == strcasecmp(cmd, "info")) {
			getINFO();
		} else if (0 == strcasecmp(cmd, "perft")) {
			puts("PERFT");
		} else if (0 == strcasecmp(cmd, "divide")) {
			puts("DIVIDE");
		} else if (0 != strcmp(cmd, "")) {
			fputs("Unknown '", stdout);
			fputs(cmd, stdout);
			fputs("' in '", stdout);
			fputs(msg, stdout);
			puts("'");
		}
		free(cmd);
		free(msg);
	}
}


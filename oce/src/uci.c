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
	printf("Oslo Chess Engine\n:");
	fflush(stdout);
	M64 pos = {0ULL,0ULL,0ULL,0ULL,0ULL,0ULL};
	M64 * m64 = &pos;
	char * msg;
	while (active && (msg = getLine()) != NULL) {
		msg[strlen(msg) - 1] = 0;
		char * cmd = strdup(msg);
		strtok(cmd, " ");
		char * prm = strtok(0, " ");
		if (0 == strcasecmp(cmd, "quit")) {
			mainExit();
		} else if (0 == strcasecmp(cmd, "setboard")) {
			setFEN(m64,prm);
		} else if (0 == strcasecmp(cmd, "fen")) {
			getFEN(m64);
		} else if (0 == strcasecmp(cmd, "info")) {
			getINFO(m64);
		} else if (0 == strcasecmp(cmd, "perft")) {
			getPerft(m64,atoi(prm));
		} else if (0 == strcasecmp(cmd, "divide")) {
			getDivide(m64,atoi(prm));
		} else if (0 == strcasecmp(cmd, "join")) {
			printf("JOIN\n:");
		} else if (decodeMove(cmd)!=-1) {
			int move = decodeMove(cmd);
			int from = move & 63;
			int to = move >> 6;
			printf("From %i to %i\n:", from, to);
			char a[2];
			char b[2];
			move2code(from,a);
			move2code(to,b);
			printf("From %s to %s\n:",a,b);
		} else if (0 != strlen(cmd)) {
			fputs("Unknown '", stdout);
			fputs(cmd, stdout);
			fputs("' in '", stdout);
			fputs(msg, stdout);
			puts("'");
		}
		free(cmd);
		free(msg);
		printf("\n:");
		fflush(stdout);
	}
}


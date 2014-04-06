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

boolean active=TRUE;

void mainExit(){
	active=FALSE;
    exit(0);
}

void mainLoop(void (*command)(char** split, char* msg,FILE* s)){
    char * msg;
	char ** split;
	while (active && (msg = getLine()) !=NULL) {
		char * msg2 = malloc(sizeof(msg));
		strcpy(msg2,msg);
		strtok(msg2, "\n");
		split = strSplit(msg2, ' ');
		command(split, msg, stdout);
		free(msg);
		free(msg2);
		int n=sizeof(split)/sizeof(*split);
		int i;
		for(i=0;i<n;i++)
			free(split[i]);
		free(split);
	}
}



/*
 ============================================================================
 Name        : chess.c
 Author      : Per
 Version     :
 Copyright   : Your copyright notice
 Description : Chess Engine in C, ANSI-style
 ============================================================================
 */

#include <windows.h>
#include <tchar.h>
#include <signal.h>
#include <stdio.h>
#include "console.h"

BOOL WINAPI consoleHandler(DWORD CEvent){
    switch(CEvent){
    case CTRL_C_EVENT:
    	mainExit();
        break;
    case CTRL_BREAK_EVENT:
        MessageBox(NULL,_T("CTRL+BREAK received!"),_T("CEvent"),MB_OK);
        break;
    case CTRL_CLOSE_EVENT:
        MessageBox(NULL,_T("Program being closed!"),_T("CEvent"),MB_OK);
        break;
    case CTRL_LOGOFF_EVENT:
        MessageBox(NULL,_T("User is logging off!"),_T("CEvent"),MB_OK);
        break;
    case CTRL_SHUTDOWN_EVENT:
        MessageBox(NULL,_T("User is logging off!"),_T("CEvent"),MB_OK);
        break;
    }
    return TRUE;
}

void command(char** prms, char* line,FILE* s) {
	char* cmd = prms[0];
	if (0 == strcasecmp(cmd, "perft")) {
		fputs("PERFT\n",s);
	} else if (0 == strcasecmp(cmd, "divide")) {
		fputs("DIVIDE\n",s);
	} else if (0 == strcasecmp(cmd, "exit")) {
		mainExit();
	} else if (0 == strcasecmp(cmd, "quit")) {
		mainExit();
	} else if (0 != strcmp(cmd, "")) {
		fputs("Unknown '", s);
		fputs(cmd, s);
		fputs("' in '", s);
		fputs(line, s);
		fputs("'\n",s);
	}
}

int main(void) {
    if (SetConsoleCtrlHandler( (PHANDLER_ROUTINE)consoleHandler,TRUE)==FALSE){
        printf("Unable to install handler!\n");
        return EXIT_FAILURE;
    }
    mainLoop(command);
	return EXIT_SUCCESS;
}


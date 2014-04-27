/*
 * mov.c
 *
 *  Created on: 29. apr. 2014
 *      Author: pdigre
 */

#include <stdio.h>
#include "mov.h"

void m_wn(M64 * pos, MOVES64 * moves){
	int num = (moves->count++);
	M64 * m = &(moves->moves[num]);
	m->b0=pos->b0;
	m->b1=pos->b1;
	m->b2=pos->b2;
	m->b3=pos->b3;
	m->state=pos->state;
	m->zobrist=pos->zobrist;
}



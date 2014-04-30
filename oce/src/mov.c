/*
 * mov.c
 *
 *  Created on: 29. apr. 2014
 *      Author: pdigre
 */

#include <stdio.h>
#include "mov.h"
#include "fen.h"

void add(MOVES64 * moves,M64 * p, unsigned from, unsigned to){
	M64 * m = &(moves->moves[moves->count++]);
	m->b0=p->b0;
	m->b1=p->b1;
	m->b2=p->b2;
	m->b3=p->b3;
	m->state=(p->state & ~MASK_FROMTO) | from << _FROM | to << _TO;
	m->zobrist=p->zobrist;
}

void m_wn(M64 * p, MOVES64 * m){
	unsigned long long wn=~(p->b0) & (p->b1) & ~(p->b2) & ~(p->b3);
	for (int i = 0; i < 64; ++i) {
		unsigned long long from = 1LL << i;
		if ((wn & from) != 0) {
			add(m,p,i,i+15);
			add(m,p,i,i+17);
		}
	}
}



#ifndef _CBL_H_
#define _CBL_H_
#define CBL_END   -1
#define NBLOCS  100
#define CBL_BLOCSIZE 16

int first_free_blocs;

extern void cbl_init();
extern void * cbl_newbloc();
extern int cbl_freebloc(void *);

#endif
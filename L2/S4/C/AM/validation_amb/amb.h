#ifndef _AMB_H_
#define _AMB_H_
#define AMB_END   -1
#define NBLOCS  1000
#define AMB_BLOCSIZE 16

int first_free_bloc;
extern int amb_init();
extern void * amb_newbloc(unsigned int);
extern int amb_freebloc(void *);

#endif
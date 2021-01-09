#ifndef _ATF_H_
#define _ATF_H_
#define NBLOCS  100
#define ATF_BLOCSIZE  1

extern void atf_init();
extern void * atf_newbloc();
extern int atf_freebloc(void *);
extern void atfb_init();
extern void * atfb_newbloc();
extern int atfb_freebloc(void *);

#endif
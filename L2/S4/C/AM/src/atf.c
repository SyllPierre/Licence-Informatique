#include "atf.h"
#include <stdio.h>

static char membloc[NBLOCS][ATF_BLOCSIZE];

static char memstatus[NBLOCS];

static char memstatus_b[NBLOCS/8];

enum memstatus_e {MEM_FREE=0, MEM_USED};
static enum memstatus_e memstatus_s[NBLOCS];


void set_memstatus(int i){
    memstatus_b[i/8] |= (1<<(i%8));
}

void clearmemstatus(int i){
    memstatus_b[i/8] &= ~(1<<(i%8));
}

int getmemstatus(int i){
    return memstatus_b[i/8] & (1<<(i%8));
}

void atfb_init(){
    for(int i =0; i<NBLOCS/8; i++){
        memstatus_b[i] = '\0';
    } 
}

void * atfb_newbloc(){
    int i = 0;
    while(getmemstatus(i) && i<NBLOCS){
        i++;
    }
    if(i<NBLOCS){
        set_memstatus(i);
        return &(membloc[i][0]);
    }
    return NULL;
}

int atfb_freebloc(void * bloc){
    int i = bloc - (void *) &(membloc[0][0]);
    if(i>=0 && i<NBLOCS){
        clearmemstatus(i);
        return 0;
    }
    else{
        return -1;
    }
}

void atf_init(){
    for(int i =0; i<NBLOCS; i++){
        memstatus[i] = '\0';
    }
}

void * atf_newbloc(){
    int i = 0;
    while(memstatus[i] && i<NBLOCS){
        i++;
    }
    if(i<NBLOCS){
        memstatus[i]= '1';
        return &(membloc[i][0]);
    }
    return NULL;
}

int atf_freebloc(void * bloc){
    int i = bloc - (void *) &(membloc[0][0]);
    if(i>=0 && i<NBLOCS){
        memstatus[i] = '\0';
        return 0;
    }
    else{
        return -1;
    }
}

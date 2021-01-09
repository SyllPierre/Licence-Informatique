#include "cbl.h"
#include <stdio.h>

char membloc[NBLOCS][CBL_BLOCSIZE];

void cbl_init(){
    int i;
    for (i=0; i<NBLOCS - 1;i++){
        int *p=(int*) &(membloc[i][0]);
        *p=i+1;
    }
    *((int*)&(membloc[NBLOCS-1][0]))=CBL_END;
    first_free_blocs=0;
}

void * cbl_newbloc(){
    if (first_free_blocs==CBL_END){
        return NULL;
    }
    else{
        void * res= (void *)&(membloc[first_free_blocs][0]);
        first_free_blocs=*((int *)&(membloc[first_free_blocs][0]));
        return res;
    }
}
int cbl_freebloc(void *bloc){
    int i = bloc - (void *)&(membloc[0][0]);
    if (i>=0 && i<(NBLOCS*CBL_BLOCSIZE)){
        * (int *)bloc = first_free_blocs;
        first_free_blocs = i/CBL_BLOCSIZE;
        return 0;
    }
    else{
        return -1;
    }
    
}

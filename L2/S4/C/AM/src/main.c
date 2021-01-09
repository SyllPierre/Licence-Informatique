#include "atf.h"
#include <stdio.h> 

int main(){
    atfb_init();
    void * tab[42];
    int i = 0;
    int cpt=0;
    int cpt2=0;
    void * p;
    do{   
        p = atfb_newbloc();
        if (i<42){
            tab[i]=p;
        }
        i++;
    }while(p != NULL);
    for(int j=0;j<42;j++){
        int lib=atfb_freebloc(tab[j]);
        if (lib==0){
            cpt +=1;
        }
    }
    printf("%d\n",cpt);
    do{ 
        p= atfb_newbloc();
        if (p== tab[cpt2]){       
            cpt2++;
        }
    }while(p != NULL);
    printf("%d\n",cpt2);
    return 0;
}
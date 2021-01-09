#include "cbl.h"
#include <stdio.h> 

int main(){
    cbl_init();
    void * tab[42];
    int i = 0;
    int cpt=0;
    int cpt2=0;
    void * p;
    do{   
        p = cbl_newbloc();
        if (i<42){
            tab[i]=p;
        }
        i++;
    }while(p != NULL);
    for(int j=0;j<42;j++){
        int lib=cbl_freebloc(tab[j]);
        if (lib==0){
            cpt +=1;
        }
    }
    printf("%d\n",cpt);
    p= cbl_newbloc();
    while(p != NULL){
        if (p== tab[41-cpt2]){       
            cpt2++;
        }
        p= cbl_newbloc();
        
    };
    printf("%d\n",cpt2);
    return 0;
}
#include "amb.h"
#include <stdio.h>
#include <string.h>

struct bloc_libre{
    unsigned int nb_freebloc;
    int next_free;
};

union union_bloc{
    char alloue[AMB_BLOCSIZE];
    struct bloc_libre premier_libre;
    unsigned int blocZero;
};

enum type { ALLOUE, LIBRE, ZERO };

/*
on utilise une struct qui contient l'union qui defini un bloc 
et une enum pour savoir quelle partie de l'union on utilise
*/
struct bloc_s{
    union union_bloc bloc;
    enum type type;
};


struct bloc_s membloc[NBLOCS];

int amb_init(){
    //on defini le premiere element de membloc comme un bloc libre et on l'initialise
    membloc[0].type = LIBRE;
    membloc[0].bloc.premier_libre.nb_freebloc = NBLOCS;
    membloc[0].bloc.premier_libre.next_free = -1;
    //on initialise first_free_bloc a 0
    first_free_bloc = 0;
    return 0;
}

void * allouerbloc(unsigned int indice, unsigned int nbloc){
    membloc[indice].type = ZERO;
    membloc[indice].bloc.blocZero = nbloc;
    //les nbloc suivant deviennent des bloc alloue et on les initialisent
    for(unsigned int i=1; i<=nbloc; i++){
        membloc[indice+i].type = ALLOUE;
        memset(&(membloc[indice+i].bloc.alloue), 0, AMB_BLOCSIZE);
    }
    return &(membloc[indice+1]);
}

void * amb_newbloc(unsigned int nbloc){
    fprintf(stderr, "debut newbloc\n nbloc : %d\n", nbloc);
    void * res; 
    if (first_free_bloc == AMB_END){
        fprintf(stderr, "fin newbloc erreur\n");
        return NULL;
    }
    else{
    // CAS OU FFB EST BON
        struct bloc_libre a = membloc[first_free_bloc].bloc.premier_libre;
        int last = -1, current = first_free_bloc;
        fprintf(stderr, "nbfree : %d next : %d\n", a.nb_freebloc, a.next_free);
        while (a.nb_freebloc < nbloc+1){
            
            //si il n'y a plus de suite de blocs contigu, on revoie null
            if (a.next_free == AMB_END){
                fprintf(stderr, "fin newbloc erreur\n");
                return NULL;
            } 
            //sinon on regarde le prochain bloc libre

            last = current;
            current = a.next_free;
            a = membloc[current].bloc.premier_libre;
            fprintf(stderr, "nbfree : %d next : %d\n", a.nb_freebloc, a.next_free);
        }
        int oldnext = a.next_free;
        int next_free;
        //  CAS OU CE QU'ON DEMANDE EST INFERIEUR A A LA PLACE LIBRE , LE FFB N'EST DONC PAS LE NEXT 
        if (nbloc+1 < a.nb_freebloc){
            int x = a.nb_freebloc;
            res = allouerbloc(first_free_bloc,nbloc);
            next_free = first_free_bloc + (nbloc + 1);
            membloc[next_free].type = LIBRE;
            membloc[next_free].bloc.premier_libre.nb_freebloc = x - (nbloc + 1);
            membloc[next_free].bloc.premier_libre.next_free = oldnext;

        }
        // CAS OU CE qu'on DEMANDE EST EXACTEMENT LE PLACE LIBRE , ALORS FFB EST LE NEXT 
        else if (nbloc+1 == a.nb_freebloc){
            res = allouerbloc(first_free_bloc,nbloc);
            next_free = oldnext;
        }
        if(last == -1)
            first_free_bloc = next_free;
        else{
            membloc[last].bloc.premier_libre.next_free = next_free;
        }
        fprintf(stderr, "fin newbloc res : %lp\n", res);
        return res;
    }
}

 void liberer(int indice, int x){
    membloc[indice].type = LIBRE;
    membloc[indice].bloc.premier_libre.nb_freebloc = x;
 }

int amb_freebloc(void *bloc){
    fprintf(stderr, "debut freebloc\n");
    int x = (bloc - (void *)&(membloc[0]))/AMB_BLOCSIZE - 1;
    fprintf(stderr, "x : %d bloc : %lp\n", x, bloc);
    if (membloc[x].type == ZERO){
        liberer(x, membloc[x].bloc.blocZero);
        int oldffb = first_free_bloc;
        first_free_bloc = x;
        membloc[first_free_bloc].bloc.premier_libre.next_free = oldffb;
        fprintf(stderr, "fin freebloc\n");
        return 0;
    }
    else{
        fprintf(stderr, "fin freebloc erreur\n");
        return 1;
    }
    
    
}
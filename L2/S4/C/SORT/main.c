#include <stdlib.h>
#include <stdio.h>
#include "struct.h"
#include "const.h"

int main (void){
	struct Nomine_s t_etoile[MAXTAB];
	int nb_lignes; 
	nb_lignes = ConstruireTableaux(t_etoile);
	printf("nombre de lignes lues : %i\n",nb_lignes);
	int comp;
	struct Nomine_s N1;
	struct Nomine_s N2;

	N1.birth.year = 1995;
	N1.birth.month = 8;
	N1.birth.day = 8;
	N2.birth.year = 1997;
	N2.birth.month = 3;
	N2.birth.day = 22;
	comp = CompareNomineParAgeDObtention(&N1,&N2);
	if (comp==0) printf("Même date de naissance\n");
	if (comp==1) printf("Paramètre 1 plus jeune\n");
	if (comp==-1) printf("Paramètre 1 plus agé\n");
	return 0;
}

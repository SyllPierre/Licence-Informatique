#include <stdlib.h>
#include <stdio.h>
#define TABSIZE 1000

int partitionner(int *tab, int debut, int fin) {
    int pivot; int i; int j;
    pivot = tab[debut];
    i = debut-1;
    j = fin+1;
    int temp;
    while (1) {
        do
            j--;
        while (tab[j] > pivot);
        do
            i++;
        while (tab[i] < pivot);
        if (i < j) {
            temp = tab[i];
            tab[i] = tab[j];
            tab[j] = temp;
        }
        else
            return j;
    }
}

void quicksort_r(int tab[], int debut, int fin){
	int q;
    	if (debut < fin) {
		q = partitionner(tab, debut, fin);
		quicksort_r(tab, debut, q);
		quicksort_r(tab, q+1, fin);
    }
}




void quicksort_int(int *tab, unsigned int nelem){
	int debut = 0;
	int fin = nelem - 1;
	quicksort_r(tab,debut, fin);
}


int main(void){
	int *aTab;
	int tab[TABSIZE];
	aTab=tab;
	int index;
	for (index=0; index<TABSIZE; index++){
		*(aTab+index) = rand();
	}
	printf("Tableau non trié :\n");
	for (index=0; index<5; index++){
		printf("%u", tab[index]);
		putchar(' ');
	}
	putchar('\n');
	quicksort_int(tab,5);
	printf("Tableau trié :\n");
	for (index=0; index<5; index++){
		printf("%u",tab[index]);
		putchar(' ');
	}
	putchar('\n');
	return 0;
}

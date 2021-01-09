

#include <stdio.h>



void* partitionner(void* debut, void* fin,int size, int(*compar)(const void *, const void *)) {
    void* pivot; void* i; void* j;
    pivot = debut;
    char* d = (char*)debut;
    i=d-1*size;
    char* f = (char*)fin;
    j = fin+1*size;
    int temp;
    while (1) {
        do
            j--;
        while(compar(*(debut+(j*size)), pivot)==1);
        do
            i++;
        while (compar(*(debut+(i*size)), pivot) == -1);
        if (compar(i, j) == -1) {
            temp = &i;
            i = &j;
            j = temp;
        }
        else
            return j;
    }
}

void quicksort_r(void* tab, void* fin,int size ,int(*compar)(const void *, const void *)){
	void* q;
    	if (tab < fin) {
		q = partitionner(tab, fin,size,compar);
		quicksort_r(tab, q, size, compar);
		quicksort_r((((char *)tab)+(char*)((q+1))*size), fin-q+1, size, compar);
    }
}




void quicksort(void *base, unsigned int nelem,int size,int(*compar)(const void *, const void *)){
	void* fin= (void*)((char*)base+(nelem - 1)*size);
	quicksort_r(base, fin, size, compar);
}


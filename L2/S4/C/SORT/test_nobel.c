#include <stdio.h>
#include "struct.h"
#include "const.h"


int main(void){
    struct Nomine_s tab[MAXTAB];
    int n=ConstruireTableaux(tab);
    for(int i=0; i<n; i++){
        struct Nomine_s nominee=tab[i];
        int p_date = nominee.date;
        char *domain= (nominee.subject==Literature?"LITERATURE":(nominee.subject==Physics?"PHYSICS":(nominee.subject==Chemistry?"CHEMISTRY":(nominee.subject==Peace?"PEACE":(nominee.subject==Physiology_or_Medicine?"PHYS OR MED":"ERROR")))));

        printf("date:%d subject:%s name:%s year:%d month:%d day:%d nationality:%s gender:%s\n", p_date, domain, nominee.name, nominee.birth.year, nominee.birth.month, nominee.birth.day, nominee.nationality, (nominee.gender==male?"MALE":(nominee.gender==female?"FEMALE":"ERROR")));
    
    }
    printf("\n\n\n%d\n",n);
    return 0;
}

#include <assert.h>
#include<stdio.h>
#include<stdlib.h>
#include "amb.h"

/* la fonction char2int renvoit la convertion
 * d'un entier repr\'esent\'e par une cha\^\i{}ne
 * de caract\`eres en un entier int. De plus, le 
 * pointeur str est modifi\'e.
 */
int char2int(char **str){

  int res = 0 ;

  for(;**str >='0' &&  **str <= '9';(*str)++)
    res = 10*res+ **str-'0' ;
  return res ;
}

char * cmp2noncmp(char *cmp){
  char *res ;
/* tout d'abord on d\'etermine la place \`a r\'eserver */
  char *tmp=cmp ;
  int lc = 0, foo, bar=0;
  while(*tmp!=0){
    foo = char2int(&tmp) ;
    while(*tmp!=0 && (*tmp-'0'<0 || *tmp-'9'>0)){
      tmp++ ; 
      bar++ ;
    }
    lc += bar*foo ; 
  }
  res = (char *) amb_newbloc(1+(lc+1)*sizeof(char)/AMB_BLOCSIZE) ;

  /* puis on rempli cette espace */
  bar = 0 ;
  while(*cmp!=0){
    foo = char2int(&cmp) ;
    while (foo-->0){
      tmp=cmp;
      while(*tmp!=0 && (*tmp-'0'<0 || *tmp-'9'>0))
      *(res+bar++)=*(tmp++) ;
    }
    cmp =tmp ;
  }
  *(res+bar) = 0 ;
  return res ;
}

int main (void){
    char * res, *tmp ;
    char buffer[81] ;
    int i=0 ;
    amb_init();
    while(1){
        assert(i<81);
        buffer[i] = (char) getchar();
        if (buffer[i] == EOF)
            return 0 ;
        if (buffer[i] == '\n')
        {
            buffer[i] = '\0' ;
            tmp = res = cmp2noncmp(buffer);
            while(*res) 
                putchar(*(res++));
            putchar('\n') ;
            amb_freebloc(tmp);
            i=0;
        }
        else i++;
	}

	return 0 ;
}

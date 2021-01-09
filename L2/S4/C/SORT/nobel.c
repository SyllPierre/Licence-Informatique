#include <stdlib.h>
#include <stdio.h>
#include "struct.h"
#define MAXIMUM 4

int ReadDate(){
	int c= getchar();
	if (c==EOF){
	return EOF;
	}

  int res=0;
  int i=MAXIMUM-1;
  while(i!=0){
    res=(c-'O')+res*10;
    i--;
    c = getchar();
    }
  return res;
}

enum subject_e ReadSubject(){
  enum subject_e res;
  int i=0;
  int c = getchar();
  while (c!= '"'){
    c = getchar();
  }
    while (1){
    c = getchar();
    if (c == 'L') {
      res = Literature;
      break;
    }
    else if (c == 'C'){
      res = Chemistry;
      break;
    }
    else if (c == 'e'){
      res = Peace;
       break;
    }
    else if ( c == 'o'){
      res = Physiology_or_Medicine;
      break;
    }
    else if (c == 'c'){
      res = Physics;
      break;
    }
        }
  //Pour épuiser jusqu'à la fin
  while (c!= '"'){
    c = getchar();
  }
  return res;
}

void ReadName(char *tab){
    int c = getchar();
    int i = 0;
    while (c!= '"'){
      tab[i] = c;
      c = getchar();
      i++;
    }
  tab[i] = 0;
}

struct birth_s ReadBirth(){
  struct birth_s b ;
  int c = getchar();
  c = getchar();
  int year = 0;
  while ((c=getchar())!= '-'){
    year=(c-'O') + year*10;
  }
  b.year = year;
  int month = 0;
  while ((c=getchar())!= '-'){
    month =(c-'O')+ month*10;
  }
  b.month = month;
  int day = 0;
  while ((c=getchar()) != '"'){
    day=(c-'O')+day*10;
  }
  b.day = day;
  return b;
}

void ReadNationality(char * tab){
  int c;
  c = getchar();
  while (c!= '"'){
    c = getchar();
  }
  //char res[30];
  int i = 0;
  while (c!= '"'){
    tab[i] = c;
    c = getchar();
    i++;
    }
  tab[i] = 0;

}

enum gender_e ReadGender(){
  enum gender_e res;
  int i=0;
  int c;
  while ((c=getchar())!= '"');


    while (1){

    if ( (c=getchar()) == 'm'){
       res = male;
       break;
    }
    else if ((c=getchar()) == 'f'){
      res = female;
      break;
    }
  }
 while (c!= '"'){
    c = getchar();
  }


  return res;
}



int ConstruireTableaux(struct Nomine_s * tab){
  int c;
  int cpt = 0;
  while((c= getchar()) != EOF){
      (*tab).date = ReadDate();
	if ((*tab).date==EOF){
	return cpt;
	}

      (*tab).subject = ReadSubject();
      ReadName((*tab).name);
      (*tab).birth = ReadBirth();
      ReadNationality((*tab).nationality);
      (*tab).gender = ReadGender();
  	tab++ ;
  	cpt++;
  }
return cpt;

}

int CompareNomineParAgeDObtention(struct Nomine_s *a, struct Nomine_s *b) {
	struct Nomine_s *Na = (struct Nomine_s *) a;
	struct Nomine_s *Nb = (struct Nomine_s *) b;
	if (Na->birth.year > Nb->birth.year) return 1;
	if (Nb->birth.year > Na->birth.year) return -1;
	if (Na->birth.month > Nb->birth.month) return 1;
	if (Nb->birth.month > Na->birth.month) return -1;
	if (Na->birth.day > Nb->birth.day) return 1;
	if (Nb->birth.day > Na->birth.day) return -1;
	return 0;
}

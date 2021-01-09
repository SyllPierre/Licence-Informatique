#include <stdio.h>
#include <string.h>

#include "ArbreBinaire.h"
#include "Affichage.h"

#define max(a,b) ((a)>(b)?(a):(b))

/* Manipulation d'arbres binaires */

Noeud_t arbre1 (void) {
    Noeud_t arbre,tmp ;

    arbre = CreerNoeud(12) ;
    tmp = CreerNoeud(9) ;
    AjouterFilsGauche(arbre,tmp) ;
    tmp = CreerNoeud(8) ;
    AjouterFilsDroit(arbre,tmp) ;

    SauverArbreDansFichier(arbre,"arbre1") ;

    return arbre;
}

Noeud_t arbre2 (void) {
    Noeud_t arbre,tmp  ;

	  arbre = CreerNoeud(12) ;
	  AjouterFilsGauche(arbre,CreerNoeud(9));
	  tmp = FilsGauche(arbre) ;
	  AjouterFilsDroit(tmp,CreerNoeud(5));
    tmp = FilsDroit(tmp) ;
    AjouterFilsGauche(tmp,CreerNoeud(7));
    SauverArbreDansFichier(arbre,"arbre2");
	  return arbre ;
}

Noeud_t arbre3 (void) {
    Noeud_t arbre,tmp  ;

    arbre = CreerNoeud(12) ;
    AjouterFilsGauche(arbre,CreerNoeud(9));
    AjouterFilsDroit(arbre,CreerNoeud(8));
    tmp = FilsGauche(arbre) ;
    AjouterFilsDroit(tmp,CreerNoeud(5));
    AjouterFilsGauche(tmp,CreerNoeud(1));
    tmp = FilsDroit(arbre) ;
    AjouterFilsDroit(tmp,CreerNoeud(4));
    tmp = FilsDroit(tmp) ;
    AjouterFilsDroit(tmp,CreerNoeud(6));
    AjouterFilsGauche(tmp,CreerNoeud(7));
    SauverArbreDansFichier(arbre,"arbre3");

    return arbre ;
}

void imprimer (Noeud_t a) {
    if (!EstVide(a)){
      imprimer(FilsGauche(a));
      if (!EstVide(FilsGauche(a))) printf(", ");
      printf("%ld",ValeurDuNoeud(a));
      if (!EstVide(FilsDroit(a))) printf(", ");
      imprimer(FilsDroit(a));
    }
}

int taille (Noeud_t a) {
    if(!EstVide(a)){
      return taille(FilsGauche(a))+taille(FilsDroit(a))+1;
    }
    return 0;
}

int hauteur (Noeud_t a) {
    if (!EstVide(a)){
      if (EstFeuille(a)){
        return 0;
      }
      else{
        int hg=hauteur(FilsGauche(a));
        int hd=hauteur(FilsDroit(a));
        return 1+max(hg,hd);
      }
    }
    return -1;
}

int nbFeuilles(Noeud_t a) {
    if(!EstVide(a)){
      if (EstFeuille(a)){
        return 1;
      }
      else{
        return nbFeuilles(FilsGauche(a))+nbFeuilles(FilsDroit(a));
      }
    }
    return 0;
}


/* Comptage d'arbres */

int nbArbres(int n) {
  if(n == 0){
    return 1;
  }
  else{
    int res = 0;
    int k;
    for(k = 0; k < n; k++){
      res += nbArbres(k)*nbArbres(n-k-1);
    }
    return res;
  }
}

/*
- on initialise c[0] à 1
- pour chaque i de 1 à n, on calcule c[i] en se servant des c[k] avec k<i
- on renvoie c[n]
*/
int nbArbresEfficace(int n) {
  int tab[100];
  int i;
  int k;
  tab[0] = 1;
  for (i=1;i<=n;i++){
    /* on veut calculer c[i]*/
    int res=0;
    for (k=0;k<=i-1;k++){
      res+=tab[k] * tab[i-1-k];
    }
    tab[i]=res;
  }
  return tab[n];
}

/* Manipulation d'arbres binaires de recherche */

Noeud_t abr1 (void) {
  Noeud_t arbre,tmp  ;
  arbre = CreerNoeud(6) ;
  AjouterFilsGauche(arbre,CreerNoeud(4));
  tmp = FilsGauche(arbre) ;
  AjouterFilsGauche(tmp,CreerNoeud(2));
  AjouterFilsDroit(arbre,CreerNoeud(7));
  AjouterFilsDroit(tmp,CreerNoeud(5));
  tmp = FilsGauche(tmp) ;
  AjouterFilsGauche(tmp,CreerNoeud(1));
  SauverArbreDansFichier(arbre,"abr1");
  return arbre ;
}

Noeud_t ajouter (value_t v, Noeud_t a) {
  if (EstVide(a)){
    return CreerNoeud(v);
  }
  else{
    if (v<=ValeurDuNoeud(a)){
      if(EstVide(FilsGauche(a))){
        AjouterFilsGauche(a,CreerNoeud(v));
        return a;
      }else{
        ajouter(v,FilsGauche(a));
        return a;
      }
    }
    else{
      if(EstVide(FilsDroit(a))){
        AjouterFilsDroit(a,CreerNoeud(v));
        return a;
      }else{
        ajouter(v,FilsDroit(a));
        return a;
      }
    }
  }
}

Noeud_t abr2 (void) {
  Noeud_t abr2 = CreerArbreVide();
  abr2=ajouter(5,abr2);
  abr2=ajouter(4,abr2);
  abr2=ajouter(2,abr2);
  abr2=ajouter(7,abr2);
  abr2=ajouter(6,abr2);
  abr2=ajouter(1,abr2);
  SauverArbreDansFichier(abr2,"abr2");
  return abr2;
}

Noeud_t abr3 (void) {
  Noeud_t arbre = CreerArbreVide();
  arbre=ajouter(7,arbre);
  arbre=ajouter(1,arbre);
  arbre=ajouter(4,arbre);
  arbre=ajouter(5,arbre);
  arbre=ajouter(6,arbre);
  arbre=ajouter(2,arbre);
  SauverArbreDansFichier(arbre,"abr3");
  return arbre;
}

int cmp=0;

int appartient (value_t v, Noeud_t a) {
  if (EstVide(a)){
    return 0;
  }
  else{
    cmp+=1;
    if (ValeurDuNoeud(a)==v){
      return 1;
    }
    cmp+=1;
    if (ValeurDuNoeud(a)<v){
      return appartient(v,FilsDroit(a));
    }
    else{
      return appartient(v,FilsGauche(a));
    }
  }
}

int valeur_minimale (Noeud_t abr) {
  if (EstVide(abr)){
    return -1;
  }
  else{
    if (EstVide(FilsGauche(abr))){
      return ValeurDuNoeud(abr);
    }
    else{
      return valeur_minimale(FilsGauche(abr));
    }
  }
}

int valeur_maximale (Noeud_t abr) {
  if (EstVide(abr)){
    return -1;
  }
  else{
    if (EstVide(FilsDroit(abr))){
      return ValeurDuNoeud(abr);
    }
    else{
      return valeur_maximale(FilsDroit(abr));
    }
  }
}

/* Entier mysterieux */

Noeud_t construitArbreEntierMysterieux (value_t i, value_t j) {
  if(i==j){
    return CreerNoeud(i);
  }
  else{
    value_t moy = (i+j)/2;
    Noeud_t g, d, a;
    a=CreerArbreVide();
    a=ajouter(moy,a);
    if (i==j-1){
      d=construitArbreEntierMysterieux(moy+1,j);
      AjouterFilsDroit(a,d);
    }
    else{
      g=construitArbreEntierMysterieux(i,moy-1);
      AjouterFilsGauche(a,g);
      d=construitArbreEntierMysterieux(moy+1,j);
      AjouterFilsDroit(a,d);
    }
    SauverArbreDansFichier(a,"a");
    return  a;
  }
}

void jouer (int n) {
  Noeud_t arbre=construitArbreEntierMysterieux(0,n);
  int i=1;
  char c[5];
  while (i!=0){
    printf("Est ce que vous pensez à: %ld \n", ValeurDuNoeud(arbre));
    scanf("%s",c);
    if (strcmp(c,"plus")==0){
      arbre=FilsDroit(arbre);
    }
    else if(strcmp(c,"moins")==0){
      arbre=FilsGauche(arbre);
    }
    else if(strcmp(c,"gagne")==0){
      i=0;
    }
  }
}

/* Tests sur les arbres binaires */

void testArbreBinaire(Noeud_t a) {
   imprimer(a); printf("\n");
   printf("Taille     = %d\n",(taille(a)));
   printf("Hauteur    = %d\n",(hauteur(a)));
   printf("nbFeuilles = %d\n",(nbFeuilles(a)));
}

/* Tests sur les arbres binaires de recherche */
void testABR (Noeud_t a) {
   int i;
   imprimer(a); printf("\n");
   printf("Taille     = %d\n",(taille(a)));
   printf("Hauteur    = %d\n",(hauteur(a)));
   printf("nbFeuilles = %d\n",(nbFeuilles(a)));
   printf("Valeurs présentes dans l'arbre : ");
   for (i = 1; i <= 10; i++) {
      if (appartient(i,a)) {
         printf("%d ",i);
      }
   }
   printf("\n");
}

/* Programme principal */
int main (int argc, char **argv) {

   int i;

   testArbreBinaire(arbre1());
   testArbreBinaire(arbre2());
   testArbreBinaire(arbre3());

   for (i = 0; i <= 19; i++) {
      printf("Le nombre d'arbres à %d noeuds est %d\n",i,(nbArbres(i)));
   }

   testABR(abr1());
   testABR(abr2());
   testABR(abr3());

   printf("Arbre mysterieux entre 12 et 24:\n");
   imprimer(construitArbreEntierMysterieux(0,100));
   printf("\n");

   jouer(100);

   return 0;

}

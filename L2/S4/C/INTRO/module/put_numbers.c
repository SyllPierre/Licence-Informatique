extern int putchar(int c);

int newline(){
  /*Retour à la ligne*/
  return putchar('\n');
}

int put_digit(int d){
  /* Imprime un chiffre */
  
  if (d >= 0 && d < 10)
    putchar('0' + d);

  else
    return -1;
}

int put_hdigit(int h){
  /* Imprime un chiffre hexadécimal */
  
  if (h >= 0 && h < 16)
    if (h < 10)
      putchar('0' + h);
    else
      putchar('A' + (h - 10));

  else
    return -1;
}

int putdec (int d){
  /* Imprime les chiffres de l'écriture décimale de l'entier d, que d soit positif ou négatif */

  int i = 1000000000;int test;int err;

  if (d == 0)
    return putchar('0');

  if (d < 0)
    putchar('-');

  while(i != 0){
    if (d / i != 0){
      test = (d / i) % 10;
      
      if (d < 0)
	test = -test;

      err = put_digit(test);

      if (err == -1)
	return -1;
      
    }

    i /= 10;
 
  }
}

int put_test_line(int n)
{
    putchar('t');
    putchar('e');
    putchar('s');
    putchar('t');
    putchar(' ');
    putchar('#');
    putdec(n);
    putchar(':');

    return 0;
}

int putbin(int b){
  /* Imprime l'entier b en binaire */
  
  int d;int err;int t = 0;

  if (b == 0)
    return putchar('0');

  for (int i = 31; i >= 0; i--){
    d = (b >> i) & 0x1;

    if (!t && d != 0)
      t = !t; 
    
    if (t){
      err = put_digit(d);

      if(err == -1)
	return -1;
    }
  }
}

int puthex(int h){
  /* Imprime l'entier h en hexadécimal */
  
  int d;int err; int t = 0;

  if (h == 0)
    return putchar('0');
  
  for (int i = 28; i >= 0; i -= 4){
    d = (h >> i) & 0xF;

    if (!t && d != 0)
      t = !t;

    if (t){
      err = put_hdigit(d);

      if (err == -1)
	return -1;
    }
  }
}

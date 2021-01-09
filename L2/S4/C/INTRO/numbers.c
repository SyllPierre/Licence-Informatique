#include <stdio.h>
extern int putchar (int c);

extern int put_digit(int d);

extern int put_hdigit(int h);

extern int putdec(int d);

extern int putdecfinal(unsigned int d);

extern int putbin(int b);

extern void print_ascii_table();

extern int putbin();

extern int puthex();

int
newline()
{
  return putchar('\n');
}

int put_test_line(int n){
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

int main(){
    int i=-2147483648;
    put_test_line(1); putdec(214); newline();
    put_test_line(2); putdec(-74); newline();
    put_test_line(3); putdec(1); newline();
    put_test_line(4); putdec(-1); newline();
    put_test_line(5); putdec(0); newline();
    put_test_line(6); putdec(2147483647); newline();
    put_test_line(7); putdec(-2147483648); newline();
    put_test_line(8); putdec(-(-2147483648)); newline();
    put_test_line(9); puthex(0); newline();
    put_test_line(10); puthex(10); newline();
    put_test_line(11); puthex(16); newline();
    put_test_line(12); puthex(2147483647); newline();
    put_test_line(13); puthex(-2147483648); newline();
    put_test_line(14); puthex(0xCAFEBABE); newline();
    put_test_line(15); puthex(-1); newline();
    put_test_line(16); putbin(0); newline();
    put_test_line(17); putbin(1); newline();
    put_test_line(18); putbin(-1); newline();
    put_test_line(19); putbin(2147483647); newline();
    put_test_line(20); putbin(-2147483648); newline();

    return 0;
}


int put_digit(int d){
  if(d>= 0 && d<= 9){
    return putchar(48+d);
  }
  else{
    return -1;
  }
}

int put_hdigit(int h){
  if (h >= 0 && h <= 9){
    return put_digit(h);
  }
  if (h >= 10 && h <= 15){
    return putchar('A'+ h - 10);
  }
  else{
    return -1;
  }
}

void print_ascii_table(){
  int i = 0;
  do{
    printf("%d %c \n",i,i);
    i++;
  }
  while(i<=255);
}

int putdec(int d){
  if (d < 0){
    putchar(45);
    putdecfinal(-d);
  }
  else putdecfinal(d);
  return 0;
}

int putdecfinal(unsigned int d){
  if (d >= 10){
    putdecfinal(d/10);
  }
  put_digit(d%10);
  return 0;
}

int putbin(int b){
  if (b == 0){
    put_digit(0);
  }
  else{
    int i = 31;
    while (b>>i == 0) i--;
    int err;
    while(i >= 0){
      err = put_digit((b>>i) & 0b1);
      if (err == -1) return -1;
      i--;
    }
  }
  return 0;
}

int puthex(int h){
  if (h == 0){
    put_digit(0);
  }
  else{
    int i = 28;
    while (h>>i == 0) i-=4;
    int err;
    while(i >= 0){
      err = put_hdigit((h>>i) & 0b1111);
      if (err == -1) return -1;
      i-=4;
    }
  }
  return 0;
}

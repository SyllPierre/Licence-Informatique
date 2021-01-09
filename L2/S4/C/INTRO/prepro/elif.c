extern int putchar(int c);
extern int getchar(void);
extern int put_digit(int d);
extern int putdec (int d);
extern int putdecfinal (unsigned int d);

#define DIGIT 'D'
#define LOWER 'L'
#define UPPER 'U'
#define OTHER 'O'
#define elif else if

int put_digit(int d){
  if(d>= 0 && d<= 9){
    return putchar(48+d);
  }
  else{
    return -1;
  }
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

int main(){
  int ln=__LINE__;
  putdec(ln);
  putdec(__LINE__);
  putdec(ln);
  int c;
  for (int i = 0;i<=10;i++) {
    c = getchar();
    if ('0'<= c && c<='9')
      putchar(DIGIT);
    elif ('a'<=c && c<='z')
      putchar(LOWER);
    elif ('A'<=c && c<='Z')
      putchar(UPPER);
    else
      putchar(OTHER);
    }
    return 0;
}

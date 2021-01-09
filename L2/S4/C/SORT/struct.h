#define MAXTAB 1000


enum gender_e {male,female};
enum subject_e {Physics,Chemistry,Physiology_or_Medicine,Literature,Peace};
struct birth_s{
  int year;
  int month;
  int day;
};


struct Nomine_s {
  int date;
  enum subject_e subject;
  char name[50];
  struct birth_s birth;
  char nationality[30];
  enum gender_e gender;
};



#include "abs.h"

inline int min(int x,int y) { return (x+y-abs(x-y))/2; }
inline int max(int x,int y) { return (x+y+abs(x-y))/2; }

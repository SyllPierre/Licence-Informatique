from ap2_decorators import *

@count
@trace
def fibo(n):
    """
    Return every number after the first two is the sum of the two preceding ones
    :param n: number
    
    >>> fibo(0)
     -> fibo((0,), {})
     <- 0
    0
    
    >>> fibo(1)
     -> fibo((1,), {})
     <- 1
    1
    
    >>> fibo(4)
     -> fibo((4,), {})
    ... -> fibo((3,), {})
    ...... -> fibo((2,), {})
    ......... -> fibo((1,), {})
    ......... <- 1
    ......... -> fibo((0,), {})
    ......... <- 0
    ...... <- 1
    ...... -> fibo((1,), {})
    ...... <- 1
    ... <- 2
    ... -> fibo((2,), {})
    ...... -> fibo((1,), {})
    ...... <- 1
    ...... -> fibo((0,), {})
    ...... <- 0
    ... <- 1
     <- 3
    3
    """
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fibo(n-1) + fibo(n-2)

if __name__ == '__main__':
    import doctest
    doctest.testmod()
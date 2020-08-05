from ap2_decorators import *

@trace
def somme(a,b):
    """
    Return the sum of a and b.
    
    :param a: number (int)
    :param b: number (int)
    
    >>> somme(2,3)
     -> somme((2, 3), {})
    ... -> somme((3, 2), {})
    ...... -> somme((4, 1), {})
    ......... -> somme((5, 0), {})
    ......... <- 5
    ...... <- 5
    ... <- 5
     <- 5
    5

    """
    if b == 0:
        return a
    else:
        return somme(a+1,b-1)

@trace
def binomial(n,p):
    """
    :param n: number (int)
    :param p: number (int)
    
    >>> binomial(3,2)
     -> binomial((3, 2), {})
    ... -> binomial((2, 1), {})
    ...... -> binomial((1, 0), {})
    ...... <- 1
    ...... -> binomial((1, 1), {})
    ...... <- 1
    ... <- 2
    ... -> binomial((2, 2), {})
    ... <- 1
     <- 3
    3
    
    >>> binomial(0,0)
     -> binomial((0, 0), {})
     <- 1
    1
    """
    assert n >= p
    if p == 0 or n == p:
        return 1
    else:
        return binomial(n-1,p-1) + binomial(n-1,p)


@trace
def is_palindromic(mot):
    """
    Return True if word is palinromic, else return False
    
    :param word: word (str)
    
    >>> is_palindromic('radar')
     -> is_palindromic(('radar',), {})
    ... -> is_palindromic(('ada',), {})
    ...... -> is_palindromic(('d',), {})
    ...... <- True
    ... <- True
     <- True
    True
    
    >>> is_palindromic('a')
     -> is_palindromic(('a',), {})
     <- True
    True
    
    >>> is_palindromic('baobab')
     -> is_palindromic(('baobab',), {})
    ... -> is_palindromic(('aoba',), {})
    ...... -> is_palindromic(('ob',), {})
    ...... <- False
    ... <- False
     <- False
    False
    """
    mot1 = mot.lower()
    if len(mot1) == 0 or len(mot1) == 1:
        return True
    else:
        if mot1[0] != mot[len(mot1)-1]:
            return False
        else:
            mot2 = mot1[1:len(mot1)-1]
            return is_palindromic(mot2)

if __name__ == '__main__':
    import doctest
    doctest.testmod()
    
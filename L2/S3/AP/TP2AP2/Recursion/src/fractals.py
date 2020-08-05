from turtle import *

up()
goto(-280,100)
down()
speed(10)
color("blue")

def koch(l, n):
    """
    Trace with turtle a curve of Van Koch.
    
    :param l: number (int or float)
    :param n: number (int)
    
    """
    if n == 0:
        forward(l)
    else:
        koch(l/3, n-1)
        left(60)
        koch(l/3, n-1)
        right(120)
        koch(l/3, n-1)
        left(60)
        koch(l/3, n-1)

def flocon(l, n):
    """
    Trace a flake of Von Koch.
    
    :param l: number (int or float)
    :param n: number (int)
    
    """
    koch(l, n)
    right(120)
    koch(l, n)
    right(120)
    koch(l, n)

def cesaro(l, n):
    """
    Trace with turtle a curve of Cesaro.
    
    :param l: number (int or float)
    :param n: number (int)
    """
    if n == 0:
        forward(l)
    else:
        cesaro(l/3, n-1)
        left(85)
        cesaro(l/3, n-1)
        right(170)
        cesaro(l/3, n-1)
        left(85)
        cesaro(l/3, n-1)

def carre(l, n):
    """
    Trace with turtle a square of Cesaro.
    
    :param l: number (int or float)
    :param n: number (int)
    """
    cesaro(l, n)
    left(90)
    cesaro(l, n)
    left(90)
    cesaro(l, n)
    left(90)
    cesaro(l, n)

def sierpinski(l, n):
    """
    Trace with turtle a triangle of Sierpinsk.
    
    :param l: number (int or float)
    :param n: number (int)
    """
    if n == 0:
        begin_fill()
        forward(l)
        left(120)
        forward(l)
        left(120)
        forward(l)
        left(120)
        end_fill()
    else:
        sierpinski(l/2, n-1)
        forward(l/2)
        sierpinski(l/2, n-1)
        left(120)
        forward(l/2)
        right(120)
        sierpinski(l/2, n-1)
        right(120)
        forward(l/2)
        left(120)
        
        

    
    
    
    

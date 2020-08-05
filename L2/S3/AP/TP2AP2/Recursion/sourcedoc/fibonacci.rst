=================
Fibonacci numbers
=================

What are Fibonacci numbers?
===========================

Fibonacci numbers are a sequence of numbers defined by the two first terms :

.. math::

   f_0 &= 0\\
   f_1 &= 1\\

and for all :math:`n\geq 0` by the following recursion relation :

.. math::

   f_{n+1} &= f_{n+1} + f_{n}.

Here are the Fibonacci numbers for :math:`0\leq n \leq 10` :

.. table:: Table of the first Fibonacci numbers
 

   ===========  ============
   :math:`n`     :math:`f_n`  
   ===========  ============
   0            0
   1            1
   2            1
   3            2
   4			3
   5            5
   6            8
   7            13
   8			21
   9            34
   10           55
   ===========  ============

for fibo(40), calculations are too long.

Nombre d'appels à la fonction pour :
fibo(0) : 1
fibo(1) : 1
fibo(2) : 3
fibo(3) : 5
fibo(4) : 9
fibo(5) : 15
fibo(6) : 25
fibo(7) : 41
fibo(8) : 67
fibo(9) : 109
fibo(10) : 177
fibo(40).count = 331160281

A recursive function
====================   


# -*- coding: utf-8 -*-

""":mod:`test` module : Test module for bloomfilter analysis

:author: `FIL - Univ. Lille <http://portail.fil.univ-lille1.fr>`_

:date: 2016, january

"""
import random
import bloomfilter

nb_hash_functions = 8
random_tab = [ 0 for i in range(128 * nb_hash_functions)]

def init_random_tab ():
    """
    Creates the hash functions.
    """
    global random_tab
    for i in range(128):
        for j in range(nb_hash_functions):
            random_tab[j * 128 + i] = random.randint(1,32000)

def code_of_string (str,n):
    """
    For a given string, returns the hash code for the n-th hashing function.

    :param str: The string to be hashed.
    :type str: string
    :param n: The function number.
    :type n: int
    :return: A hash code
    :rtype: int

    .. note::
       1 <= n <= nb_hash_functions
    """
    h = 0
    for i in range(len(str)-1):
        carac = ord(str[i])
        h += random_tab[n * 128 + carac]
    return h


def random_word ():
    """
    Returns a word with random letters whose length is between 4 and 7.

    :rtype: string
    """
    letters = [ chr(i) for i in range(ord('a'),ord('z')+1) ] + [ chr(i) for i in range(ord('A'),ord('Z')+1) ]
    length = 4 + random.randint(0,4)
    str = ""
    for i in range(length):
        str = str + random.choice(letters)
    return str

if __name__ == "__main__":
    init_random_tab()
    bf = bloomfilter.create(6,code_of_string,8)
    w = random_word()
    bloomfilter.add(bf,"timoleon")
    if bloomfilter.contains(bf,"timoleon"):
        print("%s est present" % ("timoleon"))
    if bloomfilter.contains(bf,w):
        print("%s est present" % (w))

    stream=open("res.txt","w")
    init_random_tab()
    liste_mots = []
    i = 0
    while(i<2**10):
        w = random_word()
        if w not in liste_mots:
            liste_mots.append(w)
            i += 1
    for n in range(1,9):
        for t in range(10,21):
            cpt_fp = 0
            cpt_mot = 0
            bf = bloomfilter.create(t,code_of_string,n)
            for mot in liste_mots:
                bloomfilter.add(bf,mot)
            for k in range(2**14):
                u = random_word()
                if u not in liste_mots:
                    cpt_mot += 1
                    if bloomfilter.contains(bf,u):
                        cpt_fp += 1
            texte = "{} {} {} {} {} \n".format(t, n, cpt_mot, cpt_fp, (cpt_fp/cpt_mot))
            stream.write(texte)
        stream.write("\n \n")
    stream.close()

#Personellement mon check2 fonctionne très bien pour tout les fichiers.
#Les autres élèves de la classe m'ont expliqués le problème qui était survenu chez eux,
#et celui ci est arrivé car la parenthèse solitaire est dans un commentaire ou documentation.
#Il faut donc faire la vérification en dehors des documentations, commentaires et chaines de caracteres.

import sys
from stack import *

OPEN_PAR="([{"
CLOSE_PAR=")]}"
DOC='"'
COM="#"

def main():
    """
    main program
    """
    f = sys.argv[1]
    print(parentheses_check3(f))

def parentheses_check3(f):
    """
    Checks the correct parenthesation of a document including parentheses, brackets and square brackets.
    And displays where and what the first error is.
    This version ignores the text in docs, strings and comments.
    """
    st=Stack()
    with open(f,"r") as entry:
        txt = entry.readlines()
    ignore=False
    for ligne in range(len(txt)):
        linestop=False
        for c in range(len(txt[ligne])):
            if not(linestop):
                if (txt[ligne][c] in OPEN_PAR)and(not(ignore)):
                    st.push((txt[ligne][c],ligne+1,c))
                elif (txt[ligne][c] in CLOSE_PAR)and(not(ignore)):
                    try:
                        o=st.pop()
                        if OPEN_PAR.index(o[0])!=CLOSE_PAR.index(txt[ligne][c]):
                            return("Closed parenthese {:s} at line {:d} char {:d} don't match the open parenthese {:s} at line {:d} char {:d}".format(txt[ligne][c],ligne+1,c,o[0],o[1],o[2]))
                    except StackEmptyError:
                        return("No open parenthese matching parenthese {:s} at line {:d} char {:d}".format(txt[ligne][c],ligne+1,c))
                elif txt[ligne][c] == DOC:
                    if ignore:
                        ignore = False
                    else :
                        ignore = True
                elif txt[ligne][c]==COM:
                    linestop=True
                
    if not(st.is_empty()):
        o=st.pop()
        return ("Parenthese {:s} at line {:d} char {:d} has no matching closed parenthese.".format(o[0],o[1],o[2]))
                
     
    
    
        
if __name__=='__main__':
    main()


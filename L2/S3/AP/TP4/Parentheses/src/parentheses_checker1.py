import sys
from stack import *


def main():
    """
    main program
    """
    text_name = sys.argv[1]
    
    print(parentheses_checker1(text_name))
    
    
def parentheses_checker1(text_name):
    """
    Function who check if the text in parameter is well Parenthesed.
    
    Parameters : text_name(str) - the name of the file with the text that will be check.
    
    Returns : str : True if the text is well parenthesed, False if not.
    
    CU : text_name is a str and is the name of the file with the text.
    
    Examples :
    >>> parentheses_checker1("stack.py")
    'Well Parenthesed'
    >>> parentheses_checker1("bad_stack1.py")
    'Bad Parenthesed'
    >>> parentheses_checker1("bad_stack2.py")
    'Bad Parenthesed'
    >>> parentheses_checker1("bad_stack3.py")
    'Bad Parenthesed'
    >>> parentheses_checker1("bad_stack4.py")
    'Bad Parenthesed'
    """
    open_text = open(text_name, 'r')
    st = Stack()
    st2 = Stack()
    st3 = Stack()
    i = True
    
    for line in open_text :
        for char in line:
            if (char == "("):
                st.push("(")
            elif (char == ")"):
                if (st.is_empty()):
                    return("Bad Parenthesed")
                else :
                    st.pop()
            
            elif (char == "["):
                st2.push("[")
            elif (char == "]"):
                if (st2.is_empty()):
                    return("Bad Parenthesed")
                else :
                    st2.pop()
            
            if (char == "{"):
                st3.push("{")
            elif (char == "}"):
                if (st3.is_empty()):
                    return("Bad Parenthesed")
                else :
                    st3.pop()
                    
    if (st.is_empty() == False):
        return("Bad Parenthesed")
    
    elif (st2.is_empty() == False):
        return("Bad Parenthesed")
    
    elif (st3.is_empty() == False):
        return("Bad Parenthesed")
    
    return("Well Parenthesed")


if __name__=="__main__" :
    import doctest
    doctest.testmod()
    main()
    
    
    
                    



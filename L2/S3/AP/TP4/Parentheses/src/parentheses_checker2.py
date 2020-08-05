from stack import *
import sys

def main():
    """
    main program
    """
    text_name = sys.argv[1]
    
    print(parentheses_checker2(text_name))

def parentheses_checker2(text_name):
    """
    Function who check if the text in parameter is well Parenthesed
    and print the reason for the bad parentheses. 
    
    Parameters : text_name(str) - the name of the file with the text that will be check.
    
    Returns : None
    
    CU : text_name is a str and is the name of the file with the text.
    
    Examples :
    >>> parentheses_checker2("stack.py")
    >>> parentheses_checker2("bad_stack1.py")
    No open parenthese matching parenthese ] at line 68 char 20
    the open parenthese ( at line 68 char 12 don't match with an another parenthese
    >>> parentheses_checker2("bad_stack2.py")
    the open parenthese ( at line 100 char 16 don't match with an another parenthese
    >>> parentheses_checker2("bad_stack3.py")
    the open parenthese [ at line 13 char 34 don't match with an another parenthese
    >>> parentheses_checker2("bad_stack4.py")
    No open parenthese matching parenthese ] at line 96 char 33
    """
    open_text = open(text_name, 'r')
    st = Stack()
    st2 = Stack()
    st3 = Stack()
    i = True
    line_index = 1
    rep = []
    for line in open_text :
        char_index = 0
        for char in line:
            if (char == "("):
                st.push(("(", line_index, char_index))
            elif (char == ")"):
                if (st.is_empty()):
                    print("No open parenthese matching parenthese ) at line", line_index , "char", char_index)
                else :
                    st.pop()
            
            elif (char == "["):
                st2.push(("[", line_index, char_index))
            elif (char == "]"):
                if (st2.is_empty()):
                    print("No open parenthese matching parenthese ] at line", line_index, "char", char_index)
                else :
                    st2.pop()
            
            if (char == "{"):
                st3.push(("{", line_index, char_index))
            elif (char == "}"):
                if (st3.is_empty()):
                    print("No open parenthese matching parenthese } at line", line_index, "char", char_index)
                else :
                    st3.pop()
            char_index += 1   
        line_index += 1
    
    
    while (st.is_empty() == False):
        a = st.top()
        print("the open parenthese ( at line", a[1], "char", a[2], "don't match with an another parenthese")
        st.pop()
        
    while (st2.is_empty() == False):
        a = st2.top()
        print("the open parenthese [ at line", a[1], "char", a[2], "don't match with an another parenthese")
        st2.pop()
    
    while (st3.is_empty() == False):
        a = st3.top()
        print("the open parenthese { at line", a[1], "char", a[2], "don't match with an another parenthese")
        st3.pop()
    
    return None



if __name__ == "__main__" :
    import doctest
    doctest.testmod()
    main()
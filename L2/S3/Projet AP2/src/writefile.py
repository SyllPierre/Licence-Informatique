import sys
from polyhedre import *

def title(file, name) :
    """
    Function that writes the title of a .dot file.

    :param file: the file in which to write
    :type file: str
    :param name: the name of the polyhedre
    :type name: str
    :return: None
    :side effect: creates a new file and writes the beginning of him
    """

    with open(file, "w") as p :
        p.write("strict graph G1{\n")
        p.write(name)
        p.write("[shape=plaintext]\n")
        p.write("edge[len=6;edgesep=10];\n")
        p.write(" overlap=false;\n")

def writeC(start, end) :
    """
    Function that returns a string representation of a connection between two vertices.

    :param start: the start of the connection
    :type start: int
    :param stop: the end vertex
    :type stop: int
    :return: a string representing the connection from start to stop in .dot format
    :rtype: str

    :Examples:

    >>> print(writeConnection(1, 5))
    '1--5'
    >>> print(writeConnection(2, 12))
    '2--12'
    """

    return str(start) + "--" + str(end)

def writeS(sommet) :
    """
    Returns a string for the file with default additives.

    :param sommet: the vertex to write
    :type sommet: int
    :return: the string version of that vertex
    :rtype: str

    :Example:

    >>> print(writeSommet(5))
    '5[color=green,style=filled]'
    """

    return str(sommet) + "[color=green,style=filled]"

def writePath(start, end) :
    """
    Returns a string representation of a path element.

    :param start: start of the path element
    :type start: int
    :param stop: end vertex of the path element
    :type stop: int
    :return: the string representation of the connection in the path
    :rtype: str

    :Example:

    >>> print(writeCycle(2, 7))
    '2--7[color=blue,penwidth=3]'
    """

    return str(start) + "--" + str(end) + "[color=blue,penwidth=3]"

def writeV1(file, listConnections, path):
    """
    Writes the rest of the .dot file for a path.

    :param file: the file to write in
    :type file: str
    :param listConnections: the list of all connections in the polyhedre
    :type listConnections: list
    :param path: a path of this polyhedre
    :type path: list
    :return: None
    """
    nbSommets = len(listConnections)
    
    path += [path[0]]
    
    with open(file, "a") as p :
        
        p.write(" ")
        
        for i in range(nbSommets):
            
            for c in listConnections[i] :

                p.write(writeC(i, c))
                p.write("\n")
        
        for i in range(nbSommets):
            p.write(writeS(i))
            p.write("\n")
        
        for i in range(nbSommets) :

            p.write(writePath(path[i], path[i + 1]))
            p.write("\n")
        
        p.write("}")

def writeFinal(file, listConnections, path, name):
    """
    Function who writes the complete file for a path of polyhedre
    
    :param file: the file to write in
    :type file: str
    :param listConnections: the list of all connections in the polyhedre
    :type listConnections: list
    :param name: the name of his polyedre
    :type poly: str
    :param path: param path: a path of this polyhedre
    :type path: list
    :return: None
    """
    title(file,name)
    writeV1(file, listConnections, path)


    
        
        
            
        
            
            
            
            
    
        
        
    
    
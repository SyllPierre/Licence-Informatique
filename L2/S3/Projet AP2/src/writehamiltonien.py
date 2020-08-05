from writefile import *
from polyhedre import *
from subprocess import run

def createAllFiles(poly, name):
    """
    Function that writes all files for all paths of the polyhedre
    
    :param poly: a polyhedre previouly created
    :type poly: Polyhedre
    :param name: the name of the polyhedre
    :type name: str
    """
    allConnections = poly.getAllConnections()
    allPaths = poly.getPaths()
    
    for i in range(len(allPaths)):
        writeFinal(name + "_" + str(i) +".dot", allConnections, allPaths[i], name)

def createAllImageFiles(poly, name) :
    """
    Function that creates all image for all paths of the polyhedre
    
    :param poly: a polyhedre previouly created
    :type poly: Polyhedre
    :param name: the name of the polyhedre
    :type name: str
    """
    
    for i in range(len(poly.getPaths())):
        fileName = name + "_" + str(i) + ".dot"
        imgName = name + "_" + str(i) + ".jpg"
        
        Command = "neato -Tjpeg " + fileName + " -o " + imgName
        run(Command, shell=True)

def __main__() :
    """
    The main function who allows to use all programs in shell.
    """
    try :
        poly = Polyhedre(sys.argv[1])
        
        name = sys.argv[2]
        
        createAllFiles(poly, name)

        createAllImageFiles(poly, name)
    
    except FileNotFoundError :
        print("Use an existing file")

if __name__ == "__main__" :

    __main__()
    
        
        
        
    
    
        
        
    
    
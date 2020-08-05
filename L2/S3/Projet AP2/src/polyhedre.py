def Fileinfo(file) :
    """
    Returns the information found in the .off file passed as a parameter. Used for the
    construction of a Polyhedron object

    :param file: the .off file
    :type file: str
    :return: a list composed of the number of vertices and all of their connections
    :rtype: list
    :UC: use a file in .off format

    """

    with open(file, "r") as f:

        lines = f.readlines()

        charactsLine = lines[2]

        sommets, faces, arrêtes = charactsLine.split(" ")

        sommets = int(sommets)
        faces = int(faces)
        arrêtes = int(arrêtes)

        listConnections = []

        for i in range(sommets) :
            listConnections.append([])

        line = 2 + sommets + faces + 1
        
        for i in range(line, line + arrêtes) :

            s1, s2 = lines[i].split(" ")
            s1 = int(s1)
            s2 = int(s2)

            listConnections[s1].append(s2)
            listConnections[s2].append(s1)

    return [sommets, listConnections]

class Polyhedre(object) :
    """Class that represents a Polyhedron object."""


    def __init__(self, file) :
        """
        Creates a Polyhedron from a .off file passed as a parameter. The file provides information on the characteristics of the Polyhedron, such as the number \
        of vertices or their coordinates. The information is read from this file to be inserted in the object's attributes.

        :param file: The path to the file the information about the Polyhedron is in.
        :type file: str
        :return: a brand-new Polyhedron
        :rtype: Polyhedron
        :UC: path to file must be included in the file variable

        :Examples:

        >>> cube = Polyhedre("../polyèdres/cube.off")
        >>> cube.getNbSommets()
        8

        """
        
        info = Fileinfo(file)

        self.__nbSommets = info[0]
        self.__connections = info[1]
        self.__paths = []
        self.__File = file

        self.__nbChemins = 0


        self.findPaths()

    def getNbSommets(self) :
        """
        Returns the number of vertices of the Polyhedron.

        :return: The number of vertices of a Polyhedron
        :rtype: int
        :UC: must be used on a Polyhedron

        :Examples:

        >>> cube = Polyhedre("../polyèdres/cube.off")
        >>> cube.getNbSommets()
        8
        """

        return self.__nbSommets
    
    def getAllConnections(self) :
        """
        Returns a list of all connections of all vertices in this Polyhedron.

        :return: all of connections
        :rtype: list
        :UC: must be used on a Polyhedron object

        :Examples:

        >>> cube = Polyhedre("../polyèdres/cube.off")
        >>> cube.getAllConnections()
        [[1, 2, 4], [0, 3, 5], [0, 3, 6], [1, 2, 7], [0, 5, 6], [1, 4, 7], [2, 4, 7], [3, 5, 6]]

        """

        return self.__connections
    
    def getConnectionsSommet(self, sommet) :
        """
        Returns the connections of a vertex passed as a parameter.

        :param vertex: the vertex which we wants his connections  
        :type vertex: int
        :return: the list of all vertex's connections
        :rtype: list
        :UC: must be used on a Polyhedron object and 0 <= vertex < Polyhedron's number of vertices

        :Examples:

        >>> cube = Polyhedre("../polyèdres/cube.off")
        >>> cube.getConnectionsSommet(1)
        [0, 3, 5]
        >>> cube.getConnectionsSommet(5)
        [1, 4, 7]
        """

        return self.__connections[sommet]
    
    
    
    def getPaths(self) :
        """
        Returns all the found Hamiltonian Cycles of the Polyhedron

        :return: the cycles of the Polyhedron
        :rtype: list
        :UC: must be used on a Polyhedron object

        :Examples:

        >>> cube = Polyhedre("../polyèdres/cube.off")
        >>> cube.getPaths()
        [[0, 1, 3, 2, 6, 7, 5, 4], [0, 1, 3, 7, 5, 4, 6, 2], [0, 1, 5, 4, 6, 7, 3, 2], [0, 1, 5, 7, 3, 2, 6, 4],\
         [0, 2, 3, 1, 5, 7, 6, 4], [0, 2, 3, 7, 6, 4, 5, 1], [0, 2, 6, 4, 5, 7, 3, 1], [0, 2, 6, 7, 3, 1, 5, 4],\
          [0, 4, 5, 1, 3, 7, 6, 2], [0, 4, 5, 7, 6, 2, 3, 1], [0, 4, 6, 2, 3, 7, 5, 1], [0, 4, 6, 7, 5, 1, 3, 2]]

        """

        return self.__paths
    
    def addPath(self, cycle) :
        """
        Adds a Hamiltonian Cycle to this polyhedron's list of Cycles.

        :param cycle: the cycle to add
        :type cycle: list
        :return: None
        :side effect: appends object attribute __cycles
        :UC: must be used on a Polyhedron object

        :Examples:

        >>> cube = Polyhedre("../polyèdres/cube.off")
        >>> cube.getPaths()
        [[0, 1, 3, 2, 6, 7, 5, 4], [0, 1, 3, 7, 5, 4, 6, 2], [0, 1, 5, 4, 6, 7, 3, 2], [0, 1, 5, 7, 3, 2, 6, 4],\
         [0, 2, 3, 1, 5, 7, 6, 4], [0, 2, 3, 7, 6, 4, 5, 1], [0, 2, 6, 4, 5, 7, 3, 1], [0, 2, 6, 7, 3, 1, 5, 4],\
          [0, 4, 5, 1, 3, 7, 6, 2], [0, 4, 5, 7, 6, 2, 3, 1], [0, 4, 6, 2, 3, 7, 5, 1], [0, 4, 6, 7, 5, 1, 3, 2]]
        >>> cube.addPath(['a', 'b', 'c', 'd'])
        >>> cube.getPaths()
        [[0, 1, 3, 2, 6, 7, 5, 4], [0, 1, 3, 7, 5, 4, 6, 2], [0, 1, 5, 4, 6, 7, 3, 2], [0, 1, 5, 7, 3, 2, 6, 4],\
         [0, 2, 3, 1, 5, 7, 6, 4], [0, 2, 3, 7, 6, 4, 5, 1], [0, 2, 6, 4, 5, 7, 3, 1], [0, 2, 6, 7, 3, 1, 5, 4],\
          [0, 4, 5, 1, 3, 7, 6, 2], [0, 4, 5, 7, 6, 2, 3, 1], [0, 4, 6, 2, 3, 7, 5, 1], [0, 4, 6, 7, 5, 1, 3, 2],\
           ['a', 'b', 'c', 'd']]
        """

        self.__paths.append(cycle) 
    
    
    def findPaths(self, PathInProgress = [0]) :
        """
        Function that finds all Hamiltonian Cycles for this polyhedron.

        :param currentPath: a variable used to pass on the existing work recursively
        :type currentPath: list
        :default PathInProgress: [0]
        :return: None
        :side effect: adds all Hamiltonian Paths to __paths
        :UC: must be used on a Polyhedron object

        """

        pathLength = len(PathInProgress)
        nbSommets = self.getNbSommets()
        neighbours = self.getConnectionsSommet(PathInProgress[-1])

        if pathLength == nbSommets and 0 in neighbours :
            self.addPath(PathInProgress)
        elif pathLength == nbSommets:
            pass
        else :
            for i in neighbours :
                if i in PathInProgress :
                    pass
                else :
                    self.findPaths(PathInProgress + [i])
        
    def printPaths(self) :
        """
        Prints a representation of Paths of a Polyhedre.

        :return: None
        :side effect: prints all paths
        :UC: must be used on a Polyhedre object

        :Examples:

        >>> cube = Polyhedre("../polyèdres/cube.off")
        >>> cube.printCycles()
        0 - 1 - 3 - 2 - 6 - 7 - 5 - 4
        0 - 1 - 3 - 7 - 5 - 4 - 6 - 2
        0 - 1 - 5 - 4 - 6 - 7 - 3 - 2
        0 - 1 - 5 - 7 - 3 - 2 - 6 - 4
        0 - 2 - 3 - 1 - 5 - 7 - 6 - 4
        0 - 2 - 3 - 7 - 6 - 4 - 5 - 1
        0 - 2 - 6 - 4 - 5 - 7 - 3 - 1
        0 - 2 - 6 - 7 - 3 - 1 - 5 - 4
        0 - 4 - 5 - 1 - 3 - 7 - 6 - 2
        0 - 4 - 5 - 7 - 6 - 2 - 3 - 1
        0 - 4 - 6 - 2 - 3 - 7 - 5 - 1
        0 - 4 - 6 - 7 - 5 - 1 - 3 - 2

        """

        for path in self.getPaths() :
            print(" - ".join(str(i) for i in path))
        print("Has " + str(len(self.getPaths())) + " Hamiltonian Cycles")


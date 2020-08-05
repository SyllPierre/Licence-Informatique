#!/usr/bin/python3
# -*- coding: utf-8 -*-

"""
:mod:`minesweeper` module

:author: SYLLEBRANQUE Pierre, SINNAEVE Robin (HELP : DESMAREST Mathilde et IRWIN Oliver)

:date:12/10/18

This module provides functions and a class for minesweeper's game's management.

"""

import random
from enum import Enum
from cell import Cell


################################################
# Type declaration
################################################

class GameState(Enum):
    """
    A class to define an enumerated type with three values :

    * ``winning``
    * ``losing``
    * ``unfinished``

    for the three state of minesweeper game.
    """
    winning = 1
    losing = 2
    unfinished = 3


##############################################
# Function for game's setup and management
##############################################


def neighborhood(x, y, width, height):
    """
    :param x: x-coordinate of a cell
    :type x: int
    :param y: y-coordinate of a cell
    :type y: int
    :param height: height of the grid
    :type height: int
    :param width: widthof the grid
    :type width: int
    :return: the list of coordinates of the neighbors of position (x,y) in a
             grid of size width*height
    :rtype: list of tuple
    :UC: 0 <= x < width and 0 <= y < height
    :Examples:

    >>> neighborhood(3, 3, 10, 10)
    [(2, 2), (2, 3), (2, 4), (3, 2), (3, 4), (4, 2), (4, 3), (4, 4)]
    >>> neighborhood(0, 3, 10, 10)
    [(0, 2), (0, 4), (1, 2), (1, 3), (1, 4)]
    >>> neighborhood(0, 0, 10, 10)
    [(0, 1), (1, 0), (1, 1)]
    >>> neighborhood(9, 9, 10, 10)
    [(8, 8), (8, 9), (9, 8)]
    >>> neighborhood(3, 9, 10, 10)
    [(2, 8), (2, 9), (3, 8), (4, 8), (4, 9)]
    """
    l = []
    for i in range (x-1,x+2) :
        for j in range (y-1,y+2):
            if (x,y) != (i , j) and 0 <= i < width and 0 <= j < height :
                l += [(i,j)]
    return l
    
class Minesweeper():
    """
    >>> game = Minesweeper(20, 10, 4)
    >>> game.get_width()
    20
    >>> game.get_height()
    10
    >>> game.get_nbombs()
    4
    >>> game.get_state() == GameState.unfinished 
    True
    >>> cel = game.get_cell(1, 2)
    >>> cel.is_revealed()
    False
    >>> 
    """

    def __init__(self, width=30, height=20, nbombs=99):
        """
        build a minesweeper grid of size width*height cells
        with nbombs bombs randomly placed.  

        :param width:[optional] horizontal size of game (default = 30)
        :type width: int
        :param height: [optional] vertical size of game (default = 20)
        :type height: int
        :param nbombs: [optional] number of bombs (default = 99)
        :type nbombs: int
        :return: a fresh grid of  width*height cells with nbombs bombs randomly placed.
        :rtype: Minesweeper
        :UC: width and height must be positive integers, and
             nbombs <= width * height
        :Example:

        >>> game = Minesweeper(20, 10, 4)
        >>> game.get_width()
        20
        >>> game.get_height()
        10
        >>> game.get_nbombs()
        4
        >>> game.get_state() == GameState.unfinished 
        True
        """
        assert type(width) in {int} and width >=0, 'width is not an integer or is negative'
        assert type(height) in {int} and height >=0, 'height is not an integer or is negative'
        assert nbombs <= width*height, 'nbombs is superior to the number of cells'
        self.__width=width
        self.__height=height
        self.__nbombs=nbombs
        self.__state=GameState.unfinished
        self.__grid=[]
        self.__nbr_not_revealed = width*height
        
        for i in range(height):
            ligne=[]
            for j in range(width):
                ligne.append(Cell())
            self.__grid.append(ligne)
        
        bombsPlaced = 0
        bombList = []
        while bombsPlaced < self.__nbombs :
            x = random.randint(0,self.__width-1)
            y = random.randint(0,self.__height-1)
            randCoords = (x, y)
            if randCoords not in bombList :
                bombList += [randCoords]
                self.get_cell(x, y).set_bomb()
                bombsPlaced += 1
        
        for i in range(height):
            for j in range(width):
                if (j,i) not in bombList:
                    for (u, v) in neighborhood(j, i, self.__width, self.__height) :
                        if self.get_cell(u, v).is_bomb() :
                            self.get_cell(j, i).incr_number_of_bombs_in_neighborhood()
        
        
        

    def get_height(self):
        """
        :return: height of the grid in self
        :rtype: int
        :UC: none
        """
        return self.__height

    def get_width(self):
        """
        :return: width of the grid in game
        :rtype: int
        :UC: none
        """
        return self.__width

    
    def get_nbombs(self):
        """
        :return: number of bombs in game
        :rtype: int
        :UC: none
        """
        return self.__nbombs


    def get_cell(self, x, y):
        """
        :param x: x-coordinate of a cell
        :type x: int
        :param y: y-coordinate of a cell
        :type y: int
        :return: the cell of coordinates (x,y) in the game's grid
        :type: cell
        :UC: 0 <= x < width of game and O <= y < height of game
        """
        assert 0<= x < self.__width, 'x is negative or is out of the grid'
        assert 0<= y < self.__height, 'y is negative or is out of the grid'
        return self.__grid[y][x]
        


    def get_state(self):
        """
        :return: the state of the game (winning, losing or unfinished)
        :rtype: GameState
        :UC: none
        """
        return self.__state
    
    def set_state(self, state):
        """
        :return : none
        :UC : none
        """
        self.__state = state

    def reveal_all_cells_from(self, x, y):
        """
        :param x: x-coordinate
        :param y: y-coordinate
        :return: none
        :side effect: reveal all cells of game game from the initial cell (x,y).
        :UC: 0 <= x < width of game and O <= y < height of game
        """
        assert 0 <= x < self.__width, 'x is not in the grid'
        assert 0 <= y < self.__height, 'y is not in the grid'
        for i in range(y, self.__height):
            for j in range(x, self.__width):
                self.__grid[i][j].reveal()
    
    def reveal_cell(self,x,y):
        """
        :param x: x-coordinate
        :param y: y-coordinate
        :return: none
        :side effect : reveal cell and cells around if they are not bombs
        """
        cell = self.get_cell(x,y)
        if cell.is_bomb():
            cell.reveal()
            self.set_state(GameState.losing)
        else:
            if not cell.is_revealed():
                cell.reveal()
                self.__nbr_not_revealed -= 1
                if cell.number_of_bombs_in_neighborhood() == 0:
                    for (u, v) in neighborhood(x, y, self.__width, self.__height) :
                        self.reveal_cell(u,v)
        if self.__nbr_not_revealed == self.__nbombs :
            self.set_state(GameState.winning)
    
        
        
        
if __name__ == '__main__':
    import doctest
    doctest.testmod(optionflags=doctest.NORMALIZE_WHITESPACE | doctest.ELLIPSIS, verbose=True)



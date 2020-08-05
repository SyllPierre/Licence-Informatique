#!/usr/bin/python3
# -*- coding: utf-8 -*-

"""
:mod:`main` module

:author: SYLLEBRANQUE Pierre, SINNAEVE Robin (HELP : DESMAREST Mathilde et IRWIN Oliver)

:date:  2015, september. Last revision: 2017, september

Main module to play the minesweeper's game : graphical version


"""

import sys
from minesweeper import Minesweeper, GameState

def main():
    """
    main function for graphical minesweeper game
    """
    if len(sys.argv) == 4:
        width = int(sys.argv[1])
        height = int(sys.argv[2])
        nbombs = int(sys.argv[3])
    else:
        width = 10
        height = 10
        nbombs = 2
    game = Minesweeper(width, height, nbombs)
    print_game(game)
    
    while game.get_state() == GameState.unfinished:
        actions(game)
    
    if game.get_state() == GameState.winning :
        print("Vous avez gagné !")
    
    elif game.get_state() == GameState.losing:
        print("Vous avez perdu..")

    
def actions(game):
    """
    function who ask coordonates of a cell and the action for the cell.
    """
    x = -1
    y = -1
    while (x not in range(game.get_width()) or y not in range(game.get_height()))  :
        try:
            x = int(input("Enter x :"))
            y = int(input("Enter y :"))
            
            if game.get_width() <= x or x < 0 :
                print("ces valeurs ne sont pas utilisables")
                
            elif game.get_height() <= y or y < 0 :
                print("ces valeurs ne sont pas utilisables")
                
        except :
            print("Ceci n'est pas un entier")
            continue
            
    action = input("Enter action : (R)eveal,(S)et,(U)nset :")
    
    cell = game.get_cell(x, y)
    
    if action == "R":
        if cell.is_hypothetic():
            print("Un drapeau se trouve sur cette case !")
            actions(game)
        elif cell.is_revealed():
            print("cette case est déjà révéler !")
            actions(game)
        else:
            game.reveal_cell(x,y)
    
    elif action == "S":
        cell.set_hypothetic()
    
    elif action == "U":
        cell.unset_hypothetic()
    
    else :
        print("Ceci n'est pas une commande")
        actions(game)
    
    print_game(game)


def print_game(game):
    """
    function who print the grid of the game
    """
    print("  " + "".join("{:4d}".format(i) for i in range(game.get_width())))

    ligne_h = "  "
    for i in range(game.get_width()) :
        ligne_h += "+---"
    ligne_h += "+"

    for i in range(game.get_height()) :
        print(ligne_h)
        ligne = "".join("{:2d}".format(i))
        for j in range(game.get_width()) :
            ligne += "| " + str(game.get_cell(j, i)) + " "
        ligne += "|"
        print(ligne)
        
    print(ligne_h)
    
    
if __name__ == '__main__':
    main()

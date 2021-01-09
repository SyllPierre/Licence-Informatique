package battleship;
import battleship.util.*;

/**
* a class for building the board (sea) of a battlehip game.
*
* @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/
public class Sea {

  private Cell[][] theCells;
  private int totalLifePoints;


  public Sea (int width, int height) {
    this.theCells = new Cell[width][height];
    for (int i=0; i < width; i++) {
      for (int j=0; j < height; j++) {
        this.theCells[i][j] = new Cell();
      }
    }
  }


  /**
  * Returns all the cells.
  * @return all the cells.
  */
  public Cell[][] getTheCells(){
    return this.theCells;
  }

  /**
  * Returns the total life points of the Sea.
  * @return the total life points of the Sea.
  */
  public int getTotalLifePoints(){
    return this.totalLifePoints;
  }

  /**
  * Give the cell of position p
  * @param p the position of the cell
  * @return the cell of position p
  * @throws ArrayIndexOutOfBoundsException if if position is not on the sea
  */
  public Cell getCell(Position p) throws ArrayIndexOutOfBoundsException {
    int x = p.getX();
    int y = p.getY();
    if (x < 0 || y < 0 || x > this.theCells.length || y > this.theCells[0].length) {
      throw new ArrayIndexOutOfBoundsException("Position p is invalid");
    }
    return this.theCells[x][y];
  }


  /**
  * Shoot at a cell of position p on the board.
  * @param p the poisition where we wanna shoot
  * @return the answer of the shot's consequence
  * @throws ArrayIndexOutOfBoundsException if position is not on the sea
  */
  public Answer shoot(Position p) throws ArrayIndexOutOfBoundsException {
    Cell c = this.getCell(p);
    Answer a = c.hit();
    if (a == Answer.HIT || a == Answer.SUNK) {
      this.totalLifePoints--;
    }
    return a;
  }

  /**
  * Displays the board line by line and cell by cell, the display changes for the defender or the opponent, defined by the <code>defender</code>.
  * @param defender <code>true</code> if display is for defender, <code>false</code>if for opponent.
  */
  public void display(boolean defender) {
    String res = "";
    for (int i=0; i<this.theCells[0].length; i++) {
      for (int j=0; j<this.theCells.length; j++) {
        res += this.theCells[j][i].getCharacter(defender)+"  ";
      }
      res += '\n';
    }
    System.out.println(res);
  }

  /**
  * add a ship from a position either horizontally or vertically depending on dx and dy.
  * @param shiptoPlace the ship to add.
  * @param position the position of the first cell occupied by the ship.
  * @param dx 1 if the ship must be placed horizontally 0 otherwise
  * @param dy 1 if the ship must be placed vertically 0 otherwise
  * @throws IllegalStateException if the ship cannot be placed on the sea. (outside of the board or some cell is not empty)
  */
    private void addShip(Ship shiptoPlace, Position position, int dx, int dy) throws IllegalStateException {
    int length = shiptoPlace.getLength();
    int x = position.getX();
    int y = position.getY();
    if (y + length*dy > this.theCells[0].length || x < 0 || y < 0 || x + length*dx > this.theCells.length) {
      throw new IllegalStateException("The ship cannot be placed here");
    } // position valide, mais is empty ou pas ?
    for (int i = 0; i < length; i++) {
      Position p = new Position(x+(i*dx),y+(i*dy));
      if (!this.getCell(p).isEmpty()) {
        throw new IllegalStateException("The ship cannot be placed here, it is occupied");
      }
    }
    for (int j = 0; j < length; j++) {
      Position p1 = new Position(x+(j*dx),y+(j*dy));
      this.getCell(p1).addShip(shiptoPlace);
      this.totalLifePoints++;
    }
  }

  /**
  * add a ship horizontally from position p.
  * @param shiptoPlace the ship to add.
  * @param position the position of the first cell occupied by the ship.
  * @throws IllegalStateException if the ship cannot be placed on the sea. (outside of the board or some cell is not empty)
  */
  public void addShipHorizontally(Ship shiptoPlace, Position position) throws IllegalStateException {
    this.addShip(shiptoPlace, position, 1, 0);
  }

  /**
  * add a ship horizontally from position p.
  * @param shiptoPlace the ship to add.
  * @param position the position of the first cell occupied by the ship.
  * @throws IllegalStateException if the ship cannot be placed on the sea. (outside of the board or some cell is not empty)
  */
  public void addShipVertically(Ship shiptoPlace, Position position) throws IllegalStateException {
    this.addShip(shiptoPlace, position, 0, 1);
  }




}

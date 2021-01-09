package battleship;
import battleship.util.*;

/**
 * a class for building the cells of the board game battleship.
 *
 * @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/

public class Cell {

  private boolean hit;
  private Ship ship;
  private static final char EMPTY_CHAR = '~';
  private static final char OCCUPIED_CHAR = 'B';
  private static final char HIT_CHAR = '*';
  private static final char NOTSHOT_CHAR = '.';

  /**
  * Builds a Cell object
  */
  public Cell(){
    this.hit = false;
  }

  /**
  * Set the cell occupied by a ship.
  * @param s the Ship to put on
  */
  public void addShip(Ship s) {
    this.ship = s;
  }

  /**
  * Returns the ship on the cell
  * @return the ship on the cell
  */
  public Ship getShip(){
    return this.ship;
  }

  /**
  * Returns if the cell is empty or not
  * @return true if it is, false otherwise
  */
  public boolean isEmpty(){
    if (this.ship == null) {
      return true;
    }
  return false;
  }

  /**
  * Tells if the cell is hit or not.
  * @return true if it is, false otherwise
  */
  public boolean isHit() {
    return this.hit;
  }

  /**
  * Hit the cell. Returns the answer of the attack.
  * @return the answer of the hit's consequence
  */
  public Answer hit(){
    if (this.isEmpty() || this.isHit()) {
      this.hit = true;
      return Answer.MISSED;
    }
    else{
      this.getShip().hit();
      this.hit = true ;
      if (this.getShip().getLifePoints() == 0){
        return Answer.SUNK;
      }
      else{
        return Answer.HIT;
      }
    }
  }

  /**
  * Gives the character that represents the cell.
  * @param defender true if the player is the defender, false if it is the attacker.
  * @return the character that represents the cell.
  */
  public char getCharacter(boolean defender) {
    if (defender) {
      if (this.isEmpty()) {
        return Cell.EMPTY_CHAR;
      }
      else if (this.isHit()) {
        return Cell.HIT_CHAR;
      }
      else {
        return Cell.OCCUPIED_CHAR;
      }
    }
    else {
      if (!this.isHit()) {
        return Cell.NOTSHOT_CHAR;
      }
      else if (this.isEmpty()) {
        return Cell.EMPTY_CHAR;
      }
      else {
        return Cell.HIT_CHAR;
      }
    }
  }


}

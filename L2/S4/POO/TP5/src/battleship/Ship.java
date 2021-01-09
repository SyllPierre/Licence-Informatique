package battleship;

/**
* a class for Ship objects (in order to play battleship).
*
* @author DESMAREST Mathilde / SYLLEBRANQUE Pierre

*/
public class Ship {

  private final int length;
  private int lifePoints;

  /**
  * Builds a Ship
  * @param lp the ship's number of life points
  */
  public Ship(int lp){
      this.lifePoints = lp;
      this.length = lp;
  }

  /**
  * Tells if the boat is sunk or not
  * @return True if it is, false otherwise
  */
  public boolean isSunk(){
    if (this.lifePoints == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
  * Gives the ship's number of life points.
  * @return the ship's number of life points.
  */
  public int getLifePoints() {
    return this.lifePoints;
  }

  /**
  * Gives the ship's length
  * @return the ship's length
  */
  public int getLength() {
    return this.length;
  }

  /**
  * Hit the ship, decrease its life points number
  */
  public void hit(){
    this.lifePoints--;
  }

}

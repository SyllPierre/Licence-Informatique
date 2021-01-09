package battleship;

/**
* A Position class for playing battleship.
*
* @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/
public class Position {

  private int x;
  private int y;

  /**
  * Builds a position object.
  * @param x the x coordinate
  * @param y the y coordinate
  */
  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  /**
  * Gives the x coordinate of the Position.
  * @return the x coordinate of the Position.
  */
  public int getX(){
    return this.x;
  }

  /**
  * Gives the y coordinate of the Position.
  * @return the y coordinate of the Position.
  */
  public int getY(){
    return this.y;
  }

  /**
  * Tells if two position are equals
  * @param o the object to test
  * @return True if they are equals, false otherwise
  */
  public boolean equals(Object o){
    if (o instanceof Position) {
        Position other = (Position) o;
        return this.x == other.x && this.y == other.y;
    }
    else {
        return false;
    }
  }

  /**
  * Gives a String representation of a Position
  * @return a String representation
  */
  public String toString() {
    return "x: "+this.x+" y: "+this.y;
  }
}

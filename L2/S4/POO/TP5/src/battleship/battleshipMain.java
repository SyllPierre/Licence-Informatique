package battleship;
import battleship.util.*;
import battleship.util.io.*;

public class battleshipMain {

  public static void main(String[] args) throws java.io.IOException {
    Sea s = new Sea(7,4);
    Ship b1 = new Ship(4);
    Ship b2 = new Ship(2);
    Ship b3 = new Ship(3);
    Ship b4 = new Ship(2);
    Position p1 = new Position(0,0);
    Position p2 = new Position(0,1);
    Position p3 = new Position(1,2);
    Position p4 = new Position(6,1);
    s.addShipHorizontally(b1, p1);
    s.addShipVertically(b2, p2);
    s.addShipHorizontally(b3, p3);
    s.addShipVertically(b4, p4);
    Game game = new Game(s);
    game.Attack();
  }

}

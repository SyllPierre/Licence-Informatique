import org.junit.*;
import static org.junit.Assert.*;

import battleship.*;
import battleship.util.*;

public class SeaTest {

  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void shootThrowsExceptionWhenPositionNotValid() {
    Sea s = new Sea(5,5);
    Position p = new Position (3,123);
    s.shoot(p);
  }

  @Test(expected = IllegalStateException.class)
  public void addShipVerticallyThrowsExceptionWhenPositionNegative() {
    Sea s = new Sea(10,10);
    Position p = new Position(-2,5);
    Ship b = new Ship(3);
    s.addShipVertically(b,p);
  }

  @Test(expected = IllegalStateException.class)
  public void addShipHorizontallyThrowsExceptionWhenPositionNegative() {
    Sea s = new Sea(10,10);
    Position p = new Position(2,-5);
    Ship b = new Ship(3);
    s.addShipHorizontally(b,p);
  }

  @Test(expected = IllegalStateException.class)
  public void addShipHorizontallyThrowsExceptionWhenShipTooBigForPosition() {
    Sea s = new Sea(10,10);
    Position p = new Position(8,5);
    Ship b = new Ship(3);
    s.addShipHorizontally(b,p);
  }

  @Test(expected = IllegalStateException.class)
  public void addShipVerticallyThrowsExceptionWhenShipTooBigForPosition() {
    Sea s = new Sea(10,10);
    Position p = new Position(5,8);
    Ship b = new Ship(3);
    s.addShipVertically(b,p);
  }

  @Test
  public void addShipHorizontallyIsOk() {
    Sea s = new Sea(10,10);
    Position p1 = new Position(7,2);
    Ship b = new Ship(2);
    s.addShipHorizontally(b, p1);
    Cell c1 = s.getCell(p1);
    Position p2 = new Position(8,2);
    Cell c2 = s.getCell(p2);
    Position p3 = new Position(9,2);
    Cell c3 = s.getCell(p3);
    assertFalse(c1.isEmpty());
    assertFalse(c2.isEmpty());
    assertTrue(c3.isEmpty());
  }

  @Test
  public void addShipVerticallyIsOk(){
    Sea s = new Sea(10,10);
    Position p1 = new Position(2,7);
    Ship b = new Ship(2);
    s.addShipVertically(b, p1);
    Cell c1 = s.getCell(p1);
    Position p2 = new Position(2,8);
    Cell c2 = s.getCell(p2);
    Position p3 = new Position(2,9);
    Cell c3 = s.getCell(p3);
    assertFalse(c1.isEmpty());
    assertFalse(c2.isEmpty());
    assertTrue(c3.isEmpty());
  }



    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(SeaTest.class);
    }

}

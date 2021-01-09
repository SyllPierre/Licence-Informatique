import org.junit.*;
import static org.junit.Assert.*;

import battleship.*;

public class ShipTest {

  @Test
  public void testBuildingAShip() {
    Ship b = new Ship(3);
    assertEquals(3, b.getLength());
    assertEquals(3, b.getLifePoints());
  }

  @Test
  public void testHitDecreaseLifePoints() {
    Ship b = new Ship(3);
    b.hit();
    assertEquals(2, b.getLifePoints());
    b.hit();
    assertEquals(1, b.getLifePoints());
  }

  @Test
  public void isSunkReturnsTrue() {
    Ship b = new Ship(3);
    b.hit();
    b.hit();
    b.hit();
    assertTrue(b.isSunk());
  }

  @Test
  public void isSunkReturnsFalse() {
    Ship b = new Ship(3);
    assertFalse(b.isSunk());
  }



    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(ShipTest.class);
    }

}

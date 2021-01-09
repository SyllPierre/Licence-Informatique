import org.junit.*;
import static org.junit.Assert.*;

import battleship.*;
import battleship.util.*;

public class PositionTest {

  @Test
  public void testGetX(){
    Position p = new Position(5,8);
    assertEquals(p.getX(),5);
  }

  @Test
  public void testGetY(){
    Position p = new Position(5,8);
    assertEquals(p.getY(),8);
  }

  @Test
  public void testTwoEqualsPositions(){
    Position p = new Position(5,8);
    Position p2 = new Position(5,8);
    assertEquals(p, p2);
  }



    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(PositionTest.class);
    }

}

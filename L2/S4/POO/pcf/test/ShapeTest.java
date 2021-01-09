import org.junit.*;
import static org.junit.Assert.*;

import pcf.Shape;

public class ShapeTest{

  @Test
  public void testCompareTo(){
    Shape pierre = Shape.ROCK;
    Shape ciseaux = Shape.SCISSORS;
    Shape papier = Shape.PAPER;
    assertEquals(ciseaux.compareShape(ciseaux), 0);
    assertEquals(pierre.compareShape(papier), -1);
    assertEquals(pierre.compareShape(ciseaux), 1);
  }


  // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(ShapeTest.class);
}
}

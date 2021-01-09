import org.junit.*;
import static org.junit.Assert.*;

import battleship.*;
import battleship.util.*;

public class CellTest {

  @Test
  public void testBuildingACell() {
    Cell c = new Cell();
    assertFalse(c.isHit());
    assertTrue(c.isEmpty());
  }

  @Test
  public void addShipInCell(){
    Cell c = new Cell();
    Ship b = new Ship(3);
    c.addShip(b);
    assertEquals(b, c.getShip());
  }

  @Test
  public void firstHitDecreaseLifePoints() {
    Cell c = new Cell();
    Ship b = new Ship(3);
    c.addShip(b);
    c.hit();
    assertEquals(2, b.getLifePoints());
  }

  @Test
  public void SecondHitHasNoEffect() {
    Cell c = new Cell();
    Ship b = new Ship(3);
    c.addShip(b);
    c.hit();
    assertEquals(2, b.getLifePoints());
    c.hit();
    assertEquals(2, b.getLifePoints());
  }

  @Test
  public void HitReturnsAnswerSUNK() {
    Cell c = new Cell();
    Ship b = new Ship(1);
    c.addShip(b);
    assertEquals(Answer.SUNK, c.hit());
  }

  @Test
  public void HitReturnsAnswerMISSED(){
    Cell c = new Cell();
    assertEquals(Answer.MISSED, c.hit());
  }

  @Test
  public void HitReturnsAnswerHIT(){
    Cell c = new Cell();
    Ship b = new Ship(2);
    c.addShip(b);
    assertEquals(Answer.HIT, c.hit());
  }

  @Test
  public void getCharacterDefenderReturnsEMPTY_CHAR() {
    char expect = '~';
    Cell c = new Cell();
    assertEquals(c.getCharacter(true), expect);
  }

  @Test
  public void getCharacterDefenderReturnsHIT_CHAR() {
    char expect = '*';
    Cell c = new Cell();
    Ship b = new Ship(2);
    c.addShip(b);
    c.hit();
    assertEquals(c.getCharacter(true), expect);
  }

  @Test
  public void getCharacterDefenderReturnsOCCUPIED_CHAR() {
    char expect = 'B';
    Cell c = new Cell();
    Ship b = new Ship(2);
    c.addShip(b);
    assertEquals(c.getCharacter(true), expect);
  }

  @Test
  public void getCharacterAttackerReturnsEMPTY_CHAR() {
    char expect = '~';
    Cell c = new Cell();
    c.hit();
    assertEquals(c.getCharacter(false), expect);
  }

  @Test
  public void getCharacterAttackerReturnsNOTSHOT_CHAR() {
    char expect = '.';
    Cell c = new Cell();
    Ship b = new Ship(2);
    c.addShip(b);
    assertEquals(c.getCharacter(false), expect);
  }

  @Test
  public void getCharacterAttackerReturnsHIT_CHAR() {
    char expect = '*';
    Cell c = new Cell();
    Ship b = new Ship(2);
    c.addShip(b);
    c.hit();
    assertEquals(c.getCharacter(false), expect);
  }



    // ---Pour permettre l'exécution des test----------------------
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(CellTest.class);
    }

}

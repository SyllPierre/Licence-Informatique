/**
 * A class for an Interactive Strategy
 *
 * @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/

package pcf.strategies;
import pcf.Strategy;
import pcf.Shape;
import util.*;


public class InteractiveStrat implements Strategy{
  private String strat;

  public InteractiveStrat(){
    this.strat = "InteractiveStrat";
  }

  public Shape chooseShape(){
    Shape s = null;
    while (s == null){
      System.out.println("Choose a shape between ROCK, PAPER, SISSORS:");
      String answer = Input.readString();
      try{
        s = Shape.valueOf(answer.toUpperCase());
      }catch (IllegalArgumentException e){
        System.out.println("Shape invalide");
        s = null;
      }
    }
    return s;
  }
}

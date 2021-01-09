/**
 * A class for a Paper Strategy
 *
 * @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/

package pcf.strategies;
import pcf.Strategy;
import pcf.Shape;
import util.*;

public class StratPaper implements Strategy{
  private String strat;

  /**
    *
    */
  public StratPaper(){
    this.strat = "StratPaper";
  }

  public Shape chooseShape(){
    return Shape.PAPER;
  }
}

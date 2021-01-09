/**
 * A class for the PLayer
 *
 * @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/
package pcf;
import pcf.Strategy;

public class Player {

  private String name;
  private int points;
  private Strategy myStrategy;

  /** Create a player
    * @param name the name of the Player
    * @param myStrategy the player's strategy
    */
  public Player(String name, Strategy myStrategy){
    this.points = 0;
    this.name = name;
    this.myStrategy = myStrategy;
  }

  /** Give the name of the player
    * @return the name of the player
    */
  public String getName(){
    return this.name;
  }

  /** Give the score of the player
    * @return the score of the player
    */
  public int getScore(){
    return this.points;
  }

  /** Add points to player's points
    * @param p number of points to add to player's points
    */
  public void addPoints(int p){
    this.points = this.points + p;
  }

  /** Give the strategy of the player
    * @return the player's strategy
    */
  public Strategy getStrategy(){
    return this.myStrategy;
  }

  /** Set a strategy to the player
    * @param s the strategy to set to the player
    */
  public void setStrategy(Strategy s){
    this.myStrategy = s;
  }

  /** Return "Player" and the name of the player
    * @return the name of the player
    */
  public String toString(){
    return "Player " + this.name;
  }

  /** The player choose a Shape
    * @return the shape chosen by the player
    */
  public Shape play(){
    return this.myStrategy.chooseShape() ;

  }


}

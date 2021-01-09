/**
 * A class for the Game
 *
 * @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/

package pcf;

import pcf.Player;
import pcf.Strategy;
import pcf.strategies.InteractiveStrat;

public class Game{

  private Player p1;
  private Player p2;
  private int nbTours;

  private int VICTORY_POINTS = 2;
  private int DEFEAT_POINTS = 0;
  private int TIE_POINTS = 1;

  /** Create a game between 2 players with their points
    * @param p1 Player p1
    * @param p2 Player p2
    * @param nbTours number of tours of play
    */
  public Game(Player p1, Player p2, int nbTours ){
    this.p1 = p1;
    this.p2 = p2;
    this.nbTours = nbTours;
  }

  /** Play the game
    */
  public void playGame(){
    for (int i=0; i < this.nbTours ; i++){
      this.playOneRound();
    }
    this.endOfTheGame();
  }

  /**
    * Displays who wins at the end
    */
  private void endOfTheGame(){
    int score1 = this.p1.getScore();
    int score2 = this.p2.getScore();
    if (score1 > score2){
      System.out.println(this.p1.toString() + " wins the game ! ");
    }
    else if (score1 < score2){
      System.out.println(this.p2.toString() + " wins the game ! ");
    }
    else {
      System.out.println(" Tie game ! Nobody wins the game. ");
    }

  }

  private void playOneRound(){
    Shape s1 = this.p1.play();
    Shape s2 = this.p2.play();
    System.out.println(this.p1.toString()+" plays " + s1);
    System.out.println(this.p2.toString()+" plays " + s2);
    int Npoints = s1.compareShape(s2);
    this.givePoints(Npoints);

  }


  private void givePoints(int Npoints){
    if (Npoints == 0){
      this.p1.addPoints(this.TIE_POINTS);
      this.p2.addPoints(this.TIE_POINTS);
      System.out.println("Tie game !");
    }
    else if (Npoints < 0){
      this.p1.addPoints(this.DEFEAT_POINTS);
      this.p2.addPoints(this.VICTORY_POINTS);
      System.out.println(this.p2.toString() + " wins ! ");
    }
    else{
      this.p1.addPoints(this.VICTORY_POINTS);
      this.p2.addPoints(this.DEFEAT_POINTS);
      System.out.println(this.p1.toString() + " wins ! ");
    }
  }

  }

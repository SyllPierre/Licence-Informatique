package battleship;
import battleship.util.*;
import battleship.util.io.*;

/**
* a class for building a game of battleship
*
* @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/
public class Game {

  private Sea TheSea;

  public Game(Sea s){
    this.TheSea = s;
  }

  /**
  * Asks the user where he wants to attack
  * @return the read position
  */
  private Position askPosition() {
    System.out.println("Choisissez les coordonnées de la case que vous souhaitez attaquer !");
    System.out.println("x: ");
    int x;
    int y;
    try {
      x = Input.readInt();
    } catch(java.io.IOException e) {
      x = 0;
    }
    System.out.println("y: ");
    try {
      y = Input.readInt();
    } catch(java.io.IOException e) {
      y = 0;
    }
    Position p = new Position(x,y);
    return p;
  }

  /**
  * Makes the user ask for where he want to attack and attack
  */
  public void Attack(){
    this.TheSea.display(false);
    int count = 0;
    while (this.TheSea.getTotalLifePoints() != 0) {
      Position p = this.askPosition();
      try {
        System.out.println(this.TheSea.shoot(p));
        this.TheSea.display(false);
        count++;
      } catch(ArrayIndexOutOfBoundsException e) {
        System.out.println("La position donnée n'est pas valide: elle est hors du plateau");
      }
    }
    System.out.println("Vous avez gagné en "+count+" tirs, bravo !");
  }


}

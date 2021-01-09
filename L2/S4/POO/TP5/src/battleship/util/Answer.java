package battleship.util;

/**
* an enum for playing the battleship game
*
* @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/

public enum Answer {
  HIT, MISSED, SUNK;

  public String toString() {
    if (this == Answer.HIT) {
      return "HIT";
    }
    else if (this == Answer.MISSED) {
      return "MISSED";
    }
    else {
      return "SUNK";
    }
  }

}

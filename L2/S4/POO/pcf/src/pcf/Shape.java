package pcf;
/**
 * A class for the Shape
 *
 * @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/

public enum Shape{
  ROCK , PAPER , SCISSORS;

  public int compareShape(Shape s){
    if (this == s){
      return 0;
    }

    else if (this == PAPER){
      if (s == ROCK){
        return 1;
      }
      else if (s == SCISSORS){
        return -1;
      }
    }


    else if (this == ROCK){
      if (s == PAPER){
        return -1;
      }
      else if (s == SCISSORS) {
        return 1;
      }
    }

    else if (this == SCISSORS){
      if (s == PAPER){
        return 1;
      }
      else if (s == ROCK){
        return -1;
      }
    }
    return 0;
  }
}

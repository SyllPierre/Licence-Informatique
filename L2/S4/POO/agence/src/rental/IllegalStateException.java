package rental;

/**
 * A class for the Exception IllegalState
 *
 * @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/


public class IllegalStateException extends RuntimeException{
  public IllegalStateException(){
  }

  public IllegalStateException(String msg){
    super(msg);
  }
}

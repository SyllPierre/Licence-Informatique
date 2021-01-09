/**
  * A class for goose cell
  *
  * @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
  */

package goosegame;

public class GooseCell extends StandardCell{
  /** Creates a GooseCell at the number index
    * @param index the number of the Cell
    */
  public GooseCell(int index){
    super(index);
  }

  public int handleMove(int dicethrow){
    return this.getIndex() + dicethrow;
  }

  public String toString(){
    return new String("Cell" + index + "(goose)");
  }

}

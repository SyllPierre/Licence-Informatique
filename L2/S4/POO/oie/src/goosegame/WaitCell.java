/**
 * A class for WaitCell
 *
 * @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/

package goosegame;

public class WaitCell extends StandardCell{

  protected int duration;
  protected int time;
  /** Creates a WaitCell at the number index
  * @param index the number of the cell
  * @param duration the duration to wait
  */
  public WaitCell(int index, int duration){
    super(index);
    this.duration = duration;
    this.time = duration;
  }

  public boolean canBeLeft(){
    if (time == 0){
      return true;
    }
    else{
      time --;
      return false;
    }
  }

  public void welcomePlayer(Player p){
    time = duration;
    super.welcomePlayer(p);
  }

  public String toString(){
    return new String("Cell "+index+" (waiting for "+duration+" turns)");
  }
}

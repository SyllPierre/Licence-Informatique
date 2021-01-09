/**
  *  A class dor StandardCell
  *
  * @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
  */

package goosegame;

public class StandardCell implements Cell{
  protected int index;
  protected Player player;

  /** Create a standard cell (basic cell) at the number index
    * @param index the number of the Cell
    */
  public StandardCell(int index){
    this.index = index;
    this.player = null;
    }

    public int getIndex(){
      return this.index;
    }

    public Player getPlayer(){
      return this.player;
    }

    public boolean canBeLeft(){
      return true;
    }

    public int handleMove(int dicethrow){
      return this.index;
    }

    public boolean isBusy(){
      return this.player != null;
    }

    public void welcomePlayer(Player p){
      this.player = p;
      if (p!=null){
        p.setCell(this);
    }
  }

    public String toString(){
      return new String("Cell "+ index );
    }

}

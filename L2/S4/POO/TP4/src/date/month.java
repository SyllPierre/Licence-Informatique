package date;

public enum Month{
  january(31),
  february(28),
  march(31),
  april(30),
  may(31),
  june(30),
  july(31),
  august(31),
  september(30),
  october(31),
  november(30),
  december(31);

  private static final int nbDays;
  private Month(int nbDays){
    this.nbDays = nbDays;
  }
  /**
    *return the nb of days un the month
    *@param year
    *@return the nb of day
    */
  public int nbDays(int year){
    if (this != Month.fevrier || !Date.isBissextile(year)){
      return  this.nbDays;
    }
    else{
      return this.nbDays+1;
    }
  }


  /**
    *return the next month
    *@return the next month
    */
  public Month next(){
    return Month.values()[this.ordinal() + 1 % Months.values().length];
  }

}

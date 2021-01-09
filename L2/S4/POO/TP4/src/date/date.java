package date;

public class Date{

  // les attributs de la classe Date

  /** the day of the Date  */
  private int day;
  /** the month of the Date  */
  private Month month;
  /** the year of the Date  */
  private int year;


  /**
  *create a Date
  **/
  public Date(int day,Month month,int year){
    this.day= day ;
    this.month= month ;
    this.year= year ;
  }


  /** returns the day
   * @return the day
   */
  public int getDay(){
    return this.day;
  }

  /** returns the month
   * @return the month
   */
  public Month getMonth(){
    return this.month;
  }

  /** returns the year
   * @return the year
   */
  public int getYear(){
    return this.year;
  }

  /**
    * @see java.lang.Object#toString()
    */
  public String toString() {
      return "the date is"+this.day+"/"+this.month+"/"+this.year;
  }


  /** two date are equals if they have the same days,month and year
   * @param o the object to test equality with
   * @return <code>true</code> iff o is a date with the same days,month and year than this object
   */

  public boolean equals (Object O){
    if (O instanceof Date){
      Date other = (Date) O;
      return this.day == other.day && this.month == other.month && this.year == other.year;
    }
    else{
      return false;
    }
  }

  public static boolean isBissextile(int year){
    return (year %4==0) && (year % 400 !=0);
  }

  /**
    *return tomorrow
    * @return tomorrow
    */
  public Date Tomorrow(){
    if (this.day == this.month.nbDays(this.year)){
      if (this.month == Month.decembre){
        return new Date (1, Month.janvier, this.year +1);
      }
      else{
        return new Date (1, this.month.next(),this.year);
      }
    }
    else{
      return new Date (this.day+1,this.month,this.year);
    }
  }


}

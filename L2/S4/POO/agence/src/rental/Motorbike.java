package rental;

/**
 * A class for the MotorBike
 *
 * @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/


import rental.Vehicle;

public class Motorbike extends Vehicle{
  private int cylindree;

  /**
    * Creates a car with given informations
 	  * @param brand
 	  *            the vehicle's brand
 	  * @param model
 	  *            the vehicle's model
 	  * @param productionYear
 	  *            the vehicle's production year
 	  * @param dailyRentalPrice
 	  *            the daily rental price
    * @param cylindree
    *            the engne cylinder
    */
    public Motorbike(String brand, String model, int productionYear, float dailyRentalPrice, int cylindree){
      super(brand,model,productionYear,dailyRentalPrice);
      this.cylindree = cylindree;
    }


    /**
      * @return the capacity of number of passengers for this vehicle
      */
    public int getCylindree(){
      return this.cylindree;
    }

    public String toString(){
      return super.toString() + " " + this.cylindree;
    }

  }

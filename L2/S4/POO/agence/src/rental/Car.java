package rental;

/**
 * A class for the car
 *
 * @author DESMAREST Mathilde / SYLLEBRANQUE Pierre
*/


import rental.Vehicle;

public class Car extends Vehicle{
  private int nbPassengers;

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
    * @param nbPassengers
    *            the number of passangers
    */
    public Car(String brand, String model, int productionYear, float dailyRentalPrice, int nbPassengers){
      super(brand,model,productionYear,dailyRentalPrice);
      this.nbPassengers = nbPassengers;
    }


    /**
      * @return the capacity of number of passengers for this vehicle
      */
    public int getNbPassengers(){
      return this.nbPassengers;
    }

    public String toString(){
      return super.toString() + " " + this.nbPassengers;
    }




















}

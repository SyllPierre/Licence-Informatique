package rental;

import java.util.*;
import rental.*;

/** main to test for question  Q6 */

public class Main_Q6 {
    public static void main(String[] args) throws Exception {
      RentalAgency agency = new RentalAgency();
      Vehicle v = new Vehicle("peugeot","106",2000,50);
      Car c = new Car("lamborghini","y",2015,1500,5);
      Motorbike m = new Motorbike("yamaha","m",2016,120,1400);
      agency.addVehicle(v);
      agency.addVehicle(c);
      agency.addVehicle(m);
      VehicleFilter prix = new MaxPriceFilter(150);
      agency.displaySelection(prix);
    }
}

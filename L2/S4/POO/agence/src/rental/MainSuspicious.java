package rental;

import java.util.*;

/** main to test for question  Q8 */
public class MainSuspicious {
  public static void main(String[] args) throws Exception {
    RentalAgency agency = new SuspiciousRentalAgency();
    Vehicle v = new Vehicle("peugeot","106",2000,50);
    Car c = new Car("lamborghini","y",2015,1500,5);
    Motorbike m = new Motorbike("yamaha","m",2016,120,1400);
    Client pierre = new Client("Pierrot",20);
    agency.addVehicle(v);
    agency.addVehicle(c);
    agency.addVehicle(m);
    float price = agency.rentVehicle(pierre,c);
    System.out.println(pierre.getName() +" loue actuellement " + c.getBrand()+" au prix minime de "+price+"euros");
  }
}

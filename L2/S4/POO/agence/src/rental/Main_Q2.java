package rental;

import java.util.*;


/** main to test for question  Q2 */
public class Main_Q2 {
  public static void main(String[] args) throws Exception{
    RentalAgency agency = new RentalAgency();
    Vehicle v1 = new Vehicle("b","m",2016,100); //4 paramètres corrects
    Vehicle v2 = new Vehicle("peugeot","106",2000,50);
    agency.addVehicle(v1); //on ajoute le véhicule à l'agence
    agency.addVehicle(v2);
    Client c1 = new Client("Tim Oleon", 40); //Le client s'appelle Tim Oléon et il a 40 ans
    float price = agency.rentVehicle(c1,v1);
    Client c2 = new Client("Tim Oleon", 40);
    boolean b = agency.hasRentedAVehicle(c2);
    System.out.println("Computed value for 'b'  : "+b+"( /!\\ must be true /!\\)");
    VehicleFilter prix = new MaxPriceFilter(60);
    agency.displaySelection(prix);
  }
}

package rental;

import java.util.*;

/** a rental vehicle agency, client can rent one vehicle at a time */
public class SuspiciousRentalAgency extends RentalAgency {
  public SuspiciousRentalAgency() {
    super();
  }

  /** client rents a vehicle
  * @param client the renter
  * @param v the rented vehicle
  * @return the daily rental price
  * @exception UnknownVehicleException   if v is not a vehicle of this agency
  * @exception IllegalStateException if v is already rented or client rents already another vehicle
    */
    public float rentVehicle(Client client, Vehicle v) throws UnknownVehicleException, IllegalStateException {
      if (theVehicles.contains(v)){
        if (!this.rentedVehicles.containsKey(client) && !this.rentedVehicles.containsValue(v)){
          this.rentedVehicles.put(client,v);
          if (client.getAge()<25){
            return (float)1.1 * v.getDailyPrice();
          }
          else{
            return v.getDailyPrice();
          }
        }
        throw new IllegalStateException();
      }
      throw new UnknownVehicleException("not a vehicle");
    }
}

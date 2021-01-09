public class BikeStation {
	private String name;
	private int capacity;
	private int numberOfBikes;
	private Bike[] slots;

    /** Create a bike station with given name and capacity
     * @param name the BikeStation's name
     * @param capacity the BikeStation's capacity
     */
	public BikeStation(String name, int capacity) {
	    this.name = name;
		this.capacity = capacity;
		this.slots = new Bike[capacity];
	}


    /** Give the name of the station
     * @return (string) the name of the station
     */
	public String getName() {
		return this.name;
	}


    /** Give the capacity of the Station
     * @return (int) the capacity of the station
     */
	public int getCapacity() {
		return this.capacity;
	}


    /** Give the number of Bike in the Station
     * @return (int) number of bike in the station
     */
	public int getNumberOfBikes() {
		int counter = 0;
		int i = 0 ;
		for (i=0 ; i < this.capacity ; i++ ) {
			if (slots[i] != null){
				counter++;
			}
		}
		return counter;
	}


    /** If the BikeStation isn't full, return the first free place, else return -1
     * @return i the first free slot if there is obe
		 * @return -1 if there is no free slot
     */
	public int firstFreeSlot() {
		int i = 0 ;
		for (i=0; i < this.capacity ; i++){
			if (slots[i]==null){
				return i;
			}
		}
		return -1;
	}

    /** Put the bike in the station if the station is not full
     * @param bike the bike you want to p ut in the station
     * @return boolean true if the bike had been put in the station else return false
     */
	public boolean dropBike(Bike bike){
	    if (this.firstFreeSlot() !=-1){
	    	this.numberOfBikes++;
				this.slots[firstFreeSlot()]=bike;
				return true;
	    }
	    return false;
	    }




    /** If there is a bike at the slots return the bike else return null
     * @param int the slots of the bike you want
     * @return null if the slots is empty else the bike
     */
	public Bike takeBike(int i){
		if (i<this.capacity && i>=0 && this.slots[i]!=null){
			Bike res;
			res = this.slots[i];
			this.slots[i] = null;
			return res;
		}
		else{
			return null;
		}
	}



}

package fil.coo.content;

import java.util.ArrayList;

import fil.coo.Inhabitants;

/**
 * 
 * @author SYLLEBRANQUE
 *
 */
public class ChainOfInhabitant implements Content {
	private ArrayList<Inhabitants> listOfInhabitants;

	/**
	 * Create a Chain Of Inhabitants, wich is a list of 4 inhabitants.
	 * @param listOfInhabitantsInitial The inital list of inhabitants
	 */
	public ChainOfInhabitant (ArrayList<Inhabitants> listOfInhabitantsInitial) {
		assert(listOfInhabitantsInitial.size() > 4) : "List size must be >= 4";
		this.listOfInhabitants = new ArrayList<Inhabitants>();
		for(int i = 0; i < 4; i++) {
			this.listOfInhabitants.add(listOfInhabitantsInitial.get(i));
		}
	}

	/**
	 * @return A list  of inhabitants.
	 */
	public ArrayList<Inhabitants> getListOfInhabitants() {
		return this.listOfInhabitants;
	}

	@Override
	public String toString() {
		String stringToReturn = "[";
		int i = 0;
		for (Inhabitants inhabitant : this.listOfInhabitants) {
			stringToReturn  = stringToReturn + inhabitant.getName();
			if (i != 3) {
				stringToReturn  = stringToReturn + " ,";
			}
			i = i + 1;
		}
		 stringToReturn = stringToReturn + "]";
		 return stringToReturn;
	}	
}
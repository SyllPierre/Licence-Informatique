package fil.coo.Rooms;
import fil.coo.Actions.Action;
import fil.coo.Actions.Fight;
import fil.coo.Actions.Look;
import fil.coo.Actions.Move;
import fil.coo.Actions.Suicide;
import fil.coo.Actions.Use;
import fil.coo.Character.*;
import fil.coo.Items.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import fil.coo.Choseable;

/**
 * Creates a class for a room
 * @author desmarest syllebranque
 */
public class Room implements Choseable {
	private Map<Direction, Room> neighbors;
	private ArrayList<Monster> monsters;
	private ArrayList<Item> items;
	private static int index = 0;
	private int indexOfRoom;
	private static Random alea = new Random();
	
	/**
	 * Create a room
	 * @param nbMonsters the number of monsters
	 * @param nbItems the number of items
	 */
	public Room(int nbMonsters, int nbItems){
		int i;
		this.monsters = new ArrayList<Monster>();
		this.items = new ArrayList<Item>();
		this.neighbors = new HashMap<Direction,Room>();
		indexOfRoom = Room.index;
		Room.index++;
		
		for (i=0; i<nbMonsters; i++){
			int s = alea.nextInt(30);
			int l = alea.nextInt(15);
			int g = alea.nextInt(20);
			this.monsters.add(new Monster(s,l,g,this));
		}
		for (i=0; i<nbItems; i++){
			int c = alea.nextInt(3);
			Item item ;
			item = null;
			switch (c){
			case 0:
				item = new GoldPurse();
				break;
			case 1:
				item = new HealthPotion();
				break;
			case 2:
				item = new OneArmedBandit();
				break;
			case 3:
				item = new StrengthPotion();
				break;
						}
		
			this.items.add(item);
		}
		this.neighbors = new HashMap<Direction,Room>();
	}
	/**
	 * displays the name of the room
	 */
	public void displayName(){
		System.out.println("You are in the room "+this.indexOfRoom+".");
	}
	/**
	 * Display the room
	 */
	public void display() {
		System.out.println("Room "+this.indexOfRoom);
	}
	/**
	 * Return the name of the room
	 * @return the name of the room
	 */
	public String getName(){
		return "Room "+this.indexOfRoom;
	}
	
	/**
	 * Add a direction to a room
	 * @param direction the direction between the two rooms
	 * @param room the room with the direction we want to add
	 */
	public void addDirection(Direction direction, Room room){
		this.neighbors.put(direction,room);
		if (direction == Direction.EAST) {
			room.neighbors.put(Direction.WEST, this);
		}
		if (direction == Direction.WEST) {
			room.neighbors.put(Direction.EAST, this);
		}
		if (direction == Direction.NORTH) {
			room.neighbors.put(Direction.SOUTH, this);
		}
		if (direction == Direction.SOUTH) {
			room.neighbors.put(Direction.NORTH, this);
		}
	}
	
	/**
	 * Return the list of the possible actions of the room
	 * @return the list of the possible actions of the room
	 */
	public List<Action> getPossibleActions(){
		List<Action> possibleAct = new ArrayList<Action>();
		if (this.getListMonster().size()!=0){
			possibleAct.add(new Fight());
		}
		else{
			possibleAct.add(new Move());
		}
		if (this.getItems().size()!=0){
			possibleAct.add(new Use());
		}
		possibleAct.add(new Look());
		possibleAct.add(new Suicide());
		return possibleAct;
	}
	/**
	 * @return the items
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * displays informations for the room.
	 */
	public void displayInformations(){
		
		int nbItems = this.getItems().size();
		int nbMonsters = this.getListMonster().size();
		System.out.println("There are "+nbMonsters+" monsters and "+nbItems+" items.");
		for (Item i : this.items){
			i.display();
		}
		for (Monster m : this.monsters){
			m.display();
		}
		System.out.println("");
	}
	/**
	 * Return the size of the map
	 * @return the size of the map
	 */
	public int getNbOfDirections(){
		return this.neighbors.size();
	}
	/**
	 * Returns the map
	 * @return the map
	 */
	public Map<Direction, Room> getMap(){
		return this.neighbors;
	}
	/**
	 * Return the list of monsters
	 * @return the list of monsters
	 */
	public List<Monster> getListMonster(){
		return this.monsters;
	}
	
}

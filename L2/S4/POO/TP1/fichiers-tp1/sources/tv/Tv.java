/**
 * a small class for some manipulations
 * 
 * @author JC
 * @version 1.0
 */

public class Tv {

	// LES ATTRIBUTS = definition de l'etat de la classe

	/**
	 * state of this Tv, <t>true</t> if on, <t>false</t> else
	 */
	private boolean on;
	/**
	 * the current channel number
	 */
	private int channel;
	/**
	 * current sound level, between 0 and <code>maxSound</code>
	 */
	private int soundVolume;
	/** maximum possible sound level*/
	private int maxSound;

	// LE CONSTRUCTEUR : pour construire les instances

	/**
	 * Builds a Tv, initially it is off, ready for channel 5 and
	 * sound volume is 3 for a max level of 10.
	 */
	public Tv() {
		this.on = false;
		this.channel = 5;     // les valeurs numériques devraient
		this.soundVolume = 3; // définies dans des constantes
		this.maxSound = 10;
	}

	// LES METHODES : le comportement de la classe

	/**
	 * turn this tv on
	 */
	public void on() {
		this.on = true;
	}

	/**
	 * turn this tv off
	 */
	public void off() {
		this.on = false;
	}

	/**
	 * change current channel if this Tv is on
	 * 
	 * @param channelNum
	 *            the new current channel(>0)
	 */
	public void changeChannel(int channelNum) {
		if (this.on && channelNum > 0) {
			this.channel = channelNum;
		}
	}

	/**
	 * returns the current channel
	 * 
	 * @return the current channel
	 */
	public int currentChannel() {
		return this.channel;
	}

	/**
	 * increase sound level if on, sound level can not be greater than max level
	 */
	public void volumeUp() {
		if (this.on && this.soundVolume < this.maxSound) {
			this.soundVolume = this.soundVolume + 1; // ou this.soundVolume++
		}
	}

	/**
	 * increase sound level if tv is on, sound level can not be negative
	 */
	public void volumeDown() {
		if (this.on && this.soundVolume > 0) {
			this.soundVolume--; // equivaut a this.soundVolume =this.soundVolume - 1,
		}
	}

	
	/** provide a string representation for this Tv object
	 * @return  a string representation for this Tv object
	 */
	public String toString() {
	    String result = "tv";
	    if (this.on) {
			result = result + " is on, ";
		} else {
			result = result + " is off, ";
		}
		result = result + "channel : " + this.channel + " - sound volume : " + this.soundVolume;
		return result;
	}
	
	/**
	 * display this tv current information
	 */
	public void displayState() {
		System.out.print(this.toString());
	}
	
}

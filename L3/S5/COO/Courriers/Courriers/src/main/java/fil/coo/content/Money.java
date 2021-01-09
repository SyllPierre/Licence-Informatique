package fil.coo.content;

/**
 * @author SYLLEBRANQUE
 *
 */
public class Money implements Content {
	private float amount;

	/**
	 * Create a Money content with defined amount
	 * @param amount the amount
	 */
	public Money(float amount) {
		this.amount = amount;
	}

	/**
	 * Return the amount of this content
	 * @return amount the amount
	 */
	public float getAmount() {
		return this.amount;
	}

	@Override
	public String toString() {
		return "[" + amount + "€]";
	}	
}
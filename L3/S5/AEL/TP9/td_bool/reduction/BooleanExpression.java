package reduction;

public class BooleanExpression {
	protected String image;

	public String getImage() {
		return image;
	}

	public BooleanExpression(String image) {
		this.image = image;
	}

	public String toString() {
		return image;
	}

	/**
	 *
	 * @return right composition by AND
	 */
	public BooleanExpression rightAnd(BooleanExpression other) {
		return rightAndImpl(other, true);
	}

	public BooleanExpression rightAndImpl(BooleanExpression other, boolean swap) {
		if (swap) { return other.rightAndImpl(this, false); }
		return new BooleanExpression(other.image + " et " + image);
	}

	/**
	 *
	 * @return right composition by OR
	 */
	public BooleanExpression rightOr(BooleanExpression other) {
		return rightOrImpl(other, true);
	}

	public BooleanExpression rightOrImpl(BooleanExpression other, boolean swap) {
		if (swap) { return other.rightOrImpl(this, false); }
		return new BooleanExpression(other.image + " ou " + image);
	}

	/**
	 *
	 * @return negation of this expression
	 */
	public BooleanExpression not() {
		return new BooleanExpression("non " + image);
	}

	/**
	 *
	 * @return wrap expression with brackets
	 */
	public BooleanExpression wrap() {
		return new BooleanExpression("(" + image + ")");
	}
}

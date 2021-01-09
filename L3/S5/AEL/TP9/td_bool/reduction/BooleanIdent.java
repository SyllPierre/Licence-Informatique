package reduction;

public class BooleanIdent extends BooleanExpression {

	public BooleanIdent(String image) {
		super(image);
	}

	@Override
	public BooleanExpression rightAndImpl(BooleanExpression other, boolean swap) {
		if (other instanceof BooleanIdent) {
			if (((BooleanIdent) other).image.equals(this.image)) {
				return this;
			}
		}
		return super.rightAndImpl(other, swap);
	}

	@Override
	public BooleanExpression rightOrImpl(BooleanExpression other, boolean swap) {
		if (other instanceof BooleanIdent) {
			if (((BooleanIdent) other).image.equals(this.image)) {
				return this;
			}
		}
		return super.rightOrImpl(other, swap);
	}

	@Override
	public BooleanExpression wrap() {
		return this;
	}


}

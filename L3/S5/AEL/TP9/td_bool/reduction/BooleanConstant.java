package reduction;

public class BooleanConstant extends BooleanExpression{

	boolean value;

	public BooleanConstant(boolean value) {
		super(Boolean.toString(value));
		this.value = value;
	}

	@Override
	public BooleanExpression rightAndImpl(BooleanExpression other, boolean swap) {
		if (value) { return other; }
		return this;
	}

	@Override
	public BooleanExpression rightOrImpl(BooleanExpression other, boolean swap) {
		if (!value) { return other; }
		return this;
	}

	@Override
	public BooleanExpression not() {
		return new BooleanConstant(!value);
	}

	@Override
	public BooleanExpression wrap() {
		return this;
	}	
}

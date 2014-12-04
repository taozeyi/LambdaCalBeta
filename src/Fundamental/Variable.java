package Fundamental;

public class Variable extends Expression {

	public final String id;

	public Variable(String id) {
		this.id = id;
	}

	@Override
	public <X> X accept(Visitor<X> visitor) {

		return visitor.visit(this);
	}

	public boolean isVariable() {
		return true;
	}
}

package Fundamental;

public class Abstraction extends Expression {

	public final String id;
	public final Expression exp;

	public Abstraction(String id, Expression exp) {
		this.id = id;
		this.exp = exp;
	}

	@Override
	public <X> X accept(Visitor<X> visitor) {
		System.out.println(visitor.toString());
		return visitor.visit(this);
	}

	public boolean isAbstraction() {
		return true;
	}

}

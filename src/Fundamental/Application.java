package Fundamental;

public class Application extends Expression {

	public final Expression exp1;
	public final Expression exp2;

	public Application(Expression exp1, Expression exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	@Override
	public <X> X accept(Visitor<X> visitor) {
		return visitor.visit(this);
	}

	public boolean isApplication() {
		return true;
	}

}

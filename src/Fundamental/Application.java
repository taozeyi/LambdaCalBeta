package Fundamental;

public class Application implements Expression {

	public final Expression exp1;
	public final Expression exp2;

	public Application(Expression exp1, Expression exp2) {
		this.exp1 = exp1;
		this.exp2 = exp2;
	}

	public <X> X accept(Visitor<X> visitor) {
		return visitor.visit(this);
	}

	public boolean isApplication() {
		return true;
	}	

	@Override
	public boolean isVariable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAbstraction() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSingleFragment() {
		// TODO Auto-generated method stub
		return false;
	}
	public String toString(){
		return ASTtoString.toString(this);
		//return TempGenerator.Generator(this);
	}

}

package Fundamental;

public class Abstraction implements Expression {

	public final String id;
	public final Expression exp;

	public Abstraction(String id, Expression exp) {
		this.id = id;
		this.exp = exp;
	}

	public <X> X accept(Visitor<X> visitor) {

		return visitor.visit(this);
	}
	
	@Override
	public boolean isAbstraction() {
		return true;
	}

	@Override
	public boolean isVariable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isApplication() {
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

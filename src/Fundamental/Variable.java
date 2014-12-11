package Fundamental;

public class Variable implements Expression {

	public final String id;

	public Variable(String id) {
		this.id = id;
	}

	public <X> X accept(Visitor<X> visitor) {

		return visitor.visit(this);
	}
	
	@Override
	public boolean isVariable() {
		return true;
	}

	@Override
	public boolean isApplication() {
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

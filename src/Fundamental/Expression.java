package Fundamental;

public interface Expression {

	public boolean isVariable();

	public boolean isApplication();

	public boolean isAbstraction();

	public boolean isSingleFragment();

	public String toString();

	public abstract <X> X accept(Visitor<X> visitor);
	
	

}

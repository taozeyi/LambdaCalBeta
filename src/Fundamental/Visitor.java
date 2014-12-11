package Fundamental;

public interface Visitor<X> {
	public X visit(Abstraction abs);

	public X visit(Application app);

	public X visit(Variable l);
}



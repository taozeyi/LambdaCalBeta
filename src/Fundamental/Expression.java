package Fundamental;

public abstract class Expression {

	public static Expression parse(String text) {
		Parser parser = new Parser(new Lexer(text));
		return parser.parse();
	}

	public boolean isVariable() {
		return false;
	}

	public boolean isApplication() {
		return false;
	}

	public boolean isAbstraction() {
		return false;
	}

	public boolean isSingleFragment() {
		return isVariable();
	}

	public String toString() {
		//return ASTtoString.toString(this);
		return TempGenerator.Generator(this);
	}

	public abstract <X> X accept(Visitor<X> visitor);

	public static interface Visitor<X> {
		public X visit(Abstraction abs);

		public X visit(Application app);

		public X visit(Variable l);
	}
}

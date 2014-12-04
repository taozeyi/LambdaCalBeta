package Fundamental;

public class ASTtoString implements Expression.Visitor<Expression> {

	private char LAMBDA= '\\';
	private StringBuilder buf = new StringBuilder();

	public static String toString(Expression lambda) {
		ASTtoString printer = new ASTtoString();
		lambda.accept(printer);
		return printer.buf.toString();
	}

	public String makeString(Expression lambda) {
		lambda.accept(this);
		return buf.toString();
	}

	public Expression visit(Abstraction abs) {
		Expression e = abs;
		buf.append(LAMBDA);
		while (e.isAbstraction()) {
			Abstraction eAbs = (Abstraction) e;
			buf.append(eAbs.id);
			e = eAbs.exp;
		}
		buf.append('.');
		e.accept(this);
		return abs;
	}

	public Expression visit(Application app) {
		
		Expression l = app.exp1;
		Expression r = app.exp2;
		boolean lpar = l.isAbstraction();
		boolean rpar = !r.isAtomic();

		if (lpar)
			buf.append('(');
		l.accept(this);
		if (lpar)
			buf.append(')');

		if (rpar)
			buf.append('(');
		r.accept(this);
		if (rpar)
			buf.append(')');
		return app;
	}

	public Expression visit(Variable var) {
		buf.append(var.id);
		return var;
	}

}

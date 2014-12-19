package Fundamental;
//This class is just for supporting purpose
public class TempGenerator implements Visitor<Expression> {

	private StringBuilder buf = new StringBuilder();

	public static String Generator(Expression exp) {
		TempGenerator gen = new TempGenerator();
		exp.accept(gen);
		return gen.buf.toString();
	}

	public Expression visit(Abstraction abs) {
		Expression exp = abs;

		if (exp.isAbstraction()) {

			Abstraction eAbs = (Abstraction) exp;

			buf.append("new Abstraction(" + eAbs.id + ",");

			exp = eAbs.exp;

		}
		exp.accept(this);

		buf.append(")");

		return abs;
	}

	public Expression visit(Application app) {

		buf.append("new Application(");

		Expression l = app.exp1;
		Expression r = app.exp2;

		l.accept(this);

		buf.append(",");

		r.accept(this);

		buf.append(')');

		return app;
	}

	public Expression visit(Variable var) {

		buf.append("new Variable(" + var.id + ")");

		return var;
	}
}

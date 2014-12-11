package Fundamental;

import java.util.ArrayList;

public class ASTtoString implements Visitor<Expression> {
    //private ArrayList<String> list;
	private char LAMBDA = '\\';
	private StringBuilder buf = new StringBuilder();
	

	public static String toString(Expression lambda) {
		ASTtoString printer = new ASTtoString();
		lambda.accept(printer);
		return printer.buf.toString();
	}

	public Expression visit(Abstraction abs) {
		
		Expression exp = abs;
		buf.append(LAMBDA);
		if (exp.isAbstraction()) {
			Abstraction eAbs = (Abstraction) exp;
			buf.append(eAbs.id);
			exp = eAbs.exp;
		}

		buf.append('.');

		exp.accept(this);
		
		return abs;
	}

	public Expression visit(Application app) {
		buf.append("(");
		Expression l = app.exp1;
		Expression r = app.exp2;
		boolean lpar = l.isAbstraction();
		boolean rpar = !r.isSingleFragment();

		if (lpar){
			//buf.append('(');
			}

		l.accept(this);

		if (lpar){
			//buf.append(')');
			}
		if (rpar){
			//buf.append('(');
			}
		
		r.accept(this);
		
		if (rpar){
			//buf.append(')');
			}
		buf.append(')');
		//list.add("app");
		return app;
	}

	public Expression visit(Variable var) {
		buf.append(var.id);
		//list.add("var");
		return var;
	}

}

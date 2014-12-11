package Fundamental;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Writer {
	public String s;

	public Writer(String s) {
		this.s = s;
	};

	public void outPut() throws FileNotFoundException {

		File newfile = new File("test.java");

		PrintWriter pw = new PrintWriter(newfile);
		pw.println("public class sample {");
		pw.println("public interface Expression { public Lambda app(Expression exp); public String toString();}}");
		int c = 0;

		Parser parser0 = new Parser(new Lexer(s));

		Expression exp0 = parser0.parse();

		while (exp0.isAbstraction()) {
			Abstraction abs = (Abstraction) exp0;
			String body =abs.exp.toString();
			//String original = exp0.toString();
			//String sub = original.substring(3, original.length());
			Parser parser = new Parser(new Lexer(body));
			exp0 = parser.parse();

			if (c == 0) {
				Abstraction abss = (Abstraction) exp0;
				pw.println("public static class Lam0 implements Expression {");
				pw.println("public Lam0() {};");
				pw.println("public String toString() {");
				pw.println("return '(\\ " + abs.id + ". ' + (new Lam" + (c + 1)
						+ "('" + abss.id + "', null)).toString() + ')';}");

			} else {
				if (exp0.isAbstraction()) {
					Abstraction abss = (Abstraction) exp0;
					pw.println("public static class Lam"
							+ c
							+ " implements Expression { protected String s_str;protected Expression s;");
					pw.println("public Lam"
							+ c
							+ "(String s_str, Expression s) { this.s_str = s_str;this.s = s;}");
					pw.println("public String toString() {");
					pw.println("return '(\\ y. ' +(new lam" + (c + 1) + "('"
							+ abss.id + "', e)).toString();+')'}}");
				} else {
					Application abss = (Application) exp0;
					String s = abss.toString();
					pw.println("public static class Lam"
							+ c
							+ " implements Expression { protected String s_str;protected Expression s;");
					pw.println("public Lam"
							+ c
							+ "(String s_str, Expression s) { this.s_str = s_str;this.s = s;}");
					pw.println("public String toString() {");
					pw.println("if (s == null) return '\\ " + abs.id + "." + s
							+ ";");
					pw.println("else return '\\" + abs.id + ". (' + " + "x"
							+ ".toString() + ' (' + " + "y"
							+ ".toString() + ' " + "z" + "))';}}");

				}

			}
			exp0.isAbstraction();
			c++;
		}
		pw.println("}");
		pw.close();
	}

	public static void main(String[] args) throws FileNotFoundException {
		Writer w = new Writer("\\x.\\y.\\z.xyz");
		w.outPut();
	}
}

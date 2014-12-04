package Fundamental;

public class Parser {

	private Lexer lexer;
	private Token token;

	public Parser(Lexer lexer) {
		this.lexer = lexer;
	}

	public Expression parse() {
		token = lexer.TokenScanner();
		return this.parseLambda();
	}
    //recursive parsing
	private Expression parseLambda() {

		if (token.type == TokenType.LAMBDA) {
			next();
			if (token.type == TokenType.VAR) {
				String id = token.id;
				next();
				if (token.type == TokenType.DOT) {
					next();
					return new Abstraction(id, parseLambda());
				}
			}
		}
		return parseApplication();
	}

	private Expression parseApplication() {

		Expression exp = parseSingleToken();

		TokenType t = token.type;

		if (t != TokenType.LAMBDA) {

			while (t == TokenType.VAR || t == TokenType.LEFTP) {

				exp = new Application(exp, parseSingleToken());
				t = token.type;

			}

			return exp;
		}

		return new Application(exp, parseLambda());

	}

	private Expression parseSingleToken() {

		if (token.type == TokenType.VAR) {

			String id = token.id;
			next();

			return new Variable(id);

		} else if (token.type == TokenType.LEFTP) {
			next();

			Expression exp = parseLambda();

			if (token.type == TokenType.RIGHTP) {

				next();

			}

			return exp;
		}

		return null;
	}

	private void next() {

		token = lexer.TokenScanner();

	}

	public static void main(String[] args) {

		Expression exp1 = new Abstraction("x", new Variable("x"));
		System.out.println("parsed new1: " + exp1.toString());

		Expression exp2 = new Application(new Abstraction("x",
				new Variable("x")), new Variable("x"));
		System.out.println("parsed new2: " + exp2.toString());

		Parser parser0 = new Parser(new Lexer("(\\x.x)(\\y.y(mn))"));
		Expression exp0 = parser0.parse();
		System.out.println("parsed 1: " + exp0);

		Parser parser = new Parser(new Lexer("\\x.x"));
		Expression exp = parser.parse();
		System.out.println("parsed 2: " + exp);

		Parser parser3 = new Parser(new Lexer("x\\y.y"));
		Expression exp3 = parser3.parse();
		System.out.println("parsed 3 : " + exp3);

		Parser parser4 = new Parser(new Lexer("xxxx"));
		Expression exp4 = parser4.parse();
		System.out.println("parsed 4 : " + exp4);

		Parser parser5 = new Parser(new Lexer("(((xx)x)x)"));
		Expression exp5 = parser5.parse();
		System.out.println("parsed 5 : " + exp5);

		Parser parser6 = new Parser(new Lexer("(\\x.x)y"));
		Expression exp6 = parser6.parse();
		System.out.println("parsed 5 : " + exp6);
		System.out.println("parser6 type is: " + exp6.isAbstraction());

		Parser parser7 = new Parser(new Lexer("\\x.(xy)"));
		Expression exp7 = parser7.parse();
		System.out.println("parsed 7 : " + exp7);
		System.out.println("parser7 type is: " + exp7.isAbstraction());
		//System.out.println("parser7 type is: " + parser7);
		
	}

}

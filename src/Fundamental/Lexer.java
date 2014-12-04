package Fundamental;

public class Lexer {

	private char[] charSequence;
	private int position;

	public Lexer(String input) {

		charSequence = input.toCharArray();
		position = 0;

	}

	public Token TokenScanner() {

		if (position < charSequence.length) {

			char currentChar = charSequence[position];

			if ('a' <= currentChar && currentChar <= 'z') {
				position++;
				return new Token(Character.toString(currentChar), TokenType.VAR);

			} else {
				position++;
				switch (currentChar) {
				case '\\':
					return new Token("\\", TokenType.LAMBDA);
				case '.':
					return new Token(".", TokenType.DOT);
				case '(':
					return new Token("(", TokenType.LEFTP);
				case ')':
					return new Token(")", TokenType.RIGHTP);
				}

			}
		} else {
			return new Token("HALT", TokenType.END);
		}
		return null;
	}

}

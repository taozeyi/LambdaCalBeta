package Fundamental;

import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {

	@Test
	public void test0() {
		Parser parser0 = new Parser(new Lexer("x"));
		Expression exp0 = parser0.parse();
		assertEquals(exp0.isVariable(),true);
	}
	@Test
	public void test1() {
		Parser parser0 = new Parser(new Lexer("\\x.x"));
		Expression exp0 = parser0.parse();
		assertEquals(exp0.isAbstraction(),true);
	}
	@Test
	public void test2() {
		Parser parser0 = new Parser(new Lexer("xx"));
		Expression exp0 = parser0.parse();
		assertEquals(exp0.isApplication(),true);
	}

}

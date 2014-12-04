package File;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import Fundamental.Application;
import Fundamental.Expression;
import Fundamental.Lexer;
import Fundamental.Parser;

public class Writing {
	
	public Writing(){
	
	BufferedWriter writer = null;
    try {
		writer = new BufferedWriter( new FileWriter("test.java"));
		writer.write("woqunimalegebi");
		writer.newLine();
		writer.write("public abstract class Expression {public Expression app(Expression exp){return new Application(exp,exp);}");
		writer.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

}



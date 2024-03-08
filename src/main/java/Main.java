package main.java;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import main.antlr.*;
public class Main  {
    //create a new instance of the lexer, and parser with a test string and print the parse tree
    public static void main(String[] args) throws Exception {
        ExprLexer lexer = new ExprLexer((CharStream) CharStreams.fromString("3+4*5"));
        CommonTokenStream tokens = new CommonTokenStream((TokenSource) lexer);
        ExprParser parser = new ExprParser((TokenStream) tokens);
        ParseTree tree = parser.expr();
        System.out.println(tree.toStringTree(parser));
    }

}

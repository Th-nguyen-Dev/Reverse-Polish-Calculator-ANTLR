//Add the lexer and parser as import
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import gen.ExprLexer;


public class main {
    //create a new instance of the lexer, and parser with a test string and print the parse tree
    public static void main(String[] args) throws Exception {
        ExprLexer lexer = new ExprLexer(CharStreams.fromString("3+4*5"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);
        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }

}

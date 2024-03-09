package logic;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import antlr.*;
public class Main  {
    //create a new instance of the lexer, and parser with a test string and print the parse tree
    public static void main(String[] args) throws Exception {
        ExprLexer lexer = new ExprLexer((CharStream) CharStreams.fromString("((sin(4**2)+cos(log(6)))/7)+log(tanh(ln(pi)))"));
        CommonTokenStream tokens = new CommonTokenStream((TokenSource) lexer);
        ExprParser parser = new ExprParser((TokenStream) tokens);
        ParseTree tree = parser.expr_as();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        eval.visit(tree);
    }

}

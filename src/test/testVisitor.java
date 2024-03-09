import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Stack;
import logic.*;
import antlr.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class testVisitor {

    boolean compareStacks(Stack<Atom> s1, Stack<Atom> s2) {
        if (s1.size() != s2.size()) {
            System.out.println("size: " + s1.size() + " " + s2.size());

        }
        while (!s1.isEmpty()) {
            Atom a1 = s1.pop();
            Atom a2 = s2.pop();
            System.out.println("isNumber: " + a1.getIsNumber() + " " + a2.getIsNumber());
            System.out.println("function: " + a1.getFunction() + " " + a2.getFunction());
            System.out.println("number: " + a1.getNumber() + " " + a2.getNumber());
            if (a1.getIsNumber() != a2.getIsNumber()) {

                return false;
            }
            //test for the same function
            if (a1.getFunction() != a2.getFunction()){

                return false;
            }
            if (a1.getNumber() != a2.getNumber()) {

                return false;
            }
            System.out.println();
        }
        return true;
    }

    ExprParser Initializer(String input) {
        ExprLexer lexer = new ExprLexer((CharStream) CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream((TokenSource) lexer);
        return new ExprParser((TokenStream) tokens);
    }

    @Test
    void testExprAsPlus() {
        ExprParser parser = Initializer("2+3");
        ParseTree tree = parser.prog();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        Stack<Atom> result = new Stack<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        assertEquals(compareStacks(eval.visit(tree), result), true);
    }
    @Test
    void testExprAsMinus() {
        ExprParser parser = Initializer("2-3");
        ParseTree tree = parser.prog();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        Stack<Atom> result = new Stack<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(eval.visit(tree), result), true);
    }

    @Test
    void testExprAsMinusPlus() {
        ExprParser parser = Initializer("2-3+4");
        ParseTree tree = parser.prog();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        Stack<Atom> result = new Stack<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        assertEquals(compareStacks(eval.visit(tree), result), true);
    }

    @Test
    void testExprAsPlusMinus() {
        ExprParser parser = Initializer("2+3-4");
        ParseTree tree = parser.prog();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        Stack<Atom> result = new Stack<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(eval.visit(tree), result), true);
    }
    @Test
    void testExprAsMinueNeg() {
        ExprParser parser = Initializer("2+3--4");
        ParseTree tree = parser.prog();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        Stack<Atom> result = new Stack<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        result.add(new Atom(true, -4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(eval.visit(tree), result), true);
    }
}

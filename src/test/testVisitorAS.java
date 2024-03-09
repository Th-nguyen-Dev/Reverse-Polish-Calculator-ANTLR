import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import logic.*;
import antlr.*;
import java.util.ArrayDeque;
import java.util.Queue;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

public class testVisitorAS {

    boolean compareStacks(Queue<Atom> s1, Queue<Atom> s2) {
        if (s1.size() != s2.size()) {
            System.out.println("size: " + s1.size() + " " + s2.size());

        }
        while (!s1.isEmpty()) {
            Atom a1 = s1.poll();
            Atom a2 = s2.poll();
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
        Queue<Atom> result = new ArrayDeque<Atom>();
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
        Queue<Atom> result = new ArrayDeque<Atom>();
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
        Queue<Atom> result = new ArrayDeque<Atom>();
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
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(eval.visit(tree), result), true);
    }
    @Test
    void testExprAsMinusNeg() {
        ExprParser parser = Initializer("2--4");
        ParseTree tree = parser.prog();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(eval.visit(tree), result), true);
    }
    void testExprAsNegMinus() {
        ExprParser parser = Initializer("--4-2");
        ParseTree tree = parser.prog();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(eval.visit(tree), result), true);
    }

    @Test
    void testExprAsMinusNegExtream() {
        ExprParser parser = Initializer("2--40000000000001");
        ParseTree tree = parser.prog();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 40000000000001L, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(eval.visit(tree), result), true);
    }
    void testExprAsNegMinusExtream() {
        ExprParser parser = Initializer("--40000000000001-2");
        ParseTree tree = parser.prog();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 40000000000001L, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(eval.visit(tree), result), true);
    }
}

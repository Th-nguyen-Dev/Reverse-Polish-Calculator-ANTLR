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
        boolean isSame = true;
        if (s1.size() != s2.size()) {
            System.out.println("size: " + s1.size() + " " + s2.size());
            isSame = false;
        }
        while (!s1.isEmpty()) {
            Atom a1 = s1.poll();
            Atom a2 = s2.poll();
            if (a2 == null) {
                a2 = new Atom(false, 0, Atom.Function.DEFAULT);
            }
            System.out.println("isNumber: " + a1.getIsNumber() + " " + a2.getIsNumber());
            System.out.println("function: " + a1.getFunction() + " " + a2.getFunction());
            System.out.println("number: " + a1.getNumber() + " " + a2.getNumber());
            if (a1.getIsNumber() != a2.getIsNumber()) {
                isSame = false;
            }
            if (a1.getFunction() != a2.getFunction()) {
                isSame = false;
            }
            if (a1.getNumber() != a2.getNumber()) {
                isSame = false;

            }
            System.out.println();
        }
        return isSame;
    }

    ExprParser Initializer(String input) {
        ExprLexer lexer = new ExprLexer((CharStream) CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream((TokenSource) lexer);
        return new ExprParser((TokenStream) tokens);
    }
    Queue<Atom> testExpr(String input) {
        ExprParser parser = Initializer(input);
        System.out.println(input);
        ParseTree tree = parser.prog();
        ExprPostOrderVisitor eval = new ExprPostOrderVisitor();
        return eval.visit(tree);
    }

    @Test
    void testExprAsPlus() {
        String input = "2+3";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        assertEquals(compareStacks(test, result), true);
    }
    @Test
    void testExprAsMinus() {
        String input = "2-3";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(test, result), true);
    }

    @Test
    void testExprAsMinusPlus() {
        String input = "2-3+4";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        assertEquals(compareStacks(test, result), true);
    }

    @Test
    void testExprAsPlusMinus() {
        String input = "2+3-4";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 3, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.PLUS));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(test, result), true);
    }
    @Test
    void testExprAsMinusNeg() {
        String input = "2--4";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(test, result), true);
    }
    void testExprAsNegMinus() {
        String input = "-4-2";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 4, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(test, result), true);
    }

    @Test
    void testExprAsMinusNegExtream() {
        String input = "2--40000000000001";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(true, 40000000000001L, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(test, result), true);
    }
    void testExprAsNegMinusExtream() {
        String input = "--40000000000001-2";
        Queue<Atom> test = testExpr(input);
        Queue<Atom> result = new ArrayDeque<Atom>();
        result.add(new Atom(true, 40000000000001L, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(false, 0, Atom.Function.NEG));
        result.add(new Atom(true, 2, Atom.Function.DEFAULT));
        result.add(new Atom(false, 0, Atom.Function.MINUS));
        assertEquals(compareStacks(test, result), true);
    }
}

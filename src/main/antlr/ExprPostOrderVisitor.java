// Generated from Expr.g4 by ANTLR 4.13.1

package antlr;

import logic.*;

import java.util.ArrayDeque;
import java.util.Queue;
import java.math.BigDecimal;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;

/**
 * This class provides an empty implementation of {@link ExprVisitor},
 * which can be extended to create a visitor which only needs to handle a subset
 * of the available methods.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
@SuppressWarnings("CheckReturnValue")
public class ExprPostOrderVisitor extends AbstractParseTreeVisitor<Queue<Atom>> implements ExprVisitor<Queue<Atom>> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Queue<Atom> visitProg(ExprParser.ProgContext ctx) {
		visitChildren(ctx);
		return operations;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Queue<Atom> visitExpr_as(ExprParser.Expr_asContext ctx) {
		visitChildren(ctx);
		if (ctx.getChildCount() > 1) {
			if (ctx.getChild(1).getText().equals("+")) {
				operations.add(new Atom(false, 0, Atom.Function.PLUS));
			} else if (ctx.getChild(1).getText().equals("-")) {
				operations.add(new Atom(false, 0, Atom.Function.MINUS));
			}
		}
		return null;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Queue<Atom> visitExpr_md(ExprParser.Expr_mdContext ctx) {
		visitChildren(ctx);
		if (ctx.getChildCount() > 1) {
			if (ctx.getChild(1).getText().equals("*")) {
				operations.add(new Atom(false, 0, Atom.Function.MULTIPLY));
			} else if (ctx.getChild(1).getText().equals("/")) {
				operations.add(new Atom(false, 0, Atom.Function.DIVIDE));
			}
		}
		return null;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Queue<Atom> visitExpr_pw(ExprParser.Expr_pwContext ctx) {
		visitChildren(ctx);
		if (ctx.getChildCount() > 1) {
				operations.add(new Atom(false, 0, Atom.Function.POWER));
		}
		return null;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Queue<Atom> visitExpr_func(ExprParser.Expr_funcContext ctx) {
		visitChildren(ctx);
		if (ctx.getChildCount() > 1) {
			String func = ctx.getChild(0).getText();
			String factorial_func = ctx.getChild(1).getText();
			switch (func) {
				case "sin":
					operations.add(new Atom(false, 0, Atom.Function.SIN));
					break;
				case "cos":
					operations.add(new Atom(false, 0, Atom.Function.COS));
					break;
				case "tan":
					operations.add(new Atom(false, 0, Atom.Function.TAN));
					break;
				case "log":
					operations.add(new Atom(false, 0, Atom.Function.LOG));
					break;
				case "ln":
					operations.add(new Atom(false, 0, Atom.Function.LN));
					break;
				case "tanh":
					operations.add(new Atom(false, 0, Atom.Function.TANH));
					break;
				case "cosh":
					operations.add(new Atom(false, 0, Atom.Function.COSH));
					break;
				case "sinh":
					operations.add(new Atom(false, 0, Atom.Function.SINH));
					break;
			}
			if (factorial_func.equals("!")) {
				operations.add(new Atom(false, 0, Atom.Function.FACTORIAL));
			}
		}
		return null;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Queue<Atom> visitExpr_paren(ExprParser.Expr_parenContext ctx) {
		visitChildren(ctx);
		if (ctx.getChildCount() == 2) {
			operations.add(new Atom(false, 0, Atom.Function.NEG));
		}
		else if (ctx.getChildCount() == 1) {
			operations.add(new Atom(true, Double.parseDouble(ctx.getChild(0).getText()), Atom.Function.DEFAULT));
		}
		return null;
	}
	private Queue<Atom> operations = new ArrayDeque<Atom>();
}
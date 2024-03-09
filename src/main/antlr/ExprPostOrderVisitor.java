// Generated from Expr.g4 by ANTLR 4.13.1

package antlr;

import logic.*;
import java.util.Stack;
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
public class ExprPostOrderVisitor extends AbstractParseTreeVisitor<Stack<Atom>> implements ExprVisitor<Stack<Atom>> {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Stack<Atom> visitProg(ExprParser.ProgContext ctx) {
		visitChildren(ctx);
		return operations;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Stack<Atom> visitExpr_as(ExprParser.Expr_asContext ctx) {
		visitChildren(ctx);
		if (ctx.getChildCount() > 1) {
			if (ctx.getChild(1).getText().equals("+")) {
				operations.push(new Atom(false, 0, Atom.Function.PLUS));
			} else if (ctx.getChild(1).getText().equals("-")) {
				operations.push(new Atom(false, 0, Atom.Function.MINUS));
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
	@Override public Stack<Atom> visitExpr_md(ExprParser.Expr_mdContext ctx) {
		visitChildren(ctx);
		System.out.println("Expr_md: " + ctx.getText());
		return null;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Stack<Atom> visitExpr_pw(ExprParser.Expr_pwContext ctx) {
		visitChildren(ctx);
		System.out.println("Expr_pw: " + ctx.getText());
		return null;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Stack<Atom> visitExpr_func(ExprParser.Expr_funcContext ctx) {
		visitChildren(ctx);
		System.out.println("Expr_func: " + ctx.getText());
		return null;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Stack<Atom> visitExpr_paren(ExprParser.Expr_parenContext ctx) {
		visitChildren(ctx);
		if (ctx.getChildCount() == 2) {
			operations.push(new Atom(true, -1.0*Double.parseDouble(ctx.getChild(1).getText()), Atom.Function.DEFAULT));
		}
		if (ctx.getChildCount() == 1) {
			operations.push(new Atom(true, Double.parseDouble(ctx.getChild(0).getText()), Atom.Function.DEFAULT));
		}
		return null;
	}
	private Stack<Atom> operations = new Stack<Atom>();
}
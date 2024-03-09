// Generated from Expr.g4 by ANTLR 4.13.1

    package antlr;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExprParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ExprParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr_as}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_as(ExprParser.Expr_asContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr_md}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_md(ExprParser.Expr_mdContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr_pw}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_pw(ExprParser.Expr_pwContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr_func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_func(ExprParser.Expr_funcContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExprParser#expr_paren}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_paren(ExprParser.Expr_parenContext ctx);
}
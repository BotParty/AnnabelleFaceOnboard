// Generated from C:/dev/repo/git/botparty/face/app/src/main\Bellechat.g4 by ANTLR 4.6
package org.botparty.annabelle.parser.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BellechatParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BellechatVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BellechatParser#chat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChat(BellechatParser.ChatContext ctx);
	/**
	 * Visit a parse tree produced by {@link BellechatParser#item}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitItem(BellechatParser.ItemContext ctx);
	/**
	 * Visit a parse tree produced by {@link BellechatParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(BellechatParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BellechatParser#parm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParm(BellechatParser.ParmContext ctx);
	/**
	 * Visit a parse tree produced by {@link BellechatParser#nullary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullary(BellechatParser.NullaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link BellechatParser#unary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary(BellechatParser.UnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link BellechatParser#binary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinary(BellechatParser.BinaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link BellechatParser#ternary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernary(BellechatParser.TernaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link BellechatParser#textblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextblock(BellechatParser.TextblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BellechatParser#phoneme}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPhoneme(BellechatParser.PhonemeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BellechatParser#ignored}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnored(BellechatParser.IgnoredContext ctx);
}
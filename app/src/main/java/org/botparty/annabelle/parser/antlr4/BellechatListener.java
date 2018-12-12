// Generated from C:/dev/repo/git/botparty/face/app/src/main\Bellechat.g4 by ANTLR 4.6
package org.botparty.annabelle.parser.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BellechatParser}.
 */
public interface BellechatListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BellechatParser#chat}.
	 * @param ctx the parse tree
	 */
	void enterChat(BellechatParser.ChatContext ctx);
	/**
	 * Exit a parse tree produced by {@link BellechatParser#chat}.
	 * @param ctx the parse tree
	 */
	void exitChat(BellechatParser.ChatContext ctx);
	/**
	 * Enter a parse tree produced by {@link BellechatParser#item}.
	 * @param ctx the parse tree
	 */
	void enterItem(BellechatParser.ItemContext ctx);
	/**
	 * Exit a parse tree produced by {@link BellechatParser#item}.
	 * @param ctx the parse tree
	 */
	void exitItem(BellechatParser.ItemContext ctx);
	/**
	 * Enter a parse tree produced by {@link BellechatParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(BellechatParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BellechatParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(BellechatParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BellechatParser#parm}.
	 * @param ctx the parse tree
	 */
	void enterParm(BellechatParser.ParmContext ctx);
	/**
	 * Exit a parse tree produced by {@link BellechatParser#parm}.
	 * @param ctx the parse tree
	 */
	void exitParm(BellechatParser.ParmContext ctx);
	/**
	 * Enter a parse tree produced by {@link BellechatParser#nullary}.
	 * @param ctx the parse tree
	 */
	void enterNullary(BellechatParser.NullaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BellechatParser#nullary}.
	 * @param ctx the parse tree
	 */
	void exitNullary(BellechatParser.NullaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BellechatParser#unary}.
	 * @param ctx the parse tree
	 */
	void enterUnary(BellechatParser.UnaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BellechatParser#unary}.
	 * @param ctx the parse tree
	 */
	void exitUnary(BellechatParser.UnaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BellechatParser#binary}.
	 * @param ctx the parse tree
	 */
	void enterBinary(BellechatParser.BinaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BellechatParser#binary}.
	 * @param ctx the parse tree
	 */
	void exitBinary(BellechatParser.BinaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BellechatParser#ternary}.
	 * @param ctx the parse tree
	 */
	void enterTernary(BellechatParser.TernaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BellechatParser#ternary}.
	 * @param ctx the parse tree
	 */
	void exitTernary(BellechatParser.TernaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BellechatParser#textblock}.
	 * @param ctx the parse tree
	 */
	void enterTextblock(BellechatParser.TextblockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BellechatParser#textblock}.
	 * @param ctx the parse tree
	 */
	void exitTextblock(BellechatParser.TextblockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BellechatParser#phoneme}.
	 * @param ctx the parse tree
	 */
	void enterPhoneme(BellechatParser.PhonemeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BellechatParser#phoneme}.
	 * @param ctx the parse tree
	 */
	void exitPhoneme(BellechatParser.PhonemeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BellechatParser#ignored}.
	 * @param ctx the parse tree
	 */
	void enterIgnored(BellechatParser.IgnoredContext ctx);
	/**
	 * Exit a parse tree produced by {@link BellechatParser#ignored}.
	 * @param ctx the parse tree
	 */
	void exitIgnored(BellechatParser.IgnoredContext ctx);
}
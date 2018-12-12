// Generated from C:/dev/repo/git/botparty/face/app/src/main\Bellechat.g4 by ANTLR 4.6
package org.botparty.annabelle.parser.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class BellechatParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		NULLCMD=1, UNCMD=2, BINCMD=3, TERNCMD=4, QUOTED=5, CMDPFX=6, STRING=7, 
		ALPHANUM=8, WS=9, UNKNOWN=10;
	public static final int
		RULE_chat = 0, RULE_item = 1, RULE_expr = 2, RULE_parm = 3, RULE_nullary = 4, 
		RULE_unary = 5, RULE_binary = 6, RULE_ternary = 7, RULE_textblock = 8, 
		RULE_phoneme = 9, RULE_ignored = 10;
	public static final String[] ruleNames = {
		"chat", "item", "expr", "parm", "nullary", "unary", "binary", "ternary", 
		"textblock", "phoneme", "ignored"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, null, "'\\'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "NULLCMD", "UNCMD", "BINCMD", "TERNCMD", "QUOTED", "CMDPFX", "STRING", 
		"ALPHANUM", "WS", "UNKNOWN"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Bellechat.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public BellechatParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ChatContext extends ParserRuleContext {
		public List<ItemContext> item() {
			return getRuleContexts(ItemContext.class);
		}
		public ItemContext item(int i) {
			return getRuleContext(ItemContext.class,i);
		}
		public ChatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).enterChat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).exitChat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BellechatVisitor ) return ((BellechatVisitor<? extends T>)visitor).visitChat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ChatContext chat() throws RecognitionException {
		ChatContext _localctx = new ChatContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_chat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NULLCMD) | (1L << UNCMD) | (1L << BINCMD) | (1L << TERNCMD) | (1L << STRING))) != 0)) {
				{
				{
				setState(22);
				item();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ItemContext extends ParserRuleContext {
		public TextblockContext textblock() {
			return getRuleContext(TextblockContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).enterItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).exitItem(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BellechatVisitor ) return ((BellechatVisitor<? extends T>)visitor).visitItem(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ItemContext item() throws RecognitionException {
		ItemContext _localctx = new ItemContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_item);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(30);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(28);
				textblock();
				}
				break;
			case NULLCMD:
			case UNCMD:
			case BINCMD:
			case TERNCMD:
				{
				setState(29);
				expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public NullaryContext nullary() {
			return getRuleContext(NullaryContext.class,0);
		}
		public UnaryContext unary() {
			return getRuleContext(UnaryContext.class,0);
		}
		public BinaryContext binary() {
			return getRuleContext(BinaryContext.class,0);
		}
		public TernaryContext ternary() {
			return getRuleContext(TernaryContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BellechatVisitor ) return ((BellechatVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NULLCMD:
				{
				setState(32);
				nullary();
				}
				break;
			case UNCMD:
				{
				setState(33);
				unary();
				}
				break;
			case BINCMD:
				{
				setState(34);
				binary();
				}
				break;
			case TERNCMD:
				{
				setState(35);
				ternary();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParmContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(BellechatParser.STRING, 0); }
		public TerminalNode QUOTED() { return getToken(BellechatParser.QUOTED, 0); }
		public ParmContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).enterParm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).exitParm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BellechatVisitor ) return ((BellechatVisitor<? extends T>)visitor).visitParm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParmContext parm() throws RecognitionException {
		ParmContext _localctx = new ParmContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_parm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_la = _input.LA(1);
			if ( !(_la==QUOTED || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullaryContext extends ParserRuleContext {
		public TerminalNode NULLCMD() { return getToken(BellechatParser.NULLCMD, 0); }
		public NullaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).enterNullary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).exitNullary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BellechatVisitor ) return ((BellechatVisitor<? extends T>)visitor).visitNullary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullaryContext nullary() throws RecognitionException {
		NullaryContext _localctx = new NullaryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_nullary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(NULLCMD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnaryContext extends ParserRuleContext {
		public TerminalNode UNCMD() { return getToken(BellechatParser.UNCMD, 0); }
		public ParmContext parm() {
			return getRuleContext(ParmContext.class,0);
		}
		public UnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).enterUnary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).exitUnary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BellechatVisitor ) return ((BellechatVisitor<? extends T>)visitor).visitUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryContext unary() throws RecognitionException {
		UnaryContext _localctx = new UnaryContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_unary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(UNCMD);
			setState(43);
			parm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BinaryContext extends ParserRuleContext {
		public TerminalNode BINCMD() { return getToken(BellechatParser.BINCMD, 0); }
		public List<ParmContext> parm() {
			return getRuleContexts(ParmContext.class);
		}
		public ParmContext parm(int i) {
			return getRuleContext(ParmContext.class,i);
		}
		public BinaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).enterBinary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).exitBinary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BellechatVisitor ) return ((BellechatVisitor<? extends T>)visitor).visitBinary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BinaryContext binary() throws RecognitionException {
		BinaryContext _localctx = new BinaryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_binary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(BINCMD);
			setState(46);
			parm();
			setState(47);
			parm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TernaryContext extends ParserRuleContext {
		public TerminalNode TERNCMD() { return getToken(BellechatParser.TERNCMD, 0); }
		public List<ParmContext> parm() {
			return getRuleContexts(ParmContext.class);
		}
		public ParmContext parm(int i) {
			return getRuleContext(ParmContext.class,i);
		}
		public TernaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ternary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).enterTernary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).exitTernary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BellechatVisitor ) return ((BellechatVisitor<? extends T>)visitor).visitTernary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TernaryContext ternary() throws RecognitionException {
		TernaryContext _localctx = new TernaryContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_ternary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(TERNCMD);
			setState(50);
			parm();
			setState(51);
			parm();
			setState(52);
			parm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TextblockContext extends ParserRuleContext {
		public List<PhonemeContext> phoneme() {
			return getRuleContexts(PhonemeContext.class);
		}
		public PhonemeContext phoneme(int i) {
			return getRuleContext(PhonemeContext.class,i);
		}
		public TextblockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_textblock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).enterTextblock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).exitTextblock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BellechatVisitor ) return ((BellechatVisitor<? extends T>)visitor).visitTextblock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TextblockContext textblock() throws RecognitionException {
		TextblockContext _localctx = new TextblockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_textblock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(55); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(54);
					phoneme();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(57); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PhonemeContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(BellechatParser.STRING, 0); }
		public PhonemeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phoneme; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).enterPhoneme(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).exitPhoneme(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BellechatVisitor ) return ((BellechatVisitor<? extends T>)visitor).visitPhoneme(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PhonemeContext phoneme() throws RecognitionException {
		PhonemeContext _localctx = new PhonemeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_phoneme);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IgnoredContext extends ParserRuleContext {
		public List<TerminalNode> UNKNOWN() { return getTokens(BellechatParser.UNKNOWN); }
		public TerminalNode UNKNOWN(int i) {
			return getToken(BellechatParser.UNKNOWN, i);
		}
		public IgnoredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ignored; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).enterIgnored(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof BellechatListener ) ((BellechatListener)listener).exitIgnored(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof BellechatVisitor ) return ((BellechatVisitor<? extends T>)visitor).visitIgnored(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IgnoredContext ignored() throws RecognitionException {
		IgnoredContext _localctx = new IgnoredContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_ignored);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				match(UNKNOWN);
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==UNKNOWN );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\fE\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\3\3\3\5\3!\n\3\3\4\3\4\3\4\3"+
		"\4\5\4\'\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\n\6\n:\n\n\r\n\16\n;\3\13\3\13\3\f\6\fA\n\f\r\f\16\fB\3\f\2\2"+
		"\r\2\4\6\b\n\f\16\20\22\24\26\2\3\4\2\7\7\t\t@\2\33\3\2\2\2\4 \3\2\2\2"+
		"\6&\3\2\2\2\b(\3\2\2\2\n*\3\2\2\2\f,\3\2\2\2\16/\3\2\2\2\20\63\3\2\2\2"+
		"\229\3\2\2\2\24=\3\2\2\2\26@\3\2\2\2\30\32\5\4\3\2\31\30\3\2\2\2\32\35"+
		"\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\3\3\2\2\2\35\33\3\2\2\2\36!\5"+
		"\22\n\2\37!\5\6\4\2 \36\3\2\2\2 \37\3\2\2\2!\5\3\2\2\2\"\'\5\n\6\2#\'"+
		"\5\f\7\2$\'\5\16\b\2%\'\5\20\t\2&\"\3\2\2\2&#\3\2\2\2&$\3\2\2\2&%\3\2"+
		"\2\2\'\7\3\2\2\2()\t\2\2\2)\t\3\2\2\2*+\7\3\2\2+\13\3\2\2\2,-\7\4\2\2"+
		"-.\5\b\5\2.\r\3\2\2\2/\60\7\5\2\2\60\61\5\b\5\2\61\62\5\b\5\2\62\17\3"+
		"\2\2\2\63\64\7\6\2\2\64\65\5\b\5\2\65\66\5\b\5\2\66\67\5\b\5\2\67\21\3"+
		"\2\2\28:\5\24\13\298\3\2\2\2:;\3\2\2\2;9\3\2\2\2;<\3\2\2\2<\23\3\2\2\2"+
		"=>\7\t\2\2>\25\3\2\2\2?A\7\f\2\2@?\3\2\2\2AB\3\2\2\2B@\3\2\2\2BC\3\2\2"+
		"\2C\27\3\2\2\2\7\33 &;B";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
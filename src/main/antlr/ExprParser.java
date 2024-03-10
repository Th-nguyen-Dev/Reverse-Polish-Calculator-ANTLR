// Generated from Expr.g4 by ANTLR 4.13.1

    package antlr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExprParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, NEWLINE=20, INT=21, FLOAT=22, SCIENTIFIC=23, SPECIAL=24;
	public static final int
		RULE_prog = 0, RULE_expr_as = 1, RULE_expr_md = 2, RULE_expr_pw = 3, RULE_expr_func_mul = 4, 
		RULE_expr_func = 5, RULE_expr_paren = 6, RULE_expr_atom = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "expr_as", "expr_md", "expr_pw", "expr_func_mul", "expr_func", 
			"expr_paren", "expr_atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'**'", "'sin('", "')'", "'cos('", 
			"'tan('", "'asin('", "'acos('", "'atan('", "'sinh('", "'cosh('", "'tanh('", 
			"'log('", "'ln('", "'!'", "'('"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, "NEWLINE", "INT", "FLOAT", 
			"SCIENTIFIC", "SPECIAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Expr.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExprParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<Expr_asContext> expr_as() {
			return getRuleContexts(Expr_asContext.class);
		}
		public Expr_asContext expr_as(int i) {
			return getRuleContext(Expr_asContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(19);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 32243526L) != 0)) {
				{
				{
				setState(16);
				expr_as(0);
				}
				}
				setState(21);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_asContext extends ParserRuleContext {
		public Expr_mdContext expr_md() {
			return getRuleContext(Expr_mdContext.class,0);
		}
		public Expr_asContext expr_as() {
			return getRuleContext(Expr_asContext.class,0);
		}
		public Expr_asContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_as; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitExpr_as(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_asContext expr_as() throws RecognitionException {
		return expr_as(0);
	}

	private Expr_asContext expr_as(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr_asContext _localctx = new Expr_asContext(_ctx, _parentState);
		Expr_asContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr_as, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(23);
			expr_md(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(33);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(31);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_asContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_as);
						setState(25);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						{
						setState(26);
						match(T__0);
						}
						setState(27);
						expr_md(0);
						}
						break;
					case 2:
						{
						_localctx = new Expr_asContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_as);
						setState(28);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(29);
						match(T__1);
						}
						setState(30);
						expr_md(0);
						}
						break;
					}
					} 
				}
				setState(35);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_mdContext extends ParserRuleContext {
		public Expr_pwContext expr_pw() {
			return getRuleContext(Expr_pwContext.class,0);
		}
		public Expr_mdContext expr_md() {
			return getRuleContext(Expr_mdContext.class,0);
		}
		public Expr_mdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_md; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitExpr_md(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_mdContext expr_md() throws RecognitionException {
		return expr_md(0);
	}

	private Expr_mdContext expr_md(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr_mdContext _localctx = new Expr_mdContext(_ctx, _parentState);
		Expr_mdContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_expr_md, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(37);
			expr_pw();
			}
			_ctx.stop = _input.LT(-1);
			setState(47);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(45);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
					case 1:
						{
						_localctx = new Expr_mdContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_md);
						setState(39);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						{
						setState(40);
						match(T__2);
						}
						setState(41);
						expr_pw();
						}
						break;
					case 2:
						{
						_localctx = new Expr_mdContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr_md);
						setState(42);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						{
						setState(43);
						match(T__3);
						}
						setState(44);
						expr_pw();
						}
						break;
					}
					} 
				}
				setState(49);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_pwContext extends ParserRuleContext {
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
		}
		public Expr_pwContext expr_pw() {
			return getRuleContext(Expr_pwContext.class,0);
		}
		public Expr_pwContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_pw; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitExpr_pw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_pwContext expr_pw() throws RecognitionException {
		Expr_pwContext _localctx = new Expr_pwContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr_pw);
		try {
			setState(55);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(50);
				expr_func(0);
				{
				setState(51);
				match(T__4);
				}
				setState(52);
				expr_pw();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				expr_func(0);
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_func_mulContext extends ParserRuleContext {
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
		}
		public Expr_func_mulContext expr_func_mul() {
			return getRuleContext(Expr_func_mulContext.class,0);
		}
		public Expr_func_mulContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_func_mul; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitExpr_func_mul(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_func_mulContext expr_func_mul() throws RecognitionException {
		return expr_func_mul(0);
	}

	private Expr_func_mulContext expr_func_mul(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr_func_mulContext _localctx = new Expr_func_mulContext(_ctx, _parentState);
		Expr_func_mulContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr_func_mul, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(58);
			expr_func(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr_func_mulContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr_func_mul);
					setState(60);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(61);
					expr_func(0);
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_funcContext extends ParserRuleContext {
		public Expr_asContext expr_as() {
			return getRuleContext(Expr_asContext.class,0);
		}
		public Expr_parenContext expr_paren() {
			return getRuleContext(Expr_parenContext.class,0);
		}
		public Expr_funcContext expr_func() {
			return getRuleContext(Expr_funcContext.class,0);
		}
		public Expr_funcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_func; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitExpr_func(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_funcContext expr_func() throws RecognitionException {
		return expr_func(0);
	}

	private Expr_funcContext expr_func(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr_funcContext _localctx = new Expr_funcContext(_ctx, _parentState);
		Expr_funcContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr_func, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__5:
				{
				setState(68);
				match(T__5);
				setState(69);
				expr_as(0);
				setState(70);
				match(T__6);
				}
				break;
			case T__7:
				{
				setState(72);
				match(T__7);
				setState(73);
				expr_as(0);
				setState(74);
				match(T__6);
				}
				break;
			case T__8:
				{
				setState(76);
				match(T__8);
				setState(77);
				expr_as(0);
				setState(78);
				match(T__6);
				}
				break;
			case T__9:
				{
				setState(80);
				match(T__9);
				setState(81);
				expr_as(0);
				setState(82);
				match(T__6);
				}
				break;
			case T__10:
				{
				setState(84);
				match(T__10);
				setState(85);
				expr_as(0);
				setState(86);
				match(T__6);
				}
				break;
			case T__11:
				{
				setState(88);
				match(T__11);
				setState(89);
				expr_as(0);
				setState(90);
				match(T__6);
				}
				break;
			case T__12:
				{
				setState(92);
				match(T__12);
				setState(93);
				expr_as(0);
				setState(94);
				match(T__6);
				}
				break;
			case T__13:
				{
				setState(96);
				match(T__13);
				setState(97);
				expr_as(0);
				setState(98);
				match(T__6);
				}
				break;
			case T__14:
				{
				setState(100);
				match(T__14);
				setState(101);
				expr_as(0);
				setState(102);
				match(T__6);
				}
				break;
			case T__15:
				{
				setState(104);
				match(T__15);
				setState(105);
				expr_as(0);
				setState(106);
				match(T__6);
				}
				break;
			case T__16:
				{
				setState(108);
				match(T__16);
				setState(109);
				expr_as(0);
				setState(110);
				match(T__6);
				}
				break;
			case T__0:
			case T__1:
			case T__18:
			case INT:
			case FLOAT:
			case SCIENTIFIC:
			case SPECIAL:
				{
				setState(112);
				expr_paren();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(119);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr_funcContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr_func);
					setState(115);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(116);
					match(T__17);
					}
					} 
				}
				setState(121);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_parenContext extends ParserRuleContext {
		public Expr_parenContext expr_paren() {
			return getRuleContext(Expr_parenContext.class,0);
		}
		public Expr_asContext expr_as() {
			return getRuleContext(Expr_asContext.class,0);
		}
		public Expr_atomContext expr_atom() {
			return getRuleContext(Expr_atomContext.class,0);
		}
		public Expr_parenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_paren; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitExpr_paren(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_parenContext expr_paren() throws RecognitionException {
		Expr_parenContext _localctx = new Expr_parenContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr_paren);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(T__18);
				setState(123);
				expr_paren();
				setState(124);
				match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(T__1);
				setState(127);
				expr_paren();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				match(T__0);
				setState(129);
				expr_paren();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(130);
				match(T__18);
				setState(131);
				expr_as(0);
				setState(132);
				match(T__6);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(134);
				expr_atom();
				}
				break;
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

	@SuppressWarnings("CheckReturnValue")
	public static class Expr_atomContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(ExprParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(ExprParser.FLOAT, 0); }
		public TerminalNode SCIENTIFIC() { return getToken(ExprParser.SCIENTIFIC, 0); }
		public TerminalNode SPECIAL() { return getToken(ExprParser.SPECIAL, 0); }
		public Expr_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_atom; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExprVisitor ) return ((ExprVisitor<? extends T>)visitor).visitExpr_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_atomContext expr_atom() throws RecognitionException {
		Expr_atomContext _localctx = new Expr_atomContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 31457280L) != 0)) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr_as_sempred((Expr_asContext)_localctx, predIndex);
		case 2:
			return expr_md_sempred((Expr_mdContext)_localctx, predIndex);
		case 4:
			return expr_func_mul_sempred((Expr_func_mulContext)_localctx, predIndex);
		case 5:
			return expr_func_sempred((Expr_funcContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_as_sempred(Expr_asContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_md_sempred(Expr_mdContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_func_mul_sempred(Expr_func_mulContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expr_func_sempred(Expr_funcContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0018\u008c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0001\u0000\u0005\u0000\u0012\b\u0000\n\u0000\f\u0000\u0015\t\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0005\u0001 \b\u0001\n\u0001\f\u0001#\t"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002.\b\u0002\n\u0002"+
		"\f\u00021\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u00038\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004?\b\u0004\n\u0004\f\u0004B\t\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005r\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u0005v\b\u0005\n\u0005\f\u0005y\t\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u0088\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0000"+
		"\u0004\u0002\u0004\b\n\b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0000\u0001"+
		"\u0001\u0000\u0015\u0018\u009a\u0000\u0013\u0001\u0000\u0000\u0000\u0002"+
		"\u0016\u0001\u0000\u0000\u0000\u0004$\u0001\u0000\u0000\u0000\u00067\u0001"+
		"\u0000\u0000\u0000\b9\u0001\u0000\u0000\u0000\nq\u0001\u0000\u0000\u0000"+
		"\f\u0087\u0001\u0000\u0000\u0000\u000e\u0089\u0001\u0000\u0000\u0000\u0010"+
		"\u0012\u0003\u0002\u0001\u0000\u0011\u0010\u0001\u0000\u0000\u0000\u0012"+
		"\u0015\u0001\u0000\u0000\u0000\u0013\u0011\u0001\u0000\u0000\u0000\u0013"+
		"\u0014\u0001\u0000\u0000\u0000\u0014\u0001\u0001\u0000\u0000\u0000\u0015"+
		"\u0013\u0001\u0000\u0000\u0000\u0016\u0017\u0006\u0001\uffff\uffff\u0000"+
		"\u0017\u0018\u0003\u0004\u0002\u0000\u0018!\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\n\u0003\u0000\u0000\u001a\u001b\u0005\u0001\u0000\u0000\u001b "+
		"\u0003\u0004\u0002\u0000\u001c\u001d\n\u0002\u0000\u0000\u001d\u001e\u0005"+
		"\u0002\u0000\u0000\u001e \u0003\u0004\u0002\u0000\u001f\u0019\u0001\u0000"+
		"\u0000\u0000\u001f\u001c\u0001\u0000\u0000\u0000 #\u0001\u0000\u0000\u0000"+
		"!\u001f\u0001\u0000\u0000\u0000!\"\u0001\u0000\u0000\u0000\"\u0003\u0001"+
		"\u0000\u0000\u0000#!\u0001\u0000\u0000\u0000$%\u0006\u0002\uffff\uffff"+
		"\u0000%&\u0003\u0006\u0003\u0000&/\u0001\u0000\u0000\u0000\'(\n\u0003"+
		"\u0000\u0000()\u0005\u0003\u0000\u0000).\u0003\u0006\u0003\u0000*+\n\u0002"+
		"\u0000\u0000+,\u0005\u0004\u0000\u0000,.\u0003\u0006\u0003\u0000-\'\u0001"+
		"\u0000\u0000\u0000-*\u0001\u0000\u0000\u0000.1\u0001\u0000\u0000\u0000"+
		"/-\u0001\u0000\u0000\u0000/0\u0001\u0000\u0000\u00000\u0005\u0001\u0000"+
		"\u0000\u00001/\u0001\u0000\u0000\u000023\u0003\n\u0005\u000034\u0005\u0005"+
		"\u0000\u000045\u0003\u0006\u0003\u000058\u0001\u0000\u0000\u000068\u0003"+
		"\n\u0005\u000072\u0001\u0000\u0000\u000076\u0001\u0000\u0000\u00008\u0007"+
		"\u0001\u0000\u0000\u00009:\u0006\u0004\uffff\uffff\u0000:;\u0003\n\u0005"+
		"\u0000;@\u0001\u0000\u0000\u0000<=\n\u0001\u0000\u0000=?\u0003\n\u0005"+
		"\u0000><\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000A\t\u0001\u0000\u0000\u0000B@\u0001"+
		"\u0000\u0000\u0000CD\u0006\u0005\uffff\uffff\u0000DE\u0005\u0006\u0000"+
		"\u0000EF\u0003\u0002\u0001\u0000FG\u0005\u0007\u0000\u0000Gr\u0001\u0000"+
		"\u0000\u0000HI\u0005\b\u0000\u0000IJ\u0003\u0002\u0001\u0000JK\u0005\u0007"+
		"\u0000\u0000Kr\u0001\u0000\u0000\u0000LM\u0005\t\u0000\u0000MN\u0003\u0002"+
		"\u0001\u0000NO\u0005\u0007\u0000\u0000Or\u0001\u0000\u0000\u0000PQ\u0005"+
		"\n\u0000\u0000QR\u0003\u0002\u0001\u0000RS\u0005\u0007\u0000\u0000Sr\u0001"+
		"\u0000\u0000\u0000TU\u0005\u000b\u0000\u0000UV\u0003\u0002\u0001\u0000"+
		"VW\u0005\u0007\u0000\u0000Wr\u0001\u0000\u0000\u0000XY\u0005\f\u0000\u0000"+
		"YZ\u0003\u0002\u0001\u0000Z[\u0005\u0007\u0000\u0000[r\u0001\u0000\u0000"+
		"\u0000\\]\u0005\r\u0000\u0000]^\u0003\u0002\u0001\u0000^_\u0005\u0007"+
		"\u0000\u0000_r\u0001\u0000\u0000\u0000`a\u0005\u000e\u0000\u0000ab\u0003"+
		"\u0002\u0001\u0000bc\u0005\u0007\u0000\u0000cr\u0001\u0000\u0000\u0000"+
		"de\u0005\u000f\u0000\u0000ef\u0003\u0002\u0001\u0000fg\u0005\u0007\u0000"+
		"\u0000gr\u0001\u0000\u0000\u0000hi\u0005\u0010\u0000\u0000ij\u0003\u0002"+
		"\u0001\u0000jk\u0005\u0007\u0000\u0000kr\u0001\u0000\u0000\u0000lm\u0005"+
		"\u0011\u0000\u0000mn\u0003\u0002\u0001\u0000no\u0005\u0007\u0000\u0000"+
		"or\u0001\u0000\u0000\u0000pr\u0003\f\u0006\u0000qC\u0001\u0000\u0000\u0000"+
		"qH\u0001\u0000\u0000\u0000qL\u0001\u0000\u0000\u0000qP\u0001\u0000\u0000"+
		"\u0000qT\u0001\u0000\u0000\u0000qX\u0001\u0000\u0000\u0000q\\\u0001\u0000"+
		"\u0000\u0000q`\u0001\u0000\u0000\u0000qd\u0001\u0000\u0000\u0000qh\u0001"+
		"\u0000\u0000\u0000ql\u0001\u0000\u0000\u0000qp\u0001\u0000\u0000\u0000"+
		"rw\u0001\u0000\u0000\u0000st\n\u0002\u0000\u0000tv\u0005\u0012\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000"+
		"\u0000wx\u0001\u0000\u0000\u0000x\u000b\u0001\u0000\u0000\u0000yw\u0001"+
		"\u0000\u0000\u0000z{\u0005\u0013\u0000\u0000{|\u0003\f\u0006\u0000|}\u0005"+
		"\u0007\u0000\u0000}\u0088\u0001\u0000\u0000\u0000~\u007f\u0005\u0002\u0000"+
		"\u0000\u007f\u0088\u0003\f\u0006\u0000\u0080\u0081\u0005\u0001\u0000\u0000"+
		"\u0081\u0088\u0003\f\u0006\u0000\u0082\u0083\u0005\u0013\u0000\u0000\u0083"+
		"\u0084\u0003\u0002\u0001\u0000\u0084\u0085\u0005\u0007\u0000\u0000\u0085"+
		"\u0088\u0001\u0000\u0000\u0000\u0086\u0088\u0003\u000e\u0007\u0000\u0087"+
		"z\u0001\u0000\u0000\u0000\u0087~\u0001\u0000\u0000\u0000\u0087\u0080\u0001"+
		"\u0000\u0000\u0000\u0087\u0082\u0001\u0000\u0000\u0000\u0087\u0086\u0001"+
		"\u0000\u0000\u0000\u0088\r\u0001\u0000\u0000\u0000\u0089\u008a\u0007\u0000"+
		"\u0000\u0000\u008a\u000f\u0001\u0000\u0000\u0000\n\u0013\u001f!-/7@qw"+
		"\u0087";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
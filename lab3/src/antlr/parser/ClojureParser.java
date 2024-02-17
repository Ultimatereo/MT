// Generated from D:/KT/MT/lab3/src/Clojure.g4 by ANTLR 4.13.1
package antlr.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ClojureParser extends Parser {
    public static final int
            PLUS = 1, MINUS = 2, MULTIPLY = 3, DIVIDE = 4, GREATER_THAN_OR_EQUAL_TO = 5, LESS_THAN_OR_EQUAL_TO = 6,
            GREATER_THAN = 7, LESS_THAN = 8, EQUAL_TO = 9, LPAREN = 10, RPAREN = 11, LBRACKET = 12,
            RBRACKET = 13, DEFN = 14, NS = 15, ID = 16, NUMBER = 17, STRING = 18, WS = 19;
    public static final int
            RULE_program = 0, RULE_surface_function = 1, RULE_function = 2, RULE_function_body = 3,
            RULE_ns = 4, RULE_defn = 5, RULE_arithmetic_function = 6, RULE_compare_function = 7,
            RULE_general_function = 8, RULE_args_ids = 9, RULE_form = 10, RULE_atom = 11,
            RULE_operation = 12, RULE_comparison = 13;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\u0004\u0001\u0013^\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002" +
                    "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002" +
                    "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002" +
                    "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002" +
                    "\f\u0007\f\u0002\r\u0007\r\u0001\u0000\u0005\u0000\u001e\b\u0000\n\u0000" +
                    "\f\u0000!\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001" +
                    "\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001" +
                    "\u0003\u0001\u0003\u0001\u0003\u0003\u00030\b\u0003\u0001\u0004\u0001" +
                    "\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001" +
                    "\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0005\u0006>\b" +
                    "\u0006\n\u0006\f\u0006A\t\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001" +
                    "\u0007\u0001\b\u0001\b\u0005\bI\b\b\n\b\f\bL\t\b\u0001\t\u0005\tO\b\t" +
                    "\n\t\f\tR\t\t\u0001\n\u0001\n\u0003\nV\b\n\u0001\u000b\u0001\u000b\u0001" +
                    "\f\u0001\f\u0001\r\u0001\r\u0001\r\u0000\u0000\u000e\u0000\u0002\u0004" +
                    "\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u0000\u0003\u0001" +
                    "\u0000\u0010\u0012\u0001\u0000\u0001\u0004\u0001\u0000\u0005\tX\u0000" +
                    "\u001f\u0001\u0000\u0000\u0000\u0002$\u0001\u0000\u0000\u0000\u0004&\u0001" +
                    "\u0000\u0000\u0000\u0006/\u0001\u0000\u0000\u0000\b1\u0001\u0000\u0000" +
                    "\u0000\n4\u0001\u0000\u0000\u0000\f;\u0001\u0000\u0000\u0000\u000eB\u0001" +
                    "\u0000\u0000\u0000\u0010F\u0001\u0000\u0000\u0000\u0012P\u0001\u0000\u0000" +
                    "\u0000\u0014U\u0001\u0000\u0000\u0000\u0016W\u0001\u0000\u0000\u0000\u0018" +
                    "Y\u0001\u0000\u0000\u0000\u001a[\u0001\u0000\u0000\u0000\u001c\u001e\u0003" +
                    "\u0002\u0001\u0000\u001d\u001c\u0001\u0000\u0000\u0000\u001e!\u0001\u0000" +
                    "\u0000\u0000\u001f\u001d\u0001\u0000\u0000\u0000\u001f \u0001\u0000\u0000" +
                    "\u0000 \"\u0001\u0000\u0000\u0000!\u001f\u0001\u0000\u0000\u0000\"#\u0005" +
                    "\u0000\u0000\u0001#\u0001\u0001\u0000\u0000\u0000$%\u0003\u0004\u0002" +
                    "\u0000%\u0003\u0001\u0000\u0000\u0000&\'\u0005\n\u0000\u0000\'(\u0003" +
                    "\u0006\u0003\u0000()\u0005\u000b\u0000\u0000)\u0005\u0001\u0000\u0000" +
                    "\u0000*0\u0003\b\u0004\u0000+0\u0003\n\u0005\u0000,0\u0003\f\u0006\u0000" +
                    "-0\u0003\u0010\b\u0000.0\u0003\u000e\u0007\u0000/*\u0001\u0000\u0000\u0000" +
                    "/+\u0001\u0000\u0000\u0000/,\u0001\u0000\u0000\u0000/-\u0001\u0000\u0000" +
                    "\u0000/.\u0001\u0000\u0000\u00000\u0007\u0001\u0000\u0000\u000012\u0005" +
                    "\u000f\u0000\u000023\u0005\u0010\u0000\u00003\t\u0001\u0000\u0000\u0000" +
                    "45\u0005\u000e\u0000\u000056\u0005\u0010\u0000\u000067\u0005\f\u0000\u0000" +
                    "78\u0003\u0012\t\u000089\u0005\r\u0000\u00009:\u0003\u0014\n\u0000:\u000b" +
                    "\u0001\u0000\u0000\u0000;?\u0003\u0018\f\u0000<>\u0003\u0014\n\u0000=" +
                    "<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000" +
                    "\u0000?@\u0001\u0000\u0000\u0000@\r\u0001\u0000\u0000\u0000A?\u0001\u0000" +
                    "\u0000\u0000BC\u0003\u001a\r\u0000CD\u0003\u0014\n\u0000DE\u0003\u0014" +
                    "\n\u0000E\u000f\u0001\u0000\u0000\u0000FJ\u0005\u0010\u0000\u0000GI\u0003" +
                    "\u0014\n\u0000HG\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001" +
                    "\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\u0011\u0001\u0000\u0000" +
                    "\u0000LJ\u0001\u0000\u0000\u0000MO\u0005\u0010\u0000\u0000NM\u0001\u0000" +
                    "\u0000\u0000OR\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PQ\u0001" +
                    "\u0000\u0000\u0000Q\u0013\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000" +
                    "\u0000SV\u0003\u0016\u000b\u0000TV\u0003\u0004\u0002\u0000US\u0001\u0000" +
                    "\u0000\u0000UT\u0001\u0000\u0000\u0000V\u0015\u0001\u0000\u0000\u0000" +
                    "WX\u0007\u0000\u0000\u0000X\u0017\u0001\u0000\u0000\u0000YZ\u0007\u0001" +
                    "\u0000\u0000Z\u0019\u0001\u0000\u0000\u0000[\\\u0007\u0002\u0000\u0000" +
                    "\\\u001b\u0001\u0000\u0000\u0000\u0006\u001f/?JPU";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION);
    }

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

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public ClojureParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "program", "surface_function", "function", "function_body", "ns", "defn",
                "arithmetic_function", "compare_function", "general_function", "args_ids",
                "form", "atom", "operation", "comparison"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, "'+'", "'-'", "'*'", "'/'", "'>='", "'<='", "'>'", "'<'", "'='",
                "'('", "')'", "'['", "']'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "GREATER_THAN_OR_EQUAL_TO",
                "LESS_THAN_OR_EQUAL_TO", "GREATER_THAN", "LESS_THAN", "EQUAL_TO", "LPAREN",
                "RPAREN", "LBRACKET", "RBRACKET", "DEFN", "NS", "ID", "NUMBER", "STRING",
                "WS"
        };
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
    public String getGrammarFileName() {
        return "Clojure.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final ProgramContext program() throws RecognitionException {
        ProgramContext _localctx = new ProgramContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_program);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(31);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == LPAREN) {
                    {
                        {
                            setState(28);
                            surface_function();
                        }
                    }
                    setState(33);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(34);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Surface_functionContext surface_function() throws RecognitionException {
        Surface_functionContext _localctx = new Surface_functionContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_surface_function);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(36);
                function();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FunctionContext function() throws RecognitionException {
        FunctionContext _localctx = new FunctionContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_function);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(38);
                match(LPAREN);
                setState(39);
                function_body();
                setState(40);
                match(RPAREN);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Function_bodyContext function_body() throws RecognitionException {
        Function_bodyContext _localctx = new Function_bodyContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_function_body);
        try {
            setState(47);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NS:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(42);
                    ns();
                }
                break;
                case DEFN:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(43);
                    defn();
                }
                break;
                case PLUS:
                case MINUS:
                case MULTIPLY:
                case DIVIDE:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(44);
                    arithmetic_function();
                }
                break;
                case ID:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(45);
                    general_function();
                }
                break;
                case GREATER_THAN_OR_EQUAL_TO:
                case LESS_THAN_OR_EQUAL_TO:
                case GREATER_THAN:
                case LESS_THAN:
                case EQUAL_TO:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(46);
                    compare_function();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final NsContext ns() throws RecognitionException {
        NsContext _localctx = new NsContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_ns);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(49);
                match(NS);
                setState(50);
                match(ID);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DefnContext defn() throws RecognitionException {
        DefnContext _localctx = new DefnContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_defn);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(52);
                match(DEFN);
                setState(53);
                match(ID);
                setState(54);
                match(LBRACKET);
                setState(55);
                args_ids();
                setState(56);
                match(RBRACKET);
                setState(57);
                form();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Arithmetic_functionContext arithmetic_function() throws RecognitionException {
        Arithmetic_functionContext _localctx = new Arithmetic_functionContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_arithmetic_function);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(59);
                operation();
                setState(63);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 459776L) != 0)) {
                    {
                        {
                            setState(60);
                            form();
                        }
                    }
                    setState(65);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Compare_functionContext compare_function() throws RecognitionException {
        Compare_functionContext _localctx = new Compare_functionContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_compare_function);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(66);
                comparison();
                setState(67);
                form();
                setState(68);
                form();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final General_functionContext general_function() throws RecognitionException {
        General_functionContext _localctx = new General_functionContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_general_function);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(70);
                match(ID);
                setState(74);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 459776L) != 0)) {
                    {
                        {
                            setState(71);
                            form();
                        }
                    }
                    setState(76);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Args_idsContext args_ids() throws RecognitionException {
        Args_idsContext _localctx = new Args_idsContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_args_ids);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(80);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == ID) {
                    {
                        {
                            setState(77);
                            match(ID);
                        }
                    }
                    setState(82);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FormContext form() throws RecognitionException {
        FormContext _localctx = new FormContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_form);
        try {
            setState(85);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case ID:
                case NUMBER:
                case STRING:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(83);
                    atom();
                }
                break;
                case LPAREN:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(84);
                    function();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AtomContext atom() throws RecognitionException {
        AtomContext _localctx = new AtomContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_atom);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(87);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 458752L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final OperationContext operation() throws RecognitionException {
        OperationContext _localctx = new OperationContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_operation);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(89);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 30L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ComparisonContext comparison() throws RecognitionException {
        ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_comparison);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(91);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & 992L) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ProgramContext extends ParserRuleContext {
        public ProgramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode EOF() {
            return getToken(ClojureParser.EOF, 0);
        }

        public List<Surface_functionContext> surface_function() {
            return getRuleContexts(Surface_functionContext.class);
        }

        public Surface_functionContext surface_function(int i) {
            return getRuleContext(Surface_functionContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_program;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterProgram(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitProgram(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor) return ((ClojureVisitor<? extends T>) visitor).visitProgram(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Surface_functionContext extends ParserRuleContext {
        public Surface_functionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public FunctionContext function() {
            return getRuleContext(FunctionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_surface_function;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterSurface_function(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitSurface_function(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor)
                return ((ClojureVisitor<? extends T>) visitor).visitSurface_function(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FunctionContext extends ParserRuleContext {
        public FunctionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode LPAREN() {
            return getToken(ClojureParser.LPAREN, 0);
        }

        public Function_bodyContext function_body() {
            return getRuleContext(Function_bodyContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(ClojureParser.RPAREN, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_function;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterFunction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitFunction(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor) return ((ClojureVisitor<? extends T>) visitor).visitFunction(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Function_bodyContext extends ParserRuleContext {
        public Function_bodyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public NsContext ns() {
            return getRuleContext(NsContext.class, 0);
        }

        public DefnContext defn() {
            return getRuleContext(DefnContext.class, 0);
        }

        public Arithmetic_functionContext arithmetic_function() {
            return getRuleContext(Arithmetic_functionContext.class, 0);
        }

        public General_functionContext general_function() {
            return getRuleContext(General_functionContext.class, 0);
        }

        public Compare_functionContext compare_function() {
            return getRuleContext(Compare_functionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_function_body;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterFunction_body(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitFunction_body(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor)
                return ((ClojureVisitor<? extends T>) visitor).visitFunction_body(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NsContext extends ParserRuleContext {
        public NsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode NS() {
            return getToken(ClojureParser.NS, 0);
        }

        public TerminalNode ID() {
            return getToken(ClojureParser.ID, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ns;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterNs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitNs(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor) return ((ClojureVisitor<? extends T>) visitor).visitNs(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DefnContext extends ParserRuleContext {
        public DefnContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DEFN() {
            return getToken(ClojureParser.DEFN, 0);
        }

        public TerminalNode ID() {
            return getToken(ClojureParser.ID, 0);
        }

        public TerminalNode LBRACKET() {
            return getToken(ClojureParser.LBRACKET, 0);
        }

        public Args_idsContext args_ids() {
            return getRuleContext(Args_idsContext.class, 0);
        }

        public TerminalNode RBRACKET() {
            return getToken(ClojureParser.RBRACKET, 0);
        }

        public FormContext form() {
            return getRuleContext(FormContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_defn;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterDefn(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitDefn(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor) return ((ClojureVisitor<? extends T>) visitor).visitDefn(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Arithmetic_functionContext extends ParserRuleContext {
        public Arithmetic_functionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public OperationContext operation() {
            return getRuleContext(OperationContext.class, 0);
        }

        public List<FormContext> form() {
            return getRuleContexts(FormContext.class);
        }

        public FormContext form(int i) {
            return getRuleContext(FormContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arithmetic_function;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterArithmetic_function(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitArithmetic_function(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor)
                return ((ClojureVisitor<? extends T>) visitor).visitArithmetic_function(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Compare_functionContext extends ParserRuleContext {
        public Compare_functionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ComparisonContext comparison() {
            return getRuleContext(ComparisonContext.class, 0);
        }

        public List<FormContext> form() {
            return getRuleContexts(FormContext.class);
        }

        public FormContext form(int i) {
            return getRuleContext(FormContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_compare_function;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterCompare_function(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitCompare_function(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor)
                return ((ClojureVisitor<? extends T>) visitor).visitCompare_function(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class General_functionContext extends ParserRuleContext {
        public General_functionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(ClojureParser.ID, 0);
        }

        public List<FormContext> form() {
            return getRuleContexts(FormContext.class);
        }

        public FormContext form(int i) {
            return getRuleContext(FormContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_general_function;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterGeneral_function(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitGeneral_function(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor)
                return ((ClojureVisitor<? extends T>) visitor).visitGeneral_function(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class Args_idsContext extends ParserRuleContext {
        public Args_idsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> ID() {
            return getTokens(ClojureParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(ClojureParser.ID, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_args_ids;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterArgs_ids(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitArgs_ids(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor) return ((ClojureVisitor<? extends T>) visitor).visitArgs_ids(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FormContext extends ParserRuleContext {
        public FormContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public AtomContext atom() {
            return getRuleContext(AtomContext.class, 0);
        }

        public FunctionContext function() {
            return getRuleContext(FunctionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_form;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterForm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitForm(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor) return ((ClojureVisitor<? extends T>) visitor).visitForm(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AtomContext extends ParserRuleContext {
        public AtomContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(ClojureParser.ID, 0);
        }

        public TerminalNode NUMBER() {
            return getToken(ClojureParser.NUMBER, 0);
        }

        public TerminalNode STRING() {
            return getToken(ClojureParser.STRING, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_atom;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterAtom(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitAtom(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor) return ((ClojureVisitor<? extends T>) visitor).visitAtom(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class OperationContext extends ParserRuleContext {
        public OperationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode PLUS() {
            return getToken(ClojureParser.PLUS, 0);
        }

        public TerminalNode MINUS() {
            return getToken(ClojureParser.MINUS, 0);
        }

        public TerminalNode MULTIPLY() {
            return getToken(ClojureParser.MULTIPLY, 0);
        }

        public TerminalNode DIVIDE() {
            return getToken(ClojureParser.DIVIDE, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_operation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterOperation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitOperation(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor) return ((ClojureVisitor<? extends T>) visitor).visitOperation(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ComparisonContext extends ParserRuleContext {
        public ComparisonContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode GREATER_THAN_OR_EQUAL_TO() {
            return getToken(ClojureParser.GREATER_THAN_OR_EQUAL_TO, 0);
        }

        public TerminalNode LESS_THAN_OR_EQUAL_TO() {
            return getToken(ClojureParser.LESS_THAN_OR_EQUAL_TO, 0);
        }

        public TerminalNode GREATER_THAN() {
            return getToken(ClojureParser.GREATER_THAN, 0);
        }

        public TerminalNode LESS_THAN() {
            return getToken(ClojureParser.LESS_THAN, 0);
        }

        public TerminalNode EQUAL_TO() {
            return getToken(ClojureParser.EQUAL_TO, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_comparison;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).enterComparison(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof ClojureListener) ((ClojureListener) listener).exitComparison(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof ClojureVisitor) return ((ClojureVisitor<? extends T>) visitor).visitComparison(this);
            else return visitor.visitChildren(this);
        }
    }
}
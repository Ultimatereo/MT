// Generated from D:/KT/MT/lab3/src/Clojure.g4 by ANTLR 4.13.1
package antlr.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ClojureLexer extends Lexer {
    public static final int
            PLUS = 1, MINUS = 2, MULTIPLY = 3, DIVIDE = 4, GREATER_THAN_OR_EQUAL_TO = 5, LESS_THAN_OR_EQUAL_TO = 6,
            GREATER_THAN = 7, LESS_THAN = 8, EQUAL_TO = 9, LPAREN = 10, RPAREN = 11, LBRACKET = 12,
            RBRACKET = 13, DEFN = 14, NS = 15, ID = 16, NUMBER = 17, STRING = 18, WS = 19;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\u0004\u0000\u0013w\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001" +
                    "\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004" +
                    "\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007" +
                    "\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b" +
                    "\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002" +
                    "\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002" +
                    "\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001" +
                    "\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001" +
                    "\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001" +
                    "\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001" +
                    "\u000b\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001" +
                    "\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0005\u000f" +
                    "N\b\u000f\n\u000f\f\u000fQ\t\u000f\u0001\u0010\u0003\u0010T\b\u0010\u0001" +
                    "\u0010\u0001\u0010\u0001\u0010\u0005\u0010Y\b\u0010\n\u0010\f\u0010\\" +
                    "\t\u0010\u0003\u0010^\b\u0010\u0001\u0010\u0001\u0010\u0004\u0010b\b\u0010" +
                    "\u000b\u0010\f\u0010c\u0003\u0010f\b\u0010\u0001\u0011\u0001\u0011\u0005" +
                    "\u0011j\b\u0011\n\u0011\f\u0011m\t\u0011\u0001\u0011\u0001\u0011\u0001" +
                    "\u0012\u0004\u0012r\b\u0012\u000b\u0012\f\u0012s\u0001\u0012\u0001\u0012" +
                    "\u0000\u0000\u0013\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005" +
                    "\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019" +
                    "\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\u0001\u0000" +
                    "\u0006\u0002\u0000AZaz\u0004\u0000--09AZaz\u0001\u000019\u0001\u00000" +
                    "9\u0003\u0000\n\n\r\r\"\"\u0003\u0000\t\n\r\r  ~\u0000\u0001\u0001\u0000" +
                    "\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000" +
                    "\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000" +
                    "\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000" +
                    "\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000" +
                    "\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000" +
                    "\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000" +
                    "\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000" +
                    "\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000" +
                    "#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0001\'\u0001" +
                    "\u0000\u0000\u0000\u0003)\u0001\u0000\u0000\u0000\u0005+\u0001\u0000\u0000" +
                    "\u0000\u0007-\u0001\u0000\u0000\u0000\t/\u0001\u0000\u0000\u0000\u000b" +
                    "2\u0001\u0000\u0000\u0000\r5\u0001\u0000\u0000\u0000\u000f7\u0001\u0000" +
                    "\u0000\u0000\u00119\u0001\u0000\u0000\u0000\u0013;\u0001\u0000\u0000\u0000" +
                    "\u0015=\u0001\u0000\u0000\u0000\u0017?\u0001\u0000\u0000\u0000\u0019A" +
                    "\u0001\u0000\u0000\u0000\u001bC\u0001\u0000\u0000\u0000\u001dH\u0001\u0000" +
                    "\u0000\u0000\u001fK\u0001\u0000\u0000\u0000!S\u0001\u0000\u0000\u0000" +
                    "#g\u0001\u0000\u0000\u0000%q\u0001\u0000\u0000\u0000\'(\u0005+\u0000\u0000" +
                    "(\u0002\u0001\u0000\u0000\u0000)*\u0005-\u0000\u0000*\u0004\u0001\u0000" +
                    "\u0000\u0000+,\u0005*\u0000\u0000,\u0006\u0001\u0000\u0000\u0000-.\u0005" +
                    "/\u0000\u0000.\b\u0001\u0000\u0000\u0000/0\u0005>\u0000\u000001\u0005" +
                    "=\u0000\u00001\n\u0001\u0000\u0000\u000023\u0005<\u0000\u000034\u0005" +
                    "=\u0000\u00004\f\u0001\u0000\u0000\u000056\u0005>\u0000\u00006\u000e\u0001" +
                    "\u0000\u0000\u000078\u0005<\u0000\u00008\u0010\u0001\u0000\u0000\u0000" +
                    "9:\u0005=\u0000\u0000:\u0012\u0001\u0000\u0000\u0000;<\u0005(\u0000\u0000" +
                    "<\u0014\u0001\u0000\u0000\u0000=>\u0005)\u0000\u0000>\u0016\u0001\u0000" +
                    "\u0000\u0000?@\u0005[\u0000\u0000@\u0018\u0001\u0000\u0000\u0000AB\u0005" +
                    "]\u0000\u0000B\u001a\u0001\u0000\u0000\u0000CD\u0005d\u0000\u0000DE\u0005" +
                    "e\u0000\u0000EF\u0005f\u0000\u0000FG\u0005n\u0000\u0000G\u001c\u0001\u0000" +
                    "\u0000\u0000HI\u0005n\u0000\u0000IJ\u0005s\u0000\u0000J\u001e\u0001\u0000" +
                    "\u0000\u0000KO\u0007\u0000\u0000\u0000LN\u0007\u0001\u0000\u0000ML\u0001" +
                    "\u0000\u0000\u0000NQ\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000\u0000" +
                    "OP\u0001\u0000\u0000\u0000P \u0001\u0000\u0000\u0000QO\u0001\u0000\u0000" +
                    "\u0000RT\u0005-\u0000\u0000SR\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000" +
                    "\u0000T]\u0001\u0000\u0000\u0000U^\u00050\u0000\u0000VZ\u0007\u0002\u0000" +
                    "\u0000WY\u0007\u0003\u0000\u0000XW\u0001\u0000\u0000\u0000Y\\\u0001\u0000" +
                    "\u0000\u0000ZX\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000[^\u0001" +
                    "\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000]U\u0001\u0000\u0000\u0000" +
                    "]V\u0001\u0000\u0000\u0000^e\u0001\u0000\u0000\u0000_a\u0005.\u0000\u0000" +
                    "`b\u0007\u0003\u0000\u0000a`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000" +
                    "\u0000ca\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000\u0000df\u0001\u0000" +
                    "\u0000\u0000e_\u0001\u0000\u0000\u0000ef\u0001\u0000\u0000\u0000f\"\u0001" +
                    "\u0000\u0000\u0000gk\u0005\"\u0000\u0000hj\b\u0004\u0000\u0000ih\u0001" +
                    "\u0000\u0000\u0000jm\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000" +
                    "kl\u0001\u0000\u0000\u0000ln\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000" +
                    "\u0000no\u0005\"\u0000\u0000o$\u0001\u0000\u0000\u0000pr\u0007\u0005\u0000" +
                    "\u0000qp\u0001\u0000\u0000\u0000rs\u0001\u0000\u0000\u0000sq\u0001\u0000" +
                    "\u0000\u0000st\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uv\u0006" +
                    "\u0012\u0000\u0000v&\u0001\u0000\u0000\u0000\t\u0000OSZ]ceks\u0001\u0006" +
                    "\u0000\u0000";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);
    public static String[] channelNames = {
            "DEFAULT_TOKEN_CHANNEL", "HIDDEN"
    };
    public static String[] modeNames = {
            "DEFAULT_MODE"
    };

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

    public ClojureLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "GREATER_THAN_OR_EQUAL_TO", "LESS_THAN_OR_EQUAL_TO",
                "GREATER_THAN", "LESS_THAN", "EQUAL_TO", "LPAREN", "RPAREN", "LBRACKET",
                "RBRACKET", "DEFN", "NS", "ID", "NUMBER", "STRING", "WS"
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
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }
}
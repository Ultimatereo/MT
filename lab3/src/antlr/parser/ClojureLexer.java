// Generated from ./Clojure.g4 by ANTLR 4.13.1
package antlr.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ClojureLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MINUS=2, MULTIPLY=3, DIVIDE=4, GREATER_THAN_OR_EQUAL_TO=5, LESS_THAN_OR_EQUAL_TO=6, 
		GREATER_THAN=7, LESS_THAN=8, EQUAL_TO=9, LPAREN=10, RPAREN=11, LBRACKET=12, 
		RBRACKET=13, DEFN=14, ID=15, NUMBER=16, STRING=17, WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PLUS", "MINUS", "MULTIPLY", "DIVIDE", "GREATER_THAN_OR_EQUAL_TO", "LESS_THAN_OR_EQUAL_TO", 
			"GREATER_THAN", "LESS_THAN", "EQUAL_TO", "LPAREN", "RPAREN", "LBRACKET", 
			"RBRACKET", "DEFN", "ID", "NUMBER", "STRING", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'>='", "'<='", "'>'", "'<'", "'='", 
			"'('", "')'", "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS", "MINUS", "MULTIPLY", "DIVIDE", "GREATER_THAN_OR_EQUAL_TO", 
			"LESS_THAN_OR_EQUAL_TO", "GREATER_THAN", "LESS_THAN", "EQUAL_TO", "LPAREN", 
			"RPAREN", "LBRACKET", "RBRACKET", "DEFN", "ID", "NUMBER", "STRING", "WS"
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


	public ClojureLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Clojure.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0012r\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0005\u000eI\b\u000e\n\u000e\f\u000eL\t\u000e\u0001\u000f\u0003\u000f"+
		"O\b\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000fT\b\u000f\n\u000f"+
		"\f\u000fW\t\u000f\u0003\u000fY\b\u000f\u0001\u000f\u0001\u000f\u0004\u000f"+
		"]\b\u000f\u000b\u000f\f\u000f^\u0003\u000fa\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0005\u0010e\b\u0010\n\u0010\f\u0010h\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0004\u0011m\b\u0011\u000b\u0011\f\u0011n\u0001\u0011"+
		"\u0001\u0011\u0000\u0000\u0012\u0001\u0001\u0003\u0002\u0005\u0003\u0007"+
		"\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b"+
		"\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012\u0001"+
		"\u0000\u0006\u0002\u0000AZaz\u0004\u0000--09AZaz\u0001\u000019\u0001\u0000"+
		"09\u0003\u0000\n\n\r\r\"\"\u0003\u0000\t\n\r\r  y\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0001%\u0001\u0000\u0000\u0000\u0003\'\u0001"+
		"\u0000\u0000\u0000\u0005)\u0001\u0000\u0000\u0000\u0007+\u0001\u0000\u0000"+
		"\u0000\t-\u0001\u0000\u0000\u0000\u000b0\u0001\u0000\u0000\u0000\r3\u0001"+
		"\u0000\u0000\u0000\u000f5\u0001\u0000\u0000\u0000\u00117\u0001\u0000\u0000"+
		"\u0000\u00139\u0001\u0000\u0000\u0000\u0015;\u0001\u0000\u0000\u0000\u0017"+
		"=\u0001\u0000\u0000\u0000\u0019?\u0001\u0000\u0000\u0000\u001bA\u0001"+
		"\u0000\u0000\u0000\u001dF\u0001\u0000\u0000\u0000\u001fN\u0001\u0000\u0000"+
		"\u0000!b\u0001\u0000\u0000\u0000#l\u0001\u0000\u0000\u0000%&\u0005+\u0000"+
		"\u0000&\u0002\u0001\u0000\u0000\u0000\'(\u0005-\u0000\u0000(\u0004\u0001"+
		"\u0000\u0000\u0000)*\u0005*\u0000\u0000*\u0006\u0001\u0000\u0000\u0000"+
		"+,\u0005/\u0000\u0000,\b\u0001\u0000\u0000\u0000-.\u0005>\u0000\u0000"+
		"./\u0005=\u0000\u0000/\n\u0001\u0000\u0000\u000001\u0005<\u0000\u0000"+
		"12\u0005=\u0000\u00002\f\u0001\u0000\u0000\u000034\u0005>\u0000\u0000"+
		"4\u000e\u0001\u0000\u0000\u000056\u0005<\u0000\u00006\u0010\u0001\u0000"+
		"\u0000\u000078\u0005=\u0000\u00008\u0012\u0001\u0000\u0000\u00009:\u0005"+
		"(\u0000\u0000:\u0014\u0001\u0000\u0000\u0000;<\u0005)\u0000\u0000<\u0016"+
		"\u0001\u0000\u0000\u0000=>\u0005[\u0000\u0000>\u0018\u0001\u0000\u0000"+
		"\u0000?@\u0005]\u0000\u0000@\u001a\u0001\u0000\u0000\u0000AB\u0005d\u0000"+
		"\u0000BC\u0005e\u0000\u0000CD\u0005f\u0000\u0000DE\u0005n\u0000\u0000"+
		"E\u001c\u0001\u0000\u0000\u0000FJ\u0007\u0000\u0000\u0000GI\u0007\u0001"+
		"\u0000\u0000HG\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000K\u001e\u0001\u0000\u0000"+
		"\u0000LJ\u0001\u0000\u0000\u0000MO\u0005-\u0000\u0000NM\u0001\u0000\u0000"+
		"\u0000NO\u0001\u0000\u0000\u0000OX\u0001\u0000\u0000\u0000PY\u00050\u0000"+
		"\u0000QU\u0007\u0002\u0000\u0000RT\u0007\u0003\u0000\u0000SR\u0001\u0000"+
		"\u0000\u0000TW\u0001\u0000\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001"+
		"\u0000\u0000\u0000VY\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000"+
		"XP\u0001\u0000\u0000\u0000XQ\u0001\u0000\u0000\u0000Y`\u0001\u0000\u0000"+
		"\u0000Z\\\u0005.\u0000\u0000[]\u0007\u0003\u0000\u0000\\[\u0001\u0000"+
		"\u0000\u0000]^\u0001\u0000\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001"+
		"\u0000\u0000\u0000_a\u0001\u0000\u0000\u0000`Z\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000a \u0001\u0000\u0000\u0000bf\u0005\"\u0000\u0000"+
		"ce\b\u0004\u0000\u0000dc\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000\u0000"+
		"fd\u0001\u0000\u0000\u0000fg\u0001\u0000\u0000\u0000gi\u0001\u0000\u0000"+
		"\u0000hf\u0001\u0000\u0000\u0000ij\u0005\"\u0000\u0000j\"\u0001\u0000"+
		"\u0000\u0000km\u0007\u0005\u0000\u0000lk\u0001\u0000\u0000\u0000mn\u0001"+
		"\u0000\u0000\u0000nl\u0001\u0000\u0000\u0000no\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000pq\u0006\u0011\u0000\u0000q$\u0001\u0000\u0000"+
		"\u0000\t\u0000JNUX^`fn\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
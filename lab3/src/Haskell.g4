grammar Haskell;

/*
 * Parser rules
*/

/*
 * Lexer rules
*/

// tokens
fragment DIGITS: ('0'..'9')+;
fragment SIGN: ('-' | '+');


FAC: 'fac';

INTEGER: 'Integer';
BOOLEAN: 'Boolean';
CHAR: 'Char';
DOUBLE: 'Double';
FLOAT: 'Float';
STRING: 'String';

LPAREN: '(';
RPAREN: ')';
DOUBLE_COLON: '::';
COLON: ':';
SEMICOLON: ';';
DOT: '.';

PLUS: '+';
MINUS: '-';
STAR: '*';

EQUAL: '=';
NOT_EQUAL: '/=';
GT: '>';
LT: '<';
GE: '>=';
LE: '<=';

TRUE: 'True';
FALSE: 'False';

IF: 'if';
THEN: 'then';
ELSE: 'else';

NUMBER: (SIGN)? DIGITS (DOT DIGITS)?;
IDENT: ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;
LITERAL : '\'' ('\'\'' | ~ ('\''))* '\'';

WS : [ \t\r\n] -> skip;
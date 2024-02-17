grammar Clojure;
/*
 * Правила грамматики
*/
program: surface_function* EOF;

surface_function: function;

function: LPAREN function_body RPAREN;

function_body : defn | arithmetic_function | general_function | compare_function;

defn: DEFN ID LBRACKET args_ids RBRACKET form;

arithmetic_function: operation form*;

compare_function: comparison form form;

general_function: ID form*;

args_ids: ID*;

form: atom | function;

atom: ID | NUMBER | STRING;

operation: PLUS | MINUS | MULTIPLY | DIVIDE;
comparison: GREATER_THAN_OR_EQUAL_TO | LESS_THAN_OR_EQUAL_TO | GREATER_THAN | LESS_THAN | EQUAL_TO;

/*
 * Токены
*/

// Правила для арифметических операций и сравнений
PLUS: '+';
MINUS: '-';
MULTIPLY: '*';
DIVIDE: '/';
GREATER_THAN_OR_EQUAL_TO: '>=';
LESS_THAN_OR_EQUAL_TO: '<=';
GREATER_THAN: '>';
LESS_THAN: '<';
EQUAL_TO: '=';

// Специальные символы
LPAREN: '(';
RPAREN: ')';
LBRACKET: '[';
RBRACKET: ']';

// Ключевые слова
DEFN: 'd' 'e' 'f' 'n';


// Правила для идентификаторов, чисел и строк
ID: [a-zA-Z][a-zA-Z0-9-]*;
NUMBER: '-'? ('0' | [1-9] [0-9]*) ('.'[0-9]+)?;
STRING: '"' (~["\r\n])* '"';

// Пробельные символы игнорируются
WS: [ \t\r\n]+ -> skip;
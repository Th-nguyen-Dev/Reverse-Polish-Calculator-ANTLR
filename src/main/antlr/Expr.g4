grammar Expr;
@header{
    package antlr;
}
prog: expr_as;
expr_as: expr_as ('+') expr_md
    | expr_as ('-') expr_md
    | expr_md;
expr_md: expr_md ('*') expr_pw
    | expr_md ('/') expr_pw
    | expr_pw;
expr_pw: expr_func ('**') expr_pw
    | expr_func;
expr_func_mul: expr_func
    | expr_func_mul expr_func;
expr_func: 'sin(' expr_as ')'
    | 'cos(' expr_as ')'
    | 'tan(' expr_as ')'
    | 'asin(' expr_as ')'
    | 'acos(' expr_as ')'
    | 'atan(' expr_as ')'
    | 'sinh(' expr_as ')'
    | 'cosh(' expr_as ')'
    | 'tanh(' expr_as ')'
    | 'log(' expr_as ')'
    | 'ln(' expr_as ')'
    | expr_func '!'
    | expr_paren;

expr_paren: '(' expr_paren ')'
    | '-' expr_paren
    | '+' expr_paren
    | '(' expr_as ')'
    | expr_atom;
expr_atom:INT
    | FLOAT
    | SCIENTIFIC
    | SPECIAL
    ;
NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
FLOAT   : [0-9]*'.'[0-9]+ ;
SCIENTIFIC : [0-9]+('e'|'E')[0-9]+ ;
SPECIAL : 'π'| 'pi' | 'e' ;

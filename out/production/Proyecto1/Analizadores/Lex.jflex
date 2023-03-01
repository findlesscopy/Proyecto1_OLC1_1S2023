package Analizadores;
import java_cup.runtime.Symbol;

%%
%public
%class Lexer
%cup
%line
%column
%full
%char

%init{
    System.out.println("Inicio del analisis lexico");
    yyline = 1;
    yychar = 1;
%init}

SPACE = [ \t\r]+

//Palabras reservada
RES_CONJUNTO = "CONJ"

//Simbolos
CB_LEFT = "{"
CB_RIGHT = "}"
COLON = ":"
VIRGULILLA = "~"
SEMICOLON = ";"
PORCENTAJE = "%"
ARROW = "->"
COMMA = ","

//SIMBOLOS ER
MAS = "+"
ASTERISCO = "*"
OR = "|"
AND = "."
QUESTION = "?"

//ER
L_MAYUS = [A-Z]
L_MINUS = [a-z]
DIGITS = [0-9]
ASCII = [ -/:-@\[-`{-}]
ID = [a-zA-Z_][a-zA-Z0-9_]+
CADENAS = \"([^\"\n]|\\\")*\"|'([^'\n]|\\')*'

//Espacios y comentarios

MULTILINE_COMMENT = "<!" + {ENTRADA} + "!>"
ENTRADA = .|[^.]
SINGLE_COMMENT = "/*""/"*([^*/]|[^*]"/"|"*"[^/])*"*"*"*/"

%%
<YYINITIAL> {SINGLE_COMMENT} { System.out.println("COMENTARIO DE UNA LINEA "+yytext());  }
<YYINITIAL> {MULTILINE_COMMENT} { System.out.println("COMENTARIO MULTIPLE LINEA "+yytext());  }
<YYINITIAL> {CADENAS} { System.out.println("CADENAS "+yytext()); return new Symbol(sym.CADENAS, yyline, yycolumn,yytext()); }

<YYINITIAL> {RES_CONJUNTO} { System.out.println("RES_CONJUNTO "+yytext()); return new Symbol(sym.RES_CONJUNTO, yyline, yycolumn,yytext()); }

<YYINITIAL> {CB_LEFT} { System.out.println("LLAVE ABRE "+yytext()); return new Symbol(sym.CB_LEFT, yyline, yycolumn,yytext()); }
<YYINITIAL> {CB_RIGHT} { System.out.println("LLAVE CIERRA "+yytext()); return new Symbol(sym.CB_RIGHT, yyline, yycolumn,yytext()); }
<YYINITIAL> {COLON} { System.out.println("DOS PUNTOS "+yytext()); return new Symbol(sym.COLON, yyline, yycolumn,yytext()); }
<YYINITIAL> {VIRGULILLA} { System.out.println("VIRGUILILLA "+yytext()); return new Symbol(sym.VIRGULILLA, yyline, yycolumn,yytext()); }
<YYINITIAL> {SEMICOLON} { System.out.println("PUNTO Y COMA "+yytext()); return new Symbol(sym.SEMICOLON, yyline, yycolumn,yytext()); }
<YYINITIAL> {PORCENTAJE} { System.out.println("PORCENTAJE "+yytext()); return new Symbol(sym.PORCENTAJE, yyline, yycolumn,yytext()); }
<YYINITIAL> {COMMA} { System.out.println("COMA "+yytext()); return new Symbol(sym.COMMA, yyline, yycolumn,yytext()); }
<YYINITIAL> {ARROW} { System.out.println("FLECHITA "+yytext()); return new Symbol(sym.ARROW, yyline, yycolumn,yytext()); }

<YYINITIAL> {MAS} { System.out.println("MAS "+yytext()); return new Symbol(sym.MAS, yyline, yycolumn,yytext()); }
<YYINITIAL> {ASTERISCO} { System.out.println("ASTERISCO "+yytext()); return new Symbol(sym.ASTERISCO, yyline, yycolumn,yytext()); }
<YYINITIAL> {OR} { System.out.println("OR "+yytext()); return new Symbol(sym.OR, yyline, yycolumn,yytext()); }
<YYINITIAL> {AND} { System.out.println("AND "+yytext()); return new Symbol(sym.AND, yyline, yycolumn,yytext()); }
<YYINITIAL> {QUESTION} { System.out.println("PREGUNTA "+yytext()); return new Symbol(sym.QUESTION, yyline, yycolumn,yytext()); }

\n {yychar=1;}

<YYINITIAL> {SPACE} {}

<YYINITIAL> {ID} { System.out.println("IDENTIFICADOR  "+yytext()); return new Symbol(sym.ID, yyline, yycolumn,yytext()); }

<YYINITIAL> {L_MAYUS} { System.out.println("LETRA MAYUSCULA  "+yytext()); return new Symbol(sym.L_MAYUS, yyline, yycolumn,yytext()); }
<YYINITIAL> {L_MINUS} { System.out.println("LETRA MINUSCULA  "+yytext()); return new Symbol(sym.L_MINUS, yyline, yycolumn,yytext()); }
<YYINITIAL> {DIGITS} { System.out.println("DIGITO  "+yytext()); return new Symbol(sym.DIGITS, yyline, yycolumn,yytext()); }

<YYINITIAL> {ASCII} { System.out.println("ASCII  "+yytext()); return new Symbol(sym.ASCII, yyline, yycolumn,yytext()); }

<YYINITIAL> . {
    String errLex = "Error léxico: carácter no reconocido" + yytext() + "' en la línea " + yyline + " y columna " + yycolumn;
    System.out.println(errLex);
    return new Symbol(sym.error);
}
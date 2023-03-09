package Analizadores;
import java_cup.runtime.Symbol;

%%


%class Lexer
%cup
%public
%line
%column
%unicode


%{

%}

// PALABRAS RESERVADAS
CONJ = "CONJ"

// SIMBOLOS DE ESTRUCTURA DE ARCHIVO
LL_ABRE = "{"
LL_CIERRA = "}"
D_PUNTOS = ":"
P_COMA = ";"
COMA = ","
GUION = "-"
MAYOR = ">"
VIRGULILLA = "~"
PORCENTAJE = "%"
COMILLAS = \"

// SIMBOLOS DE OPERACIONES
OR = "|"
CONCAT = "."
POSITIVA = "+"
KLEENE = "*"
OPCIONAL = "?"

// ERS
ESCAPADOS = "\\n" | "\\\"" | "\\\'"
NO_ESCAPADOS = [^\'\"]
ESPACIOS = [ \t\r\n]+
ENTRADA = [^\!]| ("!"[^\>])
COMENTARIO_MULTILINEA = "<!" {ENTRADA}+ "!>"
COMENTARIO_LINEA = "//" .*
L_MINUSCULA = [a-z]
L_MAYUSCULA = [A-Z]
DIGITO = [0-9]
ESPECIAL = [ -/:-@\[-`{-}]
ID = [a-zA-Z_][a-zA-Z0-9_]*
CARACTER = (\" {NO_ESCAPADOS} \") | {ESCAPADOS}
CADENA = \" ([^\"] | "\\\"")+  \"
%%

<YYINITIAL> {COMENTARIO_MULTILINEA}  { System.out.println("Comentario MultiLinea");/* Ignorar */ }
<YYINITIAL> {COMENTARIO_LINEA}  { System.out.println("Comentario Linea " + yytext() );/* Ignorar */ }
<YYINITIAL> {ESPACIOS}  { /* Ignorar */ }
<YYINITIAL> {CONJ}  { System.out.println("CONJUNTO"); return new Symbol(sym.CONJ); }
<YYINITIAL> {LL_ABRE}  { System.out.println("LLAVE ABRE"); return new Symbol(sym.LL_ABRE); }
<YYINITIAL> {LL_CIERRA}  { System.out.println("LLAVE CIERRA"); return new Symbol(sym.LL_CIERRA); }
<YYINITIAL> {D_PUNTOS}  { System.out.println("DOS PUNTOS"); return new Symbol(sym.D_PUNTOS); }
<YYINITIAL> {P_COMA}  { System.out.println("PUNTO Y COMA"); return new Symbol(sym.P_COMA); }
<YYINITIAL> {COMA}  { System.out.println("COMA"); return new Symbol(sym.COMA); }
<YYINITIAL> {GUION}  { System.out.println("GUION"); return new Symbol(sym.GUION); }
<YYINITIAL> {MAYOR}  { System.out.println("MAYOR"); return new Symbol(sym.MAYOR); }
<YYINITIAL> {VIRGULILLA}  { System.out.println("VIRGULILLA"); return new Symbol(sym.VIRGULILLA); }
<YYINITIAL> {PORCENTAJE}  { System.out.println("PORCENTAJE"); return new Symbol(sym.PORCENTAJE); }
<YYINITIAL> {OR}  { System.out.println("OR"); return new Symbol(sym.OR); }
<YYINITIAL> {CONCAT}  { System.out.println("CONCAT"); return new Symbol(sym.CONCAT); }
<YYINITIAL> {POSITIVA}  { System.out.println("POSITIVA"); return new Symbol(sym.POSITIVA); }
<YYINITIAL> {KLEENE}  { System.out.println("KLEENE"); return new Symbol(sym.KLEENE); }
<YYINITIAL> {OPCIONAL}  { System.out.println("OPCIONAL"); return new Symbol(sym.OPCIONAL); }
<YYINITIAL> {L_MINUSCULA}  { System.out.println("L_MINUSCULA"); return new Symbol(sym.L_MINUSCULA); }
<YYINITIAL> {L_MAYUSCULA}  { System.out.println("L_MAYUSCULA"); return new Symbol(sym.L_MAYUSCULA); }
<YYINITIAL> {ID}  { System.out.println("ID"); return new Symbol(sym.ID); }
<YYINITIAL> {CARACTER}  { System.out.println("CARACTER"); return new Symbol(sym.CARACTER); }
<YYINITIAL> {CADENA}  { System.out.println("CADENA"); return new Symbol(sym.CADENA); }
<YYINITIAL> {DIGITO}  { System.out.println("DIGITO"); return new Symbol(sym.DIGITO); }
<YYINITIAL> {ESPECIAL}  { System.out.println("ESPECIAL"); return new Symbol(sym.ESPECIAL); }

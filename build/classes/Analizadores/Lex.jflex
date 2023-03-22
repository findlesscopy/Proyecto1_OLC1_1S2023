package Analizadores;
import java_cup.runtime.Symbol;
import Errores.ErroresLexicos;
import java.util.ArrayList;
%%


%class Lexer
%cup
%public
%line
%column
%unicode


%{
    public static ArrayList<ErroresLexicos> errores = new ArrayList<>();
%}

// PALABRAS RESERVADAS
CONJ = "CONJ"

// SIMBOLOS DE ESTRUCTURA DE ARCHIVO
LL_ABRE = "{"
LL_CIERRA = "}"
D_PUNTOS = ":"
P_COMA = ";"
COMA = ","
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
ID = [a-zA-Z_][a-zA-Z0-9_]+
CARACTER = (\" {NO_ESCAPADOS} \") | {ESCAPADOS}
CADENA = \" ([^\"] | "\\\"")+  \"
FLECHA = "-" {ESPACIOS}* ">"
%%

<YYINITIAL> {COMENTARIO_MULTILINEA}  { /* Ignorar */ }
<YYINITIAL> {COMENTARIO_LINEA}  { /* Ignorar */ }
<YYINITIAL> {ESPACIOS}  { /* Ignorar */ }
<YYINITIAL> {CONJ}  {  return new Symbol(sym.CONJ, yyline, yycolumn, yytext()); }
<YYINITIAL> {LL_ABRE}  {  return new Symbol(sym.LL_ABRE, yyline, yycolumn, yytext()); }
<YYINITIAL> {LL_CIERRA}  {  return new Symbol(sym.LL_CIERRA, yyline, yycolumn, yytext()); }
<YYINITIAL> {D_PUNTOS}  {  return new Symbol(sym.D_PUNTOS, yyline, yycolumn, yytext()); }
<YYINITIAL> {P_COMA}  {  return new Symbol(sym.P_COMA, yyline, yycolumn, yytext()); }
<YYINITIAL> {COMA}  {  return new Symbol(sym.COMA, yyline, yycolumn, yytext()); }
<YYINITIAL> {FLECHA}  {  return new Symbol(sym.FLECHA, yyline, yycolumn, yytext()); }
<YYINITIAL> {VIRGULILLA}  {  return new Symbol(sym.VIRGULILLA, yyline, yycolumn, yytext()); }
<YYINITIAL> {PORCENTAJE}  {  return new Symbol(sym.PORCENTAJE, yyline, yycolumn, yytext()); }
<YYINITIAL> {OR}  {  return new Symbol(sym.OR, yyline, yycolumn, yytext()); }
<YYINITIAL> {CONCAT}  {  return new Symbol(sym.CONCAT, yyline, yycolumn, yytext()); }
<YYINITIAL> {POSITIVA}  {  return new Symbol(sym.POSITIVA, yyline, yycolumn, yytext()); }
<YYINITIAL> {KLEENE}  {  return new Symbol(sym.KLEENE, yyline, yycolumn, yytext()); }
<YYINITIAL> {OPCIONAL}  {  return new Symbol(sym.OPCIONAL, yyline, yycolumn, yytext()); }
<YYINITIAL> {L_MINUSCULA}  {  return new Symbol(sym.L_MINUSCULA, yyline, yycolumn, yytext()); }
<YYINITIAL> {L_MAYUSCULA}  {  return new Symbol(sym.L_MAYUSCULA, yyline, yycolumn, yytext()); }
<YYINITIAL> {ID}  {  return new Symbol(sym.ID, yyline, yycolumn, yytext()); }
<YYINITIAL> {CARACTER}  { return new Symbol(sym.CARACTER, yyline, yycolumn, yytext()); }
<YYINITIAL> {CADENA}  {  return new Symbol(sym.CADENA, yyline, yycolumn, yytext()); }
<YYINITIAL> {DIGITO}  {  return new Symbol(sym.DIGITO , yyline, yycolumn, yytext()); }
<YYINITIAL> {ESPECIAL}  {  return new Symbol(sym.ESPECIAL, yyline, yycolumn, yytext()); }

<YYINITIAL> . {
        errores.add(new ErroresLexicos(yytext(),(yyline+1),(yycolumn+1)));
}
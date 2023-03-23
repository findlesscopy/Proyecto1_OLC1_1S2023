# **PROYECTO 1**
### Universidad de San Carlos de Guatemala
### Facultad de Ingeniería
### Escuela de Ciencias y Sistemas
### Organización de Lenguajes y Compiladores 1
### Sección C
<br></br>

## **Gramática**
<br></br>

| Nombre | Carnet | 
| --- | --- |
| José Manuel Ibarra Pirir | 202001800 |
----
### Declaracion de terminales

```
TERMINALES = [CONJ, LL_ABRE, LL_CIERRA, D_PUNTOS, P_COMA, COMA, FLECHA, VIRGULILLA, PORCENTAJE, OR, CONCAT, POSITIVA, KLEENE, OPCIONAL, L_MINUSCULA, L_MAYUSCULA, DIGITO, ESPECIAL, ID, CARACTER, CADENA]

```
### Declaracion de no terminales

```
NON_TERMINALES = [olc, definiciones, definicion, expresion_regular, rango, listado, unico, pruebas, prueba]

```
### Declaracion de producciones

```
olc::= LL_ABRE definiciones pruebas LL_CIERRA 

definiciones::= definiciones definicion
               | definicion ;
```
```
definicion::= CONJ D_PUNTOS ID FLECHA rango P_COMA 
             |ID FLECHA expresion_regular P_COMA 
```
```
rango::= L_MINUSCULA VIRGULILLA L_MINUSCULA 
        | L_MAYUSCULA VIRGULILLA L_MAYUSCULA
        | DIGITO VIRGULILLA DIGITO 
        | ESPECIAL VIRGULILLA ESPECIAL 
        | listado
```
```
listado::= listado COMA unico
          | unico
```
```
unico::= L_MINUSCULA
        | L_MAYUSCULA
        | DIGITO
        | ESPECIAL
```
```
expresion_regular::= CONCAT expresion_regular expresion_regular
                    | OR expresion_regular expresion_regular 
                    | POSITIVA expresion_regular
                    | KLEENE expresion_regular
                    | OPCIONAL expresion_regular 
                    | CARACTER
                    | LL_ABRE ID LL_CIERRA 
```
```
pruebas ::= PORCENTAJE PORCENTAJE PORCENTAJE PORCENTAJE pruebas prueba
           | prueba;
```
```
prueba::= ID D_PUNTOS CADENA P_COMA
```
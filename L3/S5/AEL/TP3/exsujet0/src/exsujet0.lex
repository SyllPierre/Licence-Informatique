/* Exemple du sujet - version 0 */

%%

%unicode
LETTRE=[:letter:]
Punct1=[\p{Punctuation}]
Punct2=[\p{Punctuation}--[}]] 
CHIFFRE=[0-9]
OP=[-+*/]
IDENT=[A-Za-z](_?({LETTRE}|{CHIFFRE}))*
ENTIER={CHIFFRE}+
COMMENTER=#({LETTRE}|{Punct1}|' '|\t)*\n
COMMENTER2=[{]({LETTRE}|{Punct2}|\s|\n)*[}]
COMMENTER3=[<][!][-]({LETTRE}|\s|\n)*[-][>]

%%


{ENTIER}
  { return new Yytoken(TokenType.ENTIER,yytext()); }
{IDENT}
  { return new Yytoken(TokenType.IDENT,yytext()); }
{OP}
  { return new Yytoken(TokenType.OPERATEUR,yytext()); }
[\s\n]
  {}
{COMMENTER}
  {}
{COMMENTER2}
  {}
{COMMENTER3}
  {}


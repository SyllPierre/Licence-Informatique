%%

OCTAL = 0(1-7)(0-7)*
ENTIER={CHIFFRE}+
CHIFFRE = [0-9]
HEXA = (0x|0X)({CHIFFRE})*
LETTRE=[:letter:]
IDENT=[A-Za-z](_?({LETTRE}|{CHIFFRE}))*
STOCKAGE=[-][>](' '|\n)*

%state STOCKAGE

%%

<YYINITIAL>{
  {ENTIER}
    {return new Entier(yytext());}
  {OCTAL}
    {return new Entier(yytext());}
  {HEXA}
    {return new Entier(yytext());}
  [+]
    {return new Plus(yytext());}
  [-]
    {return new Moins(yytext());}
  [*]
    {return new Mult(yytext());}
  [/]
    {return new Div(yytext());}
  [\s]
    {}
  {IDENT}
    {return new Ident(yytext());}
  {STOCKAGE}
    {
      yybegin(STOCKAGE);
    }
}

<STOCKAGE>{
  {IDENT}
    {
      return new Stockage(yytext());
    }
  [\s]
    {
      yybegin(YYINITIAL);
    }
}

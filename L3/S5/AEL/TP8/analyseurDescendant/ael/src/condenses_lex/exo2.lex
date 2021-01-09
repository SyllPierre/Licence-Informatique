package condenses_lex;
%%

%unicode
CHIFFRE=[0-9]

ENTIER=[1-9]{CHIFFRE}*

QUELCONQUE={ENTIER}|{LETTRE}|{OUVRANTE}|{FERMANTE}

LETTRE=[a-zA-ZéèàôûâêîŷïöäëüÿÂÊÎÔÛŶÄËÏÖÜŸù]|\{QUELCONQUE}

OUVRANTE=[(]

FERMANTE=[)]

EOD=[#]


%%


{ENTIER}
  { return new Entier(Integer.parseInt(yytext())); }

{LETTRE}
  { return new Lettre(yytext()); }

{OUVRANTE}
  { return new Ouvrante(true); }

{FERMANTE}
  { return new Fermante(true); }

{EOD}
  { return new Eod(yytext()); }

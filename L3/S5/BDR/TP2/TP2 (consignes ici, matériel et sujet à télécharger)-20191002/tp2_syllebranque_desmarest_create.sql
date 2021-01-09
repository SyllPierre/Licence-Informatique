DROP TABLE IF EXISTS Articles CASCADE;
DROP TABLE IF EXISTS Fournisseurs CASCADE;
DROP TABLE IF EXISTS Catalogue CASCADE;

create Table Articles(
aid Integer,
anom Varchar(30) Not Null,
couleur Varchar(20) Not Null,
PRIMARY KEY(aid));

create Table Fournisseurs(
fid Integer,
fnom Varchar(30) Not Null,
fadresse Varchar(50) Not Null,
Primary Key(fid));

create Table Catalogue(
fid Integer,
aid Integer,
price numeric(10,2) Not Null,
Primary Key(fid, aid),
Foreign Key(fid) References Fournisseurs(fid) on update cascade on delete cascade,
Foreign Key(aid) References Articles (aid) on update cascade on delete cascade);

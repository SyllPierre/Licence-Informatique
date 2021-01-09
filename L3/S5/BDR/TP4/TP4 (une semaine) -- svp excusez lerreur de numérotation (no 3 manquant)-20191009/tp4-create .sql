
---drop table participer cascade; 
---drop table cours cascade ;
---drop table etudiants cascade; 
---drop table profs cascade;

create table etudiants(
	e_id int primary key,
	e_nom varchar(30),
	programme varchar(25),
	niveau varchar(10),--
	age int
	);
create table profs(
prof_id int primary key,
	prof_nom varchar(30),
	lab_id int
	);
create table cours(
       c_id int primary key,
       	titre varchar(40) unique, 
	horaire varchar(20),
	salle varchar(10),
	prof_id int,
    foreign key(prof_id) references profs
	);
create table participer(
	e_id int,
	c_id int,
	primary key(e_id,c_id),
	foreign key(e_id) references etudiants,
	foreign key(c_id) references cours(c_id)
	);

---------
insert into etudiants values(051135593,'Marie Blanche','Anglais','Master 1',21);
insert into etudiants values(060839453,'Charles Harry','Architecture','Master 1',22);
insert into etudiants values(099354543,'Susanne Martin','Droit','Licence 3',20);
insert into etudiants values(112348546,'Joseph Thomas','Informatique','Licence 2',19);
insert into etudiants values(115987938,'Christophe Cordier','Informatique','Licence 3',20);
insert into etudiants values(132977562,'Angela Martinet','Histoire','Master 1',20);
insert into etudiants values(269734834,'Thomas Robet','Psychologie','Licence 2',18);
insert into etudiants values(280158572,'Margarethe Cousin','Medecine Veterinaire','Licence 1',18);
insert into etudiants values(301221823,'Jean Robinet','Psychologie','Licence 3',20);
insert into etudiants values(318548912,'Dorothee Lechemin','Finance','Licence 1',18);
insert into etudiants values(320874981,'Daniel Lemaire','Electronique','Licence 1',17);
insert into etudiants values(322654189,'Lisa Marcheur','Informatique','Licence 2',17);
insert into etudiants values(348121549,'Paul Cheminot','Informatique','Licence 3',18);
insert into etudiants values(351565322,'Nancy Alain','Comptabilite','Licence 3',19);
insert into etudiants values(451519864,'Marc Jeune','Finance','Licence 1',18);
insert into etudiants values(455798411,'Louis Fernand','Electronique','Licence 1',17);
insert into etudiants values(462156489,'Damien Leroi','Mecanique','Licence 2',19);
insert into etudiants values(550156548,'Georges Watteau','Pedagogique','Master 1',21);
insert into etudiants values(552455318,'Anna Lopet','MIAGE','Master 1',19);
insert into etudiants values(556784565,'Morgan Monl','Genie Civil','Master 1',21);
insert into etudiants values(567354612,'Seraphine El Smail','MIAGE','Licence 1',18);
insert into etudiants values(573284895,'Stephane Vert','Kinesitherapie','Licence 2',19);
insert into etudiants values(574489456,'Betty Alambert','Economie','Licence 3',20);
insert into etudiants values(578875478,'Eduouard Blanchet','Medecine Veterinaire','Master 1',21);
------------
insert into profs values(142519864,'I. Boulala',20);
insert into profs values(242518965,'Anael Klein',68);
insert into profs values(141582651,'Joris Robillard',20);
insert into profs values(011564812,'Laura Giacco',68);
insert into profs values(254099823,'Patricia Jones',68);
insert into profs values(356187925,'Victor Goron',12);
insert into profs values(489456522,'Linda Mariencourt',20);
insert into profs values(287321212,'Valentin Owczarek',12);
insert into profs values(248965255,'Brahim Akouz',12);
insert into profs values(159542516,'Astelia Massamba',33);
insert into profs values(090873519,'Hugo Ermenidis',11);
insert into profs values(486512566,'Boubacar Diallo',20);
insert into profs values(619023588,'Justin Dutoit',11);
insert into profs values(489221823,'Nadir Trabelsi',33);
insert into profs values(548977562,'Ulysses Boulala',20);
------------
insert into cours values(1,'Structures de Donnees','LuMeVe 10','R128',489456522);
insert into cours values(2,'Systemes de Bases de Donnees','LuMeVe 12:30-1:45','1320 DCL',142519864);
insert into cours values(3,'Conception de Systemes d Exploitation','MaJeu 12-1:20','20 AVW',489456522 );
insert into cours values(4,'Psychologie',null,'null',619023588);
insert into cours values(5,'Archeologie des Incas','LuMeVe 3-4:15','R128',248965255);
insert into cours values(6,'Analyse d Accidents Aeronautiques','MaJeu 1-2:50','Q3',011564812);
insert into cours values(7,'Gestion de la qualite d air','MaJeu 10:30-11:45','R15',011564812);
insert into cours values(8,'Introduction au Latin','LuMeVe 3-4:15','R12',248965255);
insert into cours values(9,'Partis politiques francais','MaJeu 2-3:15','20 AVW',619023588);
insert into cours values(10,'Cognition Sociale','Ma 6:30-8:40','R15',159542516);
insert into cours values(11,'Perception','LuMaMeJeu 3','Q3',489221823);
insert into cours values(12,'Analyse multivariee','MaJeu 2-3:15','R15',090873519);
insert into cours values(13,'Droit des brevets','Ve 1-2:50','R128',090873519);
insert into cours values(14,'Economie Urbaine','LuMeVe 11','20 AVW',489221823);
insert into cours values(15,'Chimie organique','MaJeu 12:30-1:45','R12',489221823);
insert into cours values(16,'Marketing','LuMe 10-11:15','1320 DCL',489221823);
insert into cours values(17,'Art italien de la renaissance','Lu 4','R15',489221823);
insert into cours values(18,'Mecanique des orbites','LuMeVe 8','1320 DCL',011564812);
insert into cours values(19,'Elevage bovin','MaJeu 12:30-1:45','R128',356187925);
insert into cours values(20,'Reseaux de communication','MaMe 9:30-10:45','20 AVW',141582651);
Insert into cours values(21,'Electronique optique','MaJeu 12:30-1:45','R15',254099823);
insert into cours values(22,'Intelligence artificielle',null,'UP328',null);
insert into cours values(23,'Introduction a l Algebre Lineaire','MaJeu 8-9:30','R128',489221823);
-------------

insert into participer values(112348546,2);
insert into participer values(115987938,2);
insert into participer values(348121549,2);
insert into participer values(322654189,2);
insert into participer values(552455318,2);
insert into participer values(455798411,3);
insert into participer values(552455318,3);
insert into participer values(567354612,3);
insert into participer values(112348546,3);
insert into participer values(115987938,3);
insert into participer values(322654189,3);
insert into participer values(567354612,1);
insert into participer values(552455318,20);
insert into participer values(455798411,21);
insert into participer values(455798411,15);
insert into participer values(301221823,11);
insert into participer values(301221823,10);
insert into participer values(301221823,1);
insert into participer values(556784565,7);
insert into participer values(099354543,7);
insert into participer values(322654189,13);
insert into participer values(574489456,14);

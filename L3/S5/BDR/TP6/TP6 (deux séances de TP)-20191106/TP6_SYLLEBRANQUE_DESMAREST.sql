-----Q1
select eid, max(portee) from Employes natural join Certifications natural join Avions group by eid having count(aid)>1


-----Q2
select enom from Employes natural join Certifications where salaire < all(select prix from Vols where dep='CDG' and arr='NOU')


-----Q3
------Sans exists :
select dep, arr, distance from Vols where distance<all(select dep, arr, distance from Vols where distance<all(select max(portee) from Certifications natural join Employes natural join Avions where salaire>100000 group by eid))

------Avec exists :
select dep, arr, distance from Vols where not exists (select max(portee) from Certifications natural join Employes natural join Avions where salaire>100000 group by eid having distance>max(portee))


-----Q4
------Avec exists :
select distinct(enom) from(Employes natural join Certifications) as c1 where not exists (select enom from (Employes natural join Certifications natural join Avions) as c2 where portee<1500 and c1.eid = c2.eid) order by enom

------Avec group by :
select enom from Employes natural join Certifications natural join Avions group by eid having bool_and(portee>1500)


-----Q5
select enom from Employes natural join Certifications natural join Avions group by eid having bool_and(portee>1500) and count(aid) > 1


-----Q6
select enom from Employes natural join Certifications natural join Avions group by eid having bool_and(portee>1500) and bool_or(anom like 'Boeing%') order by enom


-----Q7
select eid from Employes where salaire = (select max(salaire) from Employes where eid<>(select eid from Employes where salaire=(select max(salaire) from Employes)))


-----Q8
select enom from Employes natural join Certifications natural join Avions group by eid having bool_or(portee>2000) and bool_and(anom not like '%Boeing%') order by enom


-----Q9
select enom, salaire from Employes where salaire > (select avg(salaire) from Employes natural join Certifications) and not exists (select * from Employes natural join Certifications)


-----Q10
select((select avg(salaire) from Employes as e1 where exists (select eid from Certifications as e2 where e1.eid = e2.eid)) - (select avg(salaire) from Employes)) as diff_salaire


-----Q11
create or replace view arrivee as 
select * from vols where arr = 'New York' and extract(hour from h_arr)<18;

select h_dep, vid from arrivee where dep = 'Madison'
union
select v1.h_dep, v1.vid from vols as v1 join arrivee as a on v1.arr = a.dep and v1.h_arr < a.h_dep
union
select v1.h_dep, v1.vid from vols as v1 join vols as v2 on (v1.arr = v2.dep and v1.h_arr < v2.h_dep) join arrivee as a on v2.arr = a.dep and v2.h_arr < a.h_dep

-----Q12
------Il faut utiliser une requête recursive.


DROP table IF EXISTS empleado;

create table empleado(
	id int auto_increment,
	trabajo varchar(250),
	salario double
);

insert into empleado (trabajo, salario)values('profesor',2000);
insert into empleado (trabajo, salario)values('futbolista',10000);
insert into empleado (trabajo, salario)values('abogado',3000);
insert into empleado (trabajo, salario)values('programador',2500);
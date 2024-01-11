create table articulos (
	id integer primary key not null,
	nombre varchar(30) not null,
	unidad varchar(10) not null,
	clave varchar(30) not null,
	precio double not null
);

create table eventos (
	id integer primary key auto_increment not null,
	evento varchar(10) not null,
	fecha datetime not null
);

delimiter //
create trigger fecha_eventos_trigger
before insert on eventos
for each row
begin
	set new.fecha = now();
end;
delimiter ;








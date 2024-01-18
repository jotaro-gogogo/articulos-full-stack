create table products (
	id integer primary key not null,
	name varchar(30) not null,
	unit varchar(10) not null,
	product_key varchar(30) not null,
	price double not null,
	check (char_length(product_key) >= 3 and char_length(product_key) <= 30),
	check (char_length(name) <= 30)
);

create table events_log (
	id integer primary key auto_increment not null,
	txn varchar(10) not null,
	txn_date datetime not null
);

insert into products values(0, "", "", "000", 0.0);

select * from products;
select * from events_log;

truncate table products;

drop table eventos;
drop table articulos;

delimiter //
-- create trigger fecha_eventos_trigger
-- before insert on eventos
-- for each row
-- begin
--	set new.fecha = now();
-- end;

create trigger events_log_insert
after insert on products
for each row
begin
	insert into events_log(txn, txn_date) values("INSERT", now());
end;

create trigger events_log_update
after update on products
for each row
begin
	insert into events_log(txn, txn_date) values("UPDATE", now());
end;

create trigger events_log_delete
after delete on products
for each row
begin
	insert into events_log(txn, txn_date) values("DELETE", now());
end;

delimiter ;
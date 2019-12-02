create table students (
	id int(5) auto_increment,
	name varchar(20),
	email varchar(20) unique,
	address varchar(10),
	phone_no varchar(10),
	course_name varchar(15),
	marks decimal(4,1),
	primary key pk(id)
);

insert into students values (
	default,
	'Sonali',
	's@gmail',
	'Pune',
	'12345',
	'DAC',
	70.2
);
insert into students values (
	default,
	'Aditi',
	'a@gmail',
	'Pune',
	'12345',
	'DITISS',
	68
);
insert into students values (
	default,
	'Priya',
	'p@gmail',
	'Pune',
	'12345',
	'DITISS',
	67.5
);
insert into students values (
	default,
	'Pankaj',
	'pa@gmail',
	'Pune',
	'12345',
	'DAC',
	70.1
);
insert into students values (
	default,
	'Imran',
	'i@gmail',
	'Pune',
	'12345',
	'DITISS',
	70.1
);
insert into students values (
	default,
	'Manika',
	'm@gmail',
	'Pune',
	'12345',
	'DAC',
	70.3
);

-- QUERIES FOR THE PROGRAM
select count(*) from students where course_name=? group by course_name;
select * from students where course_name=?;

select name from students where id=?;
update students set marks=?, phone_no=? where id=?;

select id from students where email=?;
delete from students where email=?;
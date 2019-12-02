-- TABLE DEFINITION

create table courses (
	id int auto_increment,
	name varchar(20) unique,
	fees decimal(10,2),
	start_date date,
	end_date date,
	primary key pkc(id)
);

create table students (
	id int auto_increment,
	name varchar(20),
	email varchar(20) unique,
	address varchar(30),
	dob date,
	marks int default 0,
	course_id int,
	primary key pks(id),
	foreign key fks(course_id) references courses(id)
	on update cascade on delete set null
);

-- DATA ENTRY

insert into courses values (
	default,'Core Java',1000,'2019-10-10','2019-11-06'
);
insert into courses values (
	default,'Advanced Java',5000,'2019-11-07','2019-11-20'
);
insert into courses values (
	default,'DS&Algo',4000,'2019-09-05','2019-09-19'
);

insert into students values (
	default, 'Sonali','s@gmail','Pune','1994-01-29',32,3
);
insert into students values (
	default, 'Aditi','a@gmail','Pune','1994-12-22',30,3
);
insert into students values (
	default, 'Priya','p@gmail','Pune','1993-08-08',29,3
);
insert into students values (
	default, 'Pankaj','pa@gmail','Pune','1994-01-29',32,2
);
insert into students values (
	default, 'Kashmira','ka@gmail','Pune','1994-01-29',31,2
);
insert into students values (
	default, 'Shivani','sh@gmail','Pune','1994-01-29',30,2
);
insert into students values (
	default, 'Archit','ar@gmail','Pune','1994-01-29',30,2
);
insert into students values (
	default, 'Vaishnavi','v@gmail','Pune','1994-01-29',32,1
);
insert into students values (
	default, 'Kashish','k@gmail','Pune','1994-01-29',33,1
);
insert into students values (
	default, 'Sumeet','su@gmail','Pune','1994-01-29',30,1
);
insert into students values (
	default, 'Sonal','so@gmail','Pune','1994-01-29',31,1
);
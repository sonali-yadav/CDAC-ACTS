create table stocks (
	id int(5) auto_increment,
	name varchar(20),
	company varchar(20),
	price decimal(6,1),
	quantity int(5),
	closing_date date,
	primary key pk(id)
);

insert into stocks values (
	default,
	'Shares',
	'Reliance',
	80000,
	100,
	'2019-10-11'
);

insert into stocks values (
	default,
	'Cows',
	'Patanjali',
	50000,
	500,
	'2019-11-11'
);

insert into stocks values (
	default,
	'Gold Bricks',
	'Gitanjali',
	90000,
	900,
	'2019-12-11'
);

insert into stocks values (
	default,
	'Shares',
	'Birla Group',
	50000,
	800,
	'2019-10-12'
);
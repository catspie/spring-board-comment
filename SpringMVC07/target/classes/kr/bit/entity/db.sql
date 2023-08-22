-- TBL BOARD --
create table tblBoard{
	idx int not null, 
	memId varchar(20) not null, 
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(30) not null,
	indate datetime default now(), 
	count int defualt 0, 
	boardGroup int, 
	boardSequence int 
	boardLevel int, 
	boardAvaliable int, 
	primary key(idx)
};


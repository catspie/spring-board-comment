-- TBL BOARD --
create table tblBoard(
	idx int not null, 
	memId varchar(20) not null, 
	title varchar(100) not null,
	content varchar(2000) not null,
	writer varchar(30) not null,
	indate datetime default now(), 
	count int default 0, 
	boardGroup int, 
	boardSequence int, 
	boardLevel int, 
	boardAvaliable int, 
	primary key(idx)
);

select max(idx) from tblBoard; -- NULL > 1, 2+1 > 3
select IFNULL(max(idx)+1, 1) from tblBoard; 
select IFNULL(max(boardGroup)+1, 0) from tblBoard;

-- select 및 IFNULL함수를 사용해 값 넣어주기 
insert into tblBoard 
select IFNULL(max(idx)+1, 1),
'bit01', 
'게시판연습', 
'게시판연습', 
'관리자',
now(), 
0, 
IFNULL(max(boardGroup)+1, 0), 
0, 
0, 
1
from tblBoard;

-- select 및 IFNULL함수를 사용해 값 넣어주기 
insert into tblBoard 
select IFNULL(max(idx)+1, 1),
'bit02', 
'게시판연습', 
'게시판연습', 
'유선영',
now(), 
0, 
IFNULL(max(boardGroup)+1, 0), 
0, 
0, 
1
from tblBoard;

-- select 및 IFNULL함수를 사용해 값 넣어주기 
insert into tblBoard 
select IFNULL(max(idx)+1, 1),
'bit03', 
'게시판연습', 
'게시판연습', 
'홍길동',
now(), 
0, 
IFNULL(max(boardGroup)+1, 0), 
0, 
0, 
1
from tblBoard;

select * from tblBoard;

-- TBL MEMBER --
create table tblMember(
	memId varchar(50) not null,
	memPwd varchar(50) not null, 
	memName varchar(50) not null, 
	memPhone varchar(50) not null, 
	memAddr varchar(100), 
	latitude decimal(13,10), --현재 위치 위도
	longitude decimal(13,10), --현재 위치 경도
	primary key(memId)
);

insert into tblMember (memId, memPwd, memName, memPhone) 
values ('bit01','bit01','관리자','010-1111-1111');
insert into tblMember (memId, memPwd, memName, memPhone) 
values ('bit02','bit02','유선영','010-2222-2222');
insert into tblMember (memId, memPwd, memName, memPhone) 
values ('bit03','bit03','홍길동','010-3333-3333');

select * from tblMember;

select * from tblBoard;
delete from tblBoard where idx = 1;
delete from tblBoard where idx = 2;
delete from tblBoard where idx = 3;

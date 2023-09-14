create table board_table(
id bigint auto_increment primary key,
boardWriter varchar(50),
boardPass varchar(20),
boardTitle varchar(50),
boardContents varchar(500),
createdAt datetime default now(),
boardHits int default 0,
fileAttached int default 0,
memberId bigint,
constraint foreign key (memberId) references member_table(id) on delete cascade
);

create table board_file_table(
id bigint auto_increment primary key,
originalFileName varchar(100),
storedFileName varchar(100),
boardId bigint,
constraint foreign key (boardId) references board_table(id) on delete cascade
);

create table member_file_table(
id bigint auto_increment primary key,
originalFileName varchar(100),
storedFileName varchar(100),
memberId bigint,
constraint foreign key (memberId) references member_table(id) on delete cascade
);

drop table board_table;

drop table board_file_table

desc board_table;
desc member_table;

create table comment_table(
commentWriter varchar(50),
id bigint auto_increment primary key,
commentContents varchar(500),
commentCreatedDate datetime default now(),
boardId bigint,
constraint foreign key (boardId) references member_table(id) on delete cascade
);



drop table comment_table;


select * from comment_table;

select * from member_table where memberEmail = 123 and memberPassword = 123

select * from comment_table where commentWriter like "%ㄴㅇ";

select * from member_table;


desc member_table;

desc member_file_table;

alter table member_table add fileAttached int default 0;

drop table member_table;




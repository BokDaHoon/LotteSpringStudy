create table users(
	ID varchar2(8) primary key,
    Password varchar2(8),
	name varchar2(20),
	role varchar2(5)
);

INSERT into users('test','test123','관리자','Admin');
INSERT into users('user1','user1','홍길동','user');

create table board(
	seq number(5) primary key,
	title varchar2(200),
	writer varchar2(20),
	content varchar2(2000),
	regdate date default sysdate,
	cnt number(5) default 0
);

insert into board(seq,title,writer,content) values(1,'가입인사','관리자','잘부탁드립니다,')
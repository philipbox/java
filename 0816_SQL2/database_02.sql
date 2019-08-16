use testDB;
-- DDL
-- unique를 써줘서 duplicate방지. , 근데 null이 들어가는건 방지 못해. 왜냐면 null은 비교대상이 아니기 때문에.
-- no null을 추가해주면 null도 방지할수 있어.
-- 이 두개를 추가하는 거랑 같은게 primary key (위에 두개 먹인거랑 완전 같은건 아닌데,,- primary key idx때문에, 기능상 같아)
create table SSAFY(num varchar(8) primary key, name varchar(50), jumsu int, gender char(1), regdate datetime);

-- (위에서 check 기능추가) 
-- gender에 m이랑 f 말고 다른 글자가 와도 들어가게 하면 안되잖아. 그래서 check기능을 넣어준다.
create table SSAFY(num varchar(8) primary key, name varchar(50), jumsu int, gender char(1) check(gender in('m','f')) , regdate datetime);


-- 점수 defualt 기능 추가 
create table SSAFY(num varchar(8) primary key
					, name varchar(50)
                    , jumsu int default 0
                    , gender char(1) check(gender in('m','f')) , regdate datetime default current_timestamp);

-- 컬럼 삽입 / 삭제
alter table ssafy add(cnt int default 0);
alter table ssafy drop cnt;

-- table name 변경
rename table ssafy to membername;
rename table membername to ssafy;

desc ssafy;



drop table ssafy;
-- DML
insert into ssafy(num, name, jumsu, gender, regdate)
value ('111111', '홍길동', '100', 'm', '2019-08-16 12:02:11');

insert into ssafy 
value ('222222', '둘리', '90', 'f', now());

insert into ssafy(num, name, gender)
value ('111111', '홍길동', 'm');

-- 데이터 수정 
update ssafy set gender = 'f' where num = '222222';

delete from ssafy where 1;


use scott;
-- view
create view vEmp
as
select concat(ename, '(', sal,')') as name, sal*12 + ifnull(comm,0) , deptno
from emp;

select * from vemp;

-- subquary 
select * from (select concat(ename, '(', sal, ')') as name, sal * 12 + ifnull(comm,0) 연봉, deptno
from emp) as aa;

-- view는 read-only라서 오류가 남
-- insert into vemp(name, 연봉, deptno) values ('111', 1000.3000);
-- ---------------------------------------------------------------------

-- Index
create index idxemp on emp(sal desc);
drop index idxemp on emp;

select *
from emp
where 1
and sal = 800
and ename = 'smith';


-- ------------------------------------------
create user test identified by 'test1';
grant all privileges on *.* to test@'%';




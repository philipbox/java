-- ws 0815
-- 18) 같은 업무를 하는 사람의 수가 4명이상인 업무와 인원수를 검색하세요..
select job, count(job) as num from emp group by job having num >=4;

-- 24) 부서별로 급여의 합계를 구하되 합계가 1000이상인 부서와 합계를 검색하세요.
select deptno, sum(sal) as sum  from emp group by deptno having sum >= 1000;


-- ws 0816
-- 1) create table
create table BOOK(isbn char(8) primary key
				, title varchar(50) not null
				, author varchar(10) not null
                , publisher varchar(15) not null
                , price int not null
                , description varchar(200));
show tables;

-- 2) insert 쿼리 사용 
insert into book values('123-1-14', 'Java와 coffe', 'diana', '자바닷컴', 8000, '삶의 즐거움');
insert into book values('555-23-2', 'AI와 미래', '김현주', '미래닷컴', 20000, '');
insert into book values('123-2-15', 'Java와 놀기', '김태희', '자바닷컴', 22000, 'Java 정복');
insert into book values('123-6-24', 'Java와 알고리즘', '서민규', '자바닷컴', 20000, '성능 업!!');
insert into book values('423-3-36', 'IoT세상', '이세준', '미래닷컴', 25000, '');

select * from book;

-- 3) 모든 가격 10% 인하 수정, 결과 검색
update book set price = price*0.9 where price;
select * from book;

-- 4) 제목에 JAVA가 포함된 도서들 20% 인하, 결과 검색
update book set price = price*0.8 where title like '%Java%';
select * from book;

-- 5) 제목에 Java가 포함된 도서에서 가격이 10000미만 도서는 삭제.
select * from book;
delete from book where title like '%Java%' and price<10000;

-- 6) 출반사별 도서의 개수와 가격의 합계, 가격의 평균 검색.
select publisher, count(*) as '도서개수', sum(price) as '가격 합계', avg(price) as '가격 평균' from book group by publisher;

-- 7) isbn 번호가 '555-23-2'인 도서의 description을 'AI 입문'으로 수정하고 결과.
update book set description = 'AI 입문' where isbn = '555-23-2';
select * from book;

-- 8) isbn번호가 123으로 시작하는 도서의 정보를 검색.
select * from book where isbn like '123%';


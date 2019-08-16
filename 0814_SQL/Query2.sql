show databases;
use scott;
show tables;
desc emp;

select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp;

select * from emp;

select ename, sal, deptno, sal*12 as 연봉찡 from emp;


-- 이름(급여) 출력하세요.
select concat(ename,'(',sal,')') from emp;


-- select now() from dual;
-- select date_add(now(), interval +100 day) from dual;
-- select to_days(now()) - to_days('2019-07-01') as 'SSAFY한지 몇일?' from dual;


-- deptno가 중복되어있어
select ename, deptno from emp; 
-- 중복제거
select distinct job from emp;


select ename, sal, deptno, job
from emp
where 1=1
and sal between 1800 and 3000;
-- and sal <= 3000;


select ename, sal, deptno, job
from emp
where 1=1
and job in('clerk','manager');

-- not의 방법 
-- <>
-- !=
-- not
select ename, sal, deptno, job
from emp
where 1=1
and sal <> 800
and sal != 800
and not sal = 800;


-- between 100 and 300 은 100과 300을 포함한 사잇값.


-- null에 사칙연산을 해도 그대로 null이다. 뒤에 더해줘도 null이야. 
-- null은 비교가 안돼! 찾으려면 is null. 아닌거 찾으려면 is not null
-- ifnull활용해야함! 
select ename, sal, comm, comm+100, sal+comm, sal+ifnull(comm,0)
from emp;
-- where comm is not null;

select ename, sal, job, deptno
from emp
where 1
and sal > 1500
or job= 'clerk'
and deptno in (20,10);

-- 부서번호가 10이고 업무가 manager 이거나 20이고 clerk인 사람을 구하세요.
select *
from emp
where 1
and (deptno,job) in ((10,'manager'), (20, 'clerk'));

-- %s s로 끝나는사람
-- s% s로 시작하는 사람
-- %s% 사이에 s가 있는사람 : 시작과 끝에 s도 나오더라
-- %대신 쓸수있는거 _ 인데, _는 자리수까지 맞춰야해 
select * from emp where ename like '%s%';

-- 2 3 4 1 5로 실행됨 (row먼저 실행하고 col 실행)
select ename, sal, deptno
from emp
where 1
and deptno in (20,30)
and sal > 100
order by sal asc, ename asc;



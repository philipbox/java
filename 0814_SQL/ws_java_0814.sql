-- 광주 B2반 문지환

-- 1)
select * from emp;

-- 2)
select empno, ename, hiredate, sal from emp where ename like 'k%';

-- 3)
select * from emp where extract(year from hiredate) = 2000;

-- 4)
select * from emp where comm is null;


-- 5)
select ename, deptno, sal from emp where deptno=30 and sal>=1500;

-- 6)
select * from emp where DEPTNO=30 order by empno desc;

-- 7)
select * from emp order by sal desc;

-- 8)
select * from emp order by deptno asc, sal desc;

-- 9)
select * from emp order by deptno desc, ename asc, sal desc;

-- 10)
select * from emp;
select ename, sal, sal*comm/100 , sal+ifnull(sal*comm/100,0) from emp order by sal desc;

-- 11)
select ename, sal, sal*0.13 as bonus, deptno from emp;

-- 12)
select ename, round(sal/60, 0) as 'sal/hour' from emp;

-- 13)
select ename, sal, round(sal*0.15, 2) as 회비 from emp where sal>1500 and sal<3000;

-- 14)
select ename, sal, sal-(sal*0.1) as 실수령액 from emp order by sal desc;

-- 15)
select lcase(left(ename, 3)) from emp where length(ename)>=6;

-- 16)
select avg(sal), max(sal), min(sal), count(sal) from emp where deptno=10;

-- 17)
select deptno, job, count(job)
from emp -- 1 
where DEPTNO
group by job, deptno order by DEPTNO asc;

-- 18) skip

-- 19)
select ename, hiredate, to_days(now()) - to_days(hiredate) from emp;

-- 20)
select ename, extract(year from now()) - extract(year from hiredate) from emp;

-- 21)
select empno, ename, hiredate, sal from emp where job='ANALYST';

-- 22)
select distinct deptno from emp;

-- 23)
select deptno, avg(sal) from emp group by deptno;

-- 24) skip

-- 25)
desc emp;
select count(*) from emp;

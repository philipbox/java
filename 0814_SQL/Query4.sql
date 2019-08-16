-- 다중행 함수(집계함수)
-- sum, count, max, min, avg

-- 다중행 함수를 쓰면 1줄(건)으로 바꾼다아
select sum(sal), count(sal), max(sal), min(sal), avg(sal) from emp;

-- 집계함수를 쓴 함수와 쓰지 않은함수를 혼용해서 쓰면 안된다. 
-- 위의 sql문에서 ename을 못쓰는거지,, mysql에서는 에러는 안떠도 목적과 어긋나는것. 다른 컬럼들과 연결성을 전혀 가질 수 없음.

-- 아까 컬럼끼리 더할떄 null에서는 더하면 null이 되어버렸는데, 
-- 집계함수에서는 null을 빼서 해준당 
-- 근데 avg에서는 문제가 됨. 여기는 나눌때 전체사람의 평균인지, null을 제외한사람의 평균인지!!!
-- 확인해보면 avg 는 sum/count야. 
-- 모든 사원을 기준으로 하고싶으면 avg(ifnull(comm))으로 해야함.
select sum(comm), avg(comm), avg(ifnull(comm, 0)),count(comm), count(sal) from emp;

-- 다중행함수는 단일행함수로 감쌀 수 있다.
select ifnull(comm,0) from emp;

-- 단일행함수는 다중행 함수를 감쌀 수 있다. 
select round(avg(ifnull(comm,0))) from emp;

-- 다중행함수는 다중행함수를 감쌀 수 없다.
-- select count(max(sal)) from dual;

select sum(sal) 
from emp
where deptno = 10;

select sum(sal) 
from emp
where deptno = 20;

select sum(sal) 
from emp
where deptno = 30;

-- 위에처럼 얼마 없으면 상관없어도 엄청 많으면 힘들잖앙
select distinct deptno from emp;


-- 급여가 1000이상인 사원의 부서별 급여계산등등을 급여의 역순으로 출력
select deptno, sum(sal), avg(sal), max(sal), count(sal) -- 4
from emp -- 1 
where sal>=1000 -- 2
group by deptno -- 3
order by sum(sal) desc; -- 5




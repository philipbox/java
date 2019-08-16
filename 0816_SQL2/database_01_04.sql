-- 다중행함수(집계함수)
-- sum, count, max, min, avg
select ename, sum(sal) , avg(sal), count(sal), max(sal), min(sal)
from emp;

select sum(comm)/count(ifnull(comm,0)) , avg(comm), avg(ifnull(comm,0)), count(comm),count(sal)
from emp;

select round(avg(ifnull(comm,0))) from emp;

select count(max(sal)) from dual;

select sum(sal) 
from emp
where deptno = 10;
select sum(sal) 
from emp
where deptno = 20;
select sum(sal) 
from emp
where deptno = 30;

select distinct deptno from emp;

-- 급여가 1000 이상인 사원들의 부서별 급여계산등등 을 급여의 역순으로 출력 
select deptno, sum(sal),avg(sal),max(sal),min(sal),count(sal)
from emp
where sal >=1000
group by deptno
order by sum(sal) desc;

-- group by deptno을 넣지 않고 job만하게 되면 의미없는 집계가 된다. 
select job, deptno, sum(sal), max(sal), min(sal), count(sal)
from emp
group by job , deptno order by job;  -- job으로 그룹핑하고, deptno로 그룹핑을 또 하겠당

select distinct job, deptno from emp order by job;


-- 부서별 급여 합계를 구하는데, 급여의 합계가 3000원 이상인 부서만 구하여라.
select deptno, sum(sal) 
from emp 
group by deptno 
having sum(sal) > 9000;



select deptno, job, sum(sal) 
from emp
group by deptno, job;

select deptno
	,sum(case when job='clerk' then sal else 0 end) as clerk 
	,sum(case when job='manager' then sal else 0 end) as manager 
	,sum(case when job='president' then sal else 0 end) as president
	,sum(case when job='analyst' then sal else 0 end) as analyst
	,sum(case when job='salesman' then sal else 0 end) as salesman
    ,sum(sal) as TOTAL
from emp
group by deptno;



-- 합계뽑는 것 (1)
select ifnull(deptno,'합계') as deptno, ifnull(job, case when deptno is null then '합계' else '소계' end) as job, sum(sal)
from emp
group by deptno, job with rollup;


-- 합계 뽑는 것 (2)
select ifnull(deptno,'합계') as deptno
 , case when job is null then case when deptno is null then '합계' else '소계' end else job end as job
 , sum(sal)
from emp
group by deptno, job with rollup;
-- limit 4;
-- limit 1,3;

-- limit은 standard sql은 아닌데, 나오는 츨력 개수를 컨트롤 할수있는것.

select deptno, sum(sal)
from emp
where deptno = 10
union all
select deptno, sum(sal)
from emp
where deptno = 20


select abs(12), abs(-12);
select sign(-4), sign(12), sign(0);
select 123.1234, round(125.6534, -1);

-- ceil안에 적인 숫자에서 가장 가까운 큰정수
select 123.123, ceil(123.123), floor(123.123);
select mod(6,4), pow(3,2), greatest(12,13,14,11);

select interval (4,1,2,3,5,6), rand();


select floor(mod(rand()*100, 56))+1 from dual;

-- 문자내장함수 alter
select ename, lower(ename), upper(ename) from emp;
select concat('abc','def');
select substr('20180912', 7,2);
select instr('20190802', '3');



select ename, sal
from emp
where instr(ename, 'A' ) = 0;


select substr('admin@ssafy.com', 1, instr('admin@ssafy.com', '@')-1);
select substr('admin@ssafy.com', instr('admin@ssafy.com', '@')+1);

-- 여기 다시 하나하나 봐보자 rpad 랑 trim
select ename, lpad(ename, 10,'*'), rpad(ename,10,'*') from emp;
select ename, lpad(ename, 10,'*'), rpad(ename,10,'*') from emp;
select length(lpad(ename, 10,'*')), length(trim(rpad(ename,10,'*')))from emp;
select length(lpad(ename, 10,'*')), length(trim(rpad(ename,10,'')))from emp;
select length(trim(' a bcd '));
-- trim은 양쪽 끝의 공백을 지운다.

-- 날짜 내장 함수
select now(), sysdate(), current_date(), curdate(), current_time(), curtime();
select year(now()), month(now()), day(now())
, extract(year from now()), extract(month from now()), extract(day from now());

select year('2018-08-12'), extract(year from '2018-08-12');

select date_add(now(), interval 2 year );
select date_add(now(), interval 2 day );
select date_add(now(), interval -2 day );
select day(date_sub(now(), interval 2 year ));
select day(date_sub(now(), interval 2 day ));


-- case 표현식 when 비교값 1 then 결과값1
		--   when 비교2 then 결과값2
        --   else 결과값3
        
select if(3<4, '참', '거짓') from dual;


select case substr('880818-1234567', 8, 1)
			when '1' then '남성'
            when '3' then '남성'
            else '여성'
            end as '성별';
		
        
-- 부등호비교
-- case when 표현식 >= 비교1 then 결과값1
--      when 표현식 <= 비교2 then 결과값2
--                else 결과값3
--        end;

SELECT 
    ename,
    sal,
    job,
    CASE
        WHEN sal > 3000 THEN '와 많이번다'
        WHEN sal > 2000 THEN '많이번다'
        WHEN sal > 1000 THEN '번다'
        ELSE '조금번다'
    END AS '급여'
FROM
    emp;
    
    
select date_format(now(), '%Y-%m-%b %H:%i:%s') from dual;

select sal,format(sal, '#,###,###')  from emp;


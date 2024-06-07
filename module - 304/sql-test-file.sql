-- select distinct country from offices;
-- select distinct firstname from offices;

-- I want to see all employees that work in an office in the USA
select * from employees;
select * from offices;
select e.*, o.city
from employees e, offices o
where e.office_id = o.id
	and o.country = 'USA';


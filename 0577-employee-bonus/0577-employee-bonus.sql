# Write your MySQL query statement below
select e.name, b.bonus from employee as e left join 
bonus as b on e.empId = b.empId
where ifnull(b.bonus,0) < 1000;
#ifnull returns first value if the value is not null and returns second value if its null
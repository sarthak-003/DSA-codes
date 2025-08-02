# Write your MySQL query statement below
-- SELECT e1.name
-- FROM employee e1
-- JOIN employee e2 ON e1.id = e2.managerId
-- GROUP BY e1.id, e1.name
-- HAVING COUNT(e2.id) >= 5;


select name from employee
where id in (
    select managerId 
    from employee 
    where managerId is not null
    group by managerID
    having count(*)>=5
);
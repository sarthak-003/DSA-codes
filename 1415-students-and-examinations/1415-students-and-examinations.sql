# Write your MySQL query statement below

select s.student_id, s.student_name, su.subject_name,coalesce(count(e.student_id),0) as attended_exams
from 
students s cross join subjects su left join examinations e 
on s.student_id = e.student_id and su.subject_name = e.subject_name
group by s.student_id, s.student_name, su.subject_name
order by s.student_id , su.subject_name;
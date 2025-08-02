# Write your MySQL query statement below
-- select contest_id, round(count(r.user_id) / (select count(*) from users) * 100,2) as percentage
-- from users u join register r 
-- on u.user_id = r.user_id
-- group by contest_id
-- order by percentage desc , contest_id;


select contest_id , round( count(user_id) / (select count(*) from users) * 100 , 2) as percentage
from register
group by contest_id
order by percentage desc, contest_id;
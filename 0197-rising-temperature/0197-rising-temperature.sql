# Write your MySQL query statement below
select w1.id 
from Weather w1 , Weather w2
where w2.recordDate = w1.recordDate - Interval 1 day and w1.temperature > w2.temperature;


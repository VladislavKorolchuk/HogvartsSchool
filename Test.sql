Select Count (*) as countStudent from Student;
Select Count(*) as countStudent, Sum(age) as ageStudent, Sum(age)/Count(*) as age from Student;
Select Sum(age)/Count(*) as age from Student;
Select * from student order by id desc limit (5);

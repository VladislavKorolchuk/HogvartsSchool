Select Student.name As Name, Student.age As age, faculty.name As faculty from student
         INNER JOIN Faculty faculty on student.faculty_id = faculty.id order by faculty.name;

Select Student.name, Student.age from Student
         INNER JOIN Avatar avatar on student.id = avatar.student_id;
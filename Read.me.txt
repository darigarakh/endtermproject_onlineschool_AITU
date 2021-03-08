The goal of our project is to show the school's teaching system as well as to develop a convenient system for finding information about students to teachers and vice versa, and in our system it is more convenient to work with the disciplines of a student's courses to find information about courses.


IGroupRepository:receieve information from database
StudentController:receieve information from database
IDB:interface to all databases(postgre mysql etc.)
Postgres:connect to database
GroupRepository:store male and female count,sql query,execute query,add data from all rows,check if male or not,return data from database
IGroupRepository:interface for repository
IStudentRepository:interface for repository
StudentRepository:store database,receieve all students from database, add data from all rows and  return them
Application:declare controllers,show all students,show students from group,show courses of student,show group info and others
Main:create repositoriies,create applocation variable,start our starting function from application
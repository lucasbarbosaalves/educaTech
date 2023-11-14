DROP TABLE IF EXISTS COURSE;
DROP TABLE IF EXISTS STUDENT;
--
CREATE TABLE IF NOT EXISTS COURSE (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    category VARCHAR(255),
    duration INT,
    teacher VARCHAR(255),
    description VARCHAR(255),
    id_student INT
);
CREATE TABLE IF NOT EXISTS STUDENT(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password varchar(50)
);
-- ALTER TABLE COURSE
--    ADD FOREIGN KEY (id_student)
--        REFERENCES STUDENT(id);

INSERT INTO COURSE (name,category,duration,teacher,description,id_student)VALUES ('Java','BACKEND',40,'Lucas','Java course',1);
INSERT INTO COURSE (name,category,duration,teacher,description,id_student)VALUES ('Java','BACKEND',40,'Lucas','Java course',1);
INSERT INTO COURSE (name,category,duration,teacher,description,id_student)VALUES ('Java','BACKEND',40,'Lucas','Java course',1);

INSERT INTO COURSE (name,category,duration,teacher,description,id_student)VALUES ('HTML','FRONTEND',40,'Lucas','HTML course',1);
INSERT INTO COURSE (name,category,duration,teacher,description,id_student)VALUES ('HTML','FRONTEND',40,'Lucas','HTML course',1);
INSERT INTO COURSE (name,category,duration,teacher,description,id_student)VALUES ('HTML','FRONTEND',40,'Lucas','HTML course',1);


INSERT INTO COURSE (name,category,duration,teacher,description,id_student)VALUES ('Python','DATASCIENCE',40,'Lucas','Python course',1);
INSERT INTO COURSE (name,category,duration,teacher,description,id_student)VALUES ('Python','DATASCIENCE',40,'Lucas','Python course',1);
INSERT INTO COURSE (name,category,duration,teacher,description,id_student)VALUES ('Python','DATASCIENCE',40,'Lucas','Python course',1);


INSERT INTO STUDENT (name,email,password)VALUES
('lucas','lucas@gmail.com','123');
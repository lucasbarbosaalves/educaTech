DROP TABLE IF EXISTS COURSE;
DROP TABLE IF EXISTS STUDENT;
--
CREATE TABLE IF NOT EXISTS COURSE (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
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
--ALTER TABLE COURSE
--    ADD FOREIGN KEY (id_student)
--        REFERENCES STUDENT(id_student);

INSERT INTO COURSE (name,description,duration,teacher)VALUES
('BACKEND','Curso de Java' , 32,'Enoque Leal');

INSERT INTO COURSE (name,description,duration,teacher)VALUES
    ('FRONTEND','Curso de HTML' , 32,'Enoque Leal');

INSERT INTO COURSE (name,description,duration,teacher)VALUES
    ('DATA SCIENCE','Curso de SQL' , 32,'Enoque Leal');

INSERT INTO STUDENT (name,email,password)VALUES
('lucas','lucas@gmail.com','123');
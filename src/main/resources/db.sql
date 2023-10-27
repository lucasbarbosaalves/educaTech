CREATE TABLE COURSE (
    id INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    duration INT,
    teacher VARCHAR(255),
    id_student INT
);
CREATE TABLE STUDENT(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password varchar(50)
);
--ALTER TABLE COURSE
--    ADD FOREIGN KEY (id_student)
--        REFERENCES STUDENT(id_student);

--INSERT INTO COURSE (name,duration,id_teacher)VALUES
--('example1','32','3432543');

INSERT INTO STUDENT (name,email,password)VALUES
('lucas','lucas@gmail.com','123');
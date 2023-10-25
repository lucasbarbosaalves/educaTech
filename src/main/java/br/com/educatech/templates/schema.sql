CREATE TABLE COURSE (
    id_course INTEGER AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    duration INT,
    id_teacher INT,
    id_student INT
);
CREATE TABLE STUDENT(
    id_student INT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    password varchar(50)
);
ALTER TABLE COURSE
    ADD FOREIGN KEY (id_student)
        REFERENCES STUDENT(id_student);


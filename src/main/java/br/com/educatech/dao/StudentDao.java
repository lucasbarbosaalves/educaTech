package br.com.educatech.dao;

import br.com.educatech.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDao {

    public void create(Student student) throws SQLException {

        String SQL = "INSERT INTO Student (ID, NAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setLong(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setString(3, student.getEmail());
            preparedStatement.setString(4, student.getPassword());
            preparedStatement.execute();

            System.out.println("success in insert student");

            connection.close();


        } catch (Exception e) {

            System.out.println("fail in database connection");
        }

    }

    public List<Student> findAll() {
        String SQL = "SELECT * FROM Student";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                Student student = new Student(id, name, email, password);

                students.add(student);
            }

            System.out.println("success in select students");

            connection.close();

            return students;

        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("fail in database connection");

            return Collections.emptyList();
        }

    }
}

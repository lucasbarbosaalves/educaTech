package br.com.educatech.dao;

import br.com.educatech.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDao {

    public void create(Student student) throws SQLException {

        String SQL = "INSERT INTO Student (name, email, password) VALUES (?, ?, ?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getPassword());

            preparedStatement.execute();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                student.setId(generatedKeys.getInt(1));
            } else {
                throw new RuntimeException("Failed to generate ID for new student");
            }

            System.out.println("success in insert student");

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("fail in database connection" + e.getMessage());
        }

    }

    public List<Student> findAll() {
        String SQL = "SELECT * FROM Student";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");

                Student student = new Student(name, email, password);

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

    public void update(Student student) throws SQLException {
        String SQL = "UPDATE Student SET name = ?, email = ?, password = ? WHERE id = ?";

        if (student.getId() == null) {
            throw new IllegalArgumentException("The ID cannot be null.");
        }


        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getPassword());
            preparedStatement.setInt(4, student.getId());

            preparedStatement.executeUpdate();

            System.out.println("success in update student");

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("fail in database connection" + e.getMessage());
        }

    }

    public void delete(Integer id) throws SQLException {
        String SQL = "DELETE FROM Student WHERE id = ?";

        try {
            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

            System.out.println("success in delete student");

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("fail in database connection" + e.getMessage());
        }

    }
}

package br.com.educatech.dao;

import br.com.educatech.config.ConnectionPoolConfig;
import br.com.educatech.models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentDao {

    public void create(Student student) throws SQLException {

        String SQL = "INSERT INTO STUDENT (NAME, EMAIL, PASSWORD) VALUES(?, ?, ?)";

        try {

            Connection connection = ConnectionPoolConfig.getConnection();
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setString(3, student.getPassword());

            preparedStatement.execute();

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
            Connection connection = ConnectionPoolConfig.getConnection();
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
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

    public void update(Student student) throws SQLException {
        String SQL = "UPDATE Student SET name = ?, email = ?, password = ? WHERE id = ?";

        if (student.getId() == null) {
            throw new IllegalArgumentException("The ID cannot be null.");
        }


        try {
            Connection connection = ConnectionPoolConfig.getConnection();
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
            Connection connection = ConnectionPoolConfig.getConnection();
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

    public boolean verifyCredentials(Student user) {

        String SQL = "SELECT * FROM STUDENT WHERE EMAIL = ? AND PASSWORD = ?";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();

            System.out.println("success in select username");

            while (resultSet.next()) {

                String password = resultSet.getString("password");

                System.out.println("password from database: " + password);
                System.out.println("password from user: " + user.getPassword());

                if (password.equals(user.getPassword())) {
                    return true;
                }
            }
            connection.close();

            return false;

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

            return false;

        }

    }

}

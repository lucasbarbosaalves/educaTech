package br.com.educatech.dao;

import br.com.educatech.config.ConnectionPoolConfig;
import br.com.educatech.models.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseDao {

    // Buscando todos os cursos (Omitiando categoria)
    public List<Course> findAll() {
        String SQL = "SELECT * FROM COURSE";

        try {
            Connection connection = ConnectionPoolConfig.getConnection();
            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Course> courses = new ArrayList<>();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                String teacher = resultSet.getString("teacher");
                Integer duration = resultSet.getInt("duration");

                Course course = new Course(name, description, teacher, duration );

                courses.add(course);
            }

            System.out.println("success in select courses");

            connection.close();

            return courses;

        } catch (SQLException e) {
            e.printStackTrace();

            System.out.println("fail in database connection");

            return Collections.emptyList();
        }

    }
}

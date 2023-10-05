package br.com.educatech.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDao {

    public void createCar(Student car) {

        String SQL = "INSERT INTO Student (NAME) VALUES (?)";

        try {

            Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa","sa");

            System.out.println("success in database connection");

            PreparedStatement preparedStatement = connection.prepareStatement(SQL);

            preparedStatement.setString(1, car.getName());
            preparedStatement.execute();

            System.out.println("success in insert student");

            connection.close();

        } catch (Exception e) {

            System.out.println("fail in database connection");

        }

    }
}

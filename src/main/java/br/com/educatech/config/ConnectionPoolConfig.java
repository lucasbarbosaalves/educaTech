package br.com.educatech.config;

import jdk.jfr.StackTrace;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionPoolConfig {

    private static BasicDataSource dataSource;

    private ConnectionPoolConfig() {
        getDataSource();
    }

    private static BasicDataSource getDataSource() {

        if (dataSource == null) {

            dataSource = new BasicDataSource();
            dataSource.setUrl("jdbc:h2:~/test");
            dataSource.setUsername("sa");
            dataSource.setPassword("sa");
            dataSource.setMinIdle(5);   // Número mínimo de conexões ociosas no pool
            dataSource.setMaxIdle(10);  // Número máximo de conexões ociosas no pool
            dataSource.setMaxTotal(50); // Número máximo de conexões totais no pool

            System.out.println("New connection pool created with successful");
        }

        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    }

    public void createTables(){
        String url = "jdbc:h2:~/test";
        String user = dataSource.getUsername();
        String password = dataSource.getPassword();

        try{
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            String scriptFilePath = "EducaTech\\src\\main\\java\\br\\com\\educatech\\templates\\db.sql";
            try {
                BufferedReader reader = new BufferedReader(new FileReader(scriptFilePath));
                StringBuilder script = new StringBuilder();
                String line;

                while((line = reader.readLine()) != null){
                    script.append(line).append("\n");
                }
                reader.close();

                String scriptSQL = script.toString();
                statement.execute(scriptSQL);

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException exception){
                exception.printStackTrace();
            }

        }catch (SQLException sqlE){
            sqlE.printStackTrace();
        }
    }
    public void testInsertDataBase(){
        String url = "jdbc:h2:~/test";
        String user = dataSource.getUsername();
        String password = dataSource.getPassword();

        try{
            Connection connection = DriverManager.getConnection(url, user, password);

            Statement statement = connection.createStatement();

            String scriptFilePath = "EducaTech\\src\\main\\java\\br\\com\\educatech\\templates\\data.sql";
            try {
                BufferedReader reader = new BufferedReader(new FileReader(scriptFilePath));
                StringBuilder script = new StringBuilder();
                String line;

                while((line = reader.readLine()) != null){
                    script.append(line).append("\n");
                }
                reader.close();

                String scriptSQL = script.toString();
                statement.execute(scriptSQL);

            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException exception){
                exception.printStackTrace();
            }

        }catch (SQLException sqlE){
            sqlE.printStackTrace();
        }
    }

}

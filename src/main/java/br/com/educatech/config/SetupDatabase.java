package br.com.educatech.config;

import org.h2.tools.RunScript;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet(loadOnStartup = 1, urlPatterns = "/database")
public class SetupDatabase extends HttpServlet {

        @Override
        public void init() throws ServletException {
            loadDatabase();
        }

        public void loadDatabase() {
            try {
                Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");

                RunScript.execute(connection, new FileReader("src/main/resources/db.sql"));

            } catch (Exception e) {
                    e.getMessage();
            }

        }

    }

package br.com.educatech.servlet.student;

import br.com.educatech.dao.StudentDao;
import br.com.educatech.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet ("/update")
public class UpdateStudentServlet extends HttpServlet {

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            String id = req.getParameter("id");
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            if (id.isEmpty() || name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please provide all required fields");
                return;
            }

        Student student = new Student(Integer.valueOf(id), name, email, password);

            try {
                new StudentDao().update(student);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            resp.setStatus(HttpServletResponse.SC_OK);
            resp.sendRedirect("index.html");
    }
}

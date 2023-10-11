package br.com.educatech.servlet;

import br.com.educatech.models.Student;
import br.com.educatech.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/create")
public class CreateStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String studentName = req.getParameter("name");
        String studentEmail = req.getParameter("email");
        String studentPassword = req.getParameter("password");

        System.out.println(studentName);

        Student student = new Student(1L, studentName, studentEmail, studentPassword);

        try {
            new StudentDao().create(student);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("/find-all-students");

    }
}

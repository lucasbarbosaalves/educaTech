package br.com.educatech.servlet.student;

import br.com.educatech.models.Student;
import br.com.educatech.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet ("/students")
public class ListStudentServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Student> students = new StudentDao().findAll();

        req.setAttribute("students", students);

        req.getRequestDispatcher("courses.jsp").forward(req, resp);

        resp.setStatus(HttpServletResponse.SC_OK);

    }
}

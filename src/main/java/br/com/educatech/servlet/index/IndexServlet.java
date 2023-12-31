package br.com.educatech.servlet.index;

import br.com.educatech.dao.CourseDao;
import br.com.educatech.models.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Course> courses = new CourseDao().findAll();

        req.setAttribute("courses", courses);

        req.getRequestDispatcher("index.jsp").forward(req, resp);

        resp.setStatus(HttpServletResponse.SC_OK);
    }
}

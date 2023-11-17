package br.com.educatech.servlet.student;

import br.com.educatech.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet ("/delete")
public class DeleteStudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");

        if (id.isEmpty()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please provide all required fields");
            return;
        }

        try {
            new StudentDao().delete(Integer.valueOf(id));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
        resp.sendRedirect("index.jsp");

    }
}

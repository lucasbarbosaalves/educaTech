package br.com.educatech.servlet;

import br.com.educatech.dao.StudentDao;
import br.com.educatech.models.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Student user = new Student();
        user.setEmail(email);
        user.setPassword(password);

        StudentDao dao = new StudentDao();
        boolean isValidUser = dao.verifyCredentials(user);

        System.out.println("isValidUser: " + isValidUser);

        if (isValidUser) {

            req.getSession().setAttribute("loggedUser", email);

            resp.sendRedirect("index");

        } else {

            req.setAttribute("message", "Credenciais inválidas!");

            req.getRequestDispatcher("login.jsp").forward(req, resp);

        }

    }


}
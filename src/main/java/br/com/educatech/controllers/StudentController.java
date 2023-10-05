package br.com.educatech.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/students")
public class StudentController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("student-login");
        String password = req.getParameter("student-senha");

        if (login == null || password == null) {
            resp.sendRedirect("index.html");
            return;
        }


        req.getRequestDispatcher("index.html").forward(req, resp);

        System.out.println("Student login: " + login);
        System.out.println("Student senha: " + password);
    }
}

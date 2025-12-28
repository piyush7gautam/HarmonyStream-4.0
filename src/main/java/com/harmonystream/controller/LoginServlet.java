package com.harmonystream.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harmonystream.daoimpl.UserDAOImpl;
import com.harmonystream.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        System.out.println("LOGIN SERVLET HIT");

        String email = req.getParameter("email");
        String password = req.getParameter("password");

        User u = new UserDAOImpl().login(email, password);

        if (u == null) {
            System.out.println("LOGIN FAILED");
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        System.out.println("ROLE FROM DB = [" + u.getRole() + "]");

        HttpSession session = req.getSession(true);
        session.setAttribute("user", u);

        switch (u.getRole()) {
            case "ADMIN":
                System.out.println("REDIRECTING TO ADMIN");
                res.sendRedirect(req.getContextPath() + "/adminDashboard.jsp");
                break;

            case "ARTIST":
                System.out.println("REDIRECTING TO ARTIST");
                res.sendRedirect(req.getContextPath() + "/artistDashboard.jsp");
                break;

            default:
                System.out.println("REDIRECTING TO LISTENER");
                res.sendRedirect(req.getContextPath() + "/listenerDashboard.jsp");
        }
    }
}

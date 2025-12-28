package com.harmonystream.controller;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.harmonystream.daoimpl.MusicDAOImpl;

@WebServlet("/adminMusicAction")
public class AdminMusicActionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int musicId = Integer.parseInt(req.getParameter("musicId"));
        String action = req.getParameter("action"); // APPROVED or REJECTED

        new MusicDAOImpl().updateStatus(musicId, action);

        res.sendRedirect(req.getContextPath() + "/adminDashboard.jsp");
    }
}

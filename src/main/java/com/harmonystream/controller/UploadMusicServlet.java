package com.harmonystream.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.harmonystream.daoimpl.MusicDAOImpl;
import com.harmonystream.model.Music;
import com.harmonystream.model.User;

@WebServlet("/upload")
public class UploadMusicServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        System.out.println("UPLOAD SERVLET HIT");

        HttpSession session = req.getSession(false);
        User u = (User) session.getAttribute("user");

        if (u == null) {
            res.sendRedirect(req.getContextPath() + "/login.jsp");
            return;
        }

        Music m = new Music();
        m.setTitle(req.getParameter("title"));
        m.setAlbum(req.getParameter("album"));
        m.setGenre(req.getParameter("genre"));
        m.setArtistId(u.getId());

        new MusicDAOImpl().uploadMusic(m);

        res.sendRedirect(req.getContextPath() + "/artistDashboard.jsp");
    }
}

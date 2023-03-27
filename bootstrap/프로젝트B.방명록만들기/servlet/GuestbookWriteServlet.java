package org.edwith.webbe.guestbook.servlet;

import org.edwith.webbe.guestbook.dao.GuestbookDao;
import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/guestbooks/write")
public class GuestbookWriteServlet extends HttpServlet {
    private GuestbookDao guestbookDao = GuestbookDao.getGuestbookDao();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 코드를 작성하세요.
        String name = request.getParameter("name");
        String content = request.getParameter("content");
        Guestbook guestbook = new Guestbook(name, content);

        guestbookDao.addGuestbook(guestbook);

        response.sendRedirect("/guestbooks");
    }

}

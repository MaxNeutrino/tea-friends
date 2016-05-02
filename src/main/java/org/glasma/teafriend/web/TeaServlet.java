package org.glasma.teafriend.web;

import org.glasma.teafriend.LoggerWrapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TeaServlet extends HttpServlet {

    private static final LoggerWrapper LOG = LoggerWrapper.get(TeaServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("tea");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.debug("redirect to teaList");

        resp.sendRedirect("teaList.jsp");
    }
}

package org.glasma.teafriend.web;

import org.glasma.teafriend.LoggerWrapper;
import org.glasma.teafriend.Profiles;
import org.glasma.teafriend.model.Tea;
import org.glasma.teafriend.web.tea.TeaRestController;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

public class TeaServlet extends HttpServlet {

    private static final LoggerWrapper LOG = LoggerWrapper.get(TeaServlet.class);

    public static final Comparator<Tea> TEA_COMPARATOR = (tea1, tea2) -> tea1.getName().compareTo(tea2.getName());

    private ClassPathXmlApplicationContext springContext;
    private TeaRestController teaRestController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        springContext = new ClassPathXmlApplicationContext();
        springContext.getEnvironment().setActiveProfiles(Profiles.POSTGRES, Profiles.JPA);
        springContext.setConfigLocations("spring/spring-app.xml", "spring/spring-db.xml");
        springContext.refresh();
        teaRestController = springContext.getBean(TeaRestController.class);
    }

    @Override
    public void destroy() {
        springContext.close();
        super.destroy();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.sendRedirect("tea");
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            String id = req.getParameter("id");
            int rate = Integer.parseInt(req.getParameter("rate"));
            int countConnoisseurs = Integer.parseInt(req.getParameter("countConnoisseurs"));
            Tea tea = new Tea(id.isEmpty() ? null : Integer.valueOf(id),
                    req.getParameter("name"),
                    req.getParameter("category"),
                    req.getParameter("country"),
                    req.getParameter("description"),
                    rate,
                    countConnoisseurs);
            teaRestController.create(tea);
            resp.sendRedirect("tea");
        } else {
            String category = req.getParameter("category");
            String country = req.getParameter("country");
            req.setAttribute("teaList", teaRestController.getFilteredTeaList(category, country)
                    .stream()
                    .sorted(TEA_COMPARATOR)
                    .collect(Collectors.toList()));
            req.getRequestDispatcher("/teaList.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*LOG.debug("redirect to teaList");
        resp.sendRedirect("teaList.jsp");*/

        String action = req.getParameter("action");

        if (action == null) {
            LOG.info("getAll");
            req.setAttribute("teaList", teaRestController.getAll().stream()
                    .sorted(TEA_COMPARATOR)
                    .collect(Collectors.toList()));
            req.getRequestDispatcher("/teaList.jsp").forward(req, resp);
        } else if (action.equals("delete")) {
            int id = getId(req);
            LOG.info("Delete {}", id);
            teaRestController.delete(id);
            resp.sendRedirect("tea");
        } else {
            final Tea tea = action.equals("create") ?
                    new Tea("", "", "", "") :
                    teaRestController.get(getId(req));
            req.setAttribute("tea", tea);
            req.getRequestDispatcher("/teaEdit.jsp").forward(req, resp);
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}

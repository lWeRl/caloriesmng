package org.lwerl.caloriesmng.web;

import org.lwerl.caloriesmng.service.UserService;
import org.lwerl.caloriesmng.util.LoggerWrapper;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    private WebApplicationContext wac;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        wac= WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
    }

    private static final LoggerWrapper LOG = LoggerWrapper.get(UserServlet.class);
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("forward to userList");
        UserService service = wac.getBean(UserService.class);
        request.setAttribute("userList", service.getAll());
//        response.sendRedirect("userList.jsp");
        request.getRequestDispatcher("/userList.jsp").forward(request,response);
    }
}

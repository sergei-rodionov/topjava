package ru.javawebinar.topjava.web;

import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.dao.UserMealDao;
import ru.javawebinar.topjava.dao.UserMealDaoImpl;
import ru.javawebinar.topjava.model.UserMeal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * User: gkislin
 * Date: 19.08.2014
 */
public class UserServlet extends HttpServlet {
    private static final LoggerWrapper LOG = LoggerWrapper.get(UserServlet.class);

    private UserMealDao dao = new UserMealDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("forward to userList");

        if (request.getServletPath().equals("/add")) {
            request.getRequestDispatcher("/addUserMeal.jsp").forward(request, response);
            return;
        }

        if (request.getServletPath().equals("/edit")) {
            request.setAttribute("userMeal", dao.getUserMeal(request.getParameter("date")));
            request.getRequestDispatcher("/addUserMeal.jsp").forward(request, response);
            return;
        }

        if (request.getServletPath().equals("/delete")) {
            LOG.debug("delete record");
            dao.delete(request.getParameter("date"));
            request.setAttribute("message", "Delete record ok.");
        }

        request.setAttribute("userMeal", dao.findAll());
        request.setCharacterEncoding("UTF-8");
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/userList.jsp");
        rd.forward(request, response);
        //response.sendRedirect("userList.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("post userList");

        if (request.getParameterMap() != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

            LocalDateTime dateTime = LocalDateTime.parse(request.getParameter("datetime"), formatter);
            UserMeal meal = new UserMeal(dateTime,
                    request.getParameter("description"),
                    Integer.parseInt(request.getParameter("calories")));

            if (request.getServletPath().equals("/add")) {
                dao.add(meal);
            }
            if (request.getServletPath().equals("/edit")) {
                dao.update(request.getParameter("date"), meal);
            }
        }
        // REDIRECT
        response.sendRedirect("users");


    }
}

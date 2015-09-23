package ru.javawebinar.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.repository.mock.InMemoryUserMealRepository;
import ru.javawebinar.topjava.util.UserMealsUtil;
import ru.javawebinar.topjava.web.meal.UserMealRestController;
import ru.javawebinar.topjava.web.user.AdminRestController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Objects;

/**
 * User: gkislin
 * Date: 19.08.2014
 */

@Component
public class MealServlet extends HttpServlet {
    private static final LoggerWrapper LOG = LoggerWrapper.get(MealServlet.class);

    private UserMealRepository repository; // not use
    @Autowired
    private AdminRestController adminUserController;
    @Autowired
    private UserMealRestController restController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        repository = new InMemoryUserMealRepository();

        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            adminUserController = appCtx.getBean(AdminRestController.class);
            System.out.println(adminUserController.create(new User(1, "userName", "email", "password", Role.ROLE_ADMIN)));
            System.out.println(adminUserController.create(new User(2, "userName2", "email", "password", Role.ROLE_USER)));
            //    restController = appCtx.getBean(UserMealRestController.class);
            appCtx.getAutowireCapableBeanFactory().autowireBean(this);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        if (request.getParameter("filter") != null) {
            LOG.info("filter list");
            doGet(request, response);
            return;
        }
        String id = request.getParameter("id");
        UserMeal userMeal = new UserMeal(id.isEmpty() ? null : Integer.valueOf(id),
                LocalDateTime.parse(request.getParameter("dateTime")),
                request.getParameter("description"),
                Integer.valueOf(request.getParameter("calories")),
                LoggedUser.id());
        LOG.info(userMeal.isNew() ? "Create {}" : "Update {}", userMeal);
        if (id.isEmpty()) {
            restController.create(userMeal);
        } else
            restController.update(userMeal, Integer.valueOf(id));
//        repository.save(userMeal);
        response.sendRedirect("meals");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            LOG.info("getAll");
//            request.setAttribute("mealList",
//                    UserMealsUtil.getWithExceeded(repository.getAll(), 2000));
            if (request.getParameter("filter") != null) {
                LoggedUser.setId(Integer.parseInt(request.getParameter("user")));
                if (!request.getParameter("startDate").isEmpty() ||
                        !request.getParameter("startTime").isEmpty() ||
                        !request.getParameter("endDate").isEmpty() ||
                        !request.getParameter("endTime").isEmpty()
                        ) {
                    LocalTime startTime = LocalTime.parse(request.getParameter("startTime"));
                    LocalDate startDate = LocalDate.parse(request.getParameter("startDate"));
                    LocalTime endTime = LocalTime.parse(request.getParameter("endTime"));
                    LocalDate endDate = LocalDate.parse(request.getParameter("endDate"));

                    Collection collection = restController.getByFilter(
                            LocalDateTime.of(startDate, startTime), LocalDateTime.of(endDate, endTime));
                    request.setAttribute("mealList", collection);
                } else
                    request.setAttribute("mealList", UserMealsUtil.getWithExceeded(restController.getAll(), 2000));

            } else
                request.setAttribute("mealList", UserMealsUtil.getWithExceeded(restController.getAll(), 2000));
            request.setAttribute("userList", adminUserController.getAll());
            request.getRequestDispatcher("/mealList.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            int id = getId(request);
            LOG.info("Delete {}", id);
            restController.delete(id);
//            repository.delete(id);
            response.sendRedirect("meals");
        } else {
            final UserMeal meal = action.equals("create") ?
                    new UserMeal(LocalDateTime.now(), "", 1000, LoggedUser.id()) :
                    restController.get(getId(request));
            //repository.get(getId(request));
            request.setAttribute("meal", meal);
            request.getRequestDispatcher("mealEdit.jsp").forward(request, response);
        }
    }

    private int getId(HttpServletRequest request) {
        String paramId = Objects.requireNonNull(request.getParameter("id"));
        return Integer.valueOf(paramId);
    }
}

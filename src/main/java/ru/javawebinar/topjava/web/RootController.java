package ru.javawebinar.topjava.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserService;
import ru.javawebinar.topjava.util.TimeUtil;
import ru.javawebinar.topjava.web.meal.UserMealRestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
@Controller
public class RootController {
    private static final LoggerWrapper LOG = LoggerWrapper.get(RootController.class);

    @Autowired
    private UserService service;
    @Autowired
    private UserMealRestController mealService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String root() {
        return "index";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList(Model model) {
        model.addAttribute("userList", service.getAll());
        return "userList";
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String setUser(HttpServletRequest request) {
        int userId = Integer.valueOf(request.getParameter("userId"));
        LoggedUser.setId(userId);
        return "redirect:meals";
    }

    @RequestMapping(value = "/meals", method = RequestMethod.GET)
    public String mealsList(Model model,
                            @RequestParam(value = "action", required = false) String action,
                            @RequestParam(value = "id", required = false) Integer id) {


        if (action == null) {
            LOG.info("getAll");
            model.addAttribute("mealList", mealService.getAll());
            return "mealList";
        } else if (action.equals("delete") && id != null) {
            LOG.info("Delete {}", id);
            mealService.delete(id);
            return "redirect:meals";
        } else {
            LOG.info("Update/Create");
            final UserMeal meal = action.equals("create") ?
                    new UserMeal(LocalDateTime.now(), "", 1000) :
                    mealService.get(id);
            model.addAttribute("meal", meal);
            return "mealEdit";
        }
    }

    @RequestMapping(value = "/meals", method = RequestMethod.POST)
    public String setMeal(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            String id = request.getParameter("id");
            UserMeal userMeal = new UserMeal(id.isEmpty() ? null : Integer.valueOf(id),
                    LocalDateTime.parse(request.getParameter("dateTime")),
                    request.getParameter("description"),
                    Integer.valueOf(request.getParameter("calories")));
            LOG.info(userMeal.isNew() ? "Create {}" : "Update {}", userMeal);
            mealService.create(userMeal);
            return "redirect:meals";
        } else {
            LocalDate startDate = TimeUtil.parseLocalDate(request.getParameter("startDate"), TimeUtil.MIN_DATE);
            LocalDate endDate = TimeUtil.parseLocalDate(request.getParameter("endDate"), TimeUtil.MAX_DATE);
            LocalTime startTime = TimeUtil.parseLocalTime(request.getParameter("startTime"), LocalTime.MIN);
            LocalTime endTime = TimeUtil.parseLocalTime(request.getParameter("endTime"), LocalTime.MAX);
            request.setAttribute("mealList", mealService.getBetween(startDate, startTime, endDate, endTime));
            return "mealList";
        }

    }
}

package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;
import ru.javawebinar.topjava.service.UserMealServiceImpl;
import ru.javawebinar.topjava.util.UserMealsUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class UserMealRestController {
    protected final LoggerWrapper LOG = LoggerWrapper.get(getClass());

    @Autowired
    private UserMealServiceImpl service;

    public Collection<UserMeal> getAll() {
        LOG.info("getAll");
        if (LoggedUser.role().equals(Role.ROLE_ADMIN)) {
            return service.getAll();
        } else {
            return service.getByFilter(LoggedUser.id());
        }
    }

    public UserMeal get(int id) {
        LOG.info("get " + id);
        return service.get(id, LoggedUser.id());
    }

    public Collection getByFilter(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        Collection<UserMealWithExceed> withExceeded = UserMealsUtil.getWithExceeded(
                getByFilter(LoggedUser.id(), startDateTime.toLocalDate(), endDateTime.toLocalDate()), 2000);

        return withExceeded.stream().filter(u ->
                        u.getDateTime().isAfter(startDateTime) &&
                                u.getDateTime().isBefore(endDateTime)
        ).collect(Collectors.toList());
    }

    private Collection<UserMeal> getByFilter(int userId, LocalDate startDateTime, LocalDate endDateTime) {
        return service.getByFilter(userId, startDateTime, endDateTime);
    }

    public UserMeal create(UserMeal userMeal) {
        //userMeal.setId(null);
        LOG.info("create " + userMeal);
        return service.save(userMeal);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id, LoggedUser.id());
    }

    public void update(UserMeal userMeal, int id) {
        userMeal.setId(id);
        LOG.info("update " + userMeal);
        service.update(userMeal, LoggedUser.id());
    }
}

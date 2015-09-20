package ru.javawebinar.topjava.web.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.LoggedUser;
import ru.javawebinar.topjava.LoggerWrapper;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.service.UserMealServiceImpl;

import java.util.Collection;
import java.util.Set;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class UserMealRestController {
    protected final LoggerWrapper LOG = LoggerWrapper.get(getClass());

    private final int LOGGED_USER_ID = LoggedUser.id();
    private final Set<Role> LOGGED_USER_ROLES = LoggedUser.role();


    @Autowired
    private UserMealServiceImpl service;

    public Collection<UserMeal> getAll() {
        LOG.info("getAll");
        if (LOGGED_USER_ROLES.contains(Role.ROLE_ADMIN)) {
            return service.getAll();
        } else {
            return service.getByUser(LOGGED_USER_ID);
        }
    }

    public UserMeal get(int id) {
        LOG.info("get " + id);
        return service.get(id, LOGGED_USER_ID);
    }

    public UserMeal create(UserMeal userMeal) {
        //    userMeal.setId(null);
        LOG.info("create " + userMeal);
        return service.save(userMeal);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id, LOGGED_USER_ID);
    }

    public void update(UserMeal userMeal, int id) {
        userMeal.setId(id);
        LOG.info("update " + userMeal);
        service.update(userMeal, LOGGED_USER_ID);
    }
}

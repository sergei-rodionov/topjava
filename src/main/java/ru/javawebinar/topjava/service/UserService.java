package ru.javawebinar.topjava.service;


import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.to.UserTo;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
public interface UserService {

    public User save(User user);

    public void delete(int id) throws NotFoundException;

    public User get(int id) throws NotFoundException;

    Collection<User> getAll();

    void update(UserTo user);

    public User getByEmail(String email) throws NotFoundException;

    void update(User user);

    void evictCache();

    void enable(int id, boolean enable);

    User getWithMeals(int id);
}

package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;
import ru.javawebinar.topjava.util.exception.ExceptionUtil;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
@Service
public class UserMealServiceImpl implements UserMealService {

    @Autowired
    private UserMealRepository repository;

    @Override
    public UserMeal save(UserMeal userMeal) {
        return repository.save(userMeal);
    }

    @Override
    public void delete(int id, int userId) throws NotFoundException {
        ExceptionUtil.check(repository.get(id).getUserId()==userId, id);
        repository.delete(id);
    }

    @Override
    public UserMeal get(int id, int userId) throws NotFoundException {
        UserMeal userMeal = repository.get(id);
        ExceptionUtil.check(userMeal.getUserId()==userId, id);
        return userMeal;
    }

    @Override
    public Collection<UserMeal> getAll() {
        return repository.getAll();
    }

    @Override
    public Collection<UserMeal> getByUser(int userId) {
        return repository.getByFilter(userId);
    }

    @Override
    public void update(UserMeal userMeal, int userId) {
        get(userMeal.getId(), userId); // check for user record
        repository.save(userMeal);
    }
}

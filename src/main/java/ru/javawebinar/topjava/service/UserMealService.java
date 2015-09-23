package ru.javawebinar.topjava.service;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.exception.NotFoundException;

import java.time.LocalDate;
import java.util.Collection;

/**
 * GKislin
 * 15.06.2015.
 */
public interface UserMealService {

    UserMeal save(UserMeal userMeal);

    void delete(int id, int userId) throws NotFoundException;

    UserMeal get(int id, int userId) throws NotFoundException;

    Collection<UserMeal> getAll();

    void update(UserMeal userMeal, int userId);

    Collection<UserMeal> getByFilter(int userId);

    Collection<UserMeal> getByFilter(int userId, LocalDate startDate, LocalDate endDate);


}

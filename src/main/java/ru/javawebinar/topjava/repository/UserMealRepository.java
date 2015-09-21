package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalTime;
import java.util.Collection;

/**
 * GKislin
 * 06.03.2015.
 */
public interface UserMealRepository {
    UserMeal save(UserMeal userMeal);

    void delete(int id);

    UserMeal get(int id);

    Collection<UserMeal> getAll();

    Collection<UserMeal> getByFilter(int userId);

    Collection<UserMeal> getByFilter(LocalTime startTime, LocalTime endTime);

    Collection<UserMeal> getByFilter(int userId, LocalTime startTime, LocalTime endTime);


}

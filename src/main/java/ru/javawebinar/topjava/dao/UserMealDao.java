package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * Created by SergeiRodionov.ru on 14.09.2015.
 */
public interface UserMealDao {
    void add(UserMeal userMeal);
    List<UserMeal> findAll();
    void delete(String dateRecord);
    UserMeal getUserMeal(String dateRecord);
    UserMeal update(String dateRecord, UserMeal userMeal);
}

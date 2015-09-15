package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by SergeiRodionov.ru on 14.09.2015.
 */
public class UserMealDaoImpl implements UserMealDao {

    private List<UserMeal> userMealList = UserMealDB.getUserMealList();

    @Override
    public void add(UserMeal userMeal) {
        userMealList.add(userMeal);
    }

    @Override
    public List<UserMeal> findAll() {
        return userMealList;
    }

    @Override
    public void delete(String dateRecord) {
        userMealList.removeAll(userMealList.stream().filter(t -> t.getDateTime().equals(LocalDateTime.parse(dateRecord))).collect(Collectors.toList()));
    }

    @Override
    public UserMeal update(String dateRecord, UserMeal userMeal) {
        delete(dateRecord);
        add(userMeal);
        return userMeal;
    }

    @Override
    public UserMeal getUserMeal(String dateRecord) {
        return userMealList.stream().filter(t -> t.getDateTime().equals(LocalDateTime.parse(dateRecord))).findFirst().get();
    }
}

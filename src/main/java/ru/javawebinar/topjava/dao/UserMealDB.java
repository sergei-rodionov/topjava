package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by SergeiRodionov.ru on 14.09.2015.
 */
public class UserMealDB {
    private static List<UserMeal> userMealList = new ArrayList<>();

    static {
        userMealList.addAll(Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 510),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 29, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 29, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 29, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 28, 10, 0), "Завтрак", 1500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 28, 13, 0), "Обед", 700),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 28, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 27, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 27, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 27, 20, 0), "Ужин", 700)
        ));
    }

    public static List<UserMeal> getUserMealList() {
        return userMealList;
    }
}

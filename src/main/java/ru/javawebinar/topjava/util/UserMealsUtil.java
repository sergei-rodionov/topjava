package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500)
        );
        getFilteredMealsWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
//        .toLocalDate();
//        .toLocalTime();
    }

    public static List<UserMealWithExceed> getFilteredMealsWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {

        List<UserMealWithExceed> result = new LinkedList();


        mealList.stream()
                // создаем Map по дням
                .collect(Collectors.groupingBy(u -> u.getDateTime().toLocalDate())).entrySet().stream()

                // перебираем дни
                .forEach(days -> {

                    // вычисляем один раз был перебор по каллориям или нет
                    boolean exceed = days.getValue().stream()
                            .collect(Collectors.summarizingInt(UserMeal::getCalories)).getSum() > caloriesPerDay;

                    // если находим записи с требуемым временем то добавляем в результурующий лист
                    days.getValue().stream()
                            .filter(timeMeal -> (timeMeal.getDateTime().toLocalTime().isAfter(startTime)
                                    && timeMeal.getDateTime().toLocalTime().isBefore(endTime)))
                            .forEach(meal ->
                                    result.add(new UserMealWithExceed(meal.getDateTime(),
                                            meal.getDescription(), meal.getCalories(), exceed)));
                });

        return result;
    }
}

package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

        // создаем Map по дням
        Map<LocalDate, List<UserMeal>> mapByDate = mealList.stream()
                .collect(Collectors.groupingBy(u -> u.getDateTime().toLocalDate()
                ));
        // перебираем дни
        for (Map.Entry m : mapByDate.entrySet()) {
            // проверяем был перебор по каллориям или нет
            boolean exceed = ((List<UserMeal>) m.getValue()).stream()
                    .collect(Collectors.summarizingInt(UserMeal::getCalories))
                    .getSum() > caloriesPerDay;
            // если находим записи с требуемым временем то добавляем к результурующий лист
            for (UserMeal meal : ((List<UserMeal>) m.getValue()).stream()
                                  .filter(u->(u.getDateTime().toLocalTime().isAfter(startTime)
                                           && u.getDateTime().toLocalTime().isBefore(endTime)))
                                  .collect(Collectors.toList())  ) {

                result.add(new UserMealWithExceed(meal.getDateTime(), meal.getDescription(), meal.getCalories(), exceed));
            }
        }

        return result;
    }
}

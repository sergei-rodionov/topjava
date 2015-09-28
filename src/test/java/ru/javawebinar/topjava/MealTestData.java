package ru.javawebinar.topjava;

import ru.javawebinar.topjava.matcher.ModelMatcher;
import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * GKislin
 * 13.03.2015.
 */
public class MealTestData {

    public static final ModelMatcher<UserMeal, String> MATCHER = new ModelMatcher<>(UserMeal::toString);
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ssx");

    public static final List<UserMeal> USER_MEALS = Arrays.asList(
            // meals user_id = 100000
            new UserMeal(100002, LocalDateTime.parse("2015-05-28 09:00:00+03", DATE_TIME_FORMATTER), "Завтрак", 200),
            new UserMeal(100003, LocalDateTime.parse("2015-05-28 13:00:00+03", DATE_TIME_FORMATTER), "Обед", 1200),
            new UserMeal(100004, LocalDateTime.parse("2015-05-28 19:00:00+03", DATE_TIME_FORMATTER), "Ужин", 500),
            new UserMeal(100005, LocalDateTime.parse("2015-05-29 09:00:00+03", DATE_TIME_FORMATTER), "Завтрак", 200),
            new UserMeal(100006, LocalDateTime.parse("2015-05-29 13:00:00+03", DATE_TIME_FORMATTER), "Обед", 1350),
            new UserMeal(100007, LocalDateTime.parse("2015-05-29 19:00:00+03", DATE_TIME_FORMATTER), "Ужин", 500),

            // meals user_id = 100001
            new UserMeal(100008, LocalDateTime.parse("2015-05-28 09:30:00+03", DATE_TIME_FORMATTER), "Завтрак admin", 500),
            new UserMeal(100009, LocalDateTime.parse("2015-05-28 13:20:00+03", DATE_TIME_FORMATTER), "Обед admin", 1000),
            new UserMeal(100010, LocalDateTime.parse("2015-05-28 19:01:00+03", DATE_TIME_FORMATTER), "Ужин admin", 200),
            new UserMeal(100011, LocalDateTime.parse("2015-05-30 09:30:00+03", DATE_TIME_FORMATTER), "Завтрак admin", 500),
            new UserMeal(100012, LocalDateTime.parse("2015-05-30 13:20:00+03", DATE_TIME_FORMATTER), "Обед admin", 1100),
            new UserMeal(100013, LocalDateTime.parse("2015-05-30 19:01:00+03", DATE_TIME_FORMATTER), "Ужин admin", 500)
    );

    public static class TestUserMeal extends UserMeal {

        public TestUserMeal(Integer id, LocalDateTime dateTime, String description, int calories) {
            super(id, dateTime, description, calories);
        }

        public UserMeal asUserMeal(){
            return new UserMeal(this);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TestUserMeal tum = (TestUserMeal) o;

            return Objects.equals(this.calories, tum.calories)
                    && Objects.equals(this.dateTime, tum.dateTime)
                    && Objects.equals(this.description, tum.description)
                    && Objects.equals(this.id, tum.id);
        }
    }

}

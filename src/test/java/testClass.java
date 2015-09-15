import org.junit.Test;
import ru.javawebinar.topjava.dao.UserMealDao;
import ru.javawebinar.topjava.dao.UserMealDaoImpl;
import ru.javawebinar.topjava.model.UserMeal;

import java.util.List;

/**
 * Created by SergeiRodionov.ru on 14.09.2015.
 */
public class testClass {

    @Test
    public void my() {


        UserMealDao dao = new UserMealDaoImpl();
        List<UserMeal> userMealList = dao.findAll();
        userMealList.forEach(System.out::println);


//        List<UserMeal> mealList = Arrays.asList(
//                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
//                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 500),
//                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
//                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
//                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 500),
//                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500)
//        );
//
//
//        List<UserMealWithExceed> filteredMealsWithExceeded = UserMealsUtil.getFilteredMealsWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
//        filteredMealsWithExceeded.forEach(System.out::println);
//
//        System.out.println(UserMealsUtil.getFilteredMealsWithExceededByCycle(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }
}

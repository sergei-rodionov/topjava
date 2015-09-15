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
    }
}

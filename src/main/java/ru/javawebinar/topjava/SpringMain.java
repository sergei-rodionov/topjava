package ru.javawebinar.topjava;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.javawebinar.topjava.model.Role;
import ru.javawebinar.topjava.model.User;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.web.meal.UserMealRestController;
import ru.javawebinar.topjava.web.user.AdminRestController;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
public class SpringMain {
    public static void main(String[] args) {
        // java 7 Automatic resource management
        try (ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml")) {
            System.out.println(Arrays.toString(appCtx.getBeanDefinitionNames()));
            AdminRestController adminUserController = appCtx.getBean(AdminRestController.class);
            System.out.println(adminUserController.create(new User(1, "userName", "email", "password", Role.ROLE_ADMIN)));
            System.out.println(adminUserController.create(new User(2, "userName2", "email", "password", Role.ROLE_USER)));

            UserMealRestController restController = appCtx.getBean(UserMealRestController.class);

            UserMeal userMeal = new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510, LoggedUser.id());
            System.out.println("*** " + restController.getAll());

   //         restController.update(userMeal,8);
   //         restController.delete(8);
            System.out.println("*** " + restController.get(6));

            System.out.println("* create * "+restController.create(userMeal));
            System.out.println("* get * " + restController.get(userMeal.getId()));
            UserMeal userMeal2 = new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин2", 520, LoggedUser.id());
            restController.update(userMeal2, userMeal.getId());
            System.out.println("* update * " + restController.get(userMeal2.getId()));
            System.out.println("* delete * ");
            restController.delete(userMeal2.getId());
            System.out.println("* getALL * "+restController.getAll());

        }
    }
}

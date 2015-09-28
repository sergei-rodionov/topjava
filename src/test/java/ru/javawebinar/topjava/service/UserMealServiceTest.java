package ru.javawebinar.topjava.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.util.DbPopulator;
import ru.javawebinar.topjava.util.TimeUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.MealTestData.*;

/**
 * Created by SergeiRodionov.ru on 27.09.2015.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserMealServiceTest {

    private static final int USER_ID = 100001;
    //private static final List<UserMeal> USER_MEAL_LIST = USER_MEALS.subList(0,6); // USER_ID = 100000
    private static final List<UserMeal> USER_MEAL_LIST = USER_MEALS.subList(6,12); // USER_ID = 100001

    @Autowired
    private UserMealService service;

    @Autowired
    private DbPopulator dbPopulator;

    @Before
    public void setUp() throws Exception {
        dbPopulator.execute();
    }

    @Test
    public void testGet() throws Exception {
        int id_record = 100008; // 100002-100007 (USER_ID=100000)
                                // 100008-100013 (USER_ID=100001)
        UserMeal meal = service.get(id_record, USER_ID);
        UserMeal test = USER_MEAL_LIST.stream().filter(um -> um.getId() == id_record).findFirst().get();
        MATCHER.assertEquals(meal, test);
    }

    @Test
    public void testDelete() throws Exception {
        int id_record = 100008; // 100002-100007 (USER_ID=100000)
                                // 100008-100013 (USER_ID=100001)
        service.delete(id_record, USER_ID);
        List<UserMeal> test = USER_MEAL_LIST.stream().filter(um -> um.getId()!=id_record).collect(Collectors.toList());
        test.sort((o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime())); // order DESC
        MATCHER.assertCollectionEquals(test, service.getAll(USER_ID));
    }

    @Test
    public void testGetBetweenDates() throws Exception {
        LocalDate start = LocalDateTime.parse("2015-05-28 09:10:00+03", DATE_TIME_FORMATTER).toLocalDate();
        LocalDate end = LocalDateTime.parse("2015-05-30 18:10:00+03", DATE_TIME_FORMATTER).toLocalDate();
        Collection<UserMeal> all = service.getBetweenDates(start, end, USER_ID);
        List<UserMeal> test = USER_MEAL_LIST.stream()
                .filter(um -> um.getDateTime().toLocalDate().compareTo(start) >= 0 &&
                        um.getDateTime().toLocalDate().compareTo(end) <= 0 ).collect(Collectors.toList());
        test.sort((o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime())); // order DESC
        MATCHER.assertCollectionEquals(test, all);
    }

    @Test
    public void testGetBetweenDateTimes() throws Exception {
        LocalDateTime start = LocalDateTime.parse("2015-05-29 09:10:00+03", DATE_TIME_FORMATTER);
        LocalDateTime end = LocalDateTime.parse("2015-05-30 18:10:00+03", DATE_TIME_FORMATTER);
        Collection<UserMeal> all = service.getBetweenDateTimes(start, end, USER_ID);
        List<UserMeal> test = USER_MEAL_LIST.stream()
                .filter(um -> TimeUtil.isBetween(um.getDateTime(), start, end)).collect(Collectors.toList());
        test.sort((o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime())); // order DESC
        MATCHER.assertCollectionEquals(test, all);

    }

    @Test
    public void testGetAll() throws Exception {
        Collection<UserMeal> all = service.getAll(USER_ID);
        USER_MEAL_LIST.sort((o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime())); // order DESC
        MATCHER.assertCollectionEquals(USER_MEAL_LIST, all);
    }

    @Test
    public void testUpdate() throws Exception {
        TestUserMeal tum = new TestUserMeal(null, LocalDateTime.parse("2015-05-30 09:10:00+03", DATE_TIME_FORMATTER), "Перекус", 250);
        tum.setDescription("Пережор");
        tum.setCalories(2500);
        tum.setId(service.update(tum.asUserMeal(), USER_ID).getId());
        MATCHER.assertEquals(tum, service.get(tum.getId(), USER_ID));
    }

    @Test
    public void testSave() throws Exception {
        TestUserMeal tum = new TestUserMeal(null, LocalDateTime.parse("2015-05-30 09:10:00+03", DATE_TIME_FORMATTER), "Перекус", 250);
        UserMeal created = service.save(tum, USER_ID);
        tum.setId(created.getId());
        List<UserMeal> full = new ArrayList<>();
        full.add(tum);
        full.addAll(USER_MEAL_LIST);
        full.sort((o1, o2) -> o2.getDateTime().compareTo(o1.getDateTime())); // order DESC
        MATCHER.assertCollectionEquals(full, service.getAll(USER_ID));
    }
}
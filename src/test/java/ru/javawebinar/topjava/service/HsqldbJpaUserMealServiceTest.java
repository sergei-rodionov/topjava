package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

import static ru.javawebinar.topjava.Profiles.HSQLDB;
import static ru.javawebinar.topjava.Profiles.JPA;

/**
 * Created by SergeiRodionov.ru on 13.10.2015.
 */
@ActiveProfiles({HSQLDB, JPA})
public class HsqldbJpaUserMealServiceTest extends UserMealServiceTest{
}

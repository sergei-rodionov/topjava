package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

import static ru.javawebinar.topjava.Profiles.JPA;
import static ru.javawebinar.topjava.Profiles.POSTGRES;

/**
 * Created by SergeiRodionov.ru on 13.10.2015.
 */
@ActiveProfiles({POSTGRES, JPA})
public class PostgresJpaUserServiceTest extends UserServiceTest{
}

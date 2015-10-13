package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

import static ru.javawebinar.topjava.Profiles.JPA;
import static ru.javawebinar.topjava.Profiles.POSTGRES;

@ActiveProfiles({POSTGRES, JPA})
public class PostgresJpaUserMealServiceTest extends UserMealServiceTest {

}

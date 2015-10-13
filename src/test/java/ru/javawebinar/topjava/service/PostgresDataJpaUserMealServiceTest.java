package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

import static ru.javawebinar.topjava.Profiles.DATAJPA;
import static ru.javawebinar.topjava.Profiles.POSTGRES;

@ActiveProfiles({POSTGRES, DATAJPA})
public class PostgresDataJpaUserMealServiceTest extends UserMealServiceTest {

}

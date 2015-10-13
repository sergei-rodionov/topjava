package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

import static ru.javawebinar.topjava.Profiles.DATAJPA;
import static ru.javawebinar.topjava.Profiles.POSTGRES;

/**
 * Created by SergeiRodionov.ru on 13.10.2015.
 */
@ActiveProfiles({POSTGRES, DATAJPA})
public class PostgresDataJpaUserServiceTest extends UserServiceTest{
}

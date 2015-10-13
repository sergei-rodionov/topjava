package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

import static ru.javawebinar.topjava.Profiles.DATAJPA;
import static ru.javawebinar.topjava.Profiles.HSQLDB;

/**
 * Created by SergeiRodionov.ru on 13.10.2015.
 */
@ActiveProfiles({HSQLDB, DATAJPA})
public class HsqldbJpaUserServiceTest extends UserServiceTest{
}

package ru.javawebinar.topjava.service;

import org.springframework.test.context.ActiveProfiles;

import static ru.javawebinar.topjava.Profiles.HSQLDB;
import static ru.javawebinar.topjava.Profiles.JDBC;

/**
 * Created by SergeiRodionov.ru on 13.10.2015.
 */
@ActiveProfiles({HSQLDB, JDBC})
public class HsqldbJdbcUserServiceTest extends UserServiceTest{
}

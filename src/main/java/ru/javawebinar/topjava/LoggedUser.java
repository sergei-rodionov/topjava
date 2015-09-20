package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * GKislin
 * 06.03.2015.
 */
public class LoggedUser {

    public static int id() {
        return 2;
    }

    public static Set<Role> role() {
        return new HashSet<Role>(Arrays.asList(
        //        Role.ROLE_ADMIN,
                Role.ROLE_USER
        ));
    }
}

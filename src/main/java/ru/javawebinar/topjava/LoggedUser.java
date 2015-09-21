package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Role;

/**
 * GKislin
 * 06.03.2015.
 */
public class LoggedUser {

    private static int id=1;

    public static int id() {
        return id;
    }

    public static void setId(int id) {
        LoggedUser.id = id;
    }

    public static Role role() {
        return (id==1) ? Role.ROLE_ADMIN : Role.ROLE_USER ;
    }
}

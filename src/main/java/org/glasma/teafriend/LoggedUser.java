package org.glasma.teafriend;

import org.glasma.teafriend.model.Role;

import java.util.Set;

public class LoggedUser {

    public static int id;
    protected Set<Role> roles;

    public static int id() {
        return id;
        //return 2000;
    }

    public static void setId(int id) {
        LoggedUser.id = id;
    }
}

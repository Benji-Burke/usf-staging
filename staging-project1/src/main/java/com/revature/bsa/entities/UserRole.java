package com.revature.bsa.entities;

public enum UserRole {

    ADMIN("Admin"), EAGLESCOUT("Eagle");

    private String roleName;

    UserRole(String name) { this.roleName = name; }

    public static UserRole getByName(String name) {
        for (UserRole role : UserRole.values()) {
            if (role.roleName == name) {
                return role;
            }
        }
        return EAGLESCOUT;
    }

    @Override
    public String toString() { return this.roleName; }
}

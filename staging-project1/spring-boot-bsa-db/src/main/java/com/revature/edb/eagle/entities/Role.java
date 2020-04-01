package com.revature.edb.eagle.entities;

public enum Role {

    ADMIN("ADMIN"), SCOUT("SCOUT"), MANAGER("MANAGER"), BASIC_USER("Basic User");

    private String roleName;

    Role(String name){
        this.roleName = name;
    }



    public static Role getByName(String name){
        for (Role role : Role.values()) {
            if(role.roleName == name){
                return role;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return this.roleName;
    }
}

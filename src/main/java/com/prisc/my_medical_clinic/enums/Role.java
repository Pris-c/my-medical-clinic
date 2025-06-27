package com.prisc.my_medical_clinic.enums;

/**
 * Enum representing the roles of users in the system.
 */
public enum Role {
    ADMIN("admin"),
    DOCTOR("doctor"),
    PATIENT("patient");

    private String role;

    Role(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
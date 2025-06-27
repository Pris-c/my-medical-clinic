package com.prisc.my_medical_clinic.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

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

    @JsonCreator
    public static Role from(String value) {
        for (Role role : Role.values()) {
            if (role.getRole().equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Role inválido: " + value);
    }

}
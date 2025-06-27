package com.prisc.my_medical_clinic.model.auth.response;

import com.prisc.my_medical_clinic.enums.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class UserRegistrationResponse {

    public UserRegistrationResponse(UUID userId, String name, String email, String nif) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.nif = nif;
    }

    private UUID userId;
    private String name;
    private String email;
    private String nif;

}

package com.prisc.my_medical_clinic.model.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {

    private String email;
    private String token;

}

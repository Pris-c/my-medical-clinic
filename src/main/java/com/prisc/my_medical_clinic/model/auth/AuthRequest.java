package com.prisc.my_medical_clinic.model.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthRequest {

    private String email;
    private String password;

}

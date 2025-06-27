package com.prisc.my_medical_clinic.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(name = "users")

public class User {

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private UUID id;

    @NotBlank
    @Size(min = 1, max = 200)
    private String name;

    @Email
    @Column(unique = true)
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^a-zA-Z0-9]).{9,}$",
            message = "A senha deve ter pelo menos 9 caracteres, incluindo letra maiúscula, minúscula, número e caractere especial"
    )
    private String password;

    @Column(unique = true, length = 9)
    @Size(min = 9, max = 9, message = "NIF inválido")
    @Pattern(regexp = "\\d{9}", message = "O NIF deve conter apenas números")
    private String nif;

}

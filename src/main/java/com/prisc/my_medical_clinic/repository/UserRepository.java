package com.prisc.my_medical_clinic.repository;

import com.prisc.my_medical_clinic.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);

    boolean existsUserByEmail(String email);

    boolean existsUsersByNif(String nif);
}

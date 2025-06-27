package com.prisc.my_medical_clinic.service;

import com.prisc.my_medical_clinic.enums.Role;
import com.prisc.my_medical_clinic.model.User;
import com.prisc.my_medical_clinic.model.auth.response.UserRegistrationResponse;
import com.prisc.my_medical_clinic.model.request.UserRegistrationRequest;
import com.prisc.my_medical_clinic.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        List<String> roles = new ArrayList<>();
        roles.add(user.getRole().name());
        return
                org.springframework.security.core.userdetails.User.builder()
                        .username(user.getEmail())
                        .password(user.getPassword())
                        .roles(roles.toArray(new String[0]))
                        .build();
    }

    public UserRegistrationResponse registerUser(UserRegistrationRequest dto) {
        if (userRepository.existsUserByEmail((dto.getEmail()))){
            throw new IllegalArgumentException("Email já está em uso");
        }

        if (userRepository.existsUsersByNif(dto.getNif())) {
            throw new IllegalArgumentException("NIF já está em uso");
        }

        User user = requestToUser(dto);
        return userToResponse(userRepository.save(user));
    }

    private User requestToUser(UserRegistrationRequest request){
        return new User(
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getNif(),
                Role.from(request.getRole())
        );
    }

    private UserRegistrationResponse userToResponse(User user){
        return new UserRegistrationResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getNif());
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}

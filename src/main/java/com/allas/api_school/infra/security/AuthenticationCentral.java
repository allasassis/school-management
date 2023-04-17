package com.allas.api_school.infra.security;

import com.allas.api_school.dto.authentication.DataAuthentication;
import com.allas.api_school.model.User;
import com.allas.api_school.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationCentral {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User cryptography (DataAuthentication dataAuthentication) {
        UserDetails login = userRepository.findByUsername(dataAuthentication.getUsername());

        if (login != null) {
            throw new RuntimeException("This username is registered! Please, choose another one!");
        }

        String password = passwordEncoder.encode(dataAuthentication.getPassword());
        User user = new User(dataAuthentication.getUsername(), password);
        userRepository.save(user);
        return user;
    }
}

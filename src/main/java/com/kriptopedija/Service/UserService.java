package com.kriptopedija.Service;

import com.kriptopedija.Models.DTOs.RegisterDto;
import com.kriptopedija.Models.Enumeration.Role;
import com.kriptopedija.Models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {
    User register(String username, String password, String repeatPassword, String name, String surname, Role role);
    Optional<User> register(RegisterDto registerDto);
    User findByUsername(String username);
}
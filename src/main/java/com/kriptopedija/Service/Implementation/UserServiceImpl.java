package com.kriptopedija.Service.Implementation;

import com.kriptopedija.Exceptions.InvalidUsernameOrPasswordException;
import com.kriptopedija.Exceptions.PasswordsDoNotMatchException;
import com.kriptopedija.Exceptions.UserNotFoundException;
import com.kriptopedija.Exceptions.UsernameAlreadyExistsException;
import com.kriptopedija.Models.DTOs.RegisterDto;
import com.kriptopedija.Models.Enumeration.Role;
import com.kriptopedija.Models.User;
import com.kriptopedija.Repository.UserRepository;
import com.kriptopedija.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s).orElseThrow(()->new UsernameNotFoundException(s));
    }
    @Override
    public User register(String username, String password, String repeatPassword, String name, String surname, Role role) {
        if (username==null || username.isEmpty()  || password==null || password.isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(username).isPresent())
            throw new UsernameAlreadyExistsException(username);
        User user = new User(username, passwordEncoder.encode(password), name, surname, role);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> register(RegisterDto registerDto) {
        if (registerDto.getUsername()==null || registerDto.getUsername().isEmpty()  || registerDto.getPassword()==null || registerDto.getPassword().isEmpty())
            throw new InvalidUsernameOrPasswordException();
        if (!registerDto.getPassword().equals(registerDto.getRepeatPassword()))
            throw new PasswordsDoNotMatchException();
        if(this.userRepository.findByUsername(registerDto.getUsername()).isPresent())
            throw new UsernameAlreadyExistsException(registerDto.getUsername());
        User user = new User(registerDto.getUsername(), passwordEncoder.encode(registerDto.getPassword()), registerDto.getName(), registerDto.getSurname(), registerDto.getRole());
        this.userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    public User findByUsername(String username) {
        return this.userRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException(username));
    }
}
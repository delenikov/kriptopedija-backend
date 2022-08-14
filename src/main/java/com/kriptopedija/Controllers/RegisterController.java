package com.kriptopedija.Controllers;

import com.kriptopedija.Models.DTOs.RegisterDto;
import com.kriptopedija.Models.User;
import com.kriptopedija.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody RegisterDto registerDto) {
        return this.userService.register(registerDto)
                .map(vehicle -> ResponseEntity.ok().body(vehicle))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
package com.kriptopedija.Controllers;

import com.kriptopedija.Models.Enumeration.Role;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/")
public class HomeController {
    @GetMapping("/roles")
    private List<Role> listAllUserRoles() {
        List<Role> roles = new ArrayList<Role>(EnumSet.allOf(Role.class));
        return roles;
    }
}

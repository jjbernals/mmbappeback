package com.example.ProyectoMbappe.controller;

import com.example.ProyectoMbappe.entity.Pagina;
import com.example.ProyectoMbappe.entity.User;
import com.example.ProyectoMbappe.service.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}/{contraseña}")
    public User login(@PathVariable String email, @PathVariable String contraseña)  {
        return this.userService.loginUser(email, contraseña);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User register(@RequestBody User user) {
        return this.userService.registerUser(user);
    }
}

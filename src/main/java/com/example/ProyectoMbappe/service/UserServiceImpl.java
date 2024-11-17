package com.example.ProyectoMbappe.service;

import com.example.ProyectoMbappe.entity.User;
import com.example.ProyectoMbappe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User loginUser(String email, String contraseña) {
        // Buscar al usuario por su email
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            // Verificar si la contraseña coincide
            if (passwordEncoder.matches(contraseña, user.getContraseña())) {
                return user; // Inicio de sesión exitoso
            }
        }
        return null; // Credenciales incorrectas
    }

    @Override
    public User registerUser(User user) {
        String passwordCode = passwordEncoder.encode(user.getContraseña());
        user.setContraseña(passwordCode);
        userRepository.save(user);

        return user;
    }
}

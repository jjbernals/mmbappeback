package com.example.ProyectoMbappe.service;

import com.example.ProyectoMbappe.entity.User;

public interface UserService {
    User loginUser (String email, String contraseña);
    User registerUser (User user);
}

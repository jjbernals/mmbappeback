package com.example.ProyectoMbappe.repository;

import com.example.ProyectoMbappe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT p FROM User p WHERE p.email =:email AND p.contraseña=:contraseña")
    User loginUser (String email, String contraseña);

    Optional<User> findByEmail(String email);
}

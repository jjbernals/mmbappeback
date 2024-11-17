package com.example.ProyectoMbappe.repository;

import com.example.ProyectoMbappe.entity.Pagina;
import com.example.ProyectoMbappe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaginaRepository extends JpaRepository<Pagina, Long> {
    @Query("SELECT p FROM Pagina p WHERE p.usuario_id.id = :id")
    List<Pagina> getPaginasByIdUser(Long id);

}

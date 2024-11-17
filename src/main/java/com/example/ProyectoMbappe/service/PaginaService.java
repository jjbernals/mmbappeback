package com.example.ProyectoMbappe.service;

import com.example.ProyectoMbappe.entity.Pagina;

import java.util.List;

public interface PaginaService {
    void crearPagina (Pagina cel, Long idUser);
    List<Pagina> obtenerPaginasPorIdUsuario (Long id);
    void actualizarPagina (Long id, Pagina cel);
    void borrarPagina (Long id);
}

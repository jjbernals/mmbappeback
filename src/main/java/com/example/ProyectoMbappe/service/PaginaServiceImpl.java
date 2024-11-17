package com.example.ProyectoMbappe.service;

import com.example.ProyectoMbappe.entity.Pagina;
import com.example.ProyectoMbappe.entity.User;
import com.example.ProyectoMbappe.exception.PaginaNotFoundException;
import com.example.ProyectoMbappe.repository.PaginaRepository;
import com.example.ProyectoMbappe.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaginaServiceImpl implements PaginaService {
    private final PaginaRepository paginaRepository;
    private final UserRepository userRepository;

    public PaginaServiceImpl(PaginaRepository paginaRepository, UserRepository userRepository) {
        this.paginaRepository = paginaRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void crearPagina(Pagina cel, Long idUser) {
        User user = userRepository.findById(idUser).orElseThrow(()-> new RuntimeException("No se pudo crear"));
        System.out.println(user);
        cel.setUsuario_id(user);
        paginaRepository.save(cel);
    }

    @Override
    public List<Pagina> obtenerPaginasPorIdUsuario(Long id) {
        return paginaRepository.getPaginasByIdUser(id);
    }

    @Override
    public void actualizarPagina(Long id, Pagina cel) {
        Pagina cel1 = paginaRepository.findById(id).orElseThrow(()->new PaginaNotFoundException("No se encontro el celular"));
        cel.setId(id);
        cel.setUsuario_id(cel1.getUsuario_id());
        paginaRepository.save(cel);
    }

    @Override
    public void borrarPagina(Long id) {
        paginaRepository.deleteById(id);
    }
}

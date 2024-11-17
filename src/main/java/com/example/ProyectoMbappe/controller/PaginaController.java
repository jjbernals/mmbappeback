package com.example.ProyectoMbappe.controller;

import com.example.ProyectoMbappe.entity.Pagina;
import com.example.ProyectoMbappe.service.PaginaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagina")
public class PaginaController {
    private final PaginaServiceImpl celService;

    public PaginaController(PaginaServiceImpl celService) {
        this.celService = celService;
    }
    @GetMapping("/{id}")
    public List<Pagina> obtenerCel(@PathVariable Long id) {
        return this.celService.obtenerPaginasPorIdUsuario(id);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public void crearCel(@RequestBody Pagina cel, @PathVariable Long id) {
        this.celService.crearPagina(cel, id);
    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void actuCel(@PathVariable Long id, @RequestBody Pagina cel) {
        celService.actualizarPagina(id, cel);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrarCel(@PathVariable Long id) {
        this.celService.borrarPagina(id);
    }
}

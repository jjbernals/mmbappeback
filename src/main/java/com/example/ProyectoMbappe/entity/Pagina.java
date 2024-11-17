package com.example.ProyectoMbappe.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "pagina")
public class Pagina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private User usuario_id;

    private String url;

    private String estado;

    private LocalDateTime ultimo_chequeo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(User usuario_id) {
        this.usuario_id = usuario_id;
    }
}

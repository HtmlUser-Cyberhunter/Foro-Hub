package com.forohub.Foro.Hub.controller.domain.topicos;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class topicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    @CreationTimestamp
    @Column(name = "fecha_creacion")
    private LocalDateTime fechacreacion;
    private String estatus;
    private String autor;
    private String curso;

    public topicos(DatosRegistroTopico datos) {
        this.id = null;
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.estatus = datos.estatus();
        this.autor = datos.autor();
        this.curso = datos.curso();
       }

    public void setTitulo(@NotBlank String titulo) {
        this.titulo = titulo;
    }

    public void setMensaje(@NotBlank String mensaje) {
        this.mensaje = mensaje;
    }

    public void setEstatus(@NotBlank String estatus) {
        this.estatus = estatus;
    }

    public void eliminar() {this.estatus = "ELIMINADO";}
}


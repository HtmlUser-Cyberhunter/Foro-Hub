package com.forohub.Foro.Hub.controller.domain.topicos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TopicoRepository extends JpaRepository<topicos, Long> {
    Optional<topicos> findByTituloAndMensaje(String titulo, String mensaje);

    Page<topicos> findByEstatusNot(String estatus, Pageable pageable);
    //List<topicos> findByEstatusNot(String estatus);

    }

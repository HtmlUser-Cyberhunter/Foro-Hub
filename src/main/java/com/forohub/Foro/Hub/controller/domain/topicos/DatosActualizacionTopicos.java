package com.forohub.Foro.Hub.controller.domain.topicos;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizacionTopicos(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String estatus

) {}

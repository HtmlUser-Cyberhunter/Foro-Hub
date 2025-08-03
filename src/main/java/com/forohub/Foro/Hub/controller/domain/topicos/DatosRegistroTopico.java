package com.forohub.Foro.Hub.controller.domain.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String estatus,
        @NotBlank String autor,
        @NotBlank String curso
) {}

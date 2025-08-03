package com.forohub.Foro.Hub.controller.domain.topicos;

public record DatosDetallesTopico(
        Long id,
        String titulo,
        String mensaje,
        String estatus,
        String autor,
        String curso
) {
    public DatosDetallesTopico(topicos topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getEstatus(),
                topico.getAutor(),
                topico.getCurso()
        );

    }
}

package com.forohub.Foro.Hub.controller.controller;


import com.forohub.Foro.Hub.controller.domain.topicos.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    //Registrar topicos
    @PostMapping
    public ResponseEntity<String> registrarTopico(@RequestBody @Valid DatosRegistroTopico datos) {
        boolean existe = repository.findByTituloAndMensaje(datos.titulo(), datos.mensaje()).isPresent();
        if (existe) {
            return ResponseEntity.badRequest().body("Ya existe un tópico con ese título y mensaje.");
        }

        topicos topico = new topicos(datos);
        repository.save(topico);
        return ResponseEntity.ok("Tópico registrado exitosamente.");
    }
    //listar topicos
    @GetMapping
    public ResponseEntity<Page<ListarTopicos>> listarTopicos(@PageableDefault(size = 10) Pageable paginacion) {
        Page<topicos> pagina = repository.findByEstatusNot("ELIMINADO", paginacion);
        Page<ListarTopicos> resultado = pagina.map(ListarTopicos::new);
        return ResponseEntity.ok(resultado);
    }
    //Actualizar topico
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<String> actualizarTopico(
            @PathVariable Long id,
            @RequestBody @Valid DatosActualizacionTopicos datos) {

        return repository.findById(id)
                .map(topico -> {
                    topico.setTitulo(datos.titulo());
                    topico.setMensaje(datos.mensaje());
                    topico.setEstatus(datos.estatus());

                    repository.save(topico);
                    return ResponseEntity.ok("Tópico actualizado");
                })
                .orElse(ResponseEntity.notFound().build());
    }
    //Eliminar topico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<String> eliminarTopico(@PathVariable Long id) {
        Optional<topicos> optionalTopico = repository.findById(id);

        if (optionalTopico.isPresent()) {
            topicos topico = optionalTopico.get();
            topico.eliminar(); // Cambio lógico de estado
            repository.save(topico);
            return ResponseEntity.ok("Tópico eliminado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //topicos por Id
    @GetMapping("/{id}")
    public ResponseEntity<DatosDetallesTopico> obtenerTopicoPorId(@PathVariable Long id) {
        return repository.findById(id)
                .filter(topico -> !topico.getEstatus().equalsIgnoreCase("ELIMINADO"))
                .map(topico -> ResponseEntity.ok(new DatosDetallesTopico(topico)))
                .orElse(ResponseEntity.notFound().build());
    }

}

package br.grupointegrado.book.controller;


import br.grupointegrado.book.DTO.UsuarioRequestDTO;
import br.grupointegrado.book.model.Usuario;
import br.grupointegrado.book.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    public UsuarioRepository repository;


    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> usuarios = this.repository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public Usuario findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuario não encontrado"));
    }

    @PostMapping
    public ResponseEntity<Usuario> save(@RequestBody UsuarioRequestDTO DTO) {
        if (DTO.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }
        Usuario usuario = new Usuario();
        usuario.setNome(DTO.nome());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

}

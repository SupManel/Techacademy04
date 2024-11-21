package br.grupointegrado.book.controller;


import br.grupointegrado.book.DTO.UsuarioRequestDTO;
import br.grupointegrado.book.model.ItemPedido;
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
    private UsuarioRepository repository;


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
        Usuario usuario = new Usuario();

        usuario.setId_usuario(DTO.id_usuario());
        usuario.setNome(DTO.nome());
        usuario.setGmail(DTO.gmail());
        usuario.setSenha(DTO.senha());
        usuario.setCep(DTO.senha());

        this.repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Usuario id) {
        Usuario usuario = this.repository.findById(id.getId_usuario())
                .orElseThrow(() ->
                        new IllegalArgumentException("Usuario não encontrado"));

        this.repository.delete(usuario);
        return ResponseEntity.noContent().build();
    }

}

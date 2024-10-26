package br.grupointegrado.book.controller;


import br.grupointegrado.book.DTO.UsuarioRequestDTO;
import br.grupointegrado.book.model.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/Usuario")
public class UsuarioController {


    private UsuarioController repository;

    @GetMapping
    public List<Usuario> findAll() {
        return this.repository.findAll();
    }

    @PostMapping
    public Usuario save(@RequestBody UsuarioRequestDTO DTO) {
        Usuario usuario = new Usuario();
        usuario.setNome(DTO.nome());

        return this.repository.save(DTO);
    }

}

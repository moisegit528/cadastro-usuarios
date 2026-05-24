package com.projeto1.cadastro_usuarios.controller;

import com.projeto1.cadastro_usuarios.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.projeto1.cadastro_usuarios.model.Usuario;
import com.projeto1.cadastro_usuarios.repository.UsuarioRepositorio;
import java.util.List;


@RestController
@RequestMapping("/usuarios")

public class ControleUsuario {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @PostMapping
    public Usuario cadastrar(@RequestBody Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepositorio.findAll();
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
       Usuario usuario = usuarioRepositorio.findById(id).orElseThrow();
       usuario.setNome(usuarioAtualizado.getNome());
       usuario.setEmail(usuarioAtualizado.getEmail());
       usuario.setSenha(usuarioAtualizado.getSenha());
       usuario.setNascimento(usuarioAtualizado.getNascimento());
       usuario.setTelefone(usuarioAtualizado.getTelefone());
       return usuarioRepositorio.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        usuarioRepositorio.deleteById(id);
    }
}



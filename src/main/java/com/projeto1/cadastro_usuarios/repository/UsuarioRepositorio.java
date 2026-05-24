package com.projeto1.cadastro_usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.projeto1.cadastro_usuarios.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
}

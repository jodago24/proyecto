package com.registro.usuarios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.modelo.Usuario;

// Indica que esta interfaz es un repositorio de Spring Data JPA
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	// Método para buscar un usuario por su email
	public Usuario findByEmail(String email);
}

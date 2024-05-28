package com.registro.usuarios.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Usuario;

// Interfaz para el servicio de usuario, extiende UserDetailsService para la autenticación de Spring Security
public interface UsuarioServicio extends UserDetailsService {

	// Método para guardar un nuevo usuario a partir de un DTO de registro
	public Usuario guardar(UsuarioRegistroDTO registroDTO);

	// Método para listar todos los usuarios
	public List<Usuario> listarUsuarios();
}
